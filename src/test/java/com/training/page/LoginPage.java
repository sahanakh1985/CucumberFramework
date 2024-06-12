package com.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.base.BasePage;
import com.training.base.BaseTest;

public class LoginPage extends BasePage {
	static WebDriver driver;

	public LoginPage() {
		super(driver = BaseTest.getDriver("browser"));
		
		addObject("Username", By.xpath("//input[@id='username']"));
		addObject("Password", By.xpath("//input[@id='password']"));
		addObject("RememberMe", By.id("rememberUn"));
	}

}
