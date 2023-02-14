package mySplashThread8.settings;

public class UserSettings {

    public static final String USER_AVATAR = "user.avatar";

    public static final String ROLE_READCASE = "readArchiveFileRole";
    public static final String ROLE_WRITECASE = "writeArchiveFileRole";
    public static final String ROLE_READADDRESS = "readAddressRole";
    public static final String ROLE_WRITEADDRESS = "writeAddressRole";
    public static final String ROLE_LOGIN = "loginRole";
    private static UserSettings instance=null;
    public static final String CONF_DESKTOP_RANDOM_BACKGROUND = "client.desktop.background.random";

    public static synchronized UserSettings getInstance() {
        if (instance == null) {
            instance = new UserSettings();
        }
        return instance;
    }
    
    public String getSetting(String key, String defaultValue) {
        
        String value = defaultValue;
        if (value == null) {
            value = defaultValue;
        }
        return value;
    }
}
