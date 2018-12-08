package com.shiftplanning.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

//This class will store all the locators and methods of Staff page
public class StaffPage {

	WebDriver driver;

	By addEmployee = By.id("act_primary");
	By fname = By.id("_asf1");
	By lname = By.id("_asl1");
	By email = By.id("_ase1");
	By saveButton = By.id("_as_save_multiple");
	By nameDisplayed = By.xpath(
			"/html/body/table/tbody/tr/td/div[9]/div[5]/div[3]/table/tbody/tr/td[2]/div[2]/div/table/tbody/tr[5]/td[1]");

	// Building a constructor to initialize web driver ( chrome, ie, ff)
	public StaffPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickaddEmployee() {
		driver.findElement(addEmployee).click();
	}

	public void typeFirstName(String firstn) {
		driver.findElement(fname).clear();
		driver.findElement(fname).sendKeys(firstn);
	}

	public void typeLastName(String lastn) {
		driver.findElement(lname).clear();
		driver.findElement(lname).sendKeys(lastn);
	}

	public void typeEmail(String eml) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(eml);
	}

	public void clickOnSaveButton() {
		driver.findElement(saveButton).click();
	}

	public void checkDisplayedName(String fn, String ln) {

		// Check if Name displayed in table matches our input
		String NameDisplayed = driver.findElement(nameDisplayed).getText();
		String NameExpected = fn + " " + ln;
		Assert.assertTrue(NameDisplayed.contains(NameExpected),
				"The new entered employee do not match with displayed name!");
		System.out.println("New employee is added successfully, and his name is " + NameExpected);
	}
}
