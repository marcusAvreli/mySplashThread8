package mySplashThread8.modulebar;


import mySplashThread8.editors.EditorsRegistry;
import mySplashThread8.nepxion.swing.locale.SwingLocale;
import mySplashThread8.server.modules.ModuleMetadata;

import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;


public class ModuleBar extends javax.swing.JPanel {
	private static final Logger logger = LoggerFactory.getLogger(ModuleBar.class);
    private HashMap<KeyStroke, Action> hotKeyActions = new HashMap<KeyStroke, Action>();

    /**
     * Creates new form ModuleBar
     */
    public ModuleBar() {
        initComponents();
        this.cmdSettings.setFont(this.cmdSettings.getFont().deriveFont(Font.BOLD));
    }

    public void actionPerformed(int moduleIndex) {
    	//logger.info("actionPerformed_1_called");
        ModuleButton mb = (ModuleButton) this.buttonPane.getComponent(moduleIndex);
        
        mb.actionPerformed();
       // logger.info("actionPerformed_3");
    }

    public void addModule(ModuleMetadata m) {   
    	///logger.info("addModule_called");
        if (m.isSettingsEntry()) {
            JMenuItem mi = new JMenuItem("<html>" + m.getModuleName() + ":<br/>" + m.getEditorName() + "</html>");
            mi.setIcon(m.getDefaultIcon());
            mi.setRolloverIcon(m.getRolloverIcon());
            mi.setFont(new java.awt.Font("Dialog", 1, 10));
            mi.setForeground(Color.BLACK);
            mi.setSelectedIcon(m.getRolloverIcon());

            JPanel caller = this;
            mi.addActionListener((ActionEvent ae) -> {
                if (m.getEditorClass() != null) {
                    Object editor = null;
                    try {
                        editor = EditorsRegistry.getInstance().getEditor(m.getEditorClass());
                        /*if (editor instanceof PopulateOptionsEditor) {
                            ((PopulateOptionsEditor) editor).populateOptions();
                        }*/
                        logger.info("addModule_called_2");
                        EditorsRegistry.getInstance().setMainEditorsPaneView((Component) editor);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(caller, SwingLocale.getString("error.loadingeditor") + ex.getMessage(), SwingLocale.getString("msg.title.error"), JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                	logger.info("addModule_1");
                    EditorsRegistry.getInstance().setMainEditorsPaneView(null);
                }
            });
           
            this.popSettings.add(mi);
        } else {
        //	logger.info("addModule_button");
            if (buttonPane.getComponentCount() > 0) {
                ModuleButton mb = (ModuleButton) buttonPane.getComponent(buttonPane.getComponentCount() - 1);
                String formerModuleName = mb.getModule().getModuleName();
                if (!formerModuleName.equals(m.getModuleName())) {
                    buttonPane.add(new ModuleGroupLabel(m.getModuleName()));
                }
            }
           // logger.info("addModule_button_1");
            ModuleButton b = new ModuleButton(m);
            buttonPane.add(b);
            if (m.getHotKey() != null) {
                this.hotKeyActions.put(m.getHotKey(), new AbstractAction(m.getEditorClass()) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        b.actionPerformed();
                        logger.info("addModule_button_2");
                    }
                });
            }
        }
    }

    /**
     * Should be called AFTER all the modules have been added
     */
    public void initializeHotKeys() {
        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher((KeyEvent e) -> {
            KeyStroke keyStroke = KeyStroke.getKeyStrokeForEvent(e);
            if (hotKeyActions.containsKey(keyStroke)) {
                final Action a = hotKeyActions.get(keyStroke);
                final ActionEvent ae = new ActionEvent(e.getSource(), e.getID(), null);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        a.actionPerformed(ae);
                    }
                });
                return true;
            }
            return false;
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        popSettings = new javax.swing.JPopupMenu();
        cmdSettings = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        buttonPane = new javax.swing.JPanel();

        setOpaque(false);

        cmdSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons32/material/baseline_settings_applications_black_36dp.png"))); // NOI18N
        cmdSettings.setText("Vorlagen");
        cmdSettings.setBorder(null);
        cmdSettings.setBorderPainted(false);
        cmdSettings.setContentAreaFilled(false);
        cmdSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdSettings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdSettings.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons32/material/baseline_settings_applications_green_36dp.png"))); // NOI18N
        cmdSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmdSettingsMousePressed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        buttonPane.setOpaque(false);
        buttonPane.setLayout(new javax.swing.BoxLayout(buttonPane, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(buttonPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(cmdSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdSettings))
        );
    }

    private void cmdSettingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdSettingsMousePressed
        this.popSettings.show(this.cmdSettings, evt.getX(), evt.getY());
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPane;
    private javax.swing.JButton cmdSettings;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popSettings;
    // End of variables declaration//GEN-END:variables
}