package mySplashThread8.utils;


import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jens
 */
public class TableUtils {

    private static String CELL_BREAK = "\t";
    private static String LINE_BREAK = System.getProperty("line.separator");

    public static void exportAndLaunch(String fileName, JTable table) throws Exception {

//        int numCols = table.getSelectedColumnCount();
//        int numRows = table.getSelectedRowCount();
//        int[] rowsSelected = table.getSelectedRows();
//        int[] colsSelected = table.getSelectedColumns();
//        if (numRows != rowsSelected[rowsSelected.length - 1] - rowsSelected[0] + 1 || numRows != rowsSelected.length
//                || numCols != colsSelected[colsSelected.length - 1] - colsSelected[0] + 1 || numCols != colsSelected.length) {
//
//            //JOptionPane.showMessageDialog(null, "Invalid Copy Selection", "Invalid Copy Selection", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        StringBuffer excelStr = new StringBuffer();
//        for (int i = 0; i < numRows; i++) {
//            for (int j = 0; j < numCols; j++) {
//                excelStr.append(escape(table.getValueAt(rowsSelected[i], colsSelected[j])));
//                if (j < numCols - 1) {
//                    excelStr.append(CELL_BREAK);
//                }
//            }
//            excelStr.append(LINE_BREAK);
//        }
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();

        StringBuffer excelStr = new StringBuffer();

        for (int i = 0; i < numCols; i++) {
            excelStr.append(escape(table.getColumnName(i)));
            if (i < numCols - 1) {
                excelStr.append(CELL_BREAK);
            }
        }
        excelStr.append(LINE_BREAK);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Object cellValue = table.getValueAt(i, j);
                if (cellValue instanceof Boolean) {
                    if ((Boolean) cellValue == false) {
                        cellValue = "nein";
                    } else {
                        cellValue = "ja";
                    }
                }
                excelStr.append(escape(cellValue));
                if (j < numCols - 1) {
                    excelStr.append(CELL_BREAK);
                }
            }
            excelStr.append(LINE_BREAK);
        }

     //   ReadOnlyDocumentStore store = new ReadOnlyDocumentStore("jtableexport-" + fileName, fileName);
      //  Launcher launcher = LauncherFactory.getLauncher(fileName, excelStr.toString().getBytes(), store);
      //  launcher.launch(false);

    }

    public static void handleRowClick(JTable table, MouseEvent e) {
        ListSelectionModel selectionModel = table.getSelectionModel();
        Point contextMenuOpenedAt = e.getPoint();
        int clickedRow = table.rowAtPoint(contextMenuOpenedAt);

        if (clickedRow < 0) {
            // No row selected
            selectionModel.clearSelection();
        } else // Some row selected
        {
            if ((e.getModifiers() & InputEvent.SHIFT_MASK) == InputEvent.SHIFT_MASK) {
                int maxSelect = selectionModel.getMaxSelectionIndex();
                int minSelect = selectionModel.getMinSelectionIndex();

                int from = minSelect;
                int to = maxSelect;

                if (clickedRow <= minSelect) {
                    from = clickedRow;
                    to = maxSelect;
                } else {
                    from = minSelect;
                    to = clickedRow;
                }

                if (clickedRow >= maxSelect) {
                    from = minSelect;
                    to = clickedRow;
                } else {
                    from = clickedRow;
                    to = maxSelect;
                }

                if ((e.getModifiers() & InputEvent.CTRL_MASK) == InputEvent.CTRL_MASK) {
                    // Shift + CTRL
                    //selectionModel.addSelectionInterval(maxSelect, clickedRow);
                    selectionModel.addSelectionInterval(from, to);
                } else {
                    // Shift
                    //selectionModel.setSelectionInterval(maxSelect, clickedRow);
                    selectionModel.setSelectionInterval(from, to);
                }
            } else if ((e.getModifiers() & InputEvent.CTRL_MASK) == InputEvent.CTRL_MASK) {
                // CTRL
                selectionModel.addSelectionInterval(clickedRow, clickedRow);
            } else {
                // No modifier key pressed

                // if there is a selection, do nothing and let the popup open
                // otherwise select current row
                if (selectionModel.isSelectionEmpty()) {
                    selectionModel.setSelectionInterval(clickedRow, clickedRow);
                }
            }
        }
    }

    public static void moveUpwards(JTable table) {
        moveRowBy(table, -1);
    }

    public static void moveDownwards(JTable table) {
        moveRowBy(table, 1);
    }

    private static void moveRowBy(JTable table, int by) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int[] rows = table.getSelectedRows();
        int destination = rows[0] + by;
        int rowCount = model.getRowCount();

        if (destination < 0 || destination >= rowCount) {
            return;
        }

        model.moveRow(rows[0], rows[rows.length - 1], destination);
        table.setRowSelectionInterval(rows[0] + by, rows[rows.length - 1] + by);
    }

    private static String escape(Object cell) {
        if (cell != null) {
            if (cell.toString() != null) {
                return cell.toString().replace(LINE_BREAK, " ").replace(CELL_BREAK, " ");
            } else {
                return " ";
            }
        } else {
            return " ";
        }
    }
    
    public static int getRowForObject(JTable table, int column, Object search) {
        if(search==null)
            return -1;
        
        for (int i = 0; i < table.getRowCount(); i++) {
            Object value = table.getValueAt(i, column);
            if(value==null)
                continue;
            
            if (value.getClass().equals(search.getClass())) {
                if (value.equals(search)) {
                    return i;
                }
            }
        }

        return -1;
    }
    
   


}