package com.appdragon.newtours.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appdragon.newtours.utils.PageUrl;
import com.appdragon.newtours.utils.XpathLocator;

public class LoginTest {

	WebDriver driver;
	@BeforeClass
	public void BrwoserOpen()
	{
		System.setProperty("webdriver.gecko.driver","E://geckodriver-v0.11.1-win64/wires.exe");
	
		 driver=new FirefoxDriver();
		driver.get(PageUrl.pageurl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login()
	{
		
		driver.findElement(By.xpath(XpathLocator.LoginPage.username)).sendKeys("demo");
		driver.findElement(By.xpath(XpathLocator.LoginPage.password)).sendKeys("demo");
		driver.findElement(By.xpath(XpathLocator.LoginPage.signin)).click();
		
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
				
		driver.findElement(By.xpath(XpathLocator.flightFind.typebutton)).click();
		new Select (driver.findElement(By.xpath(XpathLocator.flightFind.passengersdropdown))).selectByVisibleText("4");
		new Select (driver.findElement(By.xpath(XpathLocator.flightFind.departingDropDown))).selectByVisibleText("Paris");
		new Select (driver.findElement(By.xpath(XpathLocator.flightFind.ondropMonth))).selectByVisibleText("November");
		new Select (driver.findElement(By.xpath(XpathLocator.flightFind.ondropDay))).selectByVisibleText("25");
		new Select (driver.findElement(By.xpath(XpathLocator.flightFind.arrivingindrop))).selectByVisibleText("Sydney");
		new Select (driver.findElement(By.xpath(XpathLocator.flightFind.returningdropMonth))).selectByVisibleText("December");
		new Select (driver.findElement(By.xpath(XpathLocator.flightFind.returningdropDay))).selectByVisibleText("25");
		driver.findElement(By.xpath(XpathLocator.flightFind.serviceclassButton)).click();
		new Select (driver.findElement(By.xpath(XpathLocator.flightFind.airlinedrop))).selectByVisibleText("Unified Airlines");
		driver.findElement(By.xpath(XpathLocator.flightFind.continuesignin)).click();
		
		
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		
	}
}
