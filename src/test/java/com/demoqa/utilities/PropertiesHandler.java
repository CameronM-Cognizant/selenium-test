package com.demoqa.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
	static Properties config = new Properties();
	public static String fs = System.getProperty("file.separator");
	public static String userDir = System.getProperty("user.dir");
	public static String testResources = userDir + fs + "src" + fs + "test" + fs + "resources" + fs + "config.properties";

	public PropertiesHandler() {
		try {
			FileInputStream fis = new FileInputStream(testResources);
			config.load(fis);

		}
		catch (IOException e) {
			System.out.println("Problem reading config.properties");
		}
	}
	public String getProperty(String key) {
		return config.getProperty(key);
	}
}