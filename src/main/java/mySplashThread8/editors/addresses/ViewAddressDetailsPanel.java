package mySplashThread8.editors.addresses;

public class ViewAddressDetailsPanel extends AddressPanel {
    
    /** Creates a new instance of EditAddressPanel */
    public ViewAddressDetailsPanel() {
        super();
        this.setReadOnly(true);
       // this.cmdBackToSearch.setEnabled(true);
        //this.setOpenedFromEditorClass(ViewAddressPanel.class.getName());
        this.setOpenedFromEditorClass(EditAddressPanel.class.getName());
        this.cmdToEditMode.setEnabled(false);
        
        this.lblPanelTitle.setText("Adresse einsehen");
        //this.lblPanelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/info_big.png")));
    }

    @Override
    public boolean isDirty() {
        return false;
    }
    
    
    
}