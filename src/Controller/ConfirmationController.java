package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Model.EGModel;
import view.EGView;

public class ConfirmationController implements ActionListener{
	//Handles confirmatino button press and subsequent copy and replace actions
	private static EGView view;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//validate inpust
		//pull data
		String targetDir = view.getTgtDir();
		String EMOCNo = view.getEmoc();
		Map<String,String> filePathes = new HashMap<>();
		for(String filePath: EGModel.SOURCE_DOCS) {
			String newFilePath = appendFileToTgtDir(filePath, targetDir);
			filePathes.put(filePath,prependEmocNoToFilePath(newFilePath, EMOCNo));
		}
		//now we have map to pass to docCopy, and also map to pass to edit
		DocCopy.copyDocs(filePathes);
		//now files should be copied to new dir
		System.out.println("it worked");
	}
	
	public static String appendFileToTgtDir(String sourceFileAbsPath, String tgtDir) {
		String fileName = sourceFileAbsPath.split("\\\\")[sourceFileAbsPath.split("\\\\").length-1];
		
		return tgtDir+"\\"+fileName;
	}
	
	
	public static String prependEmocNoToFilePath(String oldPath, String EMOC) {
		String[] files = oldPath.split("\\\\");
		System.out.println(Arrays.deepToString(files));
		files[files.length-1] =EMOC + " " + files[files.length-1];
		return String.join("\\", files);
	}
	
	public static void loadView(EGView view) {
		ConfirmationController.view = view;
	}
	
}
