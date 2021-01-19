package com.flipkart.Test;


import java.io.IOException;

import org.junit.Ignore;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.TestBase.TestBase;
import com.flipkart.pages.LoginPage;
import com.flipkart.utilities.CapturingScreenShot;
import com.flipkart.utilities.ReadingExcel;

public class LoginPageTest extends TestBase{


	public LoginPageTest() throws IOException {
	
	}

	LoginPage lp;

	@Test(dataProvider = "sendData", priority=0)
	public void LoginTest(String userName, String password) throws IOException {
		lp = new LoginPage();
		lp.loginwithUserNmAndPawd(userName, password);
	}

	@DataProvider
	public Object[][] sendData() throws IOException {
		return(ReadingExcel.readData("LoginData"));
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {

		String title = lp.loginSuccessfullValidation();
		Assert.assertEquals(title,
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}

	
	
	/*
	 * @Ignore public void tearDown(ITestResult result) throws IOException {
	 * //System.out.println("****************" +result.getStatus());
	 * if(result.getStatus()==2) { CapturingScreenShot.takePhoto(TestBase.driver,
	 * result.getName()); } }
	 */
	

}
