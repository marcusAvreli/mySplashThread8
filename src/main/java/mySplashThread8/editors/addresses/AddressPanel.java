
package mySplashThread8.editors.addresses;
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
public class AddressPanel extends JPanel  implements ThemeableEditor,SaveableEditor/*implements BeaLoginCallback, ThemeableEditor, PopulateOptionsEditor, */{

	private static final Logger logger = LoggerFactory.getLogger(AddressPanel.class);
    //private AddressBean dto = null;
    private String openedFromEditorClass = null;
    private Image backgroundImage = null;
    protected String encryptionPwd = null;
private CustomApplicationDTO dto=null;
    /**
     * Creates new form AddressPanel
     */
    public AddressPanel() {
        //this.dto = null;
       // logger.info("init address panel");
        initComponents();
       // logger.info("init address panel finished");
       
    }

   

   

    public void setOpenedFromEditorClass(String editorClassName) {
        this.openedFromEditorClass = editorClassName;
    }

    public void setReadOnly(boolean readOnly) {

       
        this.txtFirstName.setEnabled(!readOnly);


        this.txtName.setEnabled(!readOnly);
       
    }

   

    public void reset() {
        this.clearInputs();
    }

   

    public void clearInputs() {      
		this.txtFirstName.setText("");     
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
        ClientSettings settings = ClientSettings.getInstance();
      
       
    }

   
    private void initComponents() {

        jPanel22 = new JPanel();
       	jPanel23 = new JPanel();
       	jPanel16 = new JPanel();
       
       	cmdSave = new JButton();
       	cmdDelete  = new JButton();
       	jLabel25 = new JLabel();
       	jLabel30 = new JLabel();
       	jLabel31 = new JLabel();    	
       	
       	jLabel47 = new JLabel();
       	lblPanelTitle= new JLabel();
		txtFirstName = new JTextField();
		txtCompany = new JTextField();
           
           
           //Panel 1
		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel40 = new JLabel();
		jLabel1.setText("Name");
           jLabel2.setText("Display Name");
           jLabel40.setText("Description");
           
           txtName = new JTextField();       
           txtFirstName = new JTextField();
           txtDescription = new JTextArea();
           txtDescription.setLineWrap(true);
           txtDescription.setWrapStyleWord(true);
           
           
          
           jSeparator2 = new JSeparator();
           
           lblPanelTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
           lblPanelTitle.setForeground(new java.awt.Color(255, 255, 255));
           lblPanelTitle.setText("jLabel19");
          
           jLabel47.setText("label 47");
           
           
           cmdSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filesave.png"))); // NOI18N
           cmdSave.setToolTipText("Speichern");
           cmdSave.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   cmdSaveActionPerformed(evt);
               }
           });
           
           //cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filesave.png"))); // NOI18N
           cmdDelete.setText("Delete");
           cmdDelete.setToolTipText("Delete");
           cmdDelete.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                   cmdSaveActionPerformed(evt);
               }
           });
           
           //update entry
           setJPanel16Layout();
           setJPanel23Layout();
           
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
                   // .add(lblHeaderInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    //.add(jTabbedPane1)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdDelete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    )
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(cmdDelete,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
               // .addGap(0, 0, 0)
                //.add(lblHeaderInfo)
                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                //.add(jTabbedPane1,GroupLayout.PREFERRED_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );
    

       
     
    }
private void cmdSaveActionPerformed(ActionEvent vnt) {
		
		//logger.info("save action performed");
		this.save();
		revalidate();
		
		
	}
    private void cmdChooseCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdChooseCityActionPerformed
    	/*
        CitySearchDialog dlg = new CitySearchDialog(EditorsRegistry.getInstance().getMainWindow(), true, this.txtZipCode, this.txtCity);
        FrameUtils.centerDialog(dlg, EditorsRegistry.getInstance().getMainWindow());
        dlg.setVisible(true);
        */
    }//GEN-LAST:event_cmdChooseCityActionPerformed

   
    
   
   
  
    private void setJPanel1Layout() {
 	   GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel31,GroupLayout.Alignment.TRAILING )
                                    .addComponent(jLabel2))
                                .addComponent(jLabel40,GroupLayout.PREFERRED_SIZE, 65,GroupLayout.PREFERRED_SIZE))
                            .addGap(63, 63, 63))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel30,GroupLayout.PREFERRED_SIZE, 152,GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel47)
                            //.add(jLabel41)
                            //.add(jLabel44)
                            )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            //.add(cmbTitle, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           // .add(cmbTitleInAddress, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName)
                           // .add(txtBirthName)
                            .addComponent(txtFirstName)
                            .addComponent(txtDescription)
                            )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                       .addComponent(jSeparator2,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        )
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                               // .add(cmbProfession,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                               // .add(jLabel45)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            //    .add(cmbRole,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                            .addGroup(jPanel1Layout.createSequentialGroup()
                              //  .add(jLabel42)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                              //  .add(cmbDegreePrefix,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                              //  .add(jLabel43)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                               // .add(cmbDegreeSuffix,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                )
                           // .add(txtInitials,GroupLayout.PREFERRED_SIZE, 100,GroupLayout.PREFERRED_SIZE)
                           // .add(cmbNationality,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            )
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                 //   .add(cmbTitle,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                   // .add(cmbTitleInAddress,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel47))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtName,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    //.add(txtBirthName,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel31)
                             		   ))
                            .addComponent(jSeparator2,GroupLayout.PREFERRED_SIZE, 112,GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFirstName,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                           .addComponent(txtDescription,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40)
                     		   )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            //.add(cmbNationality,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                     		   )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            //.add(jLabel41)
                            //.add(jLabel42)
                            //.add(cmbDegreePrefix, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            //.add(jLabel43)
                            //.add(cmbDegreeSuffix,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                     		   )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            //.add(cmbProfession,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            //.add(jLabel45)
                            //.add(cmbRole,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                            //.add(jLabel44)
                     		   )
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel22, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }
    
    
    private void tblResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultsMouseClicked
    	logger.info("tblResultsMouseClicked");
      /*  if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
            this.useSelection();
        } else if (evt.getClickCount() == 1 && evt.getButton() == MouseEvent.BUTTON3) {
            int selectionCount=this.tblResults.getSelectedRowCount();
            if (selectionCount < 1) {
                return;
            }
            this.mnuOpenSelectedAddress.setEnabled(selectionCount==1);
            this.popupAddressActions.show(this.tblResults, evt.getX(), evt.getY());
        } else if (evt.getClickCount() == 1 && evt.getButton() == MouseEvent.BUTTON1) {
            if (this.tblResults.getSelectedRowCount() == 1) {
                try {
                    int row = this.tblResults.getSelectedRow();
                    QuickAddressSearchRowIdentifier id = (QuickAddressSearchRowIdentifier) this.tblResults.getValueAt(row, 0);

                    ClientSettings settings = ClientSettings.getInstance();
                    JLawyerServiceLocator locator = JLawyerServiceLocator.getInstance(settings.getLookupProperties());
                    ArchiveFileServiceRemote afRem = locator.lookupArchiveFileServiceRemote();
                    Collection col = afRem.getArchiveFileAddressesForAddress(id.getAddressDTO().getId());
                    List<ArchiveFileBean> partyFiles = new ArrayList<>();
                    for (Object o : col) {
                        ArchiveFileAddressesBean afb = (ArchiveFileAddressesBean) o;
                            partyFiles.add(afb.getArchiveFileKey());
                        
                    }
                    String html = AddressPanel.getArchiveFilesAsHTML(partyFiles);
                    this.lblSummary.setText(html);
                } catch (Exception ex) {
                    log.error("Error getting archive files for address", ex);
                    JOptionPane.showMessageDialog(this, "Fehler beim Laden der Akten zur Adresse: " + ex.getMessage(), com.jdimension.jlawyer.client.utils.DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
                    EditorsRegistry.getInstance().clearStatus();
                }
            } else {
                this.lblSummary.setText("");
            }
        }
*/
    }//GEN-LAST:event_tblResultsMouseClicked
    
  
     private  void setJPanel16Layout() {
         cmdToEditMode = new javax.swing.JButton();

    	 cmdToEditMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
         cmdToEditMode.setToolTipText("Bearbeiten");
         cmdToEditMode.setEnabled(false);
         cmdToEditMode.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 cmdToEditModeActionPerformed(evt);
             }
         });
    	 
     	GroupLayout jPanel16Layout = new GroupLayout(jPanel16);
         jPanel16.setLayout(jPanel16Layout);
         jPanel16Layout.setHorizontalGroup(
             jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(jPanel16Layout.createSequentialGroup()
                 .addContainerGap()
                // .add(cmdBackToSearch)
                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(cmdToEditMode)
                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(cmdSave)
                 .addContainerGap())
         );
         jPanel16Layout.setVerticalGroup(
             jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(jPanel16Layout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addComponent(cmdSave)
                   //  .add(cmdBackToSearch)
                     .addComponent(cmdToEditMode)
                     )
                 .addContainerGap())
         );
     }
    private void setJPanel23Layout() {
 	   GroupLayout jPanel23Layout = new GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
               // .add(jLabel18)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPanelTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(162, 162, 162)
                .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                       // .add(chkEncryption)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                       // .add(cmdNewSmsWithEncryptionPassword)
                        )
                    //.add(GroupLayout.Alignment.TRAILING, lblEncryption)
                    ))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblPanelTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   // .add(GroupLayout.Alignment.LEADING, jLabel18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    )
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                   // .add(cmdNewSmsWithEncryptionPassword)
                 //   .add(chkEncryption)
             		   )
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
               // .add(lblEncryption)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }
    public boolean isDirty() {
       

      

    
     
      

        return false;
    }
    
    private void cmdToEditModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdToEditModeActionPerformed
    	logger.info("cmdToEditModeActionPerformed");
        try {
            Object editor = EditorsRegistry.getInstance().getEditor(EditAddressDetailsPanel.class.getName());

            if (editor instanceof ThemeableEditor) {
                // inherit the background to newly created child editors
                ((ThemeableEditor) editor).setBackgroundImage(this.backgroundImage);
            }
/*
            if (editor instanceof PopulateOptionsEditor) {
                ((PopulateOptionsEditor) editor).populateOptions();
            }*/
          //  ((AddressPanel) editor).setAddressDTO(this.dto);
            /*ClientSettings settings = ClientSettings.getInstance();
    		CustomApplicationDAO customApplicationDAO = settings.getFactoryDAO().getAffiliationDAO();
    		int id = dto.getId();
    		String name = txtName.getText();
    		String displayName = txtFirstName.getText();
    		String description = txtDescription.getText();
    		customApplicationDAO.save(id, name, displayName, description);*/
            save();
           // NavigationUtils.getInstance().selectTreeModule(EditAddressDetailsPanel.class.getName());
            EditorsRegistry.getInstance().setMainEditorsPaneView((Component) editor);
        } catch (Exception ex) {
          //  log.error("Error creating editor from class " + this.openedFromEditorClass, ex);
           // JOptionPane.showMessageDialog(this, "Fehler beim Laden des Editors: " + ex.getMessage(), com.jdimension.jlawyer.client.utils.DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmdToEditModeActionPerformed
  public void setAddressDTO(CustomApplication customApplication) {
	  
	dto = new CustomApplicationDTO();
	  	dto.setId(customApplication.getId());
	  	dto.setDescription(customApplication.getDescription());
	  	dto.setName(customApplication.getName());
	  	dto.setDisplayName(customApplication.getDisplayName());
    	txtFirstName.setText(dto.getDisplayName());
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
		String displayName = txtFirstName.getText();
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
    private JPanel jPanel22;
    private JPanel jPanel16;
    private JPanel jPanel23;
    private JButton cmdSave; 
    private JButton cmdDelete;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel25;

    private JLabel jLabel30;
    protected JTextField txtCompany;
    private JLabel jLabel31;
    private JLabel jLabel40;
    private JLabel jLabel47;
    private JSeparator jSeparator2;
    protected JLabel lblPanelTitle;
    //Panel 1
    //jpanel16
    protected javax.swing.JButton cmdToEditMode;

    protected JTextField txtName;
    protected JTextField txtFirstName;    
    protected JTextArea txtDescription;
	



}
