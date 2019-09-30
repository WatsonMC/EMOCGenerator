package Controller.config;

import org.apache.commons.io.FileUtils;

import javax.naming.ConfigurationException;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Properties;

public class Config {

    /*
    *@author
     */


    private static Config instance;
    private Properties configFile;
    private String filePath;
    private static String installationRoot = System.getenv("PROGRAMFILES(X86)") + "\\Watson\\EMOC Generator";

    /*
    *Constructor for config object. Creates the Properties object.
     */
    private Config(){
        configFile = new Properties();
        filePath = System.getProperty("user.home") + "\\AppData\\Roaming\\WatsonWare\\Emoc Generator\\config.properties";
        try(FileInputStream in = new FileInputStream(new File(filePath) )){
            System.out.println("new Config object created");
            configFile.load(in);
//            configFile.load(Config.class.getResourceAsStream(("/res/config.properties")));
        }
        catch(Exception eta){
            eta.printStackTrace();
        }
    }

    /*
     *Getter for a key:value
     *@return vale for  key or null
     */
    private String getValue(String key) {

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
            try (FileOutputStream out = new FileOutputStream(new File(filePath))){
                configFile.store(out,"no comment");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{

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

    /*
    Method to initialzie the config file from the install location and copy it to app data.
    Method also alters file contents to point to freshly installed Doc locations
     */
    public static void intialize() throws ConfigurationException,IOException{
        String rootDirPath = System.getenv("PROGRAMFILES(X86)");
        System.out.println(rootDirPath);
        String configFilePath = installationRoot + "\\config.properties";
        String appDataPath =  System.getProperty("user.home") + "\\AppData\\Roaming\\WatsonWare\\Emoc Generator\\config.properties";

        if(new File(appDataPath).exists()){
            throw new ConfigurationException("Initialize config called, but config file exists already. Config file will not be replaced");
        }
        else{
            FileUtils.copyFile(new File(configFilePath),new File(appDataPath));
        }
        setProperty("applicationFormFP",installationRoot+"\\Ext\\EMOC Application Form.docx");
        setProperty("supportingDocsFP",installationRoot+"\\Ext\\Supporting Documentation.docx");
        setProperty("hazardsChecklistFP",installationRoot+"\\Ext\\Hazard Checklist.docx");
    }

}
