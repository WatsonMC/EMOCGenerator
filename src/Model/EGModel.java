package Model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import view.EGView;

public class EGModel {
	private static final String DEFAULT_NAME= "Malcolm Watson";
	private static final String DEFAULT_DATE = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	private static final String DEFAULT_WORK_AREA = "Asimov";
	public static final String FP_APPLICATION = "C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\EMOC Application form.docx";

	//Docs to copy accorss
	public static final List<String> SOURCE_DOCS = Arrays.asList(new String[]{
			"C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\EMOC Application Form.docx",
			"C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\Document Template.docx",
			"C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\Hazard Checklist.docx"
	});
	
	private Map<String,String> FIELD_DATA;          
	public void initData() {
		Map<String,String> tempMap = new HashMap<>();
		tempMap.put("name",DEFAULT_NAME);
		tempMap.put("emoc","");
		tempMap.put("date",DEFAULT_DATE);
		tempMap.put("workArea",DEFAULT_WORK_AREA);
		FIELD_DATA = tempMap;
	}
	
	private Map<String,String> FIELD_KEYS;          
	public void initKeys() {
		Map<String,String> tempMap = new HashMap<>();
		tempMap.put("name","$#%@1");
		tempMap.put("emoc","$#%@2");
		tempMap.put("date","$#%@3");
		tempMap.put("workArea","$#%@4");
		this.FIELD_KEYS = tempMap;
	}
	
	private  EGView view;
	
	public EGModel(){
		initKeys();
		initData();
	}
	
	public void loadView(EGView view) {
		this.view = view;
	}
	
	public  String getName() {
		return FIELD_DATA.get("name");
	}
	public  void setName(String name) {
		FIELD_DATA.put("name",name);
	}
	public  String getDate() {
		return FIELD_DATA.get("date");
	}
	public  void setDate(String date) {
		FIELD_DATA.put("date",date);
	}
	public  String getWA() {
		return FIELD_DATA.get("workArea");
	}
	public  void setWA(String workArea) {
		FIELD_DATA.put("workArea",workArea);
	}

}
