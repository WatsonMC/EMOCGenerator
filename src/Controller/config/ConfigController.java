package Controller.config;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigController implements ActionListener {

    private JTextField dataField;
    private String key;

    private boolean loadProperty(String key, String value){
        return Config.setProperty(key,value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void loadTextField(JTextField field){
        if(dataField == null){
            this.dataField = field;
        }
    }

    public void loadKey(String key){
        if(this.key ==null){
            this.key = key;
        }
    }


}
