package com.easybix.DDF.Tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




import com.easybix.DDF.core.TestBase;
import com.easybix.DDF.utils.TestUtil;

public class LoginTest extends TestBase{
	
	@DataProvider
	public Object[][] getLoginData() {
		return TestUtil.getTestData("LoginTest", "doLogin");
	}
	
	@Test(dataProvider = "getLoginData")
	public void doLogin(HashMap<String, String> dataMap){
		TestUtil.checkTestRunMode("LoginTest", "doLogin");
		driver.findElement(By.xpath(objectRepo.getProperty("username"))).sendKeys(dataMap.get("UserName"));
		driver.findElement(By.xpath(objectRepo.getProperty("password"))).sendKeys(dataMap.get("Password"));
		driver.findElement(By.xpath(objectRepo.getProperty("login"))).click();
		Assert.assertEquals(driver.getTitle(), dataMap.get("PageTitle"));
	}
}
