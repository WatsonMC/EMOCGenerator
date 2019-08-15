package main;

import Controller.ModelInjector;
import Controller.ViewInjector;
import Model.EGModel;
import view.EGView;

public class Main {
	
	public static void main(String[] args) {

		EGModel model = new EGModel();
		EGView view = new EGView(model);
		model.loadView(view);
		ViewInjector.injectView(view);
		ModelInjector.injectModel(model);
		if(args !=null){
			view.setDirText(args[0]);
		}
		view.createAndShowGUI();
	}
}
