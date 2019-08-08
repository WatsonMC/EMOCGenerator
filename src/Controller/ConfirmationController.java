package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import Model.EGModel;
import view.EGView;

public class ConfirmationController implements ActionListener{
	//Handles confirmatino button press and subsequent copy and replace actions
	private static EGView view;
	private static EGModel model;
	
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
		editDocuments(filePathes);
		System.out.println("it worked");
		
	}
	
	public void editDocuments(Map<String,String> filePathes) {
			try {
				for(String file: filePathes.values()) {
					File newFile = new File(file + ".tmp");
					File oldFile = new File(file);
					FileInputStream in = new FileInputStream(oldFile);
					FileOutputStream out = new FileOutputStream(newFile);
					XWPFDocument doc = new XWPFDocument(new FileInputStream(new File(file)));
					Map<String,String> fieldKeys = model.getFieldKeys();
					Map<String,String> fieldValues = model.getFieldValues();
					for(String key:fieldKeys.keySet()) {
						System.out.println(String.format("replacing %S with %s", fieldKeys.get(key), fieldValues.get(key)));
						TextReplacer.replaceText(doc, fieldKeys.get(key), fieldValues.get(key));
					}
					
					doc.write(out);
					doc.close();
					in.close();
					out.close();
					oldFile.delete();
					newFile.renameTo(oldFile);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	public static void loadModel(EGModel model) {
		ConfirmationController.model =  model;
	}
	
}
