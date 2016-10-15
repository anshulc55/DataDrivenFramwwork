package com.easybix.DDF.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.easybix.DDF.utils.Contants;

public class TestBase {

	/*
	 * Initialize properties, initialize XLS, ini browser, close browser, Ini
	 * Logging
	 */

	public static Properties config = new Properties();
	public static Properties objectRepo = new Properties();
	public static WebDriver driver = null;
	public static Logger App_logs = Logger.getLogger("rootLogger");

	@BeforeMethod
	public void init() throws IOException {

		// Initialize cofig
		FileInputStream fisConfig = new FileInputStream(Contants.CONFIG_PROP_FILE);
		config.load(fisConfig);
		String browserName = config.getProperty("browser");
		App_logs.info("Browser invoked : " + browserName );

		// initialize Object properties
		FileInputStream fisobject = new FileInputStream(Contants.Object_PROP_FILE);
		objectRepo.load(fisobject);

		//Initialize Browser
		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",Contants.FIREFOX_DRIVER);
			driver = new FirefoxDriver();
			App_logs.debug("Browser invoke : Firefox" );
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",Contants.CHROME_DRIVER);
			driver = new ChromeDriver();
			App_logs.debug("Browser invoke : Chrome" );
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",Contants.IE_DRIVER);
			driver = new InternetExplorerDriver();
			App_logs.debug("Browser invoke : IE" );
		}else {
			System.setProperty("webdriver.gecko.driver",Contants.FIREFOX_DRIVER);
			driver = new FirefoxDriver();
			App_logs.debug("Browser invoke : Firefox" );
		}
		
		
		driver.get(config.getProperty("testSite"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
