package mySplashThread8.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;

/**
 *
 * @author jens
 */
public class TagUtils {

    public static String getTagList(ArrayList<String> tags) {

        StringBuilder sb = new StringBuilder();

        Collections.sort(tags);
        for (String t : tags) {
            sb.append(t);
            sb.append(", ");
        }
        String returnValue = sb.toString();
        if (returnValue.endsWith(", ")) {
            returnValue = returnValue.substring(0, returnValue.length() - 2);
        }
        return returnValue;

    }

    public static String getTagList(String id, Hashtable<String, ArrayList<String>> tags) {
        if (tags.containsKey(id)) {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> list = tags.get(id);
            Collections.sort(list);
            for (String t : list) {
                sb.append(t);
                sb.append(", ");
            }
            String returnValue = sb.toString();
            if (returnValue.endsWith(", ")) {
                returnValue = returnValue.substring(0, returnValue.length() - 2);
            }
            return returnValue;
        } else {
            return "";
        }
    }
    
    public static String getTagList(String id, HashMap<String, ArrayList<String>> tags) {
        if (tags.containsKey(id)) {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> list = tags.get(id);
            Collections.sort(list);
            for (String t : list) {
                sb.append(t);
                sb.append(", ");
            }
            String returnValue = sb.toString();
            if (returnValue.endsWith(", ")) {
                returnValue = returnValue.substring(0, returnValue.length() - 2);
            }
            return returnValue;
        } else {
            return "";
        }
    }

    public static void populateTags(List<String> tags, JButton cmdTagFilter, JPopupMenu popTagFilter, TagSelectedAction action) {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = false;
                for (MenuElement me : popTagFilter.getSubElements()) {
                    JCheckBoxMenuItem mi = ((JCheckBoxMenuItem) me.getComponent());
                    if (mi.isSelected()) {
                        selected = true;
                        break;
                    }
                }
                if (selected) {
                    cmdTagFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16/favorites-green.png")));
                } else {
                    cmdTagFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons16/favorites.png")));
                }

                if (action != null) {
                    action.execute();
                }

            }

        };

        List<String> currentComboItems = new ArrayList<>();
        List<String> lastFilterTags = new ArrayList<>();
        MenuElement[] elements = popTagFilter.getSubElements();
        for (MenuElement e : elements) {
            currentComboItems.add(((JCheckBoxMenuItem) e.getComponent()).getText());
            if (((JCheckBoxMenuItem) e.getComponent()).isSelected()) {
                lastFilterTags.add(((JCheckBoxMenuItem) e.getComponent()).getText());
            }
        }
        Collections.sort(currentComboItems);
        if (tags == null) {
            tags = new ArrayList<>();
        }
        if (!tags.equals(currentComboItems)) {

            popTagFilter.removeAll();
            for (String t : tags) {
                JCheckBoxMenuItem mi = new JCheckBoxMenuItem(t);
                if (lastFilterTags.contains(t)) {
                    mi.setSelected(true);
                } else {
                    mi.setSelected(false);
                }
                popTagFilter.add(mi);
            }
            for (MenuElement me : popTagFilter.getSubElements()) {
                ((JCheckBoxMenuItem) me.getComponent()).addActionListener(al);
            }

        }
    }

    public static String getDocumentTagsOverviewAsHtml(Hashtable<String, ArrayList<String>> docTags) {
        StringBuilder sb = new StringBuilder();
        if (docTags != null) {
            HashMap<String, Integer> activeTags = new HashMap<>();
            ArrayList<String> sortedTags = new ArrayList<>();
            for (ArrayList<String> dTags : docTags.values()) {
                for (String t : dTags) {
                    if (!sortedTags.contains(t)) {
                        sortedTags.add(t);
                    }
                    if (activeTags.containsKey(t)) {
                        activeTags.put(t, activeTags.get(t) + 1);
                    } else {
                        activeTags.put(t, 1);
                    }
                }
            }
            StringUtils.sortIgnoreCase(sortedTags);
            for (String dTag : sortedTags) {
                sb.append(dTag);
                sb.append(" (").append(activeTags.get(dTag)).append(")");
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public static String[] getSelectedTags(JPopupMenu popup) {
        ArrayList<String> selected = new ArrayList<>();
        MenuElement[] elements = popup.getSubElements();
        for (MenuElement e : elements) {
            if (((JCheckBoxMenuItem) e.getComponent()).isSelected()) {
                selected.add(((JCheckBoxMenuItem) e.getComponent()).getText());
            }
        }
        return selected.toArray(new String[0]);
    }


}