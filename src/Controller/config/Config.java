package config;

import java.util.Properties;

public class Config {
    private static Config instance;
    private Properties configFile;

    private Config(){
        configFile = new Properties();
        try{
            System.out.println(this.getClass().getResource("/").getPath());
            configFile.load(this.getClass().getResourceAsStream(("/config.cfg")));
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
        return setProperty(key,value);
    }


}
