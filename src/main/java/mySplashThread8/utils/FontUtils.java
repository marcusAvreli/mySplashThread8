package mySplashThread8.utils;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Hashtable;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author jens
 */
public class FontUtils {

    private static FontUtils instance = null;

    private Hashtable defaultFonts = null;

    private FontUtils() {
        this.defaultFonts = new Hashtable();
        this.loadDefaults();
    }

    public static String[] getFontFamilies() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        return ge.getAvailableFontFamilyNames();
    }

    public static synchronized FontUtils getInstance() {
        if (instance == null) {
            instance = new FontUtils();
        }
        return instance;
    }

    private void loadDefaults() {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
                FontUIResource currentFont = (FontUIResource) value;
                this.defaultFonts.put(key, value);
            }
            if (value != null && value instanceof Font) {
                Font currentFont = (Font) value;
                this.defaultFonts.put(key, value);
            }
        }
    }

    public void updateDefaults(int sizeOffset) {
        java.util.Enumeration keys = this.defaultFonts.keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = this.defaultFonts.get(key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
                FontUIResource currentFont = (FontUIResource) value;
                Font newFont = currentFont.deriveFont((float) currentFont.getSize() + (float) sizeOffset);
                UIManager.put(key, newFont);
            }
            if (value != null && value instanceof Font) {
                Font currentFont = (Font) value;
                Font newFont = currentFont.deriveFont((float) currentFont.getSize() + (float) sizeOffset);
                UIManager.put(key, newFont);
            }
        }
    }

}