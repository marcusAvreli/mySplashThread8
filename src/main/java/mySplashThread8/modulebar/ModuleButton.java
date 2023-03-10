package mySplashThread8.modulebar;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.themes.colors.DefaultColorTheme;
import mySplashThread8.editors.EditorsRegistry;
import mySplashThread8.server.modules.ModuleMetadata;
import mySplashThread8.editors.applications.QuickSearchApplicationPanel;
import mySplashThread8.events.EventBroker;
import mySplashThread8.events.OnLoadPaneView;
import mySplashThread8.settings.ClientSettings;



public class ModuleButton extends JPanel {

	private static final Logger logger = LoggerFactory.getLogger(ModuleButton.class);

	private ModuleMetadata module = null;

    private Color defaultBackColor=Color.GRAY;

    private String editorClass = null;

    private Icon icon = null;
    private Icon rollOverIcon = null;
    
    private String indicatorValue="";

    /**
     * Creates new form ModuleButton
     */
    public ModuleButton(ModuleMetadata m) {
    	
        initComponents();
        this.defaultBackColor=this.getBackground();
        this.iconButton.setIcon(this.icon);
        this.module = m;
        this.lblIndicator.setText("");
        this.editorClass = m.getEditorClass();
        this.icon = m.getDefaultIcon();
        this.rollOverIcon = m.getRolloverIcon();

        this.iconButton.setIcon(this.icon);

        boolean mod = m.getModuleName().length() > 0;
        boolean ed = m.getEditorName().length() > 0;

        if (mod && ed) {
            //setText("<html><b>" + m.getModuleName() + ":<br/>" + m.getEditorName() + "</b></html>");
            setText("<html><b>" + m.getEditorName() + "</b></html>");
            //setText("<html><table><tr><td>" + m.getModuleName() + ":<br/>" + m.getEditorName() + "</td><td>56</td></tr></table></html>");
        } else if (mod) {
            setText("<html><b>" + m.getModuleName() + "</b></html>");
        } else if (ed) {
            setText("<html><b>" + m.getEditorName() + "</b></html>");
        } else {
            setText("*");
        }

        if(m.getHotKey()!=null) {
            setToolTipText("<html>" + m.getFullName() + "<br/>Keyboard Shortcut: <b>[" + m.getHotKeyName() + "]</b></html>");
        } else {
            setToolTipText(m.getFullName());
        }

        this.lblIndicator.setText("");
        this.lblIndicator.setForeground(DefaultColorTheme.COLOR_DARK_GREY);

    }

    public void setText(String text) {
        this.lblModuleName.setText(text);
    }

    public String getText() {
        return this.lblModuleName.getText();
    }
    public ModuleMetadata getModule() {
        return module;
    }
    @Override
    public void setToolTipText(String text) {
        this.lblModuleName.setToolTipText(text);
        this.iconButton.setToolTipText(text);
        super.setToolTipText(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
 
    private void initComponents() {
    //	SearchApplicationPanel searchPanel = new SearchApplicationPanel();
        jLabel2 = new JLabel();
        iconButton = new JButton();
        lblModuleName = new JLabel();
        lblIndicator = new JLabel();
    
 
 		
        jLabel2.setText("jLabel2");

        iconButton.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        iconButton.setForeground(new java.awt.Color(255, 255, 255));
        iconButton.setBorder(null);
        iconButton.setBorderPainted(false);
        iconButton.setContentAreaFilled(false);
        iconButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                iconButtonMouseExited(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                iconButtonMouseEntered(evt);
            }
        });
        iconButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconButtonActionPerformed(evt);
            }
        });

       // lblModuleName.setText("jLabel1");
        lblModuleName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModuleName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblModuleNameMouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                lblModuleNameMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                lblModuleNameMouseExited(evt);
            }
        });

        lblIndicator.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lblIndicator.setForeground(new java.awt.Color(102, 102, 102));
        lblIndicator.setText("3");
        lblIndicator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lblIndicatorMouseClicked(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                lblIndicatorMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                lblIndicatorMouseExited(evt);
            }
        });

       GroupLayout layout = new GroupLayout(this);
       
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconButton)
                .addGap(5, 5, 5)
                .addComponent(lblModuleName)
                .addGap(5, 5, 5)
                .addComponent(lblIndicator)
                .addGap(5, 5, 5)
                //.addComponent(searchPanel)
                .addGap(5, 5, 5)
            		)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(lblModuleName,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(iconButton,GroupLayout.Alignment.TRAILING,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblIndicator,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
           // .addComponent(searchPanel,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
      
    }

    private void lblModuleNameMouseEntered(MouseEvent evt) {
        this.setBackground(this.defaultBackColor.brighter().brighter());
        this.iconButton.setIcon(this.getRollOverIcon());
    }

    private void lblModuleNameMouseExited(MouseEvent evt) {
        this.setBackground(this.defaultBackColor);
        this.iconButton.setIcon(this.getIcon());
    }

    private void iconButtonMouseEntered(MouseEvent evt) {
        this.setBackground(this.defaultBackColor.brighter().brighter());
        this.iconButton.setIcon(this.getRollOverIcon());
    }

    private void iconButtonMouseExited(MouseEvent evt) {
        this.setBackground(this.defaultBackColor);
        this.iconButton.setIcon(this.getIcon());
    }

    private void iconButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	logger.info("hello");
        actionPerformed();
    }

    private void lblModuleNameMouseClicked(MouseEvent evt) {
    	logger.info("lblModuleNameMouseClicked");
        actionPerformed();
    }

    private void lblIndicatorMouseClicked(MouseEvent evt) {
    	logger.info("hello");
        actionPerformed();
    }

    private void lblIndicatorMouseEntered(MouseEvent evt) {
    	logger.info("hello");
        this.setBackground(this.defaultBackColor.brighter().brighter());
        this.iconButton.setIcon(this.getRollOverIcon());
    }

    private void lblIndicatorMouseExited(MouseEvent evt) {//GEN-FIRST:event_lblIndicatorMouseExited
        this.setBackground(this.defaultBackColor);
        this.iconButton.setIcon(this.getIcon());
    }

    public void actionPerformed() { 
    	
        if (this.editorClass != null) {
        	//logger.info("checkPost_1");
            Object editor = null;
            try {
                editor = EditorsRegistry.getInstance().getEditor(editorClass);
             //   logger.info("checkPost_2");
                /*
                if (editor instanceof PopulateOptionsEditor) {
                    ((PopulateOptionsEditor) editor).populateOptions();
                }
*/
              //  logger.info("setting editor:"+editor.getClass().toString());
             
                EditorsRegistry.getInstance().setMainEditorsPaneView((Component) editor);
                EventBroker b = EventBroker.getInstance();
                b.publishEvent(new OnLoadPaneView(this,editorClass));
              //  updateUI();
            } catch (Exception ex) {
                logger.error("Error creating editor from class " + editorClass, ex);
             //   JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("com/jdimension/jlawyer/client/JKanzleiGUI").getString("error.loadingeditor") + ex.getMessage(), java.util.ResourceBundle.getBundle("com/jdimension/jlawyer/client/JKanzleiGUI").getString("msg.title.error"), JOptionPane.ERROR_MESSAGE);
            }
            try {
            	//logger.info("indicatorValue:"+this.indicatorValue);
               // this.updateIndicator(Integer.parseInt(this.indicatorValue));
            } catch (Throwable t) {
            	//logger.error("IndicatorValueError:",t);
            }
            
            setForeground(this.defaultBackColor);
        } else {
        	logger.info("editor class is null");
            EditorsRegistry.getInstance().setMainEditorsPaneView(null);
        }
       // logger.info("action performed finished");
    }

private void updateIndicator(int incomingValue) {
        
        SwingUtilities.invokeLater(() -> {
            String currentValue = indicatorValue;
            int cVal = 0;
            try {
                cVal = Integer.parseInt(currentValue);
            } catch (Throwable t) {
                lblIndicator.setForeground(DefaultColorTheme.COLOR_DARK_GREY);
                lblIndicator.setText("<html><table><tr><td>" + "<p style=\"color:white; background-color:#0E72B5; \">&nbsp;" + cVal +"&nbsp;</p></td></tr></table></html>");
            }
            if (incomingValue > cVal) {
                lblIndicator.setForeground(DefaultColorTheme.COLOR_LOGO_RED);
                lblIndicator.setText("<html><table><tr><td>" + "<p style=\"color:white; background-color:#DE313B; \">&nbsp;" + incomingValue +"&nbsp;</p></td></tr></table></html>");
                setForeground(DefaultColorTheme.COLOR_LOGO_GREEN);
            } else if (incomingValue==0) {
                lblIndicator.setForeground(DefaultColorTheme.COLOR_LOGO_RED);
                lblIndicator.setText("");
            } else {
                lblIndicator.setForeground(DefaultColorTheme.COLOR_DARK_GREY);
                lblIndicator.setText("<html><table><tr><td>" + "<p style=\"color:white; background-color:#0E72B5; \">&nbsp;" + incomingValue +"&nbsp;</p></td></tr></table></html>");
            }
            indicatorValue=""+incomingValue;
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton iconButton;
    private JLabel jLabel2;
    private JLabel lblIndicator;
    private JLabel lblModuleName;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * @return the rollOverIcon
     */
    public Icon getRollOverIcon() {
        return rollOverIcon;
    }

    /**
     * @param rollOverIcon the rollOverIcon to set
     */
    public void setRollOverIcon(Icon rollOverIcon) {
        this.rollOverIcon = rollOverIcon;
    }

   
  

   

}