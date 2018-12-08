package com.shiftplanning.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.shiftplanning.Pages.HomePage;
import com.shiftplanning.Pages.LoginPage;

public class TC1LoginChrome {
	public String baseUrl = "http://www.shiftplanning.com/";
	String driverPath = "C:\\selenium-java-prerequisite\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;

	@Test(dataProvider = "loginData")
	public void verifyLoginCredentials(String userE, String pass) throws Exception {
		System.out.println("Launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		// creating an object of class HomePage (and import class)
		HomePage loginTab=new HomePage(driver);
		loginTab.clickOnLogInTab();
		
		// creating an object of class LoginPage (and import class)
		LoginPage login = new LoginPage(driver);
		
		login.typeUserEmail(userE); 
		login.typePassword(pass);
		login.clickOnLogInButton();
		login.checkCredentials();
	}

	@AfterMethod
	public void terminateBrowser() {
		driver.quit();
	}
	
	@DataProvider(name = "loginData")
	public Object[][] passLoginData() {
		
		Object[][] data = new Object[3][2];

		// Negative TC: valid user email, invalid password
		data[0][0] = "annamutavdzic@gmail.com";
		data[0][1] = "test";
		
		// positive TC : correct credentials
		data[1][0] = "annamutavdzic@gmail.com";
		data[1][1] = "testing122018";

		// Negative TC: invalid user email, valid password
		data[0][0] = "annnna@gmail.com";
		data[2][1] = "testing122018";

		return data;
	}
}
