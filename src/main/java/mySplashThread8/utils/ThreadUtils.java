package mySplashThread8.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadUtils {
	private static final Logger logger = LoggerFactory.getLogger(DesktopUtils.class);
	 public static void setDefaultCursor(final Component component, boolean newThread) {
	        if (newThread) {
	            SwingUtilities.invokeLater(
	                    new Runnable() {

	                public void run() {
	                    component.setCursor(Cursor.getDefaultCursor());
	                }
	            });
	        } else {
	            component.setCursor(Cursor.getDefaultCursor());
	        }

	    }

	    public static void setDefaultCursor(final Component component) {
	        setDefaultCursor(component, true);
	    }
	    public static void updateLabel(final JLabel label, final String text) {

	        if (label == null) {
	            logger.warn("Label to be updated is null", new Exception());
	        } else {
	            SwingUtilities.invokeLater(
	                    new Runnable() {

	                public void run() {

	                    label.setText(text);

	                }
	            });
	        }

	    }

	    public static void updateLabelIcon(final JLabel label, final ImageIcon icon) {
	        SwingUtilities.invokeLater(
	                new Runnable() {

	            public void run() {
	                label.setIcon(icon);
	            }
	        });
	    }
	    
	    public static void setWaitCursor(final Component component) {
	        setWaitCursor(component, true);
	    }

	    public static void setWaitCursor(final Component component, boolean newThread) {
	        if (newThread) {
	            SwingUtilities.invokeLater(() -> {
	                component.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	            });
	        } else {
	            component.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	        }
	    }
	    public static void setTabbedPaneIcon(final JTabbedPane component, final int index, final Icon icon) {
	        SwingUtilities.invokeLater(() -> {
	            component.setIconAt(index, icon);
	        });
	    }
	    public static void setText(final JButton button, final String s) {
	        SwingUtilities.invokeLater(() -> {
	            button.setText(s);
	        });
	    }
	    
	    public static void setTextField(final JTextField tf, final String s) {
	        SwingUtilities.invokeLater(() -> {
	            tf.setText(s);
	        });
	    }

	    public static void setToolTipText(final JComponent c, final String s) {
	        SwingUtilities.invokeLater(() -> {
	            c.setToolTipText(s);
	        });
	    }
	    
	    public static void setVisible(final JComponent component, final boolean visible) {
	        SwingUtilities.invokeLater(() -> {
	            component.setVisible(visible);
	        });
	    }
	    
	    public static void setSplitDividerLocation(final JSplitPane component, final int location) {
	        SwingUtilities.invokeLater(() -> {
	            component.setDividerLocation(location);
	        });
	    }
	    public static void setLabelForeGround(final JLabel label, final Color c) {
	        SwingUtilities.invokeLater(() -> {
	            label.setForeground(c);
	        });
	    }
	    public static void setLabel(final JLabel label, final String s) {
	        SwingUtilities.invokeLater(() -> {
	            label.setText(s);
	        });
	    }
	    
	    public static void setTableModel(final JTable table, final TableModel model) {
	        setTableModel(table, model, null, true, -1, -1);
	    }
	    
	    public static void setTableModel(final JTable table, final TableModel model, final int selectionIndexFrom, final int selectionIndexTo) {
	        setTableModel(table, model, null, true, selectionIndexFrom, selectionIndexTo);
	    }

	    public static void setCellRenderer(final JTable table, final TableCellRenderer renderer, final int column) {
	        SwingUtilities.invokeLater(() -> {
	            table.getColumnModel().getColumn(column).setCellRenderer(renderer);
	        });
	    }

	    public static void setTableModel(final JTable table, final TableModel model, final TableRowSorter rowSorter) {
	        setTableModel(table, model, rowSorter, true, -1 ,-1);
	    }

	    public static void setTableModel(final JTable table, final TableModel model, final TableRowSorter rowSorter, boolean newThread, final int selectionIndexFrom, final int selectionIndexTo) {
	        if (newThread) {
	            SwingUtilities.invokeLater(() -> {
	                table.setModel(model);
	                if (rowSorter == null) {
	                    RowSorter<TableModel> sorter = new TableRowSorter<>(model);
	                    table.setRowSorter(sorter);
	                } else {
	                    table.setRowSorter(rowSorter);
	                }
	                if(model.getRowCount()>0) {
	                    ComponentUtils.autoSizeColumns(table);
	                    if (selectionIndexFrom > -1 && selectionIndexTo > -1) {
	                        table.getSelectionModel().setSelectionInterval(selectionIndexFrom, selectionIndexTo);
	                    }
	                }
	            });
	        } else {
	            table.setModel(model);
	            if (rowSorter == null) {
	                RowSorter<TableModel> sorter = new TableRowSorter<>(model);
	                table.setRowSorter(sorter);
	            } else {
	                table.setRowSorter(rowSorter);
	            }
	            if(model.getRowCount()>0) {
	            ComponentUtils.autoSizeColumns(table);
	            if (selectionIndexFrom > -1 && selectionIndexTo > -1) {
	                table.getSelectionModel().setSelectionInterval(selectionIndexFrom, selectionIndexTo);
	            }
	            }
	        }
	    }

}
