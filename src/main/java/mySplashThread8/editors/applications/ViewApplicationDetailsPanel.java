package mySplashThread8.editors.applications;

public class ViewApplicationDetailsPanel  extends ApplicationPanel {
    
    /** Creates a new instance of EditAddressPanel */
    public ViewApplicationDetailsPanel() {
        super();
        this.setReadOnly(true);
       // this.cmdBackToSearch.setEnabled(true);
        //this.setOpenedFromEditorClass(ViewAddressPanel.class.getName());
        this.setOpenedFromEditorClass(EditApplicationPanel.class.getName());
      //  this.cmdToEditMode.setEnabled(false);
        
        this.lblPanelTitle.setText("Adresse einsehen");
        //this.lblPanelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/info_big.png")));
    }

    @Override
    public boolean isDirty() {
        return false;
    }
    
    
    
}