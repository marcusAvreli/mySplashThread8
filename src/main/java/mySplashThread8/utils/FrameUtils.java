package mySplashThread8.utils;


	import java.awt.Container;
	import java.awt.Dimension;
	import java.awt.Point;
	import java.awt.Toolkit;
	import java.awt.Window;
	import javax.swing.JDialog;
	import javax.swing.JFrame;

	/**
	 *
	 * @author jens
	 */
	public class FrameUtils {
	    
	    public static void centerFrame(JFrame frame, JFrame parent) {
	        Dimension d = null; // size of what we're positioning against
	        Point     p = null;
	        
	        if (parent != null) // w is what we are positioning against, null means desktop
	        {
	            d = parent.getSize();
	            p = parent.getLocation();
	        } else {
	            d = Toolkit.getDefaultToolkit().getScreenSize();
	            p = new Point();
	        }
	        
	        double centreX = p.getX() + d.getWidth()  / 2;
	        double centreY = p.getY() + d.getHeight() / 2;
	        
	        frame.getSize(d);
	        p.setLocation(centreX - d.getWidth() / 2,
	                centreY - d.getHeight() / 2);
	        if (p.getX() < 0)
	            p.setLocation(0, p.getY());
	        
	        if (p.getY() < 0)
	            p.setLocation(p.getX(), 0);
	        
	        frame.setLocation(p);
	    }
	    
	    public static void fitDialogToScreen(JDialog dlg, float percentOfScreen) {
	        
	        Dimension d = null; // size of what we're positioning against
	        Point     p = null;
	        
	            d = Toolkit.getDefaultToolkit().getScreenSize();
	            
	            dlg.setSize((int)(d.getWidth()*(percentOfScreen/100f)), (int)(d.getHeight()*(percentOfScreen/100f)));
	        
	        centerDialog(dlg, null);
	    }
	    
	    public static void centerDialog(JDialog dlg, Window parent) {
	        Dimension d = null; // size of what we're positioning against
	        Point     p = null;
	        
	        if (parent != null) // w is what we are positioning against, null means desktop
	        {
	            d = parent.getSize();
	            p = parent.getLocation();
	        } else {
	            d = Toolkit.getDefaultToolkit().getScreenSize();
	            p = new Point();
	        }
	        
	        double centreX = p.getX() + d.getWidth()  / 2;
	        double centreY = p.getY() + d.getHeight() / 2;
	        
	        dlg.getSize(d);
	        p.setLocation(centreX - d.getWidth() / 2,
	                centreY - d.getHeight() / 2);
	        if (p.getX() < 0)
	            p.setLocation(0, p.getY());
	        
	        if (p.getY() < 0)
	            p.setLocation(p.getX(), 0);
	        
	        dlg.setLocation(p);
	    }
	    
	    public static Container getDialogOfComponent(Container c) {
	        
	        while(!(c instanceof JDialog) && c.getParent()!=null) {
	            c=c.getParent();
	        }
	        return c;
	    }
	    
	}

