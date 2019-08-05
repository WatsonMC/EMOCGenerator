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
	public static final List<String> SOURCE_DOCS = Arrays.asList(new String[]{
			"C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\EMOC Application form.docx",
			"C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\Document Template.docx",
			"C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\Document Template.docx"
	});
	
	public static void createNewFiles() {
		String EMOCNumber = EGView.getEmoc();
		
		//TODO Write tests for prependEmocNo,
		//Write tests for create new files
		//
		
	}
	
	public static String prependEmocNoToFilePath(String oldPath, String EMOC) {
		String[] files = oldPath.split("\\\\");
		String newPath;
		files[files.length-1] =EMOC + " " + files[files.length-1];
		return String.join("\\\\", files);
	}
}
