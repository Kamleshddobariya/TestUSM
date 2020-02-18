package com.usm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.usm.qa.base.TestBase;

public class ArchivePage extends TestBase{
	
	//@FindBy(xpath = "//a[@class='nav-link']")
	@FindBy(linkText = "ARCHIVE")
	public WebElement archivePage;

	//current class object - initialize Elements with the help of Page Factory 
	public ArchivePage(){
		PageFactory.initElements(driver, this);
	}
			
	//Different Actions for the page:	
	//1. verify Archive Page Title
	public String validateArchivePageTitle() {
		return archivePage.getText();
	}
	
}
