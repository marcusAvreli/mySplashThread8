package mySplashThread8.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.MenuElement;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.slf4j.LoggerFactory;

import mySplashThread8.settings.ClientSettings;
import mySplashThread8.themes.colors.DefaultColorTheme;

import org.slf4j.Logger;

/**
 *
 * @author jens
 */
public class ComponentUtils {

	private static final Logger logger = LoggerFactory.getLogger(VersionUtils.class);

    public static void expandTree(JTree tree) {

        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }

    public static Object[] getAllListElements(JList list) {
        int size = list.getModel().getSize(); // 4
        Object[] objects = new Object[size];

        // Get all item objects
        for (int i = 0; i < size; i++) {
            Object item = list.getModel().getElementAt(i);
            objects[i] = item;
        }

        return objects;

    }

    public static boolean containsItem(JComboBox cmb, Object item) {
        ComboBoxModel cmbModel=cmb.getModel();
        for(int i=0;i<cmbModel.getSize();i++) {
            if(cmbModel.getElementAt(i).equals(item))
                return true;
        }
        return false;
    }
    
    public static void addAllItemsToCombobox(JComboBox cmb, Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            cmb.addItem(objects[i]);
        }
    }

    public static void addAllItemsToCombobox(JComboBox cmb, List objects) {
        for (int i = 0; i < objects.size(); i++) {
            cmb.addItem(objects.get(i));
        }
    }

    public static void selectComboboxItem(JComboBox cmb, Object selection) {
        for (int i = 0; i < cmb.getItemCount(); i++) {
            Object current = cmb.getItemAt(i);
            if (current.equals(selection)) {
                cmb.setSelectedIndex(i);
                break;
            }
        }
    }

    public static void autoSizeColumns(JTable table) {

        if (table.getRowCount() == 0) {
            return;
        }

        try {

            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            int totalColWidth = 0;

            for (int column = 0; column < table.getModel().getColumnCount(); column++) {
                TableColumn tableColumn = table.getColumnModel().getColumn(column);
                int preferredWidth = tableColumn.getMinWidth();
                int maxWidth = tableColumn.getMaxWidth();

                for (int row = 0; row < table.getModel().getRowCount(); row++) {
                    try {

                        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);

                        Component c = table.prepareRenderer(cellRenderer, row, column);
                        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                        preferredWidth = Math.max(preferredWidth, width);

                        //  We've exceeded the maximum width, no need to check other rows
                        if (preferredWidth >= maxWidth) {
                            preferredWidth = maxWidth;
                            break;
                        }
                    } catch (Throwable t) {
                        logger.error("error",t);
                    }
                }

                TableCellRenderer headerRenderer = tableColumn.getHeaderRenderer();
                if (headerRenderer == null) {
                    headerRenderer = table.getTableHeader().getDefaultRenderer();
                }
                Object headerValue = tableColumn.getHeaderValue();
                Component headerComp = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, 0, column);
                int maxHeaderWidth = Math.max(preferredWidth, headerComp.getPreferredSize().width);
                // note some extra padding
                //tableColumn.setPreferredWidth(maxWidth + 6);//IntercellSpacing * 2 + 2 * 2 pixel instead of taking this value from Borders

                preferredWidth = Math.max(preferredWidth, maxHeaderWidth + 6) + 15;

                tableColumn.setPreferredWidth(preferredWidth);
                totalColWidth = totalColWidth + preferredWidth;
            }

            if (totalColWidth < table.getParent().getWidth()) {
                TableColumn tableColumn = table.getColumnModel().getColumn(table.getColumnCount() - 1);
                tableColumn.setPreferredWidth(tableColumn.getPreferredWidth() + (table.getParent().getWidth() - totalColWidth));
            }

        } catch (Throwable t) {
            logger.error("Could not auto-resize table columns", t);
        }

    }

    public static void storeDialogSize(JDialog d) {
        try {
            if (d != null) {
                int width = d.getWidth();
                int height = d.getHeight();
                ClientSettings s = ClientSettings.getInstance();
                s.setConfiguration(d.getClass().getName() + ".w", "" + width);
                s.setConfiguration(d.getClass().getName() + ".h", "" + height);
            }
        } catch (Throwable t) {
            logger.error("can not store size of dialog", t);
        }
    }

    public static void setEnabledRecursive(Container c, boolean enabled) {
        c.setEnabled(enabled);
        for (Component child : c.getComponents()) {
            if (child instanceof Container) {
                setEnabledRecursive((Container) child, enabled);
            }
        }
    }

    public static void restoreDialogSize(JDialog d) {
        try {
            if (d != null) {
                ClientSettings s = ClientSettings.getInstance();
                String w = s.getConfiguration(d.getClass().getName() + ".w", "" + d.getWidth());
                String h = s.getConfiguration(d.getClass().getName() + ".h", "" + d.getHeight());

                int width = Integer.parseInt(w);
                int height = Integer.parseInt(h);

                d.setSize(width, height);

            }
        } catch (Throwable t) {
            logger.error("can not restore size of dialog", t);
        }
    }

    public static String[] getSelectedMenuItems(JPopupMenu pop) {
        ArrayList<String> list = new ArrayList<>();
        for (MenuElement me : pop.getSubElements()) {
            if (me.getComponent() instanceof JCheckBoxMenuItem) {
                JCheckBoxMenuItem mi = ((JCheckBoxMenuItem) me.getComponent());
                if (mi.isSelected()) {
                    list.add(mi.getText());
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void unSelectMenuItems(JPopupMenu pop) {
        for (MenuElement me : pop.getSubElements()) {
            if (me.getComponent() instanceof JCheckBoxMenuItem) {
                JCheckBoxMenuItem mi = ((JCheckBoxMenuItem) me.getComponent());
                mi.setSelected(false);
            }
        }
    }

    public static void decorateSplitPane(JSplitPane split) {
        decorateSplitPane(split, null);
    }

    public static void restoreSplitPane(JSplitPane split, Class container, String componentName) {
        try {
            String dividerLocation = ClientSettings.getInstance().getConfiguration("split." + container.getName() + "." + componentName, "");
            if (!"".equalsIgnoreCase(dividerLocation)) {
                split.setDividerLocation(Integer.parseInt(dividerLocation));
            }
        } catch (Throwable t) {
            logger.error("Could not set divider location for " + componentName + " in " + container.getName(), t);
        }
    }
    
    public static void persistSplitPane(JSplitPane split, Class container, String componentName) {
        split.addPropertyChangeListener((PropertyChangeEvent evt) -> {
            if (evt.getPropertyName().equals(JSplitPane.DIVIDER_LOCATION_PROPERTY)) {
                if (split.getDividerLocation() > 0) {
                    ClientSettings s = ClientSettings.getInstance();
                    s.setConfiguration("split." + container.getName() + "." + componentName, "" + split.getDividerLocation());
                }
            }
        });
    }

    public static void decorateSplitPane(JSplitPane split, Color dividerColor) {
        BasicSplitPaneDivider divider = ((BasicSplitPaneUI) split.getUI()).getDivider();
        split.setOneTouchExpandable(false);
        divider.setDividerSize(5);

        split.setUI(new BasicSplitPaneUI() {
            @Override
            public BasicSplitPaneDivider createDefaultDivider() {
                return new BasicSplitPaneDivider(this) {
                    @Override
                    public void setBorder(Border b) {
                    }

                    @Override
                    public void paint(Graphics g) {
                        if (dividerColor != null) {
                            g.setColor(dividerColor);
                        } else {
                            g.setColor(DefaultColorTheme.COLOR_DARK_GREY);
                        }
                        g.fillRect(0, 0, getSize().width, getSize().height);
                        super.paint(g);
                    }
                };
            }
        });
        split.setBorder(null);

    }
    
    public static void addAutoComplete(JComboBox cmb) {
//        ComboBoxAdaptor cmbAdaptor = new ComboBoxAdaptor(cmb);
//        AutoCompleteDocument autoCompDoc = new AutoCompleteDocument(cmbAdaptor, false);
//        AutoCompleteDecorator.decorate(cmb);
       // AutoCompleteDecorator.decorate(cmb);
    }
    
    public static void addAutoComplete(JTextField txt, String[] candidates) {
        JList dataList = new JList(candidates);
        //ListAdaptor listAdaptor = new ListAdaptor(dataList, txt);
       // AutoCompleteDocument autoCompDoc = new AutoCompleteDocument(listAdaptor, false);
        //AutoCompleteDecorator.decorate(txt, autoCompDoc, listAdaptor);
    }
}