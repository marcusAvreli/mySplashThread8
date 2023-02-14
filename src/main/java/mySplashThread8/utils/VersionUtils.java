package mySplashThread8.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class VersionUtils {

	private static final Logger logger = LoggerFactory.getLogger(VersionUtils.class);

    public static String getClientVersion() {
        return "1.14";
    }

    public static String getPatchLevel() {
        return "0";
    }

    public static String getBuild() {
        return "0";
    }
    public static String getFullClientVersion() {
        return getClientVersion() + "." + getPatchLevel() + "." + getBuild();
    }
}
