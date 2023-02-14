package mySplashThread8.editors;

import java.awt.Component;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.nepxion.swing.locale.SwingLocale;
import mySplashThread8.utils.ThreadUtils;


public class EditorsRegistry {
	private static final Logger logger = LoggerFactory.getLogger(EditorsRegistry.class);
    private static EditorsRegistry instance = null;
    private static final String STATUS_READY = SwingLocale.getString("status.ready");
    private HashMap editors;
    private JPanel pane = null;
    private JLabel statusLabel;

    private Timer timer = null;
    private JFrame mainWindow = null;

    /**
     * Creates a new instance of EditorsRegistry
     */
    private EditorsRegistry() {
        this.editors = new HashMap();
        this.statusLabel = null;
        this.timer = new Timer();
        this.setMainWindow(null);
    }

    public static synchronized EditorsRegistry getInstance() {
        if (instance == null) {
            instance = new EditorsRegistry();
        }
        return instance;
    }

    public Object getEditor(String editorClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (!(this.editors.containsKey(editorClass))) {
            Object editor = Class.forName(editorClass).newInstance();
            this.editors.put(editorClass, editor);
        }
        return this.editors.get(editorClass);
    }

    public void setMainEditorsPane(JPanel panel) {
        this.pane = panel;
    }

    public JPanel getMainEditorsPane() {
        return this.pane;
    }

    public Object getCurrentEditor() {
        if (this.pane == null) {
            return null;
        }

        if (this.pane.getComponentCount() != 1) {
            return null;
        }

        return this.pane.getComponent(0);
    }

    public boolean isEditorActive(String editorClass) {
        if (this.pane == null) {
            return false;
        }

        if (this.pane.getComponentCount() != 1) {
            return false;
        }

        if (editorClass != null) {
            if (editorClass.equals(this.pane.getComponent(0).getClass().getName())) {
                return true;
            }
        }
        return false;
    }

   
    public void updateStatus(String text) {
        this.updateStatus(text, true);
    }
    public void setStatusLabel(JLabel status) {
        this.statusLabel = status;
    }

    public void clearStatus() {
        this.updateStatus(this.STATUS_READY);
    }

    public void clearStatus(boolean newThread) {
        this.updateStatus(this.STATUS_READY, newThread);
    }
   

    public void updateStatus(String text, boolean newThread) {
        if (newThread) {
            ThreadUtils.updateLabel(this.statusLabel, text);
        } else {
            this.statusLabel.setText(text);
        }
    }

    public void updateStatus(String text, int milliseconds) {
        if (this.statusLabel != null) {
            this.statusLabel.setText(text);
            this.timer.schedule(new UpdateStatusTimerTask(STATUS_READY), milliseconds);
        }
    }
    private class UpdateStatusTimerTask extends TimerTask {

        private String newText;

        public UpdateStatusTimerTask(String newText) {
            this.newText = newText;
        }

        public void run() {
            ThreadUtils.updateLabel(statusLabel, this.newText);
        }
    }

  
    public void setMainEditorsPaneView(Component c) {
        this.setMainEditorsPaneView(c, false);
    }

    public void setMainEditorsPaneView(Component c, boolean skipReset) {
    	
    	
        if (this.pane == null) {
        	logger.info("pane is null");
            return;
        }

        if (c != null && this.pane.getComponentCount() == 1) {
            if (c == this.pane.getComponent(0)) {
            	logger.info("component c is not null:"+c.getClass().getSimpleName());
            	 this.pane.revalidate();
                 this.pane.repaint();
                return;
            }
        }
        
        if (this.pane.getComponentCount() == 1) {
            Component currentEd = this.pane.getComponent(0);
            /*if (currentEd instanceof SelfValidatingEditor) {
                SelfValidatingEditor se = (SelfValidatingEditor) currentEd;
                if (!se.isDataValid()) {
                    return;
                }
            }*/
        }

        boolean saved = true;
        if (this.pane.getComponentCount() == 1) {
            Component currentEd = this.pane.getComponent(0);
            /*if (currentEd instanceof SaveableEditor) {
                SaveableEditor se = (SaveableEditor) currentEd;
                if (se.isDirty()) {
                    int ret = JOptionPane.showConfirmDialog(this.getMainWindow(), java.util.ResourceBundle.getBundle("com/jdimension/jlawyer/client/editors/EditorsRegistry").getString("dialog.savebeforeexit"), java.util.ResourceBundle.getBundle("com/jdimension/jlawyer/client/editors/EditorsRegistry").getString("dialog.savebeforeexit.title"), JOptionPane.YES_NO_OPTION);
                    if (ret == JOptionPane.YES_OPTION) {
                        saved = se.save();
                    }
                }
            }*/
        }

        c.doLayout();
        if (saved) {
            //this.pane.setViewportView(c);
            this.pane.removeAll();
            this.pane.add(c);
            this.pane.revalidate();
            this.pane.repaint();
        }
       
        if (saved) {
            //this.pane.setViewportView(c);
            this.pane.removeAll();
            this.pane.add(c);
            this.pane.revalidate();
            this.pane.repaint();
        }

        if (!skipReset) {
            if (c instanceof ResetOnDisplayEditor) {
                if (((ResetOnDisplayEditor) c).needsReset()) {
                    ((ResetOnDisplayEditor) c).reset();
                }
            }
        }
    }

  

   

    public JFrame getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;
    }
}