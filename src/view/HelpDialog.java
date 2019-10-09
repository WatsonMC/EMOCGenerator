package view;

import javax.swing.*;
import java.awt.event.*;

public class HelpDialog extends JDialog {
    private JPanel contentPane;
    private JButton btnOK;

    private JTabbedPane tabbedPane1;
    private JTextArea txtUsage;
    private JLabel lblUsageTitle;
    private JLabel lblConfigTitle;
    private JTextArea txtConfig;
    private JLabel lblTemplateTitle;
    private JTextArea txtTemplates;

    public HelpDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOK);
        this.setTitle("Help");
        this.setResizable(false);
        this.txtUsage.setEditable(false);
        this.txtConfig.setEditable(false);
        this.txtTemplates.setEditable(false);

        btnOK.addActionListener(new ActionListener() {
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
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void createAndShowDialog(){
        HelpDialog dialog = new HelpDialog();

        dialog.pack();
        dialog.setVisible(true);
    }

}
