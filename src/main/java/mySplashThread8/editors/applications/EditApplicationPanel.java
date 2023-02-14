package mySplashThread8.editors.applications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*
* @author jens
*/
public class EditApplicationPanel extends QuickSearchApplicationPanel{
   
	private static final Logger logger = LoggerFactory.getLogger(EditApplicationPanel.class);
	private static final long serialVersionUID = 371511670777859395L;

/** Creates a new instance of EditAddressPanel */
   public EditApplicationPanel() {
       super();       
       
       this.lblPanelTitle.setText("Adresse suchen");
   }
   
	
}