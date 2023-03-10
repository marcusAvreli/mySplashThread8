package mySplashThread8.gdev.gawt.tableCellEditor;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.dynagent.common.utils.Auxiliar;
import mySplashThread8.dynagent.common.utils.RowItem;
import mySplashThread8.editors.addresses.AddressPanel;
import mySplashThread8.gdev.gawt.GTable;
import mySplashThread8.gen.GConfigView;
import mySplashThread8.gfld.GTableColumn;

public class CheckCellEditor extends CellEditor{
	private static final Logger logger = LoggerFactory.getLogger(CheckCellEditor.class);
	private static final long serialVersionUID = 1L;
	protected Boolean value;
	protected JCheckBox editorComponent;
	protected Color colorDefaultComponent;
	protected boolean mustStop = true;
	protected Boolean oldValue;
	protected FocusListener listener;
	
	public CheckCellEditor(GTableColumn column,GTable tf, final FocusListener listener) {
		super(tf,column);
		//logger.info("build check cell editor");
		this.listener=listener;
		create();
		configure();
	}
	
	protected void create(){
		//logger.info("create editor");
		editorComponent = new JCheckBox();
		value=false;
	}
	
	protected void configure(){
		//logger.info("configure check editor");
		editorComponent.setHorizontalAlignment(JLabel.CENTER);
		editorComponent.setVerticalAlignment(JLabel.CENTER);
		//editor.setBorder(BorderFactory.createEmptyBorder());
		editorComponent.setBorder(GConfigView.borderSelected);
		editorComponent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					nextState();
					editorComponent.setSelected(value);	
					//gTable.getModel().setValueAt(value,row,column);
					//fireEditingStopped();
					stopCellEditing();
				}catch(Exception ex){
					ex.printStackTrace();
					//gTable.getServer().logError(SwingUtilities.getWindowAncestor(gTable),ex,"Error al asignar valor");
				}
			} 
		});
			
		editorComponent.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent ev){
				mustStop=true;
			}

			public void focusLost(FocusEvent ev){
				try{
					if(mustStop && !ev.isTemporary()){					
						if(gTable.getTable().isEditing())
							stopCellEditing();
						listener.focusLost(ev);
					}
				}catch(Exception ex){
					ex.printStackTrace();
					//gTable.getServer().logError(SwingUtilities.getWindowAncestor(gTable),ex,"Error al finalizar edici??n");
				}
			}			
		});
		colorDefaultComponent=editorComponent.getBackground();
	}
	
	public Component getTableCellEditorComponent(JTable table, Object val, boolean isSelected, int row, int column) {
		//System.err.println("Valueeee editor para row:"+row+" y col:"+column+" value:"+val+" selected:"+isSelected);
		mustStop=true;
		boolean bolVal=false;
		//logger.info("getTableCellEditorComponent check editor");
		if( val instanceof Boolean ){
			bolVal=(Boolean)val;
		}
		
		else if(val instanceof String){
			String[] buf=((String)val).split(":");
			bolVal=(buf[0].equals("null")?false:new Boolean(buf[0]));
			//TODO Hay que pensar que hacer cuando es un boolean con comentario
			//if(buf.length>1)
			//	commentVal=(buf[1].equals("null")?null:buf[1]);
		}
		oldValue=value;
		editorComponent.setSelected( bolVal );
		value=bolVal;
		
		if(Auxiliar.equals(gTable.getModel().getColumnSelectionRowTable(),column)){
			editorComponent.setBackground(colorDefaultComponent);
		}else{
			//if(!gTable.getModel().isNullable(row,column))
			//	editorComponent.setBackground(GConfigView.colorBackgroundRequired);
			 editorComponent.setBackground(colorDefaultComponent);
		}
		
		return editorComponent;
	}	
    
	protected void nextState() {
		//logger.info("nextState check editor");
		if (value == true) {
			value=false;
		} else if (value==false) {
			value=true;
		}
	}
	
    public Object getCellEditorValue(){
    	//logger.info("getCellEditorValue check editor");
    	return value;
    }
    
    public boolean stopCellEditing() {
    	//logger.info("stopCellEditing check editor");
    	//System.err.println("StopCellEditing number");
    	/*if(!Auxiliar.equals(gTable.getModel().getColumnSelectionRowTable(),column.getColumn())){
	    	if(getCellEditorValue()!=null){
				RowItem rowItem = gTable.getModel().getRowData().get(gTable.getTable().getSelectedRow());
				if(rowItem.getColumnIdo(column.getColumn())==null){
					if(rowItem.getIdRow().getIdto()!=rowItem.getColumnIdto(column.getColumn())){
						rowItem.setColumnOldIdo(column.getColumn(),rowItem.getColumnIdo(column.getColumn()));
						rowItem.setColumnOldIdto(column.getColumn(),rowItem.getColumnIdto(column.getColumn()));
						int action=rowItem.getState();
						if(rowItem.isNullRow())
							action=RowItem.CREATION_STATE+RowItem.SUBCREATION_STATE;
						else action=RowItem.SUBCREATION_STATE;
						rowItem.setState(action);
					}
				}
	        }
	    	mustStop=false;
    	}*/
        return super.stopCellEditing();        
    }

	@Override
	public void cancelChangeValue() {
		editorComponent.setSelected( oldValue );
		value=oldValue;
	}

	@Override
	public void setValue(Object value) {
		//logger.info("set selected:"+value);
		editorComponent.setSelected( (Boolean)value );
		this.value=(Boolean)value;
	}     
}