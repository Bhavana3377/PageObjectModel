package Browser;

import java.awt.Desktop.Action;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class browser {
	public static Actions act;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest logger1;
	public static void init(String reportName) {
		extent = new ExtentReports();
		reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//target//ExtentReport//"+reportName+".html");
		
	}
	/*
	 * Open the browser based on the choice
	 */
	public static void openBrowser() throws Exception {
		extent.attachReporter(reporter);
		logger1 = extent.createTest("Open browser");
		logger1.log(Status.INFO, "opening the browser");
		try {
			String choice = utility.properties("browser"); 
			if (choice.equalsIgnoreCase("Chrome"))
				driver = new ChromeDriver();
			else if (choice.equalsIgnoreCase("Edge"))
				driver = new EdgeDriver();
			else if (choice.equalsIgnoreCase("Firefox"))
				driver = new FirefoxDriver();
			logger1.log(Status.PASS,"browser opened successfully");
		} catch (Exception e) {
			
			// e.printStackTrace();
			System.out.println("Browser - openBrowser");
			logger1.log(Status.FAIL,"failed opening the browser ");

		}
		extent.flush();
	}
	/*
	 * Pauses the URL of the application
	 */
	public static void navigateToUrl() throws Exception {
		try {
			extent.attachReporter(reporter);
			logger1 = extent.createTest("Navigate to browser");
			logger1.log(Status.INFO, "Navigating to browser");
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
			driver.manage().window().maximize();
			act = new Actions(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs("OrangeHRM"));
			logger1.log(Status.PASS,"Navigated successfully");
		} catch (Exception e) {
			System.out.println("Browser - geturl");
			logger1.log(Status.FAIL,"failed navigating to browser ");
		}
		extent.flush();
	}
	/*
	 * Closes the Browser
	 */
	public static void closeBrowser() {
		try {
			extent.attachReporter(reporter);
			logger1 = extent.createTest("Close browser");
			logger1.log(Status.INFO, "Closing browser");
			driver.quit();
			logger1.log(Status.PASS,"Closed successfully");
		} catch (Exception e) {
			System.out.println("Browser - closeBrowser");
			logger1.log(Status.FAIL,"failed to browser ");
		}
		extent.flush();
	}
	
	

}
