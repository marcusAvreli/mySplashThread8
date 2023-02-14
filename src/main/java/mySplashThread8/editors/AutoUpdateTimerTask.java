package mySplashThread8.editors;

import mySplashThread8.settings.ClientSettings;
import mySplashThread8.utils.VersionUtils;
import java.awt.Component;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author jens
 */
public class AutoUpdateTimerTask extends java.util.TimerTask {

	private static final Logger logger = LoggerFactory.getLogger(AutoUpdateTimerTask.class);
    private Component owner;

    /**
     * Creates a new instance of SystemStateTimerTask
     */
    public AutoUpdateTimerTask(Component owner) {
        super();
        this.owner = owner;

    }

    public void run() {

        int addressCount = 0;
        int archiveFileCount = 0;
        int docCount = 0;
        try {
            ClientSettings settings = ClientSettings.getInstance();
         //   JLawyerServiceLocator locator = JLawyerServiceLocator.getInstance(settings.getLookupProperties());

            //AddressServiceRemoteHome home = (AddressServiceRemoteHome)locator.getRemoteHome("ejb/AddressServiceBean", AddressServiceRemoteHome.class);
           // AddressServiceRemote addressService = locator.lookupAddressServiceRemote();
            addressCount = 6;

            //ArchiveFileServiceRemoteHome fHome = (ArchiveFileServiceRemoteHome)locator.getRemoteHome("ejb/ArchiveFileServiceBean", ArchiveFileServiceRemoteHome.class);
          //  ArchiveFileServiceRemote fileService = locator.lookupArchiveFileServiceRemote();
           // archiveFileCount = fileService.getArchiveFileCount();

            docCount = 5;

        } catch (Throwable t) {
            logger.error("Error getting usage stats", t);
        }

        try {
            String javaVersion = System.getProperty("java.version");
            javaVersion = URLEncoder.encode(javaVersion, "UTF-8");

            String osName = System.getProperty("os.name");
            osName = URLEncoder.encode(osName, "UTF-8");

            String osVersion = System.getProperty("os.version");
            osVersion = URLEncoder.encode(osVersion, "UTF-8");

          //  ServerSettings set = ServerSettings.getInstance();
            String company = "test";
            String zip = "zip";

            String voipmode = "off";
            
            String drebismode = "on";
            String backupmode = "off";

            // anonymous - identify as unique installation, but we don't care about personal details.
            String installationHash = md5(zip + " " + company);
            String userHash = "userHash";

            String csession = installationHash + ",user=" + userHash + ",java=" + javaVersion + ",os=" + osName + ",osversion=" + osVersion + ",adrc=" + addressCount + ",afc=" + archiveFileCount + ",docc=" + docCount + ",j-lawyer=" + VersionUtils.getFullClientVersion() + ",drebis=" + drebismode + ",voip=" + voipmode + ",backup=" + backupmode;

            URL updateURL = new URL("https://www.j-lawyer.org/downloads/updatecheck.xml?csession=" + "session");
            URLConnection urlCon = updateURL.openConnection();
            urlCon.setRequestProperty("User-Agent", "j-lawyer Client v" + VersionUtils.getFullClientVersion());

            InputStream is = urlCon.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);

            char[] buffer = new char[1024];
            int len = 0;
            StringBuffer sb = new StringBuffer();
            while ((len = reader.read(buffer)) > -1) {
                sb.append(buffer, 0, len);
            }
            reader.close();
            is.close();
            String updateContent = sb.toString();
//            System.out.println(updateContent);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            try {
                dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
                dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            } catch (IllegalArgumentException iae) {
                // only available from JAXP 1.5+, but Wildfly still ships 1.4
            	logger.warn("Unable to set external entity restrictions in XML parser", iae);
            }
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(updateContent)));

            NodeList nl = doc.getElementsByTagName("version");
            String version = nl.item(0).getTextContent();
//            System.out.println(version);

            nl = doc.getElementsByTagName("changelogurl");
            String changelog = nl.item(0).getTextContent();
//            System.out.println(changelog);

            nl = doc.getElementsByTagName("published");
            String published = nl.item(0).getTextContent();
//            System.out.println(published);

            nl = doc.getElementsByTagName("news-published");
            String newsPublished = nl.item(0).getTextContent();
            nl = doc.getElementsByTagName("news-url");
            String newsUrl = nl.item(0).getTextContent();
            nl = doc.getElementsByTagName("news-summary");
            String newsSummary = nl.item(0).getTextContent();

            //if (!VersionUtils.getFullClientVersion().equals(version)) {
  /*          if (VersionUtils.isVersionGreater(version, VersionUtils.getFullClientVersion())) {
                EventBroker b = EventBroker.getInstance();
                b.publishEvent(new AutoUpdateEvent(version, published, changelog));
            }
*/
            ClientSettings settings = ClientSettings.getInstance();
            String lastConfirmed = settings.getConfiguration("client.desktop.news.lastconfirmed", "dummy");
            if (!newsPublished.equals(lastConfirmed)) {
                //EditorsRegistry.getInstance().newsNotification(newsSummary, newsPublished, newsUrl);
    //            EventBroker b = EventBroker.getInstance();
      //          b.publishEvent(new NewsEvent(newsSummary, newsPublished, newsUrl));
            }

            nl = doc.getElementsByTagName("urlforum");
            String urlForum = nl.item(0).getTextContent();
        //    settings.setUrlForum(urlForum);

            nl = doc.getElementsByTagName("urlhelp");
            String urlHelp = nl.item(0).getTextContent();
          //  settings.setUrlHelp(urlHelp);

            nl = doc.getElementsByTagName("urlxjustiz");
            String urlXjustiz = nl.item(0).getTextContent();
           // settings.setUrlXjustiz(urlXjustiz);

            nl = doc.getElementsByTagName("bea-enabled-versions");
            String beaEnabledVersions = nl.item(0).getTextContent();
            //set.setSetting(ServerSettings.SERVERCONF_BEAENABLEDVERSIONS, beaEnabledVersions);

        } catch (Throwable t) {
            logger.error("Error checking for updates on j-lawyer.org", t);
        }

    }

    private static String md5(String plaintext) {

        try {

            MessageDigest m = MessageDigest.getInstance("MD5");

            m.reset();

            m.update(plaintext.getBytes("UTF-8"));

            byte[] digest = m.digest();

            BigInteger bigInt = new BigInteger(1, digest);

            String hashtext = bigInt.toString(16);

//            while (hashtext.length() < 32) {
//
//                hashtext = "0" + hashtext;
//
//            }
            return hashtext;
        } catch (Throwable t) {
        	logger.error("error",t);
            return "" + plaintext.hashCode();
        }
    }
}