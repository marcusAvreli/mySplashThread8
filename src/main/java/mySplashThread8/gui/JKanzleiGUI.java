package mySplashThread8.gui;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.table.TableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.editors.EditorsRegistry;
import mySplashThread8.themes.colors.DefaultColorTheme;
import mySplashThread8.modulebar.ModuleBar;
import mySplashThread8.server.modules.ModuleMetadata;
import mySplashThread8.DemoPaginationBar;
import mySplashThread8.MagTable;
import mySplashThread8.gdev.gawt.GTableModelReduction;
import mySplashThread8.model.base.dao.CustomApplicationDAO;
import mySplashThread8.model.base.entity.CustomApplication;
import mySplashThread8.modulebar.ModuleButton;
import mySplashThread8.nepxion.swing.locale.SwingLocale;
import mySplashThread8.nepxion.swing.pagination.PaginationContext;
import mySplashThread8.settings.ClientSettings;




public class JKanzleiGUI extends JFrame  {

	private static final Logger logger = LoggerFactory.getLogger(JKanzleiGUI.class);
	private JPanel mainPanel;
	private JMenu fileMenu;
	private JMenu helpMenu;
	private JMenuBar mainMenuBar;
	private JMenuItem exitMenuItem;
	//private StateObserverMenuItem affiliationsManagerMenuItem;
	   private ModuleBar moduleBar;
	private JMenuItem loginMenuItem;
	private JMenuItem settingsMenuItem;
	 private boolean initializing = false;
    public JKanzleiGUI() {
		//logger.info("start_create_JKanzleiGUI");
		  // set frame site
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
		
		//add(this.jPanel1);		
		// applyComponentOrientation(ComponentOrientation
	        //        .getOrientation(settings.getLocale()));
		
		 this.initializing = true;
	        initComponents();
	       
	        this.lblNewsStatus.setForeground(DefaultColorTheme.COLOR_LOGO_RED);
	        this.initializing = false;
	        
	        EditorsRegistry registry = EditorsRegistry.getInstance();
	        registry.setMainEditorsPane(this.jPanel1);
		
		
		
		
		//logger.info("finish_create_JKanzleiGUI");
    }
    public void buildModuleBar() {
        ModuleMetadata rootModule = ClientSettings.getInstance().getRootModule();
		if(null == rootModule) {
			logger.info("root module is null");
		}
		if(null == this.moduleBar) {
			logger.info("module bar is null");
		}
        this.moduleBar.addModule(rootModule);
        for (int i = 0; i < rootModule.getChildCount(); i++) {
            ModuleMetadata folderMod = (ModuleMetadata) rootModule.getChildAt(i);
            for (int k = 0; k < folderMod.getChildCount(); k++) {
                this.moduleBar.addModule((ModuleMetadata) folderMod.getChildAt(k));
            }
        }
    //    logger.info("checkPost1");
        this.moduleBar.doLayout();
     //   logger.info("checkPost2");
        this.moduleBar.initializeHotKeys();

        // activate Desktop module
        this.moduleBar.actionPerformed(0);

    }

    private void initComponents() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainPanel = new JPanel();
		fileMenu = new JMenu();
		helpMenu = new JMenu();
		mainMenuBar = new JMenuBar();
		exitMenuItem = new JMenuItem();
		loginMenuItem = new JMenuItem(); 
		settingsMenuItem = new JMenuItem();
 		
		moduleBar = new ModuleBar();
 		

		
		  statusPanel = new javax.swing.JPanel();
	        statusLabel = new javax.swing.JLabel();
	        lblUpdateStatus = new javax.swing.JLabel();
	        lblScanStatus = new javax.swing.JLabel();
	        lblMailStatus = new javax.swing.JLabel();
	        lblSystemStatus = new javax.swing.JLabel();
	        lblFaxStatus = new javax.swing.JLabel();
	        lblNewsStatus = new javax.swing.JLabel();
	        lblDrebisStatus = new javax.swing.JLabel();
	        lblBeaStatus = new javax.swing.JLabel();
	        moduleBar = new ModuleBar();
	        jPanel1 = new javax.swing.JPanel();
	        jMenuBar1 = new javax.swing.JMenuBar();
	        mnuFile = new javax.swing.JMenu();
	        mnuDocumentsBin = new javax.swing.JMenuItem();
	        mnuBankImport = new javax.swing.JMenuItem();
	        mnuZipCodeImport = new javax.swing.JMenuItem();
	        mnuAddressImport = new javax.swing.JMenuItem();
	        mnuBeaCourtAddressImport = new javax.swing.JMenuItem();
	        jSeparator3 = new javax.swing.JSeparator();
	        mnuExit = new javax.swing.JMenuItem();
	        mnuView = new javax.swing.JMenu();
	        mnuFontSize = new javax.swing.JMenuItem();
	        mnuChkRandomBackground = new javax.swing.JCheckBoxMenuItem();
	        mnuOptions = new javax.swing.JMenu();
	        mnuAddressOptions = new javax.swing.JMenu();
	        mnuAddressOptionsSalutation = new javax.swing.JMenuItem();
	        mnuAddressOptionsComplimentaryClose = new javax.swing.JMenuItem();
	        mnuAddressOptionsTitle = new javax.swing.JMenuItem();
	        mnuAddressOptionsTitleInAddress = new javax.swing.JMenuItem();
	        mnuAddressOptionsCountry = new javax.swing.JMenuItem();
	        mnuAddressOptionsNationality = new javax.swing.JMenuItem();
	        mnuAddressOptionsLegalForm = new javax.swing.JMenuItem();
	        mnuAddressOptionsDegreePrefix = new javax.swing.JMenuItem();
	        mnuAddressOptionsDegreeSuffix = new javax.swing.JMenuItem();
	        mnuAddressOptionsBeruf = new javax.swing.JMenuItem();
	        mnuAddressOptionsRole = new javax.swing.JMenuItem();
	        mnuAddressTags = new javax.swing.JMenuItem();
	        mnuAddressCustomFields = new javax.swing.JMenuItem();
	        mnuPartyTypes = new javax.swing.JMenuItem();
	        mnuAddressBookSync = new javax.swing.JMenuItem();
	        mnuAddressBookSyncNow = new javax.swing.JMenuItem();
	        mnuArchiveFileOptions = new javax.swing.JMenu();
	        mnuArchiveFileOptionsDictateSign = new javax.swing.JMenuItem();
	        mnuArchiveFileOptionsSubjectFields = new javax.swing.JMenuItem();
	        mnuArchiveFileTags = new javax.swing.JMenuItem();
	        mnuDocumentTags = new javax.swing.JMenuItem();
	        mnuArchiveFileCustomFields = new javax.swing.JMenuItem();
	        mnuArchiveFileCustomFieldsInvolvements = new javax.swing.JMenuItem();
	        mnuArchiveFileOptionsCaseNumbering = new javax.swing.JMenuItem();
	        mnuFormsManager = new javax.swing.JMenuItem();
	        mnuDocumentFolderTemplates = new javax.swing.JMenuItem();
	        mnuDocumentOptions = new javax.swing.JMenu();
	        mnuMappingTables = new javax.swing.JMenuItem();
	        mnuMappingEntries = new javax.swing.JMenuItem();
	        mnuScanOptions = new javax.swing.JMenuItem();
	        mnuWordProcessor = new javax.swing.JMenuItem();
	        mnuSearchIndex = new javax.swing.JMenuItem();
	        mnuDocumentPreview = new javax.swing.JMenuItem();
	        mnuCustomLauncherOptions = new javax.swing.JMenuItem();
	        mnuCalendarOptions = new javax.swing.JMenu();
	        mnuArchiveFileOptionsReviewReasons = new javax.swing.JMenuItem();
	        mnuCalendarSetup = new javax.swing.JMenuItem();
	        mnuCalendarSyncNow = new javax.swing.JMenuItem();
	        jSeparator2 = new javax.swing.JSeparator();
	        mnuUserProfile = new javax.swing.JMenuItem();
	        mnuProfileInfo = new javax.swing.JMenuItem();
	        jSeparator4 = new javax.swing.JPopupMenu.Separator();
	        mnuMailboxSettings = new javax.swing.JMenuItem();
	        mnuVoipSoftphoneSettings = new javax.swing.JMenuItem();
	        mnuBeaSettings = new javax.swing.JMenuItem();
	        mnuDrebisSettings = new javax.swing.JMenuItem();
	        mnuCalculations = new javax.swing.JMenu();
	        mnuAdministration = new javax.swing.JMenu();
	        mnuUsers = new javax.swing.JMenuItem();
	        mnuGroups = new javax.swing.JMenuItem();
	        jSeparator5 = new javax.swing.JPopupMenu.Separator();
	        mnuBackupConfiguration = new javax.swing.JMenuItem();
	        mnuServerMonitor = new javax.swing.JMenuItem();
	        mnuSecurity = new javax.swing.JMenuItem();
	        mnuAdminConsole = new javax.swing.JMenuItem();
	        mnuWebHooks = new javax.swing.JMenuItem();
	        mnuServices = new javax.swing.JMenu();
	        mnuHelp = new javax.swing.JMenu();
	        mnuDocumentMonitor = new javax.swing.JMenuItem();
	        mnuOnlineHelp = new javax.swing.JMenuItem();
	        mnuForum = new javax.swing.JMenuItem();
	        mnuXjustizViewer = new javax.swing.JMenuItem();
	        mnuAbout = new javax.swing.JMenuItem();

		
		
		
		
		
		
		
		



		loginMenuItem.addActionListener(new ActionListener() {
       	 public void actionPerformed(ActionEvent evt) {
               // loginMenuItemActionPerformed(evt);
              }

       	
       });
        
        
       
        
      
        
        exitMenuItem.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
        	  exitMenuItemActionPerformed(evt);
          }
        });
        
        
        settingsMenuItem.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent evt) {
        		 settingsMenuItemActionPerformed(evt);
             }
        });
        
        loginMenuItem.setText(SwingLocale.getString("Login"));
       // affiliationsManagerMenuItem.setText("Custom Applications manager");        
        exitMenuItem.setText(SwingLocale.getString("Exit"));
        fileMenu.add(loginMenuItem);
        //fileMenu.add(affiliationsManagerMenuItem);
        fileMenu.add(exitMenuItem);
        
        settingsMenuItem.setText(SwingLocale.getString("Settings"));
        helpMenu.add(settingsMenuItem);
        
        fileMenu.setText(SwingLocale.getString("File"));
        helpMenu.setText(SwingLocale.getString("Help"));
        mainMenuBar.add(fileMenu);
        mainMenuBar.add(helpMenu);
        setJMenuBar(mainMenuBar);
        
        
        
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addComponent(moduleBar, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(statusPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(moduleBar, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

    	
    	/*
    	jPanel1 = new ModuleButton();
    	
    	
    	
    	
    	
    	
	    jPanel1.actionPerformed();
    	*/
        pack();
    }
  
	private void exitMenuItemActionPerformed(ActionEvent evt) {
		finish();
	}
	private void  settingsMenuItemActionPerformed(ActionEvent evt) {
		
	}
		
	private void finish() {
		dispose();
		logger.info("Finish");
		System.exit(0);
	}      
	
    //private ModuleButton jPanel1;
	private JPanel jPanel1;
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
  
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JLabel lblBeaStatus;
    private javax.swing.JLabel lblDrebisStatus;
    private javax.swing.JLabel lblFaxStatus;
    private javax.swing.JLabel lblMailStatus;
    private javax.swing.JLabel lblNewsStatus;
    private javax.swing.JLabel lblScanStatus;
    private javax.swing.JLabel lblSystemStatus;
    private javax.swing.JLabel lblUpdateStatus;
    private javax.swing.JMenuItem mnuAbout;
    private javax.swing.JMenuItem mnuAddressBookSync;
    private javax.swing.JMenuItem mnuAddressBookSyncNow;
    private javax.swing.JMenuItem mnuAddressCustomFields;
    private javax.swing.JMenuItem mnuAddressImport;
    private javax.swing.JMenu mnuAddressOptions;
    private javax.swing.JMenuItem mnuAddressOptionsBeruf;
    private javax.swing.JMenuItem mnuAddressOptionsComplimentaryClose;
    private javax.swing.JMenuItem mnuAddressOptionsCountry;
    private javax.swing.JMenuItem mnuAddressOptionsDegreePrefix;
    private javax.swing.JMenuItem mnuAddressOptionsDegreeSuffix;
    private javax.swing.JMenuItem mnuAddressOptionsLegalForm;
    private javax.swing.JMenuItem mnuAddressOptionsNationality;
    private javax.swing.JMenuItem mnuAddressOptionsRole;
    private javax.swing.JMenuItem mnuAddressOptionsSalutation;
    private javax.swing.JMenuItem mnuAddressOptionsTitle;
    private javax.swing.JMenuItem mnuAddressOptionsTitleInAddress;
    private javax.swing.JMenuItem mnuAddressTags;
    private javax.swing.JMenuItem mnuAdminConsole;
    private javax.swing.JMenu mnuAdministration;
    private javax.swing.JMenuItem mnuArchiveFileCustomFields;
    private javax.swing.JMenuItem mnuArchiveFileCustomFieldsInvolvements;
    private javax.swing.JMenu mnuArchiveFileOptions;
    private javax.swing.JMenuItem mnuArchiveFileOptionsCaseNumbering;
    private javax.swing.JMenuItem mnuArchiveFileOptionsDictateSign;
    private javax.swing.JMenuItem mnuArchiveFileOptionsReviewReasons;
    private javax.swing.JMenuItem mnuArchiveFileOptionsSubjectFields;
    private javax.swing.JMenuItem mnuArchiveFileTags;
    private javax.swing.JMenuItem mnuBackupConfiguration;
    private javax.swing.JMenuItem mnuBankImport;
    private javax.swing.JMenuItem mnuBeaCourtAddressImport;
    private javax.swing.JMenuItem mnuBeaSettings;
    private javax.swing.JMenu mnuCalculations;
    private javax.swing.JMenu mnuCalendarOptions;
    private javax.swing.JMenuItem mnuCalendarSetup;
    private javax.swing.JMenuItem mnuCalendarSyncNow;
    private javax.swing.JCheckBoxMenuItem mnuChkRandomBackground;
    private javax.swing.JMenuItem mnuCustomLauncherOptions;
    private javax.swing.JMenuItem mnuDocumentFolderTemplates;
    private javax.swing.JMenuItem mnuDocumentMonitor;
    private javax.swing.JMenu mnuDocumentOptions;
    private javax.swing.JMenuItem mnuDocumentPreview;
    private javax.swing.JMenuItem mnuDocumentTags;
    private javax.swing.JMenuItem mnuDocumentsBin;
    private javax.swing.JMenuItem mnuDrebisSettings;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuFontSize;
    private javax.swing.JMenuItem mnuFormsManager;
    private javax.swing.JMenuItem mnuForum;
    private javax.swing.JMenuItem mnuGroups;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuMailboxSettings;
    private javax.swing.JMenuItem mnuMappingEntries;
    private javax.swing.JMenuItem mnuMappingTables;
    private javax.swing.JMenuItem mnuOnlineHelp;
    private javax.swing.JMenu mnuOptions;
    private javax.swing.JMenuItem mnuPartyTypes;
    private javax.swing.JMenuItem mnuProfileInfo;
    private javax.swing.JMenuItem mnuScanOptions;
    private javax.swing.JMenuItem mnuSearchIndex;
    private javax.swing.JMenuItem mnuSecurity;
    private javax.swing.JMenuItem mnuServerMonitor;
    private javax.swing.JMenu mnuServices;
    private javax.swing.JMenuItem mnuUserProfile;
    private javax.swing.JMenuItem mnuUsers;
    private javax.swing.JMenu mnuView;
    private javax.swing.JMenuItem mnuVoipSoftphoneSettings;
    private javax.swing.JMenuItem mnuWebHooks;
    private javax.swing.JMenuItem mnuWordProcessor;
    private javax.swing.JMenuItem mnuXjustizViewer;
    private javax.swing.JMenuItem mnuZipCodeImport;
//   private ModuleBar moduleBar;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables
}