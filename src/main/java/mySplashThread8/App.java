package mySplashThread8;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.nepxion.swing.locale.SwingLocale;
import mySplashThread8.server.modules.ModuleMetadata;
import mySplashThread8.settings.ClientSettings;
import mySplashThread8.utils.FontUtils;



//https://github.com/NCIP/cab2b
//https://github.com/Nepxion/Marvel
//https://www.codeproject.com/Articles/36170/Simple-and-Powerful-TableModel-with-Reflection
//j-lawyer-org/j-lawyer-server-entities/src/java/com/jdimension/jlawyer/persistence/AppOptionGroupBean.java
//https://www.oracle.com/technical-resources/articles/javase/locale.html
//https://github.com/semantic-web-software/dynagent/tree/master/Elecom
///https://github.com/semantic-web-software/dynagent/blob/a0d356169ef34f3d2422e235fed7866e3dda6d8a/Elecom/src/gdev/gawt/GTable.java
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {		
		System.setProperty("http.agent", "j-lawyer Client v16");
		App main = new App();
		 
        ClientSettings settings = ClientSettings.getInstance();
        settings.newProject();
        settings.registerLocale();
		main.showSplash(settings);
	}

	private void showSplash(ClientSettings settings) {
	
		ModuleMetadata root = new ModuleMetadata(SwingLocale.getString("mod.mydesktop"));

		final String moduleNameCalendar = "Kalender";

		root.setEditorClass("mySplashThread8.desktop.DesktopPanel");
		root.setFullName("Mein Desktop");
		root.setEditorName("Desktop");
		root.setModuleName("");
		root.setDefaultIcon(new javax.swing.ImageIcon(
				getClass().getResource("/icons32/material/baseline_desktop_windows_blue_36dp.png")));
		root.setRolloverIcon(new javax.swing.ImageIcon(
				getClass().getResource("/icons32/material/baseline_desktop_windows_green_36dp.png")));
		root.setHotKey(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_DOWN_MASK), "Shift+F1");

		ModuleMetadata addresses = new ModuleMetadata(SwingLocale.getString("mod.contacts"));
		addresses.setFullName("Adressen");
		root.addChildModule(addresses);
		
		
		  /*ModuleMetadata addressesNew = new ModuleMetadata(SwingLocale.getString("mod.contacts.new"));
          addressesNew.setEditorClass("mySplashThread8.editors.applications.NewApplicationPanel");
          addressesNew.setBackgroundImage("addresses.jpg");
          addressesNew.setFullName("New Application");
          addressesNew.setEditorName("New");
          addressesNew.setModuleName("Adressen");
          addressesNew.setDefaultIcon(new javax.swing.ImageIcon(getClass().getResource("/icons32/material/Icons2-19-blue.png")));
          addressesNew.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons32/material/Icons2-19-green.png")));         
          addressesNew.setHotKey(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.SHIFT_DOWN_MASK), "Shift+F4");         
          addresses.addChildModule(addressesNew);
          */
          ModuleMetadata addressesEdit = new ModuleMetadata(SwingLocale.getString("mod.contacts.edit"));
          addressesEdit.setEditorClass("mySplashThread8.editors.addresses.EditAddressPanel");
          addressesEdit.setBackgroundImage("addresses.jpg");
          addressesEdit.setFullName("vorhandene Adresse suchen");
          addressesEdit.setEditorName("Approvers_editor_name");
          addressesEdit.setModuleName("Approvers_Module_Name");
          addressesEdit.setDefaultIcon(new javax.swing.ImageIcon(getClass().getResource("/icons32/material/Icons2-20-blue.png")));
          addressesEdit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons32/material/Icons2-20-green.png")));
        
          addressesEdit.setHotKey(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.SHIFT_DOWN_MASK), "Shift+F5");
        
          addresses.addChildModule(addressesEdit);

		ModuleMetadata applications = new ModuleMetadata("Applications Module");
		applications.setFullName("Wiedervorlagen und Fristen");
		root.addChildModule(applications);  
          
		ModuleMetadata applicationsNew = new ModuleMetadata(SwingLocale.getString("mod.contacts.new"));
		applicationsNew.setEditorClass("mySplashThread8.editors.applications.NewApplicationPanel");
		applicationsNew.setBackgroundImage("addresses.jpg");
		applicationsNew.setFullName("New Application");
		applicationsNew.setEditorName("New");
		applicationsNew.setModuleName("Applications");
		applicationsNew.setDefaultIcon(new javax.swing.ImageIcon(getClass().getResource("/icons32/material/Icons2-19-blue.png")));
		applicationsNew.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons32/material/Icons2-19-green.png")));         
		applicationsNew.setHotKey(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.SHIFT_DOWN_MASK), "Shift+F4");         
        applications.addChildModule(applicationsNew); 
		
		ModuleMetadata applicationEdit = new ModuleMetadata(SwingLocale.getString("mod.applications.edit"));
		applicationEdit.setEditorClass("mySplashThread8.editors.applications.EditApplicationPanel");
		// applicationEdit.setBackgroundImage("addresses.jpg");
		applicationEdit.setFullName(SwingLocale.getString("searchApplication"));
		applicationEdit.setEditorName("Applications List");
		applicationEdit.setModuleName("Applications");
		applicationEdit.setDefaultIcon(
				new javax.swing.ImageIcon(getClass().getResource("/icons32/material/Icons2-20-blue.png")));
		applicationEdit.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/icons32/material/Icons2-20-green.png")));
		applicationEdit.setHotKey(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "F5");
		applications.addChildModule(applicationEdit);

		settings.setRootModule(root);
		
		// this.updateStatus(java.util.ResourceBundle.getBundle("dumpViewer5/Main").getString("status.settingsinit"),
		// true);

		String themeName = settings.getConfiguration(settings.CONF_THEME, "default");
		settings.setConfiguration(settings.CONF_THEME, themeName);

		// this.updateStatus(java.util.ResourceBundle.getBundle("dumpViewer5/Main").getString("status.fontsizes"),
		// true);
		FontUtils fontUtils = FontUtils.getInstance();
		String fontSizeOffset = settings.getConfiguration(settings.CONF_UI_FONTSIZEOFFSET, "0");
		try {
			int offset = Integer.parseInt(fontSizeOffset);
			fontUtils.updateDefaults(offset);
		} catch (Throwable t) {
			logger.error("Could not set font size", t);
		}

		// this.updateStatus(java.util.ResourceBundle.getBundle("dumpViewer5/Main").getString("status.modules.available"),
		// true);
		// todo: load this from the server

		//logger.debug(java.util.ResourceBundle.getBundle(packageNamePath + "/Main").getString("status.starting"));
		// this.updateStatus(java.util.ResourceBundle.getBundle(packageNamePath+"/Main").getString("status.started"),
		// false);

		String cmdSecMode = "standard";
		String cmdSshHost = null;
		String cmdSshPort = null;
		String cmdSshUser = null;
		String cmdSshPwd = null;
		String cmdSshTargetPort = null;

		
		new Thread(new SplashThread(settings)).start();
	

	}
}
