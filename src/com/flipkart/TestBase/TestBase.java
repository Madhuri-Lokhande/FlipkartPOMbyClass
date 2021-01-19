package com.flipkart.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public static WebDriver driver;
	public Properties prop;

	public TestBase() throws IOException {

		FileInputStream ip = new FileInputStream(
				"D:\\Software Testing Hands On\\Automation Programs\\First Attempt towards POM\\src\\com\\flipkart\\config\\config.properties");
		prop = new Properties();
		prop.load(ip);
		

		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome-file-path"));
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox_file_path"));
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
