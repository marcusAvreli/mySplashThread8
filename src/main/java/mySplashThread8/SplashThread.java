package mySplashThread8;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.App;
import mySplashThread8.SplashThread;
import mySplashThread8.editors.EditorsRegistry;
import mySplashThread8.events.Event;
import mySplashThread8.events.EventConsumer;
import mySplashThread8.gui.JKanzleiGUI;
import mySplashThread8.server.modules.ModuleMetadata;
import mySplashThread8.settings.ClientSettings;
import mySplashThread8.settings.ThemeSettings;
import mySplashThread8.settings.UserSettings;
import mySplashThread8.utils.VersionUtils;



public class SplashThread implements Runnable,EventConsumer {
	String packagePathName="/dumpViewer6/gui";
	
	private static final Logger logger = LoggerFactory.getLogger(SplashThread.class);
	private ClientSettings settings = null;
    private int loadedMods = 0;
    private int numberOfMods = 0;
    private JFrame owner = null;
	   
//j-lawyer-org/j-lawyer-server-entities/src/java/com/jdimension/jlawyer/persistence/AppOptionGroupBean.java
	 public SplashThread(ClientSettings settings) {
		
	        this.settings = settings;
	        //this.owner = owner;
	 }
	public void run() {
		logger.info("run function called");
        ModuleMetadata rootModule = settings.getRootModule();
        
        String randomBackgrounds = UserSettings.getInstance().getSetting(UserSettings.CONF_DESKTOP_RANDOM_BACKGROUND, "0");
        // webswing did not like the large images and displayed an empty frame instead of the application
        String demoSystem = settings.getConfiguration("runtime.isdemosystem", "0");
        boolean isDemoSystem = false;
        if (demoSystem != null && "1".equalsIgnoreCase(demoSystem)) {
            isDemoSystem = true;
          
        }
        if ("0".equalsIgnoreCase(randomBackgrounds) || isDemoSystem) {


            rootModule.setBackgroundImage(packagePathName+"/themes/default/archivefiles.jpg");

            rootModule.setRandomBackgroundImage(null);
        } else {
            rootModule.setBackgroundImage(null);
            
            FileSystem fileSystem=null;
            try {

                URI uri = App.class.getResource(packagePathName+"/themes/default/backgroundsrandom").toURI();
                Path path;
                if (uri.getScheme().equals("jar")) {
                    fileSystem = FileSystems.newFileSystem(uri, Collections.<String, Object>emptyMap());
                    path = fileSystem.getPath(packagePathName+"/themes/default/backgroundsrandom");
                    
                } else {
                    path = Paths.get(uri);
                }

                Predicate<String> con1 = s -> s.endsWith(".jpg");
                Predicate<String> con2 = s -> s.endsWith(".png");
                
                List<String> backgroundFileNames=new ArrayList<>();
                try (Stream<Path> walk = Files.walk(path)) {
                    backgroundFileNames=walk
                            .map(Path::getFileName)
                        .map(Path::toString)
                        .filter(con1.or(con2))
                        .collect(Collectors.toList());
                }

                int randomNum = ThreadLocalRandom.current().nextInt(0, backgroundFileNames.size());
               // rootModule.setRandomBackgroundImage(backgroundFileNames.get(randomNum));
            } catch (Throwable t) {
            	logger.error("unable to get random background image", t);
                rootModule.setBackgroundImage("archivefiles.jpg");
                rootModule.setRandomBackgroundImage(null);
            } finally {
                if(fileSystem!=null) {
                    try {
                        fileSystem.close();
                    } catch (Exception ex) {
                        logger.warn("Could not close filesystem object", ex);
                    }
                }
            }

        }
        ThemeSettings theme = ThemeSettings.getInstance();
       // preloadEditors(theme, rootModule);
        
      
        
        
		   SwingUtilities.invokeLater(() -> {
	            JKanzleiGUI gui = new JKanzleiGUI();
	            EditorsRegistry.getInstance().setMainWindow(gui);
	            ClientSettings cs = ClientSettings.getInstance();
	            gui.setTitle(gui.getTitle() + " " + VersionUtils.getFullClientVersion() + " [" + "TestUser" + "@" + cs.getConfiguration(ClientSettings.CONF_LASTSERVER, "localhost") + ":" + cs.getConfiguration(ClientSettings.CONF_LASTPORTDYN, "8080") + "-" + cs.getConfiguration(ClientSettings.CONF_LASTSECMODE, "standard") + "]");
	            gui.buildModuleBar();
	            gui.pack();
	            gui.doLayout();
	            gui.setVisible(true);
	            notifyEditorForStatus(cs.getRootModule());
		   });
		
	}
	   private void preloadEditors(ThemeSettings theme, ModuleMetadata module) {

	        this.loadedMods++;

	        this.updateStatus(java.text.MessageFormat.format(java.util.ResourceBundle.getBundle("idmManager4/SplashThread").getString("status.loadingmodules"), new Object[]{module.getFullName()}), true);
	        this.updateProgress(false, this.numberOfMods, this.loadedMods, "");

	        String editorClass = ((ModuleMetadata) module).getEditorClass();
	        logger.info("editor_class:"+editorClass);
	        if (editorClass != null) {
	            try {
	                if (!SwingUtilities.isEventDispatchThread()) {
	                    SwingUtilities.invokeAndWait(() -> {
	                        try {
	                        	
	                            long start=System.currentTimeMillis();
	                            
	                            Object editor = EditorsRegistry.getInstance().getEditor(editorClass);
	                            
	                            if (module.getBackgroundImage() != null || module.getRandomBackgroundImage() != null) {
	                               /* if (editor instanceof ThemeableEditor) {
	                                    Image image = theme.getBackground(module);
	                                    if (image != null) {
	                                        ((ThemeableEditor) editor).setBackgroundImage(image);
	                                    }
	                             */
	                                    logger.warn("Editor " + editorClass + " has a background image set but does not implement interface ThemeableEditor");
	                             
	                            }
	                            logger.info("fully initialized module " + editorClass + ": " + (System.currentTimeMillis()-start));
	                        } catch (Exception ex) {
	                            logger.error("Fehler beim Laden des Moduls " + editorClass, ex);
	                            //ThreadUtils.showErrorDialog(owner, "Fehler beim Laden des Moduls " + editorClass + ": " + ex.getMessage(), com.jdimension.jlawyer.client.utils.DesktopUtils.POPUP_TITLE_ERROR);
	                        }
	                    });

	                } else {
	                    long start=System.currentTimeMillis();
	                    Object editor = EditorsRegistry.getInstance().getEditor(editorClass);
	                    logger.info("loaded module " + editorClass + ": " + (System.currentTimeMillis()-start));
	                    if (module.getBackgroundImage() != null || module.getRandomBackgroundImage() != null) {
	                      /*  if (editor instanceof ThemeableEditor) {
	                            Image image = theme.getBackground(module);
	                            if (image != null) {
	                                ((ThemeableEditor) editor).setBackgroundImage(image);
	                            }
	                    */
	                        	logger.warn("Editor " + editorClass + " has a background image set but does not implement interface ThemeableEditor");
	                        
	                    }
	                    logger.info("fully initialized module " + editorClass + ": " + (System.currentTimeMillis()-start));
	                }

	            } catch (Exception ex) {
	            	logger.error("Error preloading editor from class " + editorClass, ex);
	                //ThreadUtils.showErrorDialog(this.owner, java.text.MessageFormat.format(java.util.ResourceBundle.getBundle("com/jdimension/jlawyer/client/SplashThread").getString("error.loadingeditor"), new Object[]{ex.getMessage()}), java.util.ResourceBundle.getBundle("com/jdimension/jlawyer/client/SplashThread").getString("msg.error"));
	            }

	        }
	        for (int i = 0; i < module.getChildCount(); i++) {
	        	logger.info("preloading");
	            this.preloadEditors(theme, (ModuleMetadata) module.getChildAt(i));
	        }

	    }
	   private void updateProgress(final boolean indeterminate, final int max, final int value, final String s) {
	      logger.info("update_progress");
	    }
	   private void updateStatus(final String s, final boolean newLine) {
		   logger.info("update_status");
	      
	    }
	   private void notifyEditorForStatus(ModuleMetadata module) {
	        String editorClass = ((ModuleMetadata) module).getEditorClass();
	        if (editorClass != null) {
	            Object editor = null;
	            try {
	                editor = EditorsRegistry.getInstance().getEditor(editorClass);
	              
	            } catch (Exception ex) {
	                logger.error("Could not notify editor for status updates", ex);
	            }
	        }
	        for (int i = 0; i < module.getChildCount(); i++) {
	            this.notifyEditorForStatus((ModuleMetadata) module.getChildAt(i));
	        }
	    }
	@Override
	public void onEvent(Event e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
