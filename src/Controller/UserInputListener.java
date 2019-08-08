package Controller;

import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class UserInputListener implements DocumentListener{

	@Override
	public void insertUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		boolean success = EGController.getView().updateField(doc);
		if (!success) {
			System.out.println("Error when trying to update ");
		}		
	}
		

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		boolean success = EGController.getView().updateField(doc);
		if (!success) {
			System.out.println("Error when trying to update ");
		}		
	}
	
}
