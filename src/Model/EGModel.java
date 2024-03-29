package Model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.config.Config;
import view.EGView;

public class EGModel {
	private static final String DEFAULT_NAME= "Malcolm Watson";
	private static final String DEFAULT_DATE = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	private static final String DEFAULT_WORK_AREA = "Asimov";
	public static final String FP_APPLICATION = "C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\EMOC Application form.docx";

	//Docs to copy accorss
//	public static final List<String> SOURCE_DOCS = Arrays.asList(new String[]{
//			"C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\EMOC Application Form.docx",
//			"C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\Document Template.docx",
//			"C:\\Users\\sp194e\\Documents\\Programs\\JAVA\\EMOCGenerator\\Ext\\Hazard Checklist.docx"
//	});
	public Map<String,String> TEMPLATE_PATHES = new HashMap<>();

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
		loadConfigTemplatePathes();
		loadConfigFields();

	}

	public void updateFields(){
		view.updateView();
	}

	public void updateTemplatePathes(){
		this.loadConfigTemplatePathes();
	}

	private void loadConfigFields(){
		for(String key: FIELD_DATA.keySet()){
			if(Config.getProperty(key)!= null){
				FIELD_DATA.put(key, Config.getProperty(key));
			}
		}
	}

	private void loadConfigTemplatePathes(){
		TEMPLATE_PATHES.put("hazardsChecklistFP",Config.getProperty("hazardsChecklistFP"));
		TEMPLATE_PATHES.put("applicationFormFP",Config.getProperty("applicationFormFP"));
		TEMPLATE_PATHES.put("supportingDocsFP",Config.getProperty("supportingDocsFP"));
	}

	public void setProperty(String key, String value){
		if(FIELD_DATA.get(key) != null){
			FIELD_DATA.put(key,value);
		}
		else{
			System.out.println(String.format("Failed to load property: %s, %s", key, value));
		}
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
	public  String getEmoc() {
		return FIELD_DATA.get("emoc");
	}
	public  void setEmoc(String emoc) {
		FIELD_DATA.put("emoc",emoc);
	}
	
	public Map<String,String> getFieldKeys(){
		return new HashMap<String,String>(this.FIELD_KEYS);
	}
	
	public Map<String,String> getFieldValues(){
		return new HashMap<String,String>(this.FIELD_DATA);
	}

	public Map<String,String> getTemplates(){
		loadConfigTemplatePathes();
		return new HashMap<>(this.TEMPLATE_PATHES);
	}

}
