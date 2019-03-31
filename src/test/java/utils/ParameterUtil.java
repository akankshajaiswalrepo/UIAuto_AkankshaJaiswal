package utils;

import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * This class provide wrapper methods to read values from Json files
 */

public class ParameterUtil {

	
	public static String readConfigValue(String fileName, String configName){
		String result = "";
		try{
			File jsonFile = new File("./src/test/resources/config/" + fileName +".json" );
			result = JsonPath.read(jsonFile, "$.config." + configName );


		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return result;
		
	}
}
