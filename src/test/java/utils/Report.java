package utils;

import java.io.File;
public class Report {

	public static String extentConfigPath;

	public static void init(){
		extentConfigPath = System.getProperty("user.dir")+"/src/test/resources/config/extent-config.xml";
	}
	
	
}
