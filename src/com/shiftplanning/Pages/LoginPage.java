package com.shiftplanning.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//This class will store all the locators and methods of Login page
public class LoginPage {

	WebDriver driver;

	By useremail = By.id("email");
	By password = By.id("password");
	By loginButton = By.xpath("//button[contains(text(),'Log in')]");

	// Building a constructor to initialize web driver ( chrome, ie, ff)
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeUserEmail(String usemail) {
		driver.findElement(useremail).clear();
		driver.findElement(useremail).sendKeys(usemail);
	}

	public void typePassword(String uspass) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(uspass);
	}

	public void clickOnLogInButton() {
		driver.findElement(loginButton).click();
	}

	public void checkCredentials() {
		boolean avatar = driver.findElement(By.id("tr_avatar")).isDisplayed();
		Assert.assertTrue(avatar, "The test failed and login was not successful");
		System.out.println("The test passed and the login was successful");
	}
}
