package Controller;

import view.EGView;

public class ViewInjector {
	/**
	 * Helper class to inject the view object into the controllers
	 */
	
	public static void injectView(EGView view){
		ConfirmationController.loadView(view);
		EGController.loadView(view);
		TargetDirController.loadView(view);
	}
	
}
