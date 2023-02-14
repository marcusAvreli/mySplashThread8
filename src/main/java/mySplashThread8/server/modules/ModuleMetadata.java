package mySplashThread8.server.modules;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.KeyStroke;
import javax.swing.tree.TreeNode;

public class ModuleMetadata  implements TreeNode {
    
    private String backgroundImage=null;
    private String randomBackgroundImage=null;
    private Icon defaultIcon=null;
    private Icon rolloverIcon=null;
    private String moduleName="";
    private String editorName="";
    private boolean settingsEntry=false;
    
    
    private String editorClass;
    
    private ModuleMetadata parent=null;

    private java.util.ArrayList<ModuleMetadata> childModules=new ArrayList<ModuleMetadata>();

    // legacy stuff
    private String icon=null;
    private transient Image iconAsImage=null;
    private String text;
    private String fullName=null;
    
    private Integer statusEventType=-1;
    
    private KeyStroke hotKey=null;
    private String hotKeyName=null;

    
    /** Creates a new instance of ModuleMetadata */
    public ModuleMetadata() {
        
    }
    
    
    
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEditorClass() {
        return editorClass;
    }

    public void setEditorClass(String editorClass) {
        this.editorClass = editorClass;
    }

    public java.util.ArrayList<ModuleMetadata> getChildModules() {
        return childModules;
    }

    public void setChildModules(java.util.ArrayList<ModuleMetadata> childModules) {
        this.childModules = childModules;
    }
    
    public void addChildModule(ModuleMetadata child) {
        this.childModules.add(child);
        child.setParent(this);
    }

    public ModuleMetadata(String text) {
        this.text=text;
    }

    public TreeNode getChildAt(int i) {
        return this.childModules.get(i);
    }

    public int getIndex(TreeNode treeNode) {
        return this.childModules.indexOf(treeNode);
    }

    public boolean isLeaf() {
        return this.childModules.size()==0;
    }

    public TreeNode getParent() {
        return parent;
    }
    
    public void setParent(ModuleMetadata parent) {
        this.parent=parent;
    }

    public int getChildCount() {
        return this.childModules.size();
    }

    public boolean getAllowsChildren() {
        return true;
    }

    public Enumeration children() {
        return new Vector(this.childModules).elements();
    }

    public String toString() {
        return this.text;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Image getIconAsImage() {
        return iconAsImage;
    }

    public void setIconAsImage(Image iconAsImage) {
        this.iconAsImage = iconAsImage;
    }

    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        
        if(!(obj instanceof ModuleMetadata))
            return false;
        
        ModuleMetadata comp=(ModuleMetadata)obj;
        if(this.text==null && comp.getText()!=null)
            return false;
        
        if(this.editorClass==null && comp.getEditorClass()!=null)
            return false;
        
        if(this.text!=null) {
            if(!(this.text.equals(comp.getText()))){
                return false;
            }
        }
        
        if(this.editorClass!=null) {
            if(!(this.editorClass.equals(comp.getEditorClass()))){
                return false;
            }
        }
        
        return true;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the defaultIcon
     */
    public Icon getDefaultIcon() {
        return defaultIcon;
    }

    /**
     * @param defaultIcon the defaultIcon to set
     */
    public void setDefaultIcon(Icon defaultIcon) {
        this.defaultIcon = defaultIcon;
    }

    /**
     * @return the rolloverIcon
     */
    public Icon getRolloverIcon() {
        return rolloverIcon;
    }

    /**
     * @param rolloverIcon the rolloverIcon to set
     */
    public void setRolloverIcon(Icon rolloverIcon) {
        this.rolloverIcon = rolloverIcon;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * @return the editorName
     */
    public String getEditorName() {
        return editorName;
    }

    /**
     * @param editorName the editorName to set
     */
    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    /**
     * @return the settingsEntry
     */
    public boolean isSettingsEntry() {
        return settingsEntry;
    }

    /**
     * @param settingsEntry the settingsEntry to set
     */
    public void setSettingsEntry(boolean settingsEntry) {
        this.settingsEntry = settingsEntry;
    }

    /**
     * @return the statusEventType
     */
    public Integer getStatusEventType() {
        return statusEventType;
    }

    /**
     * @param statusEventType the statusEventType to set
     */
    public void setStatusEventType(Integer statusEventType) {
        this.statusEventType = statusEventType;
    }

    /**
     * @return the hotKey
     */
    public KeyStroke getHotKey() {
        return hotKey;
    }

    /**
     * @param hotKey the hotKey to set
     */
    public void setHotKey(KeyStroke hotKey, String keyName) {
        this.hotKey = hotKey;
        this.setHotKeyName(keyName);
    }

    /**
     * @return the hotKeyName
     */
    public String getHotKeyName() {
        return hotKeyName;
    }

    /**
     * @param hotKeyName the hotKeyName to set
     */
    public void setHotKeyName(String hotKeyName) {
        this.hotKeyName = hotKeyName;
    }

    /**
     * @return the randomBackgroundImage
     */
    public String getRandomBackgroundImage() {
        return randomBackgroundImage;
    }

    /**
     * @param randomBackgroundImage the randomBackgroundImage to set
     */
    public void setRandomBackgroundImage(String randomBackgroundImage) {
        this.randomBackgroundImage = randomBackgroundImage;
    }
    
}
