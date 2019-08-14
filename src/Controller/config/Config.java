package Controller.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class Config {
    private static Config instance;
    private Properties configFile;

    private Config(){
        configFile = new Properties();
        try{
            configFile.load(this.getClass().getResourceAsStream(("/res/config.properties")));
        }
        catch(Exception eta){
            eta.printStackTrace();
        }
    }

    private String getValue(String key){
        return configFile.getProperty(key);
    }

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

    public static String getProperty(String key){
        if(instance == null) {instance = new Config();}
        return instance.getValue(key);

    }

    public static boolean setProperty(String key, String value){
        if(instance == null) {instance = new Config();}
        return instance.setValue(key,value);
    }




}
