package com.shiftplanning.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This class will store all the locators and methods of Dashboard page
public class DashboardPage {

	WebDriver driver;

	By staff = By.id("sn_staff");
	By timeclock = By.id("sn_timeclock");

	// Building a constructor to initialize web driver ( chrome, ie, ff)
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickStaff() {
		driver.findElement(staff).click();
	}

	public void clickTimeClock() {
		driver.findElement(timeclock).click();
	}
}
