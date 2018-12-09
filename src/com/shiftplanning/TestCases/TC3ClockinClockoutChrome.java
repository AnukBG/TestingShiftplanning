package com.shiftplanning.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.shiftplanning.Pages.HomePage;
import com.shiftplanning.Pages.LoginPage;
import com.shiftplanning.Pages.DashboardPage;
import com.shiftplanning.Pages.TimeClockPage;

public class TC3ClockinClockoutChrome {
	public String baseUrl = "http://www.shiftplanning.com/";
	String driverPath = "C:\\selenium-java-prerequisite\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;

	@Test
	public void checkClockinClockout() throws Exception {
		System.out.println("Launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);

		// creating an object of class HomePage (and import class)
		HomePage loginTab = new HomePage(driver);
		loginTab.clickOnLogInTab();

		// creating an object of class LoginPage (and import class)
		LoginPage login = new LoginPage(driver);
		login.typeUserEmail("annamutavdzic@gmail.com");
		login.typePassword("testing122018");
		login.clickOnLogInButton();

		// creating an object of class DashboardPage (and import class)
		DashboardPage staffTab = new DashboardPage(driver);
		staffTab.clickTimeClock();

		// creating an object of class TimeClockPage (and import class)
		TimeClockPage clock = new TimeClockPage(driver);
		clock.clickClockIn();
		clock.clickClockOut();

	}

	@AfterTest
	public void terminateBrowser() {

		// Terminate the browser
		driver.quit();

	}
}
