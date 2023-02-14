
package mySplashThread8.editors.applications;
import mySplashThread8.editors.EditorsRegistry;
import mySplashThread8.editors.SaveableEditor;
import mySplashThread8.editors.ThemeableEditor;
import mySplashThread8.model.base.dao.CustomApplicationDAO;
import mySplashThread8.model.base.dto.CustomApplicationDTO;
import mySplashThread8.model.base.entity.CustomApplication;
//import mySplashThread8.persistence.AddressBean;
/*
import com.jdimension.jlawyer.client.bea.BeaAccess;
import com.jdimension.jlawyer.client.bea.BeaIdentitySearchDialog;
import com.jdimension.jlawyer.client.bea.BeaLoginCallback;
import com.jdimension.jlawyer.client.bea.BeaLoginDialog;
import com.jdimension.jlawyer.client.bea.IdentityPanel;
import com.jdimension.jlawyer.client.bea.SendBeaMessageDialog;
import com.jdimension.jlawyer.client.components.MultiCalDialog;
import com.jdimension.jlawyer.client.configuration.BankSearchDialog;
import com.jdimension.jlawyer.client.configuration.CitySearchDialog;
import com.jdimension.jlawyer.client.configuration.OptionGroupListCellRenderer;
import com.jdimension.jlawyer.client.configuration.PopulateOptionsEditor;
import com.jdimension.jlawyer.client.editors.EditorsRegistry;
import com.jdimension.jlawyer.client.editors.SaveableEditor;
import com.jdimension.jlawyer.client.editors.ThemeableEditor;
import com.jdimension.jlawyer.client.editors.files.NewArchiveFilePanel;
import com.jdimension.jlawyer.client.encryption.PasswordGenerator;
import com.jdimension.jlawyer.client.events.ContactUpdatedEvent;
import com.jdimension.jlawyer.client.events.EventBroker;
import com.jdimension.jlawyer.client.mail.SendEmailDialog;
*/
import mySplashThread8.settings.ClientSettings;
//import com.jdimension.jlawyer.client.utils.JTextFieldLimit;
import mySplashThread8.utils.StringUtils;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jens
 */
//https://github.com/jlawyerorg/j-lawyer-org/blob/a2a96a1d34b21c7ac938c7b794a08fd8c594f0ee/j-lawyer-client/src/com/jdimension/jlawyer/client/editors/addresses/AddressPanel.java
//j-lawyer-org/j-lawyer-client/src/com/jdimension/jlawyer/client/editors/addresses/AddressPanel.java 
public class ApplicationPanel extends JPanel  implements ThemeableEditor,SaveableEditor/*implements BeaLoginCallback, ThemeableEditor, PopulateOptionsEditor, */{

	private static final Logger logger = LoggerFactory.getLogger(ApplicationPanel.class);
    private Image backgroundImage = null;
    protected String encryptionPwd = null;
private CustomApplicationDTO dto=null;
    /**
     * Creates new form AddressPanel
     */
    public ApplicationPanel() {
      
        initComponents();
      
       
    }

   

   

    public void setOpenedFromEditorClass(String editorClassName) {
    }

    public void setReadOnly(boolean readOnly) {

       
        this.txtDisplayName.setEnabled(!readOnly);


        this.txtName.setEnabled(!readOnly);
       
    }

   

    public void reset() {
        this.clearInputs();
    }

   

    public void clearInputs() {      
		this.txtDisplayName.setText("");     
		this.txtName.setText("");
		this.txtDescription.setText("");
    }

    public void setBackgroundImage(Image image) {
        this.backgroundImage = image;
        this.jPanel1.setOpaque(false);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.backgroundImage != null) {
            g.drawImage(this.backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    public void populateOptions() {
        ClientSettings.getInstance();
      
       
    }

   
    private void initComponents() {

       
       
       
       	cmdSave = new JButton();
      
       	lblPanelTitle= new JLabel();
		txtDisplayName = new JTextField();
		
           
           
           //Panel 1
		jPanel1 = new JPanel();
		lblName = new JLabel();
		lblDisplayName = new JLabel();
		lblDescription = new JLabel();
		lblName.setText("Name");
       lblDisplayName.setText("Display Name");
       lblDescription.setText("Description");
           
           txtName = new JTextField();       
           txtDisplayName = new JTextField();
          
           txtDescription = new JTextArea();
           txtDescription.setLineWrap(true);
           txtDescription.setWrapStyleWord(true);
           
           txtDescription.setColumns(20);
         
           txtDescription.setRows(5);
         
          
         
           
           lblPanelTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
           lblPanelTitle.setForeground(new java.awt.Color(255, 255, 255));
           lblPanelTitle.setText("jLabel19");
          
          // jLabel47.setText("label 47");
           
           
           cmdSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filesave.png"))); // NOI18N
           cmdSave.setToolTipText("Speichern");
           cmdSave.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   cmdSaveActionPerformed(evt);
               }
           });
           
         
         
           
           //new entry
           setJPanel1Layout();
       
           //	new entry
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)                 
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  
                    )
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
               
                .addContainerGap())
        );
    

       
     
    }
private void cmdSaveActionPerformed(ActionEvent vnt) {
		
		//logger.info("save action performed");
		this.save();
		revalidate();
		
		
	}
   
   
    
   
   
  
    private void setJPanel1Layout() {
    	
 	   GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
 	  jPanel1Layout.setAutoCreateGaps(true);
 	 jPanel1Layout.setAutoCreateContainerGaps(true);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup().
			addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addComponent(lblName)
				.addComponent(lblDisplayName)
				.addComponent(lblDescription)
			)
			.addGroup(jPanel1Layout.createParallelGroup()
				.addComponent(txtName)                          
				.addComponent(txtDisplayName)
				.addComponent(txtDescription)
			)
			.addGroup(jPanel1Layout.createParallelGroup()
				.addComponent(cmdSave,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
			)       
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()                    
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)                        
						.addComponent(lblName,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addComponent(txtName,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
					 )
                        
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(txtDisplayName,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDisplayName)
					)
                       
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(txtDescription,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescription)
					)                 
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)       
						.addComponent(cmdSave,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
					)
                    
                    
                .addContainerGap()
                )
        );
    }
    
    

  
   
  
    public boolean isDirty() {
       

      

    
     
      

        return false;
    }
    
    private void cmdToEditModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdToEditModeActionPerformed
    	logger.info("cmdToEditModeActionPerformed");
        try {
            Object editor = EditorsRegistry.getInstance().getEditor(EditApplicationDetailsPanel.class.getName());

            if (editor instanceof ThemeableEditor) {
                // inherit the background to newly created child editors
                ((ThemeableEditor) editor).setBackgroundImage(this.backgroundImage);
            }

           
            save();
          
            EditorsRegistry.getInstance().setMainEditorsPaneView((Component) editor);
        } catch (Exception ex) {
          //  log.error("Error creating editor from class " + this.openedFromEditorClass, ex);
           // JOptionPane.showMessageDialog(this, "Fehler beim Laden des Editors: " + ex.getMessage(), com.jdimension.jlawyer.client.utils.DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }
  public void setAddressDTO(CustomApplication customApplication) {
	  
	dto = new CustomApplicationDTO();
	  	dto.setId(customApplication.getId());
	  	dto.setDescription(customApplication.getDescription());
	  	dto.setName(customApplication.getName());
	  	dto.setDisplayName(customApplication.getDisplayName());
    	txtDisplayName.setText(dto.getDisplayName());
    	txtName.setText(dto.getName());
    	txtDescription.setText(dto.getDescription());
    }
    @Override
	public boolean save() {
		// TODO Auto-generated method stub
    	//logger.info("save function called");
		ClientSettings settings = ClientSettings.getInstance();
		CustomApplicationDAO customApplicationDAO = settings.getFactoryDAO().getAffiliationDAO();
		int id =-1;
		if(null != dto) {
		 id = dto.getId();
		
		}
		String name = txtName.getText();
		String displayName = txtDisplayName.getText();
		String description = txtDescription.getText();
		customApplicationDAO.save(id, name, displayName, description);
		  this.clearInputs(); 
		return true;
	}

   
    public Image getBackgroundImage() {
        return this.backgroundImage;
    }

    public void loginSuccess() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void loginFailure(String msg) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    final class OptionsComboBoxModel extends DefaultComboBoxModel {

        public OptionsComboBoxModel(Object[] items) {
            super(items);
        }
    }
    private JPanel jPanel1;
   
   
    private JButton cmdSave; 
   
    private JLabel lblName;
    private JLabel lblDisplayName;

    private JLabel lblDescription;

    
    protected JLabel lblPanelTitle;

    protected JTextField txtName;
    protected JTextField txtDisplayName;    
    protected JTextArea txtDescription;
	



}
