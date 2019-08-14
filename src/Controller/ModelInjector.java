package Controller;

import Model.EGModel;
import view.ConfigDialog;

public class ModelInjector {
	
	public static void injectModel(EGModel model){

		ConfirmationController.loadModel(model);
		ConfigDialog.loadModel(model);
	}
}
