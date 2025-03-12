package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Browser.browser;
import Locators.page2Objects;

public class page2 extends browser {
		public static String Username()
		{
			return page2Objects.username().getText();
		}
		//clicking method
		public static void optionclick(String str) 
		{
			try{
				extent.attachReporter(reporter);
				logger1 = extent.createTest("OptionClick");
				logger1.log(Status.INFO, "Option Clicked");
				List<WebElement> list=page2Objects.menuelements();
				for(WebElement e:list)
				{
					if(e.getText().equalsIgnoreCase(str))
					{	e.click();
						break; 
					}
				}
				logger1.log(Status.PASS,"Selected successfully");
		}
			catch(Exception E)
			{
				logger1.log(Status.FAIL,"failed selecting ");
				System.out.println("Click :"+E);
			}	
			extent.flush();
		}
		public static String MenuName()
		{
			extent.attachReporter(reporter);
			logger1 = extent.createTest("MenuName");
			logger1.log(Status.INFO, "Dispalyed MenuName");
			logger1.log(Status.PASS,"MenuName Showed successfully");
			extent.flush();
			return page2Objects.menuName().getText();
		}
}
