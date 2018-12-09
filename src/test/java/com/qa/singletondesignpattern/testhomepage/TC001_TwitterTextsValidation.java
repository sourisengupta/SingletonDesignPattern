package com.qa.singletondesignpattern.testhomepage;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.singletondesignpattern.testbase.TestBase;

public class TC001_TwitterTextsValidation extends TestBase{
	@BeforeTest
	public void launchTwiter() {
		initApplication();
	}
	@AfterTest
	public void tearDown() {
		closeApplication();
	}
	@Test
	public void tc001_TwitterTextsValidation() {
		driver.get("https://twitter.com/?lang=en");
		driver.manage().window().fullscreen();
		//driver.manage().window().maximize();
		String followInterest = driver.findElement(By.xpath("//div[@class='StaticLoggedOutHomePage-communicationContent']/div[1]")).getText();
		String peopleTalking = driver.findElement(By.xpath("//div[@class='StaticLoggedOutHomePage-communicationContent']/div[2]")).getText();
		String joinConv = driver.findElement(By.xpath("//div[@class='StaticLoggedOutHomePage-communicationContent']/div[3]")).getText();
		
		assertTrue(followInterest.contains("Follow your interests"));
		assertTrue(peopleTalking.contains("Hear what people are talking about"));
		assertTrue(joinConv.contains("Join the conversation"));
	}
}
