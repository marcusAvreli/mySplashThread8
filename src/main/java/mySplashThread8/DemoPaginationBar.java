package mySplashThread8;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.dynagent.common.utils.RowItem;
import mySplashThread8.events.Event;
import mySplashThread8.events.UpdateFindings;
import mySplashThread8.gdev.gawt.GTable;
import mySplashThread8.gdev.gawt.GTableModelReduction;
import mySplashThread8.gfld.GFormTable;
import mySplashThread8.gfld.GTableRow;
import mySplashThread8.model.base.dao.CustomApplicationDAO;
import mySplashThread8.model.base.entity.CustomApplication;
import mySplashThread8.nepxion.swing.pagination.PaginationBar;
import mySplashThread8.nepxion.swing.pagination.PaginationContext;

public class DemoPaginationBar extends PaginationBar {
	private static final Logger logger = LoggerFactory.getLogger(DemoPaginationBar.class);
	private static final long serialVersionUID = 1L;

	public DemoPaginationBar(GTable table, PaginationContext paginationContext) {
		super(table, paginationContext);
		if (null == paginationContext) {
			logger.info("context is null");
		}
		setLayout();

	}

	public String[] getSortNameList() {
		return new String[] { "Name", "Value" };
	}

	public void directRowIndex(int rowIndex) throws Exception {
		//logger.info("direct row index:"+rowIndex);
		GTable table =  getTable();
		PaginationContext paginationContext = getPaginationContext();
		paginationContext.setRowIndex(rowIndex);
		direct(table);
	}

	public void directRowCount(int rowCount) throws Exception {
		//logger.info("direct row count:"+rowCount);
		GTable table = getTable();	
		direct(table);
	}

	private void direct(GTable table) throws Exception {
		PaginationContext paginationContext = getPaginationContext();

		// first row of page
		int rowIndex = paginationContext.getRowIndex();

		// rows per page
		int rowCount = paginationContext.getRowCount();

	//	logger.info("row_index:" + rowIndex);
	//	logger.info("row_count:" + rowCount);			
		int startIndex = paginationContext.getStartIndex();		
		int endIndex = paginationContext.getEndIndex();
		//GTableModelReduction m_objTableModel = table.getModel();
		logger.info("start_index:" + startIndex+ " end_Index:"+endIndex);
		table.cutTable(startIndex, endIndex);
		updatePagination();
	}

	public void clearRowDatas() throws Exception {
		getTable();

	}
	/*
	public Vector <GTableRow> gSubVector(int startIndex,int endIndex,GFormTable m_objFormField) {
		Vector rowVector = m_objFormField.getRowList();
		Vector<GTableRow> subVector =new Vector<GTableRow>();
		for(int i=startIndex;i<1;i++) {
    	GTableRow object = (GTableRow) rowVector.get(i);
    	
    	subVector.add(0,object);
		}
		return subVector;
	}
*/
	@Override
	public void onEvent(Event e) {
		// TODO Auto-generated method stub
		if(e.getType()==Event.TYPE_UPDATE_FINDINGS) {
			//logger.info("update findings");
			if(e.getPayload() instanceof List) {
				
			
				GTable table = getTable();
				GTableModelReduction model = table.getModel();
				logger.info("received payload:"+e.getPayload());
				//model.setVisibleRow((ArrayList<Integer>) e.getPayload());
				model.setFoundRowMap((ArrayList<Integer>) e.getPayload());
			
				refresh();
				
				//updatePagination();
				
			}
			if(e.getPayload() instanceof GTable) {
				//logger.info("update findings Gtable");
				GTable gTable = (GTable) e.getPayload();
				//logger.info("Row Count:"+ gTable.getRowCount());
		//	table = (GTable)e.getPayload();
			//setTable(table);
			try {
				
				//direct(gTable);
				//updatePagination();
				//directRowIndex(10);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
	}

}
