package Controller.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class Config {

    /*
    *@author
     */


    private static Config instance;
    private Properties configFile;

    /*
    *Constructor for config object. Creates the Properties object.
     */
    private Config(){
        configFile = new Properties();
        try{
            configFile.load(this.getClass().getResourceAsStream(("/res/config.properties")));
        }
        catch(Exception eta){
            eta.printStackTrace();
        }
    }

    /*
    *Getter for a key:value
    *@return vale for key or null
    */
    private String getValue(String key){
        return configFile.getProperty(key);
    }

    /*
    *Setter for properties file
    *@param key String key for properties file
    *@param value String key to be applied in properties to key
    *@return boolean, true if successfully altered properties else false
    */
    private boolean setValue(String key, String value){
        if(configFile.getProperty(key)!= null){
            configFile.setProperty(key,value);
            try {
                FileOutputStream out = new FileOutputStream(new File(this.getClass().getResource("/res/config.properties").getPath()));
                configFile.store(out,"no comment");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    /*
    *Getter for property
    *@param key key of property to be returned
    @return value of property as a String or null
     */
    public static String getProperty(String key){
        if(instance == null) {instance = new Config();}
        return instance.getValue(key);

    }

    /*
    Setter for property
    @param key key to be set
    @param value String of value to be st to key
    @return boolean, true if set false else
     */
    public static boolean setProperty(String key, String value){
        if(instance == null) {instance = new Config();}
        return instance.setValue(key,value);
    }




}
