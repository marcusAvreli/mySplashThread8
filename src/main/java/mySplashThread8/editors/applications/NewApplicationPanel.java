package mySplashThread8.editors.applications;

import mySplashThread8.editors.ResetOnDisplayEditor;
import mySplashThread8.editors.addresses.AddressPanel;
import mySplashThread8.utils.StringUtils;

public class NewApplicationPanel extends ApplicationPanel implements ResetOnDisplayEditor {
    
    /** Creates a new instance of NewAddressPanel */
    public NewApplicationPanel() {
        super();
        this.lblPanelTitle.setText("new application apply from NewApplicationPanel");
        
    }
    
   
    
    public void setName (String name) {
        this.txtName.setText(name);
    }
    
    public void setDisplayName (String name) {
        this.txtDisplayName.setText(name);
    }
    
   

    @Override
    public boolean isDirty() {
        
        
        
        
        if (!StringUtils.isEmpty(this.txtDisplayName.getText())) {
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
