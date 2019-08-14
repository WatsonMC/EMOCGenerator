package view;

import Controller.config.Config;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class TemplateSourcesDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton btnAF;
    private JButton btnHC;
    private JButton btnSD;
    private JTextField txtHC;
    private JTextField txtAF;
    private JTextField txtSD;

    private Map<String,JTextField> componentMap;

    public TemplateSourcesDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
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
    }

    private void onOK() {
        // add your code here
        //TODO set config properties to be text field valuse
        //TODO set buttons to call FileGUI.getFile() and send that to the txtField
        //TODO change model so that it reads filepathes from config file, then add update method so that it re-reads after this dialog closes
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void updateText(String key){
        try{
            componentMap.get(key).setText(Config.getProperty(key));
        }
        catch(NullPointerException npe){
            System.out.println("No key of that type: " + key );
        }
    }

    public void initComponentMap(){
        componentMap =  new HashMap<>();
        componentMap.put("hazardsChecklistFP", txtHC);
        componentMap.put("applicationFormFP", txtAF);
        componentMap.put("supportingDocsFP", txtSD);
        for(String key: componentMap.keySet()){
            updateText(key);
        }
    }

    public static void createAndShowDialog() {
        TemplateSourcesDialog dialog = new TemplateSourcesDialog();
        dialog.initComponentMap();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
