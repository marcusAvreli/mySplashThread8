package mySplashThread8.editors.addresses;

import mySplashThread8.DemoPaginationBar;
import mySplashThread8.FactoryDAO;
import mySplashThread8.MagTable;
import mySplashThread8.dynagent.common.utils.Auxiliar;
import mySplashThread8.dynagent.common.utils.RowItem;
//import com.jdimension.jlawyer.client.configuration.PopulateOptionsEditor;
import mySplashThread8.editors.EditorsRegistry;
import mySplashThread8.editors.ResetOnDisplayEditor;
import mySplashThread8.editors.ThemeableEditor;
import mySplashThread8.events.Event;
import mySplashThread8.events.EventBroker;
import mySplashThread8.events.EventConsumer;
import mySplashThread8.events.OnLoadPaneView;
import mySplashThread8.gdev.gawt.GTable;
import mySplashThread8.gdev.gawt.GTableModelReduction;
import mySplashThread8.gen.GConst;
import mySplashThread8.gfld.GFormField;
import mySplashThread8.gfld.GFormTable;
import mySplashThread8.gfld.GTableColumn;
import mySplashThread8.gfld.GTableRow;
import mySplashThread8.model.base.dao.CustomApplicationDAO;
import mySplashThread8.model.base.entity.CustomApplication;
import mySplashThread8.nepxion.swing.pagination.PaginationContext;
//import com.jdimension.jlawyer.client.editors.ResetOnDisplayEditor;
//import com.jdimension.jlawyer.client.editors.ThemeableEditor;
import mySplashThread8.settings.ClientSettings;
import mySplashThread8.utils.ThreadUtils;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jens
 */
public class QuickAddressSearchPanel extends JPanel implements ThemeableEditor, EventConsumer,ResetOnDisplayEditor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 806497561967679020L;

	private static final Logger logger = LoggerFactory.getLogger(QuickAddressSearchPanel.class);

    private String detailsEditorClass;
    private Image backgroundImage = null;
    private Set<String> selectedIds = null;
  //VARIABLES_DATA
  	private GTable gtable;
  	private DemoPaginationBar bar;
  	private PaginationContext paginationContext;
  	EventBroker eventBroker = null;
  	 private List<CustomApplication> customApplications;
	   private FactoryDAO factoryDAO = null;
	    private Vector<GTableColumn> listaColumnas = null;
	    private Vector<GTableRow> rows = null;
	    private GFormTable m_objFormField = null;
	    private int size =0;
    /**
     * Creates new form QuickAddressSearchPanel
     */
    public QuickAddressSearchPanel() {
    	eventBroker = EventBroker.getInstance();
		eventBroker.subscribeConsumer(this, Event.TYPE_ROW_SELECTION_CHANGED);
		//eventBroker.subscribeConsumer(this, Event.TYPE_LOAD_PANE_VIEW);
        initComponents();
        
        this.txtSearchString.putClientProperty("JTextField.showClearButton", true);
        this.txtSearchString.putClientProperty("JTextField.placeholderText", "Suche: Adressen");
        
      
        String[] colNames = new String[]{"Name", "Vorname", "Unternehmen", "Abteilung", "PLZ", "Ort", "Strasse", "Nr.", "Land", "Etiketten"};
        QuickAddressSearchTableModel model = new QuickAddressSearchTableModel(colNames, 0);
      //  this.tblResults.setModel(model);
        this.detailsEditorClass = ViewAddressDetailsPanel.class.getName();
       // ComponentUtils.autoSizeColumns(tblResults);
        
        
    }

    public void populateTags(List<String> tags) {

        //TagUtils.populateTags(tags, cmdTagFilter, popTagFilter, null);
        
    }
 
    public void clearInputs() {
    	logger.info("clear inputs");
        this.txtSearchString.setText("");
        String[] colNames = new String[]{"Name", "Vorname", "Unternehmen", "Abteilung", "PLZ", "Ort", "Strasse", "Nr.", "Land", "Etiketten"};
        QuickAddressSearchTableModel model = new QuickAddressSearchTableModel(colNames, 0);
       // this.tblResults.setModel(model);
    }

    public void setBackgroundImage(Image image) {
    	logger.info("setBackgroundImage");
        this.backgroundImage = image;
        //this.tblResults.setOpaque(false);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.backgroundImage != null) {
            g.drawImage(this.backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    public void updateTable() {
    	logger.info("updateTable");
        /*
        if (("".equals(this.txtSearchString.getText()) && this.tblResults.getRowCount() > 0) || !("".equals(this.txtSearchString.getText()))) {
            this.cmdQuickSearchActionPerformed(null);
        }
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	//logger.info("START QuickAddressSearchPanel");
        popupAddressActions = new javax.swing.JPopupMenu();
        mnuOpenSelectedAddress = new javax.swing.JMenuItem();
        mnuDuplicateSelectedAddress = new javax.swing.JMenuItem();
        mnuDeleteSelectedAddresses = new javax.swing.JMenuItem();
        popTagFilter = new javax.swing.JPopupMenu();
        txtSearchString = new javax.swing.JTextField();
      //  jScrollPane1 = new javax.swing.JScrollPane();
       // tblResults = new javax.swing.JTable();
        cmdQuickSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblSummary = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblPanelTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmdExport = new JButton();
        cmdDelete = new JButton();
        cmdTagFilter = new JButton();

        mnuOpenSelectedAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vcard.png"))); // NOI18N
        mnuOpenSelectedAddress.setText("öffnen");
        mnuOpenSelectedAddress.setToolTipText("gewählte Adresse öffnen");
        mnuOpenSelectedAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOpenSelectedAddressActionPerformed(evt);
            }
        });
        popupAddressActions.add(mnuOpenSelectedAddress);

        mnuDuplicateSelectedAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editcopy.png"))); // NOI18N
        mnuDuplicateSelectedAddress.setText("duplizieren");
        mnuDuplicateSelectedAddress.setToolTipText("gewählte Adresse duplizieren");
        mnuDuplicateSelectedAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDuplicateSelectedAddressActionPerformed(evt);
            }
        });
        popupAddressActions.add(mnuDuplicateSelectedAddress);

        mnuDeleteSelectedAddresses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editdelete.png"))); // NOI18N
        mnuDeleteSelectedAddresses.setText("löschen");
        mnuDeleteSelectedAddresses.setToolTipText("gewählte Adressen löschen");
        mnuDeleteSelectedAddresses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteSelectedAddressesActionPerformed(evt);
            }
        });
        popupAddressActions.add(mnuDeleteSelectedAddresses);

        txtSearchString.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchStringKeyPressed(evt);
            }
        });

        //LOAD_DATA
       // loadData();
        
    	listaColumnas = buildColumns();
		/*
		List<CustomApplication> customApplications = new ArrayList<CustomApplication>();;
		
		try {
			
			if(null != customApplications) {
				size = customApplications.size();
			}
			paginationContext = new PaginationContext(size);
			cmdExport = new JButton();
			Vector<GTableColumn> listaColumnas = buildColumns();
			Vector<GTableRow> rows = buildRows(customApplications);		
			GFormTable m_objFormField = createTable(listaColumnas,rows);		
			gtable = new GTable(m_objFormField);
			gtable.createComponent();	
			bar = new DemoPaginationBar(gtable, paginationContext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		factoryDAO = ClientSettings.getInstance().getFactoryDAO();
		
		customApplications = new ArrayList<CustomApplication>();
		
	
	try {
		if(null != customApplications) {
			size = customApplications.size();
		}
		paginationContext = new PaginationContext(size);
		cmdExport = new JButton();
		
		rows = buildRows(customApplications);		
		
		m_objFormField = createTable(listaColumnas,rows);		
		
		rows = buildRows(customApplications);
		m_objFormField.setRowList(rows);
		gtable = new GTable(m_objFormField);
		gtable.createComponent();	
		bar = new DemoPaginationBar(gtable, paginationContext);
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
		MagTable magTable = gtable.getTable();
		 magTable.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter2");
	        magTable.getActionMap().put("Enter2", new AbstractAction() {
	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                useSelection();
	            }
	        });
       /* tblResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblResults.getTableHeader().setReorderingAllowed(false);
        tblResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblResultsMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultsMouseClicked(evt);
            }
        });
        tblResults.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblResultsKeyReleased(evt);
            }
        });*/
       // jScrollPane1.setViewportView(tblResults);
		
        cmdQuickSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/find.png"))); // NOI18N
        cmdQuickSearch.setToolTipText("Suchen");
        cmdQuickSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdQuickSearchActionPerformed(evt);
            }
        });

        lblSummary.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jScrollPane2.setViewportView(lblSummary);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Icons2-20.png"))); // NOI18N

        lblPanelTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPanelTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblPanelTitle.setText("jLabel19");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel1.setOpaque(false);

        cmdExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dumpViewer6/gui/icons16/calc.png"))); // NOI18N
        cmdExport.setToolTipText("Liste nach LibreOffice exportieren");
        cmdExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExportActionPerformed(evt);
            }
        });
        
        cmdDelete.setText("Delete"); // NOI18N
        cmdDelete.setToolTipText("Delete");
        cmdDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });
        cmdDelete.setEnabled(false);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdExport)
                .addComponent(cmdDelete)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdExport)
                .addComponent(cmdDelete)
                .addContainerGap())
        );

        cmdTagFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dumpViewer6/gui/icons16/favorites.png"))); // NOI18N
        cmdTagFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmdTagFilterMousePressed(evt);
            }
        });

       
        initLayout();
       // logger.info("FINISH QuickAddressSearchPanel");
    }// </editor-fold>//GEN-END:initComponents
private void initLayout() {
	  bar.refresh();
	     bar.repaint();
	     bar.revalidate();
	 GroupLayout layout = new GroupLayout(this);
     this.setLayout(layout);
     layout.setHorizontalGroup(
         layout.createParallelGroup(GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
             .addContainerGap()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                 .addComponent(bar, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                 .addComponent(jScrollPane2)
                 .addGroup(layout.createSequentialGroup()
                     .addComponent(txtSearchString)
                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(cmdQuickSearch)
                     .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                     .addComponent(cmdTagFilter))
                 .addGroup(layout.createSequentialGroup()
                     .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                     .addGap(18, 18, 18)
                     .addComponent(jLabel18)
                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(lblPanelTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
             .addContainerGap())
     );
     layout.setVerticalGroup(
         layout.createParallelGroup(GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
             .addContainerGap()
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                 .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                     .addComponent( lblPanelTitle,GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(jLabel18, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                 .addComponent(cmdQuickSearch,GroupLayout.Alignment.TRAILING)
                 .addComponent(txtSearchString, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                 .addComponent(cmdTagFilter))
             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(bar, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
             .addContainerGap())
     );
     GTableModelReduction objTableModel=       gtable.getModel();
     objTableModel.fireTableDataChanged();
     bar.refresh();
     bar.repaint();
     bar.revalidate();
     repaint();
     revalidate();
}
    private void loadData() {
    	//logger.info("RELOAD DATA START");
    	   int size = 0;
           FactoryDAO factoryDAO = ClientSettings.getInstance().getFactoryDAO();
   		CustomApplicationDAO customApplicationDAO =  factoryDAO.getAffiliationDAO();
   		List<CustomApplication> customApplications;
           
   		try {
   			customApplications = customApplicationDAO.getData();
   			if(null != customApplications) {
   				size = customApplications.size();
   			}
   			paginationContext = new PaginationContext(size);
   			cmdExport = new JButton();
   			Vector<GTableColumn> listaColumnas = buildColumns();
   			Vector<GTableRow> rows = buildRows(customApplications);		
   			GFormTable m_objFormField = createTable(listaColumnas,rows);		
   			gtable = new GTable(m_objFormField);
   			gtable.createComponent();	
   			bar = new DemoPaginationBar(gtable, paginationContext);
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		//logger.info("RELOAD DATA FINISH");
    }
    private void mnuDeleteSelectedAddressesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteSelectedAddressesActionPerformed
    	logger.info("mnuDeleteSelectedAddressesActionPerformed");
       /* int response = JOptionPane.showConfirmDialog(this, "Ausgewählte Adresse(n) löschen?", "Adresse löschen", JOptionPane.YES_NO_OPTION);
        if (response != JOptionPane.YES_OPTION) {
            return;
        }

        ThreadUtils.setWaitCursor(this, false);
        int[] selectedIndices = this.tblResults.getSelectedRows();
        Arrays.sort(selectedIndices);
        ArrayList<String> ids = new ArrayList<>();
        for (int i = 0; i < selectedIndices.length; i++) {
            QuickAddressSearchRowIdentifier id = (QuickAddressSearchRowIdentifier) this.tblResults.getValueAt(selectedIndices[i], 0);
         //   ids.add(id.getAddressDTO().getId());
        }

        EditorsRegistry.getInstance().updateStatus("Lösche " + ids.size() + " Adresse(n)...", false);
        ClientSettings settings = ClientSettings.getInstance();
        try {
            JLawyerServiceLocator locator = JLawyerServiceLocator.getInstance(settings.getLookupProperties());

            AddressServiceRemote addressService = locator.lookupAddressServiceRemote();
            for (int i = ids.size() - 1; i > -1; i--) {
                addressService.removeAddress(ids.get(i));
                QuickAddressSearchTableModel model = (QuickAddressSearchTableModel) this.tblResults.getModel();
                model.removeRow(this.tblResults.convertRowIndexToModel(selectedIndices[i]));
            }

            EditorsRegistry.getInstance().clearStatus(false);

        } catch (Exception ex) {
            logger.error("Error deleting address", ex);
            JOptionPane.showMessageDialog(this, "Fehler beim Löschen: " + ex.getMessage(), com.jdimension.jlawyer.client.utils.DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
            EditorsRegistry.getInstance().clearStatus(false);
        } finally {
            ThreadUtils.setDefaultCursor(this, false);
        }*/
    }//GEN-LAST:event_mnuDeleteSelectedAddressesActionPerformed

    private void useSelection() {
    	logger.info("useSelection_started");
    	MagTable magTable = gtable.getTable();
    	
       int row = magTable.getSelectedRow();
       logger.info("useSelection_started:"+row);
      /*  if (row < 0) {
            return;
        }*/
       String rowId = gtable.getModel().getDatabaseRowId();
       logger.info("test_row_id:"+rowId);
        String id =  gtable.getModel().getRowItemFromIndex(row).getDatabaseId();
        logger.info("useSelection_started:"+id);
        Object editor = null;
        try {
            editor = EditorsRegistry.getInstance().getEditor(this.detailsEditorClass);

            if (editor instanceof ThemeableEditor) {
                // inherit the background to newly created child editors
                ((ThemeableEditor) editor).setBackgroundImage(this.backgroundImage);
            }
            /*if (editor instanceof PopulateOptionsEditor) {
                ((PopulateOptionsEditor) editor).populateOptions();
            }
            */
            ClientSettings clientSettings = ClientSettings.getInstance();
            FactoryDAO factoryDAO = clientSettings.getFactoryDAO();
            CustomApplicationDAO customApplicationDAO = factoryDAO.getAffiliationDAO();
            CustomApplication customApplication = customApplicationDAO.getById(Integer.valueOf(id));
            ((AddressPanel) editor).setAddressDTO(customApplication);
            ((AddressPanel) editor).setOpenedFromEditorClass(this.getClass().getName());
            EditorsRegistry.getInstance().setMainEditorsPaneView((Component) editor);

        } catch (Exception ex) {
            logger.error("Error creating editor from class " + this.detailsEditorClass, ex);
          //  JOptionPane.showMessageDialog(this, "Fehler beim Laden des Editors: " + ex.getMessage(), com.jdimension.jlawyer.client.utils.DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        
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
                    logger.error("Error getting archive files for address", ex);
                    JOptionPane.showMessageDialog(this, "Fehler beim Laden der Akten zur Adresse: " + ex.getMessage(), com.jdimension.jlawyer.client.utils.DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
                    EditorsRegistry.getInstance().clearStatus();
                }
            } else {
                this.lblSummary.setText("");
            }
        }*/
setVisible(true);
    }//GEN-LAST:event_tblResultsMouseClicked

    private void txtSearchStringKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStringKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.cmdQuickSearchActionPerformed(null);
        }
    }//GEN-LAST:event_txtSearchStringKeyPressed

    private void cmdQuickSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdQuickSearchActionPerformed
        // perform search here
        EditorsRegistry.getInstance().updateStatus("Suche Adressen...");
        ThreadUtils.setWaitCursor(this);
        
      //  new Thread(new QuickAddressSearchThread(this, this.txtSearchString.getText(), TagUtils.getSelectedTags(this.popTagFilter), this.tblResults)).start();

    }//GEN-LAST:event_cmdQuickSearchActionPerformed

    private void tblResultsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultsKeyReleased
    	logger.info("tblResultsKeyReleased");
       /* if (this.tblResults.getSelectedRowCount() == 1 && (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP)) {
            try {
                int row = this.tblResults.getSelectedRow();
                QuickAddressSearchRowIdentifier id = (QuickAddressSearchRowIdentifier) this.tblResults.getValueAt(row, 0);

                ClientSettings settings = ClientSettings.getInstance();
                JLawyerServiceLocator locator = JLawyerServiceLocator.getInstance(settings.getLookupProperties());
                ArchiveFileServiceRemote afRem = locator.lookupArchiveFileServiceRemote();
                Collection<ArchiveFileAddressesBean> col = afRem.getArchiveFileAddressesForAddress(id.getAddressDTO().getId());
                List<ArchiveFileBean> partyFiles = new ArrayList<>();
                for (Object o : col) {
                    ArchiveFileAddressesBean afb = (ArchiveFileAddressesBean) o;
                        partyFiles.add(afb.getArchiveFileKey());
                    
                }
                String html = AddressPanel.getArchiveFilesAsHTML(partyFiles);
                this.lblSummary.setText(html);
            } catch (Exception ex) {
                logger.error("Error getting archive files for address", ex);
                JOptionPane.showMessageDialog(this, "Fehler beim Laden der Akten zur Adresse: " + ex.getMessage(), com.jdimension.jlawyer.client.utils.DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
                EditorsRegistry.getInstance().clearStatus();
            }
        } else {
            this.lblSummary.setText("");
        }*/
    }//GEN-LAST:event_tblResultsKeyReleased

    public void enableDeleteButton() {
    	logger.info("enable delete button");
    	if(null !=selectedIds && !selectedIds.isEmpty()) {
    		cmdDelete.setEnabled(true);
    		logger.info("open");
    	}else {
    		cmdDelete.setEnabled(false);
    		logger.info("close");
    	}
    }
    private void cmdDeleteActionPerformed(ActionEvent e) {
    	logger.info("delete action performed");
    	
         ClientSettings clientSettings = ClientSettings.getInstance();
         FactoryDAO factoryDAO = clientSettings.getFactoryDAO();
         CustomApplicationDAO customApplicationDAO = factoryDAO.getAffiliationDAO();
         Iterator<String> iterator  = selectedIds.iterator();
         while(iterator.hasNext()) {
        
        	 String selectedId = iterator.next();
        	 customApplicationDAO.deleteById((selectedId));
        	 iterator.remove();
         }
         enableDeleteButton();
         gtable.getModel().updateGUI(true);
         loadData();
         gtable.getModel().updateGUI(true);
        // gtable.getModel().removeRow(0);
         GTableModelReduction objTableModel=       gtable.getModel();
         objTableModel.fireTableDataChanged();
       //  initLayout();
        // repaint();
    	
    }
    private void cmdExportActionPerformed(ActionEvent evt) {
    	logger.info("cmdExportActionPerformed");
        /*try {
            TableUtils.exportAndLaunch("adresssuche-export.csv", this.tblResults);
        } catch (Exception ex) {
            logger.error("Error exporting table to CSV", ex);
            JOptionPane.showMessageDialog(this, "Fehler beim Export: " + ex.getMessage(), DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
        }*/
    }

    private void tblResultsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultsMousePressed
    	logger.info("tblResultsMousePressed");
        //TableUtils.handleRowClick(tblResults, evt);
    }//GEN-LAST:event_tblResultsMousePressed

    private void mnuOpenSelectedAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOpenSelectedAddressActionPerformed
        this.useSelection();
    }//GEN-LAST:event_mnuOpenSelectedAddressActionPerformed

    private void cmdTagFilterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdTagFilterMousePressed
        this.popTagFilter.show(this.cmdTagFilter, evt.getX(), evt.getY());
    }//GEN-LAST:event_cmdTagFilterMousePressed

    private void mnuDuplicateSelectedAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDuplicateSelectedAddressActionPerformed
    	logger.info("mnuDuplicateSelectedAddressActionPerformed");
        /*int[] selectedIndices = this.tblResults.getSelectedRows();
        Arrays.sort(selectedIndices);
        ArrayList<String> ids = new ArrayList<>();
        
        for (int i = 0; i < selectedIndices.length; i++) {
            QuickAddressSearchRowIdentifier id = (QuickAddressSearchRowIdentifier) this.tblResults.getValueAt(selectedIndices[i], 0);
            ids.add(id.getAddressDTO().getId());
        }
        
      /*  if (ids.size() > 1) {
            int response = JOptionPane.showConfirmDialog(this, "" + ids.size() + " Adressen duplizieren?", "Adressen duplizieren", JOptionPane.YES_NO_OPTION);
            if (response != JOptionPane.YES_OPTION) {
                return;
            }
        }

        ThreadUtils.setWaitCursor(this, false);
        EditorsRegistry.getInstance().updateStatus("Dupliziere " + ids.size() + " Adresse(n)...", false);
        ClientSettings settings = ClientSettings.getInstance();
       try {
            JLawyerServiceLocator locator = JLawyerServiceLocator.getInstance(settings.getLookupProperties());

            AddressServiceRemote addressService = locator.lookupAddressServiceRemote();
            for (int i = ids.size() - 1; i > -1; i--) {
                AddressBean source=addressService.getAddress(ids.get(i));
                Collection<AddressTagsBean> sourceTags=addressService.getTags(ids.get(i));
                String targetCompany=source.getCompany();
                boolean markedAsCopy=false;
                if(targetCompany!=null) {
                    if(targetCompany.length()>0) {
                        source.setCompany(source.getCompany() + " (Kopie)");
                        markedAsCopy=true;
                    }
                }
                if(!markedAsCopy) {
                    String targetLastName=StringUtils.nonNull(source.getName());
                    targetLastName=targetLastName + " (Kopie)";
                    source.setName(targetLastName);
                }
                AddressBean target=addressService.createAddress(source);
                for(AddressTagsBean atb: sourceTags) {
                    addressService.setTag(target.getId(), atb, true);
                }
            }

            EditorsRegistry.getInstance().clearStatus(false);
            this.cmdQuickSearchActionPerformed(null);
        } catch (Exception ex) {
            log.error("Error duplicating contacts", ex);
            JOptionPane.showMessageDialog(this, "Fehler beim Duplizieren: " + ex.getMessage(), com.jdimension.jlawyer.client.utils.DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
            EditorsRegistry.getInstance().clearStatus(false);
        } finally {
            ThreadUtils.setDefaultCursor(this, false);
        }*/
    }//GEN-LAST:event_mnuDuplicateSelectedAddressActionPerformed

    public Vector<GTableColumn> buildColumns() {
		Vector<GTableColumn> listaColumnas = new Vector<GTableColumn>();
		GTableColumn column = buildSelectionColumn();
    	listaColumnas.add(column);   	
    	column = buildName();
		//(String id,		String idParent,	int col,		String 	strLab,		int type,	String ref,		int idProp,		int width,	int height,	int length,		String 	mask,boolean 	enable,		boolean hide,	boolean total,	boolean agrupable,	boolean dobleSizeHeader,boolean nullable,	boolean creation,	int finder,		boolean basicEdition,	boolean uniqueValue,Integer redondeo)
    	
    	listaColumnas.add(column);
    	column = buildDisplayName();
    	listaColumnas.add(column);
    	return listaColumnas;
	}
	public Vector<GTableRow> buildRows(List<CustomApplication> customApplications) {
		Vector<GTableRow> rows = new Vector<GTableRow>();
		GTableRow row = null;
		if(null != customApplications) {
			for(CustomApplication customApplication : customApplications) {
	    		String appName = customApplication.getName();
	    		String displayName = customApplication.getDisplayName();

	    		row=new GTableRow();	
	    		row.setDatabaseId(String.valueOf(customApplication.getId()));	    		
	    		row.setDataColumn("name", appName);
	    		row.setDataColumn("displayName", displayName);
	    		rows.add(row);    		
	    	}	
		}
		return rows;
	}
	
	 public  GFormTable createTable(Vector<GTableColumn> vColumns,Vector<GTableRow> vRows) {
	    	GFormTable table = new GFormTable();
	     
	        
	       
	        Enumeration en = vColumns.elements();
	        while(en.hasMoreElements())
	        {
	            GTableColumn col = (GTableColumn)en.nextElement();
	            table.addColumn(col);
	        }
	        Enumeration enRows = vRows.elements();
	        while(enRows.hasMoreElements())
	        {
	            GTableRow row = (GTableRow)enRows.nextElement();
	            table.addRow(row);
	        }
	        return table;
	    }
	 
	 public  GTableColumn buildSelectionColumn() {
	  	  /** El id de la columna*/
	        String m_iId = "SELECTION";
	        /** El índice de la columna (empezando desde 0)*/
	        int m_iColumn=2;
	        /** El nombre de la columna*/
	        String m_strLabel="";
	        /** El código del tipo de la columna*/
	        int m_iType=GConst.TM_BOOLEAN;
	        /** Si la columna es editable*/
	        boolean m_enable=true;
	    	//No se tiene permiso para modificar este campo.
	        /** Si la columna está oculta o no*/
	        boolean m_hide=false;
	        /** Si se puede resumir en una*/
	         boolean m_total=true;
	        /** Si se puede agrupar en varios valores*/
	        boolean m_agrupable=true;
	        /** Id de la columna*/
	         int m_idProp=0;
	        /** Ancho de la columna*/
	       int m_width=100;
	        /** Alto de la columna*/
	       int m_height=120;
	        /** Longitud de la columna*/
	       int m_length=100;
	        /** */
	       String m_ref="m_ref";
	        /** */
	       boolean m_dobleSizeHeader = false;
	        /** Si acepta el valor nulo*/
	       boolean m_nullable=false;
	        /** Máscara aplicable*/
	       String m_mask="m_mask";
	        
	       
	        
	       boolean m_creation=false;
	        
	       int m_typeFinder=0;
	        
	       boolean m_basicEdition=true;//En principio se permite la edicion de la columna pero siempre que enable este tambien a true
	        
	       boolean m_uniqueValue=false;//Indica si el valor de esta columna tiene que ser unico en base de datos

	       Integer m_redondeo=1;//Para saber el numero de digitos de redondeo en caso de ser un double
	        
	        /** El id del padre de la columna*/
	       String m_iIdParent = null;
	        
	       GTableColumn column = new GTableColumn(			m_iId,		m_iIdParent,		m_iColumn,			m_strLabel,		m_iType,		m_ref,		m_idProp,		m_width,	m_height,	m_length,			m_mask,			m_enable,			m_hide,			m_total,		m_agrupable,		m_dobleSizeHeader,		m_nullable,			m_creation,		m_typeFinder,		m_basicEdition,			m_uniqueValue,m_redondeo);
	       return column;
	    }
  public  GTableColumn buildName() {
		  /** El id de la columna*/
	      String m_iId = "name";
	    /** El índice de la columna (empezando desde 0)*/
	      int m_iColumn=1;
	    /** El nombre de la columna*/
	      String m_strLabel="Name";
	    /** El código del tipo de la columna*/
	       int m_iType=1;
	    /** Si la columna es editable*/
	       boolean m_enable=true;
		//No se tiene permiso para modificar este campo.
	    /** Si la columna está oculta o no*/
	       boolean m_hide=false;
	    /** Si se puede resumir en una*/
	       boolean m_total=true;
	    /** Si se puede agrupar en varios valores*/
	       boolean m_agrupable=true;
	    /** Id de la columna*/
	       int m_idProp=0;
	    /** Ancho de la columna*/
	       int m_width=100;
	    /** Alto de la columna*/
	       int m_height=120;
	    /** Longitud de la columna*/
	       int m_length=100;
	    /** */
	       String m_ref="m_ref";
	    /** */
	       boolean m_dobleSizeHeader = false;
	    /** Si acepta el valor nulo*/
	       boolean m_nullable=false;
	    /** Máscara aplicable*/
	       String m_mask="m_mask";
	    
	   
	    
	       boolean m_creation=false;
	    
	       int m_typeFinder=0;
	    
	       boolean m_basicEdition=true;//En principio se permite la edicion de la columna pero siempre que enable este tambien a true
	    
	       boolean m_uniqueValue=false;//Indica si el valor de esta columna tiene que ser unico en base de datos

	       Integer m_redondeo=1;//Para saber el numero de digitos de redondeo en caso de ser un double
	    
	    /** El id del padre de la columna*/
	       String m_iIdParent=null;
	   GTableColumn column = new GTableColumn(			m_iId,		m_iIdParent,		m_iColumn,			m_strLabel,		m_iType,		m_ref,		m_idProp,		m_width,	m_height,	m_length,			m_mask,			m_enable,			m_hide,			m_total,		m_agrupable,		m_dobleSizeHeader,		m_nullable,			m_creation,		m_typeFinder,		m_basicEdition,			m_uniqueValue,m_redondeo);
	   return column;
  }
  public  GTableColumn buildDisplayName() {
   	  /** El id de la columna*/
         String m_iId = "displayName";
         /** El índice de la columna (empezando desde 0)*/
         int m_iColumn=0;
         /** El nombre de la columna*/
         String m_strLabel="Display Name";
         /** El código del tipo de la columna*/
         int m_iType=GConst.TM_TEXT;
         /** Si la columna es editable*/
         boolean m_enable=true;
     	//No se tiene permiso para modificar este campo.
         /** Si la columna está oculta o no*/
         boolean m_hide=false;
         /** Si se puede resumir en una*/
          boolean m_total=true;
         /** Si se puede agrupar en varios valores*/
         boolean m_agrupable=true;
         /** Id de la columna*/
          int m_idProp=0;
         /** Ancho de la columna*/
        int m_width=100;
         /** Alto de la columna*/
        int m_height=120;
         /** Longitud de la columna*/
        int m_length=100;
         /** */
        String m_ref="m_ref";
         /** */
        boolean m_dobleSizeHeader = false;
         /** Si acepta el valor nulo*/
        boolean m_nullable=false;
         /** Máscara aplicable*/
        String m_mask="m_mask";
         
        
         
        boolean m_creation=false;
         
        int m_typeFinder=0;
         
        boolean m_basicEdition=true;//En principio se permite la edicion de la columna pero siempre que enable este tambien a true
         
        boolean m_uniqueValue=false;//Indica si el valor de esta columna tiene que ser unico en base de datos

        Integer m_redondeo=1;//Para saber el numero de digitos de redondeo en caso de ser un double
         
         /** El id del padre de la columna*/
        String m_iIdParent = null;
         
        GTableColumn column = new GTableColumn(			m_iId,		m_iIdParent,		m_iColumn,			m_strLabel,		m_iType,		m_ref,		m_idProp,		m_width,	m_height,	m_length,			m_mask,			m_enable,			m_hide,			m_total,		m_agrupable,		m_dobleSizeHeader,		m_nullable,			m_creation,		m_typeFinder,		m_basicEdition,			m_uniqueValue,m_redondeo);
        return column;
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton cmdExport;
    private JButton cmdDelete;
    private JButton cmdQuickSearch;
    private JButton cmdTagFilter;
    private JLabel jLabel18;
    private JPanel jPanel1;
    //presented data table in original version
   // private javax.swing.JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    protected JLabel lblPanelTitle;
    private JLabel lblSummary;
    private JMenuItem mnuDeleteSelectedAddresses;
    private JMenuItem mnuDuplicateSelectedAddress;
    private JMenuItem mnuOpenSelectedAddress;
    private JPopupMenu popTagFilter;
    private JPopupMenu popupAddressActions;
   // private javax.swing.JTable tblResults;
    private JTextField txtSearchString;
    // End of variables declaration//GEN-END:variables

    public Image getBackgroundImage() {
        return this.backgroundImage;
    }

    public void reset() {
        this.txtSearchString.requestFocus();
        this.txtSearchString.selectAll();
    }

    public boolean needsReset() {
        return true;
    }

	@Override
	public void onEvent(Event e) {

		if(e.getType()==Event.TYPE_ROW_SELECTION_CHANGED) {
			selectedIds  = null;
			logger.info("row selection changed");
			   GFormField m_objFormField= gtable.getFormField();
		        GTableModelReduction objTableModel=       gtable.getModel();
		        List<RowItem> rowItems = objTableModel.getRowData();
		        for(RowItem rowItem : rowItems) {
		        	Object object  = rowItem.getColumnData(0);
		        	if(Auxiliar.equals(objTableModel.getColumnSelectionRowTable(), 0)) {
		        		if(null !=object && object.equals(true)) {
		        			if(null == selectedIds || selectedIds.isEmpty()) {
		        				selectedIds = new HashSet<String>();
		        			}
		        			logger.info("adding");
		        			selectedIds.add(rowItem.getDatabaseId());
			        		
		        		}else {
		        			logger.info("value:"+object);
		        		}
		        	}
		        	//logger.info("object"+object);
		        	object  = rowItem.getColumnData(1);
		        	logger.info("object_1"+object);
		        	//object  = rowItem.getColumnData(2);
		        	//logger.info("object_2"+object);
		        	
		        }
		        enableDeleteButton();
		}
		   if( e instanceof OnLoadPaneView) {
	        	//  CustomApplicationDAO dao = new CustomApplicationDAO();
	            //  dao.getAffiliations();  
			   logger.info("on load pane view called");
			   loadData();
			   initLayout();
			   //gtable.getModel().updateGUI(true);
			  // repaint();
			  // revalidate();
	        }
		
	}

}