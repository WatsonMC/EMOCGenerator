package Controller;

import Model.EGModel;

public class ModelInjector {
	
	public static void injectModel(EGModel model){
		ConfirmationController.loadModel(model);
	}
}
