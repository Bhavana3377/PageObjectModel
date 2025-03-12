package TestCase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Browser.browser;
import Locators.page2Objects;
import Pages.page1;
import Pages.page2;
import ScreenShot.capture;

public class Test3 {
	
	@BeforeMethod
	public void openbrowser() throws Exception
	{
		browser.init("testReport3");
		browser.openBrowser();
		browser.navigateToUrl();
		
	}
		
	@Test
	public void TestMenu()
	{
		page1.enterusername("Admin");
		page1.enterpassword("admin123");
		page1.click();
		page2.optionclick("leave");
		Assert.assertEquals(page2Objects.menuName().getText(),"Leave");
	}
	
	@AfterMethod
	public void closebrowser()
	{
		browser.closeBrowser();
	}


}
