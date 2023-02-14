package mySplashThread8.settings;

import java.awt.Image;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mySplashThread8.server.modules.ModuleMetadata;

public class ThemeSettings {
    
	private static final Logger logger = LoggerFactory.getLogger(ClientSettings.class);
    private static ThemeSettings instance=null;
    
    private Hashtable backgrounds;
    
    /**
     * Creates a new instance of ClientSettings
     */
    private ThemeSettings() {
        this.backgrounds=new Hashtable();
    }
    
    public static synchronized ThemeSettings getInstance() {
        if(instance==null) {
            instance=new ThemeSettings();
        }
        return instance;
    }
    
    public void addBackground(ModuleMetadata module, Image background) {
        this.backgrounds.put(module, background);
    }
    
    public Image getBackground(ModuleMetadata module) {
        return (Image)this.backgrounds.get(module);
    }
    
}
