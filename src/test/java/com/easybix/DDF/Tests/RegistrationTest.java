package com.easybix.DDF.Tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.easybix.DDF.core.TestBase;
import com.easybix.DDF.utils.TestUtil;

public class RegistrationTest extends TestBase{
	
	@DataProvider
	public Object[][] getRegistrationData() {
		return TestUtil.getTestData("RegistrationTest", "doRegistration");
	}
	
	@DataProvider
	public Object[][] getRegistrationCopyData() {
		return TestUtil.getTestData("RegistrationTest", "doRegistrationCopy");
	}
	

	@Test(dataProvider = "getRegistrationData")
	public void doRegistration(HashMap<String, String> dataMap) throws InterruptedException{
		TestUtil.checkTestRunMode("RegistrationTest", "doRegistration");
		driver.findElement(By.xpath(objectRepo.getProperty("firstnameTxt"))).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.xpath(objectRepo.getProperty("lastnameTxt"))).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.xpath(objectRepo.getProperty("emailtxt"))).sendKeys(dataMap.get("email"));
		driver.findElement(By.xpath(objectRepo.getProperty("confirmpasswordTxt"))).sendKeys(dataMap.get("confirmpassword"));
	
		Thread.sleep(3000);
	}
	
	@Test(dataProvider = "getRegistrationCopyData")
	public void doRegistrationCopy(HashMap<String, String> dataMap) throws InterruptedException{
		TestUtil.checkTestRunMode("RegistrationTest", "doRegistrationCopy");
		driver.findElement(By.xpath(objectRepo.getProperty("firstnameTxt"))).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.xpath(objectRepo.getProperty("lastnameTxt"))).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.xpath(objectRepo.getProperty("emailtxt"))).sendKeys(dataMap.get("email"));
		driver.findElement(By.xpath(objectRepo.getProperty("confirmpasswordTxt"))).sendKeys(dataMap.get("confirmpassword"));
		
		Thread.sleep(3000);
	}
}
