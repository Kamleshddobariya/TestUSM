package com.usm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.usm.qa.base.TestBase;
import com.usm.qa.pages.ArchivePage;
import com.usm.qa.pages.HomePage;
import com.usm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ArchivePage archivePage;
	
	// call super class constructor - from Base class
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser 
	
	@BeforeMethod
	public void setUp() {
	initialization(); 	// initialize property 
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	archivePage = new ArchivePage();
	}
	
	
	@Test(priority=1) 
	public void verifyHomePageTitle() { 
		String homePageTitle = homePage.validateAfterLoginPageTitle();
		Assert.assertEquals(homePageTitle, "USM", "Home Page title not matched");
		System.out.println(homePageTitle);
	}
	
	@Test(priority=2)
	public void verifyuserName() {
		String userName = homePage.validateuserNameLabel();
		System.out.println("user is: " + userName);
		Assert.assertEquals(userName, "India_Profile_QA2", "User not matached");
		
		try { 
			if (homePage.validateuserNameLabel().equals("India_Profile_QA2")) {
				  System.out.println("Test Pass"); 
			} else { 
			  	  System.out.println("Test Fail");
		  		   } 
		} catch(Exception e) { 
				System.out.println(e); 
			} 
	}
	
	@Test(priority=3)
	public void verifyuserNameDisplay( ) {
		boolean flag = homePage.verifyuserNameDisplay();
		System.out.println(flag);
		//Assert.assertTrue(homePage.verifyuserNameDisplay());
	}
	
	@Test(priority=4) 
	public void verifyarchivePageTitle() throws InterruptedException { 
		homePage.clickOnArchivePage();
		String archivePageTitle = archivePage.validateArchivePageTitle();
		Assert.assertEquals(archivePageTitle, "ARCHIVE", "Archive Page title not matched");
		System.out.println(archivePageTitle);
	}
	
	@AfterMethod
	public void tearDown( ) {
		driver.quit();
	}
	
}
