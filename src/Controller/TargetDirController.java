package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import fileReaderGUI.FileGUI;
import fileReaderGUI.FileGUI;
import fileReaderGUI.FileGuiInterface;
import view.EGView;

public class TargetDirController  implements ActionListener{

	private static EGView view;

	
	/** 
	 * This class lisens to the Select Directory button and calls a JFileChooser to update the direcotry text
	 * with the file path when chosen.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Opening File GUI for target directory");
		String filePath = FileGuiInterface.getDirectory().getAbsolutePath();
		if(filePath !=null) {
			view.setDirText(filePath);
			//TODO log here- filepath x set
		}
	}
	
	public static void loadView(EGView view) {
		TargetDirController.view= view;
	}

}
