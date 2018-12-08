package com.shiftplanning.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This class will store all the locators and methods of Time Clock page
public class TimeClockPage {

	WebDriver driver;

	By clockIn = By.id("tc_tl_ci");
	By clockOut = By.id("tc_tl_co");

	// Building a constructor to initialize web driver ( chrome, ie, ff)
	public TimeClockPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickClockIn() {
		driver.findElement(clockIn).click();
	}

	public void clickClockOut() {
		driver.findElement(clockOut).click();
	}
}
