package com.framework.utlis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
	public static Properties readData(String filename) throws IOException {
		Properties prop = null;
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Config"+filename);
		prop = new Properties();
		prop.load(fis);
		return prop	;
	}

}
