package TestCaseDemo;
import Browser.browser;
import Pages.page1;
import Pages.page2;
import ScreenShot.capture;

public class Demo {

public static void main(String[] args) throws Exception {
		
		browser.openBrowser();
		browser.navigateToUrl();
		page1.enterusername("Admin");
		capture.screenShot("username");
		page1.enterpassword("admin123");

		if(page1.Title().equals("OrangeHRM"))
		{
			System.out.println("Title matched with expected");
		}
		else
		{
			System.out.println("Title is not matched with expected");
			
		}
		page1.click();
		
		if(page2.Username().equals("manda user"))
		{
			System.out.println("user matched with expected");
		}
		else
		{
			System.out.println("user not matched with expected");
			
		}
		capture.screenShot("page2");
		page2.optionclick("time");
		Thread.sleep(3000);
		browser.closeBrowser();
		

	}


}