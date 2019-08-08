package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class DocCopy {
	
	/**
	 * Copies files from key location to value location
	 * @param filePathes - map of {Key:value = fileToCopy:locationToCopyTo}
	 * 
	 */
	public static void copyDocs(Map<String, String> filePathes) {
		try {
			for(String filePath: filePathes.keySet()) {
				FileUtils.copyFile(new File(filePath), new File(filePathes.get(filePath)));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error copying docs accross, return false");
		}
	}
	
}
