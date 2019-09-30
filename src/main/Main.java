package main;

import Controller.ModelInjector;
import Controller.ViewInjector;
import Controller.config.Config;
import Model.EGModel;
import view.EGView;

import javax.naming.ConfigurationException;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		if(args.length ==1 && args[0].equals("#INIT")){
			//Initialize key found, run initialize
			System.out.println("Initialization called");
			try{
				Config.intialize();
			}
			catch(IOException ioe){
				System.out.println("No config file found in program files to copy");
			}
			catch(ConfigurationException cfe){
				System.out.println("Config file exists already, no new config will be set");
			}
			System.exit(0);
		}

		System.out.println("testing ");
		EGModel model = new EGModel();
		EGView view = new EGView(model);
		model.loadView(view);
		ViewInjector.injectView(view);
		ModelInjector.injectModel(model);
		if(args.length !=0){
			view.setDirText(args[0]);
		}
		view.createAndShowGUI();
	}
}
