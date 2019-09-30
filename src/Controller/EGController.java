package Controller;


import view.EGView;

public class EGController {
	//Functionality to add:
		/*
		 * Select target directory
		 * data validation on confirmation
		 * confirmation: For each doc
		 * 	- Load individually
		 * 	- Replace target ID's with the Controller.config'd values
		 *  - Save doc in target directory
		 *  
		 *  Saveable configs
		 *  External Controller.config
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
