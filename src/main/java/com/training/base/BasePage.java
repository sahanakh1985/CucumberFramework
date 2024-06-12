package com.training.base;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	public HashMap<String, By> objRep = new HashMap<String, By>();

	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	public void addObject(String logicalName, By by) {
		objRep.put(logicalName, by);
	}

	public void enterIntoTextbox(String logicalName, String value) {
		WebElement element = getWebElement(logicalName);

		enterIntoTextbox(element, value);

	}

	private void enterIntoTextbox(WebElement element, String value) {
		waitForElement(element);
		element.sendKeys(value);
	}

	private void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	private WebElement getWebElement(String logicalName) {
		WebElement element = null;
		By by = null;
		by = objRep.get(logicalName);
		element = driver.findElement(by);

		return element;
	}

}
