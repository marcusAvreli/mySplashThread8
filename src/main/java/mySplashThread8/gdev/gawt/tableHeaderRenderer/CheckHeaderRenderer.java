package mySplashThread8.gdev.gawt.tableHeaderRenderer;


import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.gdev.gawt.GTable;
import mySplashThread8.gfld.GTableColumn;

//https://github.com/semantic-web-software/dynagent/blob/a0d356169ef34f3d2422e235fed7866e3dda6d8a/Elecom/src/gdev/gawt/tableHeaderRenderer/CheckHeaderRenderer.java
//dynagent/Elecom/src/gdev/gawt/tableHeaderRenderer/CheckHeaderRenderer.java
public class CheckHeaderRenderer extends JCheckBox implements TableCellRenderer, MouseListener {
	private static final Logger logger = LoggerFactory.getLogger(CheckHeaderRenderer.class);
	private static final long serialVersionUID = 1L;
	private GTable gTable;
	private GTableColumn column;
	protected boolean mousePressed = false;

	public CheckHeaderRenderer(GTableColumn column, GTable gTable) {
		this.gTable=gTable;
		this.column=column;
		setOpaque(true);
		setForeground(UIManager.getColor("TableHeader.foreground"));
		setBackground(UIManager.getColor("TableHeader.background"));
		setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		setBorderPainted(true);
		setBorderPaintedFlat(true);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		setMargin(new Insets(0,0,0,0));
		setIconTextGap(0);
		JTableHeader header = gTable.getTable().getTableHeader();
		header.addMouseListener(this);
		//setBorder(BorderFactory.createEmptyBorder(0, GConfigView.horizontalMarginCell, 0, GConfigView.horizontalMarginCell));
	}

	public Component getTableCellRendererComponent(JTable table, Object val,
			boolean isSelected, boolean hasFocus, int row, int column) {
		//System.err.println("Valueeee renderer para row:"+row+" y col:"+column+" value:"+val+" selected:"+isSelected);

		boolean bolVal=false;
		if(val instanceof Boolean){
			setText(null);
			bolVal=(Boolean)val;
		}else if(val instanceof String){
			setText(null);
			String[] buf=((String)val).split(":");
			bolVal=(buf[0].equals("null")?false:new Boolean(buf[0]));
		}

		if(!bolVal)
			setToolTipText("Seleccionar todo");
		else setToolTipText("Deseleccionar todo");

		super.setSelected(bolVal);
		return this;
	}

	public void mouseClicked(MouseEvent e) {  
		//if(mousePressed){
		//	mousePressed=false;
		logger.info("mouse clicked");
		JTableHeader header = (JTableHeader)(e.getSource());   
		JTable tableView = header.getTable();   
		TableColumnModel columnModel = tableView.getColumnModel();   
		int viewColumn = columnModel.getColumnIndexAtX(e.getX());   
		int column = tableView.convertColumnIndexToModel(viewColumn);   
//logger.info("viewColumn:"+viewColumn);
//logger.info("column:"+column);
//logger.info("column:"+this.column.getColumn());
		if (viewColumn == this.column.getColumn() && column != -1) {
			//logger.info("checkPost_1");
			
	setSelected(!isSelected());
	//rtl column selection
			TableColumn tc = gTable.getModel().getColumnModel().getColumn(0);
			tc.setHeaderValue(isSelected());
			
			gTable.selectAll(isSelected());
		}   
		//}

	}   
	public void mousePressed(MouseEvent e) {   
		//mousePressed = true;   
	}   
	public void mouseReleased(MouseEvent e) {   
	}   
	public void mouseEntered(MouseEvent e) {   
	}   
	public void mouseExited(MouseEvent e) {   
	}   

	

}