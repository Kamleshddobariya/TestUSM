package com.usm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.usm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'India_Profile_QA2')]")
	public WebElement userNameLabel;
	
	@FindBy(xpath = "//button[@class='logout-button btn btn-sm btn-inverse']")
	public WebElement logOut;
	
	@FindBy(linkText = "STONES")
	public WebElement verifyMe;
	
	@FindBy(xpath = "//button[contains(text(),'New')]")
	public WebElement NewStone;
	
	//@FindBy(xpath = "//a[@class='nav-link']")
	@FindBy(linkText = "ARCHIVE")
	public WebElement archivePage;
	
	@FindBy(xpath = "//a[@class='btn-link label label-blue clickable']")
	public WebElement dateFrom;
	
	@FindBy(xpath = "//button[@class='btn btn-sm btn-secondary'][4]")
	public WebElement searchAll;
	
	@FindBy(id = "search-box")
	public WebElement searchBox;
	
	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	public WebElement searchValue;
	
//=============================================================================//
	
	//current class object - initialize Elements with the help of Page Factory 
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
		
	//Different Actions for the page:
	//1. verify page title after login
	public String validateAfterLoginPageTitle() {
		return driver.getTitle();
	}
	
	//2. verify login userName Label
	public String validateuserNameLabel() {
		return userNameLabel.getText();
			
	}
	
	public boolean verifyuserNameDisplay() {
		return userNameLabel.isDisplayed();
			
	}
	
	//3. verify Archive Page 
	public ArchivePage clickOnArchivePage() {
		archivePage.click();
		return new ArchivePage();
	}
	
}
