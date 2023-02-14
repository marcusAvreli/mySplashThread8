package mySplashThread8.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringUtils {
	  public static void sortIgnoreCase(List<String> list) {
	        Collections.sort(list, new SortIgnoreCase());
	    }
	  public static boolean isEmpty(String s) {
		  //j-lawyer-org/j-lawyer-server-common/src/com/jdimension/jlawyer/server/utils/ServerStringUtils.java 
	        if(s==null)
	            return true;
	        
	        if("".equals(s.trim()))
	            return true;
	        
	        return false;
	            
	    }
	   public static boolean equals(String s1, String s2) {
	        if(s1==null) {
	            return (s2==null || "".equals(s2));
	        } else  {
	            return s1.equals(s2);
	        }
//	        return true;
	    }
	    
	    public static void sortIgnoreCase(String[] list) {
	        Arrays.sort(list, new SortIgnoreCase());
	    }
	    
	    static class SortIgnoreCase implements Comparator<Object> {
	        public int compare(Object o1, Object o2) {
	            String s1 = (String) o1;
	            String s2 = (String) o2;
	            return s1.toLowerCase().compareTo(s2.toLowerCase());
	        }
	    }
}
