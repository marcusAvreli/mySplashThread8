package mySplashThread8.modulebar;

import java.awt.Color;
import java.awt.Font;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.themes.colors.DefaultColorTheme;

/**
 *
 * @author jens
 */
public class ModuleGroupLabel extends javax.swing.JPanel {

    
    private static final Logger logger = LoggerFactory.getLogger(ModuleButton.class);
    /**
     * Creates new form ModuleButton
     */
    public ModuleGroupLabel(String groupCaption) {
        initComponents();
        this.lblModuleName.setText(groupCaption);
        this.lblModuleName.setFont(this.lblModuleName.getFont().deriveFont(Font.BOLD));
        //this.setBackground(DefaultColorTheme.COLOR_DARK_GREY);
        
        
//        this.setBackground(Color.WHITE);
//        this.lblModuleName.setForeground(DefaultColorTheme.COLOR_LOGO_BLUE.darker());

        this.lblModuleName.setForeground(Color.WHITE);
        this.setBackground(DefaultColorTheme.COLOR_LOGO_BLUE);

    }

    public void setText(String text) {
        this.lblModuleName.setText(text);
    }

    public String getText() {
        return this.lblModuleName.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModuleName = new javax.swing.JLabel();

        lblModuleName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblModuleName.setText("jLabel1");
        lblModuleName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblModuleName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblModuleName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblModuleName;
    // End of variables declaration//GEN-END:variables

    

}