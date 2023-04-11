package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataReader {

	private static Properties property;
	static {
		try {
			File file = new File("./src/resources/variables.properties");
			FileInputStream input = new FileInputStream(file);
			//creating obj. and instantiate it.
			property = new Properties();
			//coming from property class , nust loading that file(input)
			property.load(input);
			input.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//new method return a String just one String key, returns the value for that key.
public static String getProperty(String key) {
	return property.getProperty(key);
}
}