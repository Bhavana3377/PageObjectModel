package Pages;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Browser.utility;
import Locators.page1Objects;
import ScreenShot.capture;

public class page1 extends browser{
	//Method for getting the actual title
	public static String Title() throws Exception
	{
		extent.attachReporter(reporter);
		logger1 = extent.createTest("ScreenShot");
		logger1.log(Status.INFO, "ScreenShot");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(logger));
		logger1.addScreenCaptureFromPath(capture.screenShot("title"));
		extent.flush();
		return driver.getTitle();
	}
	//Entering user name method
	public static void enterusername(String str) 
	{
		try 
		{	extent.attachReporter(reporter);
			logger1 = extent.createTest("Username");
			logger1.log(Status.INFO, " username sent");
			page1Objects.username().sendKeys(str);
			logger1.log(Status.PASS,"UserName enteted successfully");
		}
		catch(Exception E)
		{
			logger1.log(Status.FAIL,"failed to enter username ");
			System.out.println("Username :"+E);
		}
		extent.flush();
	}
	//Entering password method
		public static void enterpassword(String str) 
		{
			try
			{
				extent.attachReporter(reporter);
				logger1 = extent.createTest("Password");
				logger1.log(Status.INFO, " Password sent");
				page1Objects.password().sendKeys(str);
				logger1.log(Status.PASS,"Password enteted successfully");
			}
			catch(Exception E)
			{
				logger1.log(Status.FAIL,"failed to enter Password ");
				System.out.println("Password :"+E);
			}
			extent.flush();
		}
	//clicking method
	public static void click() 
	{
		try
		{
			extent.attachReporter(reporter);
			logger1 = extent.createTest("Click");
			logger1.log(Status.INFO, " Clicked");
			page1Objects.login().click();
			logger1.log(Status.PASS,"Clicked successfully");
		}
		catch(Exception E)
		{
			logger1.log(Status.FAIL,"failed Clicking");
			System.out.println("Click :"+E);
		}
		extent.flush();
	}
}
