package com.shiftplanning.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.shiftplanning.Pages.HomePage;
import com.shiftplanning.Pages.LoginPage;
import com.shiftplanning.Pages.DashboardPage;
import com.shiftplanning.Pages.StaffPage;

public class TC2AddingNewEmployeeChrome {
	public String baseUrl = "http://www.shiftplanning.com/";
	String driverPath = "C:\\selenium-java-prerequisite\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;

	public String newFirstName = "Peter";
	public String newLastName = "Peterson";
	public String newEmail = "peterson01@peterson01.com";

	@Test
	public void addNewEmployee() throws Exception {
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
		staffTab.clickStaff();

		// creating an object of class StaffPage (and import class)
		StaffPage staff = new StaffPage(driver);
		staff.clickaddEmployee();
		staff.typeFirstName(newFirstName);
		staff.typeLastName(newLastName);
		staff.typeEmail(newEmail);
		staff.clickOnSaveButton();

		staff.checkDisplayedName(newFirstName, newLastName);

	}

	@AfterTest
	public void clearData() throws Exception {

		// ----Deleting added new employee in order to reuse the test-----
		// Click on All Staff
		driver.findElement(By.xpath("//*[@id=\"StaffSchedules\"]/ul/li[1]/a")).click();
		
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[contains(text(),'Peter Peterson')]")).click();
		
		// Click to delete employee
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

		// Accept alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Terminate the browser
		driver.quit();

	}
}
