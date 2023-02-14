package mySplashThread8.editors.addresses;

import mySplashThread8.editors.ResetOnDisplayEditor;
import mySplashThread8.utils.StringUtils;

//j-lawyer-org/j-lawyer-client/src/com/jdimension/jlawyer/client/editors/addresses/NewAddressPanel.java
public class NewAddressPanel extends AddressPanel implements ResetOnDisplayEditor {
    
    /** Creates a new instance of NewAddressPanel */
    public NewAddressPanel() {
        super();
        this.lblPanelTitle.setText("neue Adresse anlegen");
        
    }
    
    public void setCompany(String company) {
        this.txtCompany.setText(company);
    }
    
    public void setName (String name) {
        this.txtName.setText(name);
    }
    
    public void setFirstName (String name) {
        this.txtFirstName.setText(name);
    }
    
   

    @Override
    public boolean isDirty() {
        
        
        if (!StringUtils.isEmpty(this.txtCompany.getText())) {
            return true;
        }
        
        if (!StringUtils.isEmpty(this.txtFirstName.getText())) {
            return true;
        }
        
        if (!StringUtils.isEmpty(this.txtName.getText())) {
            return true;
        }
        
        if (!StringUtils.isEmpty(this.encryptionPwd)) {
            return true;
        }

        return false;
    }

    

    @Override
    public boolean needsReset() {
        return true;
    }
    
    
    
}
