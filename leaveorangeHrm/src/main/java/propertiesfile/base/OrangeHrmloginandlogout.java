package propertiesfile.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmloginandlogout {

	public WebDriver driver=null;
	
	static ExtentReports extent;
	
	@BeforeTest

		public void open() {
			//open browser
	        WebDriverManager.chromedriver().setup();
	        

			ExtentSparkReporter reporter=new ExtentSparkReporter("\\src\\test\\java\\Reportsleave\\Extentreportsleave.html");
			
			reporter.config().setReportName("OrangeHrm Leave Automation");
			
			extent=new ExtentReports();
			
			extent.attachReporter(reporter);
			
			driver=new ChromeDriver();

			SoftAssert softAssert = new SoftAssert();
			
			driver.manage().window().maximize();
			
			softAssert.assertNull(driver);
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			
			driver.get("https://opensource-demo.orangehrmlive.com/");
			
			softAssert.assertEquals("OrangeHrm", "OrangeHrm");
            
			
			
	}
	@AfterTest
	 
	public void close() throws Exception {
		 //driver.findElement(By.id("welcome")).click();
		 //driver.findElement(By.xpath("//a[text()='Logout']")).click();

		 driver.quit();
			
			
			
			
		}
	}


	

