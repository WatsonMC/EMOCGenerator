package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import Model.EGModel;

public class TextReplacer {
	
	public static void main(String[] args) {
		
		try {
			FileInputStream inStream = new FileInputStream(new File(EGModel.FP_APPLICATION));
			
			XWPFDocument doc = new XWPFDocument(inStream);
			replaceText(doc, "THISIsATEST", "THIS WORKED!");
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean replaceText(XWPFDocument doc, String searchText, String replaceText) {
		
		for(XWPFTable table: doc.getTables()) {
			for(XWPFTableRow row: table.getRows()) {
				processTableRow(row,searchText,replaceText);
			}
		}
		for(XWPFParagraph para: doc.getParagraphs()) {
			for(XWPFRun run: para.getRuns()) {
				processRun(run, searchText, replaceText);
			}
		}
		return true;
	}
	
	private static boolean processTableRow(XWPFTableRow row, String searchText, String replaceText) {
		for(XWPFTableCell cell: row.getTableCells()) {
//			System.out.println(cell.getText());
		
			for(XWPFParagraph para:cell.getParagraphs()) {
				for(XWPFRun run: para.getRuns()) {
					processRun(run, searchText, replaceText);
					System.out.println(run.getText(0));
				}
			}
		}
		return false;
	}
	
	private static boolean processRun(XWPFRun run, String searchText, String replaceText) {
		if(run.getText(0) != null && run.getText(0).contains(searchText)) {
			run.setText(run.getText(0).replace(searchText,replaceText),0);
			return true;
		}
		return false;
	}
	
}	
