package com.training.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.training.utilities.CommonUtilities;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver;
	static CommonUtilities common = new CommonUtilities();

	public static WebDriver getDriver(String browserName) {
		if (driver == null) {

			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

		}
		return driver;

	}

	public static void launchApp() throws IOException {
		String url = common.getApplicationProperty("url");
		String browserName = common.getApplicationProperty("browser");
		driver = getDriver(browserName);
		driver.get(url);

	}

}
