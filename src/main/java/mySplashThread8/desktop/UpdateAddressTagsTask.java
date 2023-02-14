package mySplashThread8.desktop;

import mySplashThread8.editors.addresses.EditAddressPanel;
import mySplashThread8.editors.addresses.QuickAddressSearchPanel;
import mySplashThread8.settings.ClientSettings;
import mySplashThread8.utils.StringUtils;
import mySplashThread8.utils.ThreadUtils;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jens
 */
public class UpdateAddressTagsTask extends TimerTask {
	private static final Logger logger = LoggerFactory.getLogger(UpdateAddressTagsTask.class);
    
    private Component owner;
    private QuickAddressSearchPanel p1;
    //private QuickAddressSearchPanel p2;

    /**
     * Creates a new instance of SystemStateTimerTask
     */
    public UpdateAddressTagsTask(Component owner, QuickAddressSearchPanel p1) {
        super();
        //logger.info("checkPost_1");
        		
        this.owner = owner;
        this.p1 = p1;
        //logger.info("checkPost_2");
        //this.p2=p2;

    }

	public void run() {
		 //  logger.info("checkPost_1_run");
        final List<String> tagsInUse2;
        try {
            ClientSettings settings = ClientSettings.getInstance();
           

            List<String> tagsInUse = new ArrayList<String>();
            tagsInUse.add("tag1");
            tagsInUse.add("tag2");

            StringUtils.sortIgnoreCase(tagsInUse);
            //logger.info("checkPost_2_run");
            tagsInUse2 = tagsInUse;

        } catch (Throwable ex) {
            logger.error("Error connecting to server", ex);
            //ThreadUtils.showErrorDialog(this.owner, java.text.MessageFormat.format(java.util.ResourceBundle.getBundle("com/jdimension/jlawyer/client/desktop/ReviewsDueTimerTask").getString("msg.connectionerror"), new Object[]{ex.getMessage()}), java.util.ResourceBundle.getBundle("com/jdimension/jlawyer/client/desktop/ReviewsDueTimerTask").getString("msg.error"));
            return;
        }

        try {
            SwingUtilities.invokeLater(
                    new Runnable() {
                public void run() {

                    p1.populateTags(tagsInUse2);
                    //p2.populateTags(tagsInUse2);

//                DefaultListModel dm=new DefaultListModel();
//                myListUI.setModel(dm);
//                myListUI.setCellRenderer(new MyListCellRenderer());
//                dm.removeAllElements();
//                for(ArchiveFileBean aFile:myList) {
//                    dm.addElement(aFile.getFileNumber() + " - " + aFile.getName());
//                    
//                }
                }
            });
        } catch (Throwable t) {
            logger.error("error",t);
        }

    }

}