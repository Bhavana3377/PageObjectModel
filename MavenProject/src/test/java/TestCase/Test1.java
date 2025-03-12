package TestCase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Browser.browser;
import Locators.page2Objects;
import Pages.page1;
import Pages.page2;
import ScreenShot.capture;

public class Test1 {

	@BeforeMethod
	public void openbrowser() throws Exception
	{
		browser.init("testReport1");
		browser.openBrowser();
		browser.navigateToUrl();
		
	}
	
	@DataProvider(name="title")
	public Object[] data()
	{
		Object[] obj= {"OrangeHRM"};
		return obj;
	}
	
	@Test(priority=1 ,dataProvider = "title")
	public void TestTitle(String title) throws Exception 
	{
		Assert.assertEquals(page1.Title(), title);
		//capture.screenShot("title");
		Reporter.log("Screenshot taken by name title");
	}
	
	@AfterMethod
	public void closebrowser()
	{
		browser.closeBrowser();
	}

}
