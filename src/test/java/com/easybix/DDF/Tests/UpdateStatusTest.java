package com.easybix.DDF.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.easybix.DDF.core.TestBase;

public class UpdateStatusTest extends TestBase{
	
	@Test
	public void doStatusUpdate(){
		driver.findElement(By.xpath(objectRepo.getProperty("username"))).sendKeys("yuvikasharma@opages.com");
		driver.findElement(By.xpath(objectRepo.getProperty("password"))).sendKeys("yuvikasharma");
		driver.findElement(By.xpath(objectRepo.getProperty("login"))).click();
		
		driver.findElement(By.xpath(objectRepo.getProperty("home"))).click();
		
		driver.findElement(By.xpath(objectRepo.getProperty("postUpdate"))).click();
		driver.findElement(By.xpath(objectRepo.getProperty("postUpdateEditor"))).sendKeys("पाकिस्तानी दोस्त के घर से लौटे शख्स ने सुनाया वहां का हाल, पढ़ें क्या कहा ?");
		driver.findElement(By.xpath(objectRepo.getProperty("postBtn"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
