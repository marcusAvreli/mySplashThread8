package mySplashThread8.desktop;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.editors.EditorsRegistry;
import mySplashThread8.editors.addresses.EditAddressPanel;
import mySplashThread8.nepxion.swing.locale.SwingLocale;

public class DesktopPanel extends JPanel  {
	private static final Logger logger = LoggerFactory.getLogger(DesktopPanel.class);
	public DesktopPanel() {
      
        initComponents();
        
        
        Timer timer10 = new Timer();
        TimerTask tagsTask2;
		try {
			tagsTask2 = new UpdateAddressTagsTask(this, (EditAddressPanel) EditorsRegistry.getInstance().getEditor(EditAddressPanel.class.getName()));
			 timer10.schedule(tagsTask2, 5500, 60000);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
	private void initComponents() {
		//logger.info("init_components_started");
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane3 = new javax.swing.JScrollPane();
		 jScrollPane4 = new javax.swing.JScrollPane();
	    this.jScrollPane3.getViewport().setOpaque(false);
        this.jScrollPane1.getViewport().setOpaque(false);
        this.jScrollPane4.getViewport().setOpaque(false);
        this.jScrollPane4.setVisible(true);
      //  ComponentUtils.decorateSplitPane(jSplitPane1, Color.WHITE);
       // ComponentUtils.decorateSplitPane(jSplitPane2, Color.WHITE);
		
       JLabel  jLabel7 = new javax.swing.JLabel();
       //java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("mySplashThread6/desktop/DesktopPanel"); // NOI18N
       
        jLabel7.setText(SwingLocale.getString("label.lastchanged.loading")); // NOI18N
        
        GroupLayout pnlLastChangedLayout = new GroupLayout(this);
        this.setLayout(pnlLastChangedLayout);
        pnlLastChangedLayout.setHorizontalGroup(
            pnlLastChangedLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlLastChangedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
       
        pnlLastChangedLayout.setVerticalGroup(
            pnlLastChangedLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlLastChangedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        setVisible(true);
      //  logger.info("init_components_finished");
        
       
	}
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane4;
	
	
}
