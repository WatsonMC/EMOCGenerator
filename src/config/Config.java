package config;

import java.util.Properties;

public class Config {
    private static Config instance;
    private Properties configFile;

    private Config(){
        configFile = new Properties();
        try{
            configFile.load(this.getClass().getResourceAsStream(("config.cfg")));
        }
        catch(Exception eta){
            eta.printStackTrace();
        }
    }

    private String getValue(String key){
        return configFile.getProperty(key);
    }

    public static String getProperty(String key){
        if(instance == null) {instance = new Config();}
        return instance.getValue(key);

    }


}
