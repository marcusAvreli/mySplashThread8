package mySplashThread8.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jens
 */
public class SystemUtils {

	private static final Logger logger = LoggerFactory.getLogger(ThreadUtils.class);

    public static boolean launchedThroughWebstart() {
        boolean hasJNLP = false;
        try {
            Class.forName("javax.jnlp.ServiceManager");
            hasJNLP = true;
        } catch (ClassNotFoundException ex) {
            hasJNLP = false;
        }
        return hasJNLP;
    }
    
    public static boolean isLinux() {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.contains("linux");        
    }
    
    public static boolean isMacOs() {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.startsWith("mac");        
    }
    
    public static boolean isWindows() {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.contains("win");        
    }
}