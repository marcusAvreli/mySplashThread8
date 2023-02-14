package mySplashThread8.editors.applications;

import mySplashThread8.editors.addresses.AddressPanel;
import mySplashThread8.editors.addresses.EditAddressPanel;

public class EditApplicationDetailsPanel extends ApplicationPanel {
    
    /** Creates a new instance of EditAddressPanel */
    public EditApplicationDetailsPanel() {
        super();
        this.setReadOnly(false);
        //this.cmdBackToSearch.setEnabled(true);
        this.setOpenedFromEditorClass(EditApplicationPanel.class.getName());
        
        this.lblPanelTitle.setText("Application bearbeiten");
        //this.lblPanelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_big.png")));
    }
    
}
