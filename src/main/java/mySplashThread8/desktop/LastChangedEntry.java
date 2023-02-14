package mySplashThread8.desktop;

import java.util.ArrayList;

/**
 *
 * @author jens
 */
public class LastChangedEntry {
    
    private String id=null;
    private String name=null;
    private String fileNumber=null;
    private String reason=null;
    private String lastChangedBy=null;
    private ArrayList<String> tags=null;
    
    
    public LastChangedEntry() {
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the fileNumber
     */
    public String getFileNumber() {
        return fileNumber;
    }

    /**
     * @param fileNumber the fileNumber to set
     */
    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the lastChangedBy
     */
    public String getLastChangedBy() {
        return lastChangedBy;
    }

    /**
     * @param lastChangedBy the lastChangedBy to set
     */
    public void setLastChangedBy(String lastChangedBy) {
        this.lastChangedBy = lastChangedBy;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the tags
     */
    public ArrayList<String> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
    
}