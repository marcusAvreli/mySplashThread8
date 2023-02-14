package mySplashThread8.editors.addresses;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jens
 */
public class QuickAddressSearchTableModel extends DefaultTableModel {
    
    /** Creates a new instance of QuickAddressSearchTableModel */
    public QuickAddressSearchTableModel(Object[] colNames, int rowCount) {
        super(colNames, rowCount);
    }

    public boolean isCellEditable(int i, int i0) {
        /*boolean retValue;
        
        retValue = super.isCellEditable(i, i0);
        return retValue;*/
        return false;
    }
    
}