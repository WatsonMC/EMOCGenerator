package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;

import Controller.ConfirmationController;
import Controller.TargetDirController;
import Controller.UserInputListener;
import Model.EGModel;

public class EGView {

	private EGModel model;
	
	private  JTextField txtName;
	private  JTextField txtDate;
	private  JTextField txtWorkArea;
	private  JTextField txtEmoc;
	private  JTextField txtTgtDir;
	private  JFrame frame_1;
	private JMenuBar menubar;


	
	private static  String TEXT_TARGET_DIR = "/Target/Directory/Here";
	
	public  String getEmoc() {
		return txtEmoc.getText();
	}
	
	public  String getTgtDir() {
		return txtTgtDir.getText();
	}

	public void setTxtEmoc(String txtEmoc) {
		this.txtEmoc.setText(txtEmoc); 
	}


	public  void setDirText(String newText) {
		EGView.TEXT_TARGET_DIR = newText;
		if(txtTgtDir != null){
			txtTgtDir.setText(newText);
		}
	}
	
	public EGView(EGModel model) {
		this.model = model;
	}
	
	public void loadModel(EGModel model) {
		this.model = model;
	}
	
	public boolean updateField(Document comp) {
		if(comp.equals(txtName.getDocument())) {
			model.setName(txtName.getText());
			return true;
		}
		if(comp.equals(txtDate.getDocument())) {
			model.setDate((txtDate.getText()));
			return true;
		}
		if(comp.equals(txtEmoc.getDocument())) {
			model.setEmoc(txtEmoc.getText());
			return true;
		}
		if(comp.equals(txtWorkArea.getDocument())) {
			model.setWA(txtWorkArea.getText());
//			System.out.println("text changed: " + txtWorkArea.getText());
			return true;
		}
		return false;
	}

	
	
	private void createConfirmationPanel(JPanel panel) {
		frame_1.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setBorder(new EmptyBorder(0,10,5,10));
		JButton btnConfirm = new JButton("Confirm selections, create documents");
		btnConfirm.addActionListener(new ConfirmationController());
		panel.setLayout(new BorderLayout());
		panel.add(btnConfirm,BorderLayout.CENTER);
	}

	private void createMenuBar(JFrame frame){
		menubar = new JMenuBar();
		JMenu file = new JMenu("file");
		JMenuItem configItem = new JMenuItem("Config");
		configItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConfigDialog.createAndShowDialog();
			}
		});
		JMenuItem templatesItem = new JMenuItem("Templates");
		templatesItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TemplateSourcesDialog.createAndShowDialog();
			}
		});
		file.add(templatesItem);
		file.add(configItem);
		menubar.add(file);
		frame.setJMenuBar(menubar);
	}

	private void createUserInputPanel(JPanel userInputPanel){
		userInputPanel.setForeground(Color.LIGHT_GRAY);
		GridBagLayout gl_userInputPanel = new GridBagLayout();
		
		
	
		userInputPanel.setLayout(gl_userInputPanel);
		frame_1.getContentPane().add(userInputPanel, BorderLayout.CENTER);
		

		
		txtEmoc = new JTextField();
		GridBagConstraints cEmoc = new GridBagConstraints();
		cEmoc.insets = new Insets(0, 20, 0, 0);
		cEmoc.gridx = 0;
		cEmoc.weightx = 0.75;
		cEmoc.gridy = 0;
		cEmoc.gridwidth = 2;
		cEmoc.fill = GridBagConstraints.HORIZONTAL;
		userInputPanel.add(txtEmoc,cEmoc);
		JLabel lbLEmoc = new JLabel("EMOC No");
		lbLEmoc.setHorizontalTextPosition(SwingConstants.LEFT);
		lbLEmoc.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints cLblEmoc = new GridBagConstraints();
		cLblEmoc.gridx = 2;
		cLblEmoc.gridy = 0;
		cLblEmoc.weightx = 0.25;
		userInputPanel.add(lbLEmoc,cLblEmoc);
		
		
		
		txtName = new JTextField(model.getName());
		GridBagConstraints cName = new GridBagConstraints();
		cName.insets = new Insets(0, 20, 0, 0);
		cName.gridx = 0;
		cName.weightx = 0.75;
		cName.gridy = 1;
		cName.gridwidth = 2;
		cName.fill = GridBagConstraints.HORIZONTAL;
		userInputPanel.add(txtName,cName);
		JLabel lblName = new JLabel("Applicant");
		lblName.setHorizontalTextPosition(SwingConstants.LEFT);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints cLblName = new GridBagConstraints();
		cLblName.gridx = 2;
		cLblName.gridy = 1;
		cLblName.weightx = 0.25;
		userInputPanel.add(lblName,cLblName);
		
		txtDate = new JTextField(model.getDate());
		GridBagConstraints cDate = new GridBagConstraints();
		cDate.insets = new Insets(0, 20, 0, 0);
		cDate.gridx = 0;
		cDate.weightx = 0.75;
		cDate.gridy = 2;
		cDate.gridwidth = 2;
		cDate.fill = GridBagConstraints.HORIZONTAL;
		userInputPanel.add(txtDate,cDate);
		JLabel lblDate = new JLabel("Date");
		GridBagConstraints cLblDate = new GridBagConstraints();
		cLblDate.gridx = 2;
		cLblDate.gridy = 2;
		cLblDate.weightx = 0.25;
		userInputPanel.add(lblDate,cLblDate);
	
		
		txtWorkArea = new JTextField(model.getWA());
		GridBagConstraints cWA = new GridBagConstraints();
		cWA.insets = new Insets(0, 20, 0, 0);
		cWA.gridx = 0;
		cWA.weightx = 0.75;
		cWA.gridy = 3;
		cWA.gridwidth = 2;
		cWA.fill = GridBagConstraints.HORIZONTAL;
		userInputPanel.add(txtWorkArea,cWA);
		JLabel lblWorkArea = new JLabel("Work Area");
		GridBagConstraints cLblWA = new GridBagConstraints();
		cLblWA.gridx = 2;
		cLblWA.gridy = 3;
		cLblWA.weightx = 0.25;
	
		txtWorkArea.getDocument().addDocumentListener(new UserInputListener());
		txtDate.getDocument().addDocumentListener(new UserInputListener());
		txtEmoc.getDocument().addDocumentListener(new UserInputListener());
		txtName.getDocument().addDocumentListener(new UserInputListener());
		userInputPanel.add(lblWorkArea,cLblWA);
	}
	
	private  void createSelectDirPanel(JPanel selectDirectoryPanel) {
		frame_1.getContentPane().add(selectDirectoryPanel, BorderLayout.NORTH);
		selectDirectoryPanel.setBorder(new EmptyBorder(5,10,5,10));
		selectDirectoryPanel.setLayout(new BorderLayout());
		
		
		
		txtTgtDir = new JTextField(TEXT_TARGET_DIR);
		selectDirectoryPanel.add(txtTgtDir, BorderLayout.CENTER);
		txtTgtDir.addPropertyChangeListener(TEXT_TARGET_DIR, new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				txtTgtDir.setText(TEXT_TARGET_DIR);
			}
		});
		
		JButton btnSelectDirectory = new JButton("Select Directory");
		selectDirectoryPanel.add(btnSelectDirectory, BorderLayout.LINE_END);
		btnSelectDirectory.addActionListener(new TargetDirController());
		
	}

	public void updateView(){
		txtEmoc.setText(model.getEmoc());
		txtName.setText(model.getName());
		txtWorkArea.setText(model.getWA());
	}

	//@wbp.parser.entryPoint

	/**
	 * @wbp.parser.entryPoint
	 */
	public void createAndShowGUI() {
		//setup labels
			//Date = Today
			//Work area = Asimov
			// Applicant = Malcolm watson
		// Select target directory
		// Create EMOC, Support Doc, Hazard check
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame_1 = new JFrame("EMOC Generator");
				frame_1.setPreferredSize(new Dimension(500, 250));
				frame_1.getContentPane().setSize(new Dimension(500, 300));
				frame_1.setResizable(false);
				BorderLayout borderLayout = (BorderLayout) frame_1.getContentPane().getLayout();
				borderLayout.setHgap(10);
				
				JPanel confirmationPanel = new JPanel();
				createConfirmationPanel(confirmationPanel);
				
				JPanel userInputPanel = new JPanel();
				createUserInputPanel(userInputPanel);
				
				JPanel selectDirectoryPanel = new JPanel();
				createSelectDirPanel(selectDirectoryPanel);

				createMenuBar(frame_1);
				frame_1.pack();
				frame_1.setVisible(true);		
				frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
	}
	
		
	public Dimension getFrameSize() {
		return frame_1.getSize();
	}
	public void setFrameSize(Dimension size) {
		frame_1.setSize(size);
	}
}
