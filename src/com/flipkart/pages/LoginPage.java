package com.flipkart.pages;

import java.io.IOException;
import org.openqa.selenium.By;

import com.flipkart.TestBase.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {

	}

	public void loginwithUserNmAndPawd(String uname, String passwd) {

		driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys(uname);

		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(passwd);

		driver.findElement(By.xpath(prop.getProperty("loginButton"))).click();
	}

	//Check Title
	public String loginSuccessfullValidation() {

		return driver.getTitle();

	}

	//Check if username is present after Login
	public boolean isLinkPresent(String xpathkey) {
		try {
			driver.findElement(By.xpath(prop.getProperty(xpathkey)));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
