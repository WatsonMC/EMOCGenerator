package main;

import Controller.ViewInjector;
import Model.EGModel;
import view.EGView;

public class Main {
	
	public static void main(String[] args) {
		EGModel model = new EGModel();
		EGView view = new EGView(model);
		model.loadView(view);
		ViewInjector.injectView(view);
		view.createAndShowGUI();
	}
}
