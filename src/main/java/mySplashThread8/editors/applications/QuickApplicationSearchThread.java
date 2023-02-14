package mySplashThread8.editors.applications;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.JTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.dynagent.common.utils.RowItem;
import mySplashThread8.events.Event;
import mySplashThread8.events.EventBroker;
import mySplashThread8.events.OnLoadPaneView;
import mySplashThread8.events.UpdateFindings;
import mySplashThread8.gdev.gawt.GTable;
import mySplashThread8.gdev.gawt.GTableModelReduction;
import mySplashThread8.gfld.GFormField;
import mySplashThread8.gfld.GFormTable;
import mySplashThread8.gfld.GTableColumn;
import mySplashThread8.gfld.GTableRow;
import mySplashThread8.nepxion.swing.pagination.PaginationContext;

public class QuickApplicationSearchThread implements Runnable {
    
	private static final Logger logger = LoggerFactory.getLogger(QuickApplicationSearchThread.class);
    
    private String query;
    private GTable target;
    private EventBroker b = EventBroker.getInstance();
    /** Creates a new instance of QuickAddressSearchThread */
    public QuickApplicationSearchThread(Component owner, String query,  GTable target) {
        this.query=query;
        this.target=target;
        
    }

    @Override
    public void run() {
       
   //   logger.info("thread started");
      logger.info("search_query>>>>>"+query+"<<<<");
        GFormField m_objFormField= target.getFormField();
        
        GTableModelReduction objTableModel=       target.getModel();
        objTableModel.getRowData();
    	Vector<GTableRow> tableRows = ((GFormTable)m_objFormField).getRowList();
    	Vector vectorColumnList = ((GFormTable)m_objFormField).getColumnList();
    	Set<Integer> findings = new HashSet<Integer>();
    	int tableRowsSize = tableRows.size();
    	//logger.info("total rows:"+tableRowsSize);
    	for(int i=0;i<vectorColumnList.size();i++) {
    		GTableColumn column = (GTableColumn) vectorColumnList.get(i);
	    	String columnName = column.getId();
	    	
	    	for(int j=0;j<tableRowsSize;j++) {
		    	Object dataColumnValueObject  =tableRows.get(j).getDataColumn(columnName);	
		    	
		    	
		    	
		    	 
		    	
		    	
		    	if(null !=dataColumnValueObject) {
		    		if(dataColumnValueObject instanceof String) {
		    			String dataColumnValue = (String)dataColumnValueObject;
		    			//int location = tableRowsSize-j;
		    			int location = j;
		    			if(dataColumnValue.equals(query)) {
		    			//	logger.info("column_value_equals:"+dataColumnValue);	
		    				findings.add(location);
		    				
		    			}
		    		
		    			if(dataColumnValue.startsWith(query)) {
		    			//	logger.info("column_value_starts:"+dataColumnValue);	
		    				findings.add(location);
		    				
		    			}
		    			if(dataColumnValue.endsWith(query)) {
		    			//	logger.info("column_value_ends:"+dataColumnValue);	
		    				findings.add(location);
		    				
		    			}			    	
		    			if(dataColumnValue.contains(query)) {
		    				//logger.info("column_value_contains:"+dataColumnValue);	
		    				findings.add(location);
		    			
		    				
		    			}
		    		}		    		
		    	}
	    	}
    	}
	
		ArrayList<Integer> visibleRows = new ArrayList<Integer>(findings);
		
		//logger.info("visible rows size:"+visibleRows.size());
		//logger.info("found indexes:"+visibleRows);	    
		 b.publishEvent(new UpdateFindings(this,Event.TYPE_UPDATE_FINDINGS,visibleRows));
	
       
    }
    
}
