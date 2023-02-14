package mySplashThread8.editors.addresses;

public class EditAddressDetailsPanel extends AddressPanel {
    
    /** Creates a new instance of EditAddressPanel */
    public EditAddressDetailsPanel() {
        super();
        this.setReadOnly(false);
        //this.cmdBackToSearch.setEnabled(true);
        this.setOpenedFromEditorClass(EditAddressPanel.class.getName());
        
        this.lblPanelTitle.setText("Adresse bearbeiten");
        //this.lblPanelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_big.png")));
    }
    
}