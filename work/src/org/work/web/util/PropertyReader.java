package org.work.web.util;  
  
import java.net.URL;  
import java.util.*;  
  
/** 
 * Util class that will read properties from the WEB-INF/classes/directory 
 * or by specifying a URL on the filesystem. 
 * Also has a helper method for creating a platform independent URL. 
*/  
public class PropertyReader {  
  
   /** 
    * Retrieve the properties specified by the fileName 
    * The property file should be in the WEB-INF/classess directory 
    * Suppose you need to get the properties in the 
    * web-inf/classes/config/application.properties , 
    * you need to pass the propertyFile: config/application.properties 
    * 
    * @param propertyFile relative path to a properties file in the WEB-INF/classes directory 
    * @return a <code>Properties<code> object based on the input file 
    **/  
   public static Properties getProperties(String propertyFile) {  
      try {  
         URL url = getPropertiesURL(propertyFile);  
         return getProperties(url);  
      }  
      catch (Exception e) {  
         System.out.println("Error ocurred during properties retrieval");  
         System.out.println(e.getMessage());  
         return null;  
      }  
   }  
  
   /** 
    * This method will return a platform independent URL to a file 
    * in the web-inf/classes direcotry. 
    * 
    * @param fileName relative path to a properties file in the WEB-INF/classes directory 
    * @return a platform independent URL to the xml file. 
    */  
   public static URL getPropertiesURL(String fileName) {  
      try {  
         System.out.println("Getting the properties URL");  
         URL url = null;  
         url = PropertyReader.class.getResource("/" + fileName);  
         String s = url.toString();  
         System.out.println("Filename of the  properties file is: " + s);  
         if (s.indexOf("file://") != -1) {  
            int indexOf = s.indexOf("file://") + 6;  
            String temp = s.substring(0, indexOf);  
            System.out.println("temp = " + temp + " moet zijn file:/");  
            url = new URL(temp + "//" + s.substring(indexOf));  
            System.out.println("The url is now: " + url);  
         }  
         return url;  
      }  
      catch (Exception e) {  
         System.out.println("Error ocurred during properties retrieval");  
         System.out.println(e.getMessage());  
         return null;  
      }  
   }  
  
   /** 
    * Retrieve the properties accesible through the specified URL 
    * 
    * @param url a reference to a properties file 
    * @return a properties file 
    **/  
   public static Properties getProperties(URL url) {  
      try {  
         Properties props = new Properties();  
         // Check for Solaris compatibility.  
         // A // in the file protocol won't be found in Solaris.  
         props.load(url.openStream());  
         System.out.println("Properties have been loaded: " + props);  
         return props;  
      }  
      catch (Exception e) {  
         System.out.println("Error ocurred during properties retrieval");  
         System.out.println(e.getMessage());  
         return null;  
      }  
   }  
}  