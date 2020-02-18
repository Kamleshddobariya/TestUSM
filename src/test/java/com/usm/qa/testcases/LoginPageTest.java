package com.usm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.usm.qa.base.TestBase;
import com.usm.qa.pages.HomePage;
import com.usm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	// call super class constructor - from Base class
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
	initialization(); 	// initialize property 
	loginPage = new LoginPage();
	}
	
	
	@Test(priority=1) 
	public void loginPageTitleTest() throws InterruptedException { 
		Thread.sleep(3000);
		String title = loginPage.validateLoginPageTile(); 
		System.out.println(title);
		Assert.assertEquals(title, "Login");
	}
	  
	@Test(priority=2) 
	public void VerifySarinelogo() { 
		boolean flag = loginPage.validateSarineLogo();
		Assert.assertTrue(flag); 
		System.out.println(flag);
	}
	  
	@Test(priority=3) 
	public void loginTest() { 
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  
	  try { 
		  if (loginPage.validateAfterLoginPageTitle().equals("USM")) {
			  System.out.println("Login Pass"); 
	  } else { 
		  	  System.out.println("Login Fail");
	  		 } 
		  }catch(Exception e) { 
			  System.out.println(e); 
			 } 
	}
	
	@Test(priority=4)
	public void loginTestBoolean() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean flag = loginPage.VerifyUSMTitle();
		System.out.println(flag);
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
