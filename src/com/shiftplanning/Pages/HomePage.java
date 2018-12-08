package com.shiftplanning.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This class will store all the locators and methods of Home page
public class HomePage {

	WebDriver driver;

	By loginTab = By.className("login-button");

	// Building a constructor to initialize web driver ( chrome, ie, ff)
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLogInTab() {
		driver.findElement(loginTab).click();
	}
}
