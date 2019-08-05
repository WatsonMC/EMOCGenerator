package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EGModel {
	private static String name = "Malcolm Watson";
	private static String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	
	
	
	
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		EGModel.name = name;
	}
	public static String getDate() {
		return date;
	}
	public static void setDate(String date) {
		EGModel.date = date;
	}
	public static String getWA() {
		return WA;
	}
	public static void setWA(String wA) {
		WA = wA;
	}
	private static String WA = "Asimov";
}
