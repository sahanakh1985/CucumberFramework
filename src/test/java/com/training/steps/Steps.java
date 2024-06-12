package com.training.steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.pagefactory.PageFactory;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BaseTest {
	WebDriver driver;

	BasePage page;
	PageFactory pageFactory = new PageFactory();

	@Before
	public void setUp() throws IOException {
		launchApp();
	}

	@Given("user is on {string}")
	public void user_is_on(String pageName) {
		page = pageFactory.initialize(pageName);

	}

	@When("User enter  into textbox {string} {string}")
	public void user_enter_into_textbox(String logicalName, String value) throws InterruptedException {
		Thread.sleep(3000);
		page.enterIntoTextbox(logicalName, value);

	}

}
