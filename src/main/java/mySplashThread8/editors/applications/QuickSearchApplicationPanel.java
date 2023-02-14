package mySplashThread8.editors.applications;

import java.awt.Component;
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

import javax.security.auth.Refreshable;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import mySplashThread8.DemoPaginationBar;
import mySplashThread8.FactoryDAO;
import mySplashThread8.MagTable;
import mySplashThread8.dynagent.common.utils.Auxiliar;
import mySplashThread8.dynagent.common.utils.RowItem;
import mySplashThread8.editors.EditorsRegistry;
import mySplashThread8.editors.ThemeableEditor;
import mySplashThread8.editors.addresses.AddressPanel;
import mySplashThread8.editors.addresses.ViewAddressDetailsPanel;
import mySplashThread8.events.Event;
import mySplashThread8.events.EventBroker;
import mySplashThread8.events.EventConsumer;
import mySplashThread8.events.OnLoadPaneView;
import mySplashThread8.events.UpdateFindings;
import mySplashThread8.gdev.gawt.GTable;
import mySplashThread8.gdev.gawt.GTableModelReduction;
import mySplashThread8.gen.GConst;
import mySplashThread8.gfld.GFormField;
import mySplashThread8.gfld.GFormTable;
import mySplashThread8.gfld.GTableColumn;
import mySplashThread8.gfld.GTableRow;
import mySplashThread8.jlawyer.client.utils.TableUtils;
import mySplashThread8.model.base.dao.CustomApplicationDAO;
import mySplashThread8.model.base.entity.CustomApplication;
import mySplashThread8.nepxion.swing.locale.SwingLocale;
import mySplashThread8.nepxion.swing.pagination.PaginationContext;
import mySplashThread8.settings.ClientSettings;

public class QuickSearchApplicationPanel extends JPanel  implements EventConsumer {

	private static final Logger logger = LoggerFactory.getLogger(QuickSearchApplicationPanel.class);
	
	private Image backgroundImage = null;
	private String token;

//VARIABLES_DATA
	private GTable gtable;
	private DemoPaginationBar bar;
	private PaginationContext paginationContext;
	
	
	 private javax.swing.JButton cmdExport;
	    private javax.swing.JButton cmdQuickSearch;
	  
	    private javax.swing.JButton cmdTagFilter;
	    private javax.swing.JLabel jLabel18;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane2;
	    protected javax.swing.JLabel lblPanelTitle;
	    private javax.swing.JLabel lblSummary;
	    private javax.swing.JMenuItem mnuDeleteSelectedAddresses;
	    private javax.swing.JMenuItem mnuDuplicateSelectedAddress;
	    private javax.swing.JMenuItem mnuOpenSelectedAddress;
	    private javax.swing.JPopupMenu popTagFilter;
	    private javax.swing.JPopupMenu popupAddressActions;
//	    private javax.swing.JTable tblResults;
	    private javax.swing.JTable tblDirContent;
	   private List<CustomApplication> customApplications;
	   private FactoryDAO factoryDAO = null;
	  private EventBroker eventBroker = null;
	    private javax.swing.JTextField txtSearchString;
	    private Vector<GTableRow> rows = null;
	    private GFormTable m_objFormField = null;
	    private Vector<GTableColumn> listaColumnas = null;
	    private Set<String> selectedIds = null;
	    private JButton cmdDelete;
	    // End of variables declaration//GEN-END:variables
	private String detailsEditorClass;
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Creates new form QuickAddressSearchPanel
	 */
	public QuickSearchApplicationPanel() {
		
		//logger.info("SearchApplicationPanel_started");
		eventBroker = EventBroker.getInstance();
		factoryDAO = ClientSettings.getInstance().getFactoryDAO();
		
		
		eventBroker.subscribeConsumer(this, Event.TYPE_LOAD_PANE_VIEW);
		eventBroker.subscribeConsumer(this, Event.TYPE_ROW_SELECTION_CHANGED);
		eventBroker.subscribeConsumer(this, Event.TYPE_ALL_ROWS_SELECTED);

		initComponents();
	    this.txtSearchString.putClientProperty("JTextField.showClearButton", true);
        this.txtSearchString.putClientProperty("JTextField.placeholderText", "Suche: Adressen");
        lblPanelTitle = new javax.swing.JLabel();
        
        
        lblPanelTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPanelTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblPanelTitle.setText("jLabel19");
        
      
		//logger.info("SearchApplicationPanel_finished");
        this.detailsEditorClass = ViewApplicationDetailsPanel.class.getName();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		txtSearchString = new javax.swing.JTextField();
		jPanel1 = new JPanel();
		cmdQuickSearch = new JButton();
		
		popupAddressActions = new javax.swing.JPopupMenu();
	    mnuOpenSelectedAddress = new javax.swing.JMenuItem();
	    mnuDuplicateSelectedAddress = new javax.swing.JMenuItem();
	    mnuDeleteSelectedAddresses = new javax.swing.JMenuItem();
	    popTagFilter = new javax.swing.JPopupMenu();
	    txtSearchString = new javax.swing.JTextField();
	    jScrollPane1 = new javax.swing.JScrollPane();
	   
	    tblDirContent = new JTable();
	    
	    jScrollPane2 = new javax.swing.JScrollPane();
	    lblSummary = new javax.swing.JLabel();
	    jLabel18 = new javax.swing.JLabel();
	    lblPanelTitle = new javax.swing.JLabel();
	  
	    cmdExport = new javax.swing.JButton();
	    cmdTagFilter = new javax.swing.JButton();
	    cmdDelete = new JButton();
	    cmdExport = new JButton();
	    
	    //LOAD_DATA
	    int size = 0;
	    boolean startup=true;
		//loadData(startup);
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
		paginationContext = new PaginationContext(10);
		
		
		rows = buildRows(customApplications);		
		m_objFormField = new GFormTable();
		m_objFormField = m_objFormField.createTable(listaColumnas,rows);	
		
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
		
		
		 mnuOpenSelectedAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vcard.png"))); // NOI18N
	        mnuOpenSelectedAddress.setText("öffnen");
	        mnuOpenSelectedAddress.setToolTipText("gewählte Adresse öffnen");
	        mnuOpenSelectedAddress.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                //mnuOpenSelectedAddressActionPerformed(evt);
	            }
	        });
	        popupAddressActions.add(mnuOpenSelectedAddress);

	        mnuDuplicateSelectedAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editcopy.png"))); // NOI18N
	        mnuDuplicateSelectedAddress.setText("duplizieren");
	        mnuDuplicateSelectedAddress.setToolTipText("gewählte Adresse duplizieren");
	        /*mnuDuplicateSelectedAddress.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                mnuDuplicateSelectedAddressActionPerformed(evt);
	            }
	        });*/
	        popupAddressActions.add(mnuDuplicateSelectedAddress);

	        mnuDeleteSelectedAddresses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editdelete.png"))); // NOI18N
	        mnuDeleteSelectedAddresses.setText("löschen");
	        mnuDeleteSelectedAddresses.setToolTipText("gewählte Adressen löschen");
	        /*mnuDeleteSelectedAddresses.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                mnuDeleteSelectedAddressesActionPerformed(evt);
	            }
	        });*/
	        popupAddressActions.add(mnuDeleteSelectedAddresses);
		
		
		txtSearchString.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
			// txtSearchStringKeyPressed(evt);
			//	logger.info("key pressed");
			}
		});
		//  cmdQuickSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/find.png"))); // NOI18N
		 /*  cmdQuickSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/find.png"))); // NOI18N
	        cmdQuickSearch.setToolTipText("Suchen");
	        cmdQuickSearch.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                cmdQuickSearchActionPerformed(evt);
	            }
	        });
*/
	        lblSummary.setVerticalAlignment(javax.swing.SwingConstants.TOP);
	        jScrollPane2.setViewportView(lblSummary);

	        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Icons2-20.png"))); // NOI18N

	        lblPanelTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
	        lblPanelTitle.setForeground(new java.awt.Color(255, 255, 255));
	        lblPanelTitle.setText("jLabel19");

	        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
	        jPanel1.setOpaque(false);
	        cmdDelete.setText("Delete"); // NOI18N
	       cmdDelete.setToolTipText("Delete");
	        cmdDelete.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                cmdDeleteActionPerformed(evt);
	            }
	        });
		  cmdExport.setText(SwingLocale.getString("exportToCsv")); // NOI18N
	        cmdExport.setToolTipText(SwingLocale.getString("exportToCsv"));
	        cmdExport.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                cmdExportActionPerformed(evt);
	            }
	        });
	        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(cmdExport)
	                
	                .addContainerGap())
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(cmdExport)
	                
	                .addContainerGap())
	        );
	        
	        
	        cmdQuickSearch.setToolTipText(SwingLocale.getString("search"));
	        cmdQuickSearch.setText(SwingLocale.getString("search"));
	        cmdQuickSearch.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                cmdQuickSearchActionPerformed(evt);
	            	//logger.info("search button pressed");
	            }
	        });
	      
	        cmdTagFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dumpViewer6/gui/icons16/favorites.png"))); // NOI18N
	        cmdTagFilter.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mousePressed(java.awt.event.MouseEvent evt) {
	             //   cmdTagFilterMousePressed(evt);
	            }
	        });

		  jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
	        jPanel1.setOpaque(false);  
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
				
		  layout.setHorizontalGroup(
		            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addComponent(bar, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
		                   // .addComponent(jScrollPane2)
		                    .addGroup(layout.createSequentialGroup()
		                    		.addComponent(jPanel1)
		                        .addComponent(txtSearchString)
		                        .addComponent(cmdQuickSearch)
		                        .addComponent(cmdDelete)
		                       // .addComponent(cmdExport)
		                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		                       
		                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
		                     //   .addComponent(cmdTagFilter))
		                   )))
		        );
		
		  layout.setVerticalGroup(
		            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                		.addComponent(jPanel1)
		                	       .addComponent(txtSearchString, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                	       .addComponent(cmdQuickSearch,GroupLayout.Alignment.TRAILING)
		                	       .addComponent(cmdDelete,GroupLayout.Alignment.TRAILING)
		                	       //.addComponent(cmdExport,GroupLayout.Alignment.TRAILING)
		                  //  .addComponent(bar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
		                      //  .addComponent( lblPanelTitle,GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                       // .addComponent(jLabel18, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                        )
		                        )
		                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		               //     .addComponent(cmdQuickSearch,GroupLayout.Alignment.TRAILING)
		                		  .addComponent(bar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		             //       .addComponent(txtSearchString, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                   // .addComponent(cmdTagFilter)
		                    )
		                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		             //  .addComponent(bar, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
		                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		               // .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
		                .addContainerGap())
		        );
	}
	
	private void loadData(boolean startup) {
		int size = 0;
		
		
		jPanel1.repaint();
		jPanel1.revalidate();
	}
	public PaginationContext getPaginationContext() {
		return paginationContext;
	}

	public void setPaginationContext(PaginationContext paginationContext) {
		this.paginationContext = paginationContext;
	}

	public DemoPaginationBar getBar() {
		
		return bar;
	}

	public void setBar(DemoPaginationBar bar) {
		this.bar = bar;
	}
/*
	public Vector <GTableRow> gSubVector(int startIndex,int endIndex,GFormTable m_objFormField) {
		Vector rowVector = m_objFormField.getRowList();
		Vector<GTableRow> subVector =new Vector<GTableRow>();
		for(int i=0;i<endIndex;i++) {
    	GTableRow object = (GTableRow) rowVector.get(i);
    	
    	subVector.add(0,object);
		}
		return subVector;
	}
	public Image getBackgroundImage() {
		return this.backgroundImage;
	}
*/
	public void reset() {
		this.txtSearchString.requestFocus();
		this.txtSearchString.selectAll();
	}

	public boolean needsReset() {
		return true;
	}

	
	public GTable getGtable() {
		return gtable;
	}

	public void setGtable(GTable gtable) {
		this.gtable = gtable;
	}

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
				int databaseId = customApplication.getId();
	    		String appName = customApplication.getName();
	    		String displayName = customApplication.getDisplayName();

	    		row=new GTableRow();	
	    		row.setDatabaseId(String.valueOf(databaseId));
	    		row.setDataColumn("name", appName);
	    		row.setDataColumn("displayName", displayName);
	    		rows.add(row);    		
	    	}	
		}
		return rows;
	}
	  private void cmdQuickSearchActionPerformed(ActionEvent evt) {

	     // logger.info("search button pressed");  
	        new Thread(new QuickApplicationSearchThread(this, this.txtSearchString.getText(),  this.gtable)).start();

	    }
	  private void cmdAddPlgnClmnActionPerformed(ActionEvent evt) {
		  logger.info("add button pressed");  
		
	  }
	
	 private void cmdExportActionPerformed(ActionEvent evt) {
		 logger.info("cmd export performed");
		 //GTable table = getGtable();
		 GTableModelReduction tableModel = gtable.getModel();
		 GFormTable formTable = gtable.getGformTable();
		 Vector<GTableColumn> vectorColumn = formTable.getColumnList();
		 Vector<GTableRow> vectorRows = formTable.getRowList();
		 ArrayList selectedRows = gtable.getDataSelectedRows();
		 if(null !=selectedRows) {
			 logger.info("selectedRows:"+selectedRows.size());
		 }else {
			 logger.info("selectedRows is null");
		 }
		 
		 
		 if(tableModel.getColumnSelectionRowTable()!=null){
			 for(RowItem rowItem : tableModel.getRowData()){
					//rowItem.setColumnData(tableModel.getColumnSelectionRowTable(),select);
				Object value=	rowItem.getColumnData(tableModel.getColumnSelectionRowTable());
				int index = rowItem.getIndex();
				
				//tableModel.getr
				if(null !=value) {
					if(value instanceof Boolean) {
						boolean isSelected = (Boolean)value;
						if(isSelected) {
							//logger.info("selected:"+value+" index:"+index);
							//String nameValue = (String) vectorRows.get(index).getDataColumn("name");
							//logger.info("name value:"+nameValue);
							//String objectValue = (String) rowItem.getColumnData(1);
							//logger.info("name value:"+objectValue);
							for(GTableColumn gTableColumn : vectorColumn) {
								String nameColumn = gTableColumn.getId();
								int idColumn = gTableColumn.getColumn();
								
								String objectValue = (String) rowItem.getColumnData(idColumn);
								logger.info("name value:"+objectValue);
							}
						}
					}
				
				}
		 }
		 }
	     /*try {
	         TableUtils.exportAndLaunch("adresssuche-export.csv", this.tblResults);
	     } catch (Exception ex) {
	         logger.error("Error exporting table to CSV", ex);
	         JOptionPane.showMessageDialog(this, "Fehler beim Export: " + ex.getMessage(), DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
	     }*/
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
	   private void useSelection() {
	    	logger.info("useSelection_started");
	    	MagTable magTable = gtable.getTable();
	    	
	       int row = magTable.getSelectedRow();
	       logger.info("useSelection_editing_row:"+row);
	      /*  if (row < 0) {
	            return;
	        }*/
	       //String rowId = gtable.getModel().getDatabaseRowId();
	       //logger.info("database_row_id:"+rowId);
	        String id =  gtable.getModel().getRowItemFromIndex(row).getDatabaseId();
	        logger.info("database_row_id:"+id);
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
	            ((ApplicationPanel) editor).setAddressDTO(customApplication);
	            ((ApplicationPanel) editor).setOpenedFromEditorClass(this.getClass().getName());
	            EditorsRegistry.getInstance().setMainEditorsPaneView((Component) editor);

	        } catch (Exception ex) {
	            logger.error("Error creating editor from class " + this.detailsEditorClass, ex);
	          //  JOptionPane.showMessageDialog(this, "Fehler beim Laden des Editors: " + ex.getMessage(), com.jdimension.jlawyer.client.utils.DesktopUtils.POPUP_TITLE_ERROR, JOptionPane.ERROR_MESSAGE);
	        }
	        
	    }
	@Override
	public void onEvent(Event e) {
		// TODO Auto-generated method stub
		int oldSize =gtable.getModel().getRowCount();
	//	logger.info("old size:"+oldSize);
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
		        		//	logger.info("adding");
		        			selectedIds.add(rowItem.getDatabaseId());
			        		
		        		}else {
		        		//	logger.info("value:"+object);
		        		}
		        	}
		        	//logger.info("object"+object);
		        	object  = rowItem.getColumnData(1);
		        	//logger.info("object_1"+object);
		        	//object  = rowItem.getColumnData(2);
		        	//logger.info("object_2"+object);
		        	
		        }
		        enableDeleteButton();
		}
		if(e.getType() == Event.TYPE_LOAD_PANE_VIEW) {
			if(e.getPayload()=="mySplashThread8.editors.applications.EditApplicationPanel") {
			logger.info("refresh!!!!!!!!!!!!!!!!!!!! TYPE_LOAD_PANE_VIEW");
		
			refreshPanel();
			}
			
			
		}
		if(e.getType() == Event.TYPE_ALL_ROWS_SELECTED) {
			logger.info("all rows selected");
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
		        		//	logger.info("adding");
		        			selectedIds.add(rowItem.getDatabaseId());
			        		
		        		}else {
		        		//	logger.info("value:"+object);
		        		}
		        	}
		        	//logger.info("object"+object);
		        	object  = rowItem.getColumnData(1);
		        	//logger.info("object_1"+object);
		        	//object  = rowItem.getColumnData(2);
		        	//logger.info("object_2"+object);
		        	
		        }
		        enableDeleteButton();
		
			
			
		}
		
	}
	
	private void refreshPanel() {
		CustomApplicationDAO customApplicationDAO =  factoryDAO.getAffiliationDAO();
		customApplications = customApplicationDAO.getData();
		
		
		int rowCount = gtable.getRowCount();
		logger.info("row_count:"+rowCount);
		if(rowCount > 0) {
			logger.info("before remove");
			try {
				for(int i=rowCount-1;i>=0;i--) {
					gtable.getModel().removeRow(i,true);
					List visible = gtable.getModel().getVisibleRows();
					logger.info("visible:"+visible);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("after remove");
			//gtable.getModel().setRowCount(0);
		}
		if(null != customApplications) {
			logger.info("Cas:"+customApplications.size());
		rows = buildRows(customApplications);					
	//	m_objFormField.setRowList(rows);
		
		
		
	//	logger.info("row_count:"+rowCount);
		gtable.getModel().buildRows(rows, false);
		GTableModelReduction model  = gtable.getModel();
		gtable.refreshModel(model);
		//gtable.getModel().addRow(rows);
		rowCount = gtable.getRowCount();
		logger.info("row_count:"+rowCount);
		//bar = new DemoPaginationBar(gtable, paginationContext);
		bar.setTable(gtable);
		paginationContext.setTotalRowCount(rowCount);
		//paginationContext.setRowCount();
		try {
			bar.directRowCount(rowCount);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bar.updatePagination();
		bar.refreshPagination();
		//logger.info("row_count:"+rowCount);
		}
		  repaint();
		   revalidate();
	}
	  public void enableDeleteButton() {
	    	//logger.info("enable delete button");
	    	if(null !=selectedIds && !selectedIds.isEmpty()) {
	    		cmdDelete.setEnabled(true);
	    		//logger.info("open");
	    	}else {
	    		cmdDelete.setEnabled(false);
	    		//logger.info("close");
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
	         refreshPanel();
	      
	    	
	    }
    

}