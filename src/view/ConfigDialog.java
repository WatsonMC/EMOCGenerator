package view;

import Controller.config.Config;
import Model.EGModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtWorkArea;
    private JTextField txtName;
    private JTextField txtEmoc;
    private JButton btnWorkArea;
    private JButton btnName;
    private JButton btnEmoc;

    private Map<String, JTextField> componentMap;
    private static EGModel model;

    public ConfigDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.setTitle("Configure default values");

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        btnWorkArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config.setProperty("workArea",componentMap.get("workArea").getText());
                model.setWA(componentMap.get("workArea").getText());
            }
        });
        btnName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config.setProperty("name",componentMap.get("name").getText());
                model.setName(componentMap.get("name").getText());

            }
        });
        btnEmoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config.setProperty("emoc",componentMap.get("emoc").getText());
                model.setEmoc(componentMap.get("emoc").getText());
            }
        });
    }

    private void onOK() {
        // add your code here

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void initComponentMap(){
        componentMap =  new HashMap<>();
        componentMap.put("name", txtName);
        componentMap.put("workArea", txtWorkArea);
        componentMap.put("emoc", txtEmoc);
        for(String key: componentMap.keySet()){
            updateText(key);
        }
    }

    private void updateText(String key){
        try{
            ((JTextField)componentMap.get(key)).setText(Config.getProperty(key));
        }
        catch(NullPointerException npe){
            System.out.println("No key of that type: " + key );
        }
    }

    public static void loadModel(EGModel model){
        ConfigDialog.model = model;
    }

    public static void createAndShowDialog(){
        ConfigDialog dialog = new ConfigDialog();
        dialog.initComponentMap();
        dialog.pack();
        dialog.setVisible(true);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                model.updateFields();
            }
        });
    }

}
