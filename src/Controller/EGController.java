package Controller;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;

import view.EGView;

public class EGController {
	//Functionality to add:
		/*
		 * Select target directory
		 * data validation on confirmation
		 * confirmation: For each doc
		 * 	- Load individually
		 * 	- Replace target ID's with the config'd values
		 *  - Save doc in target directory
		 *  
		 *  Saveable configs
		 *  External config
		 *  Right Click to perform
		 *  
		 */
	private static EGView view;
	
	public static void createNewFiles() {
		String EMOCNumber = view.getEmoc();
		
		//TODO Write tests for prependEmocNo,
		//Write tests for create new files
	}
	
	public static void loadView(EGView view) {
		EGController.view= view;
	}
	
	public static EGView getView() {
		return EGController.view;
	}
	

}
