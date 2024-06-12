package com.training.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static com.training.utilities.Constants.USER_DIR;
import static com.training.utilities.Constants.APPLICATION_PROPERTIES;

public class CommonUtilities {

	public String getApplicationProperty(String key) throws IOException {

		String sPath = USER_DIR + File.separator + APPLICATION_PROPERTIES;
		System.out.println(sPath);
		Properties property = new Properties();
		String value = "";
		FileInputStream fileInput = new FileInputStream(sPath);

		property.load(fileInput);
		value = property.getProperty(key);
		System.out.println("value recieved" + value);
		fileInput.close();
		return value;
	}

}
