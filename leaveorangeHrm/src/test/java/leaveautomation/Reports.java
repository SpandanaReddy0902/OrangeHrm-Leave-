package leaveautomation;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;


public class Reports extends OrangeHrmloginandlogout{

	@Test(priority = 6,dataProvider = "leavetypereports")
	public void generatereportsonLeaveType(String username,String password,String generate,String tleave,String fromda,String jobTitle,String location,String Subunit,String generateemp,String name ) throws Exception {

		Properties properties = new Properties(); 
		
		FileInputStream Lis= new FileInputStream("C:\\Automationworkspace\\Facebook\\src\\test\\java\\datafile\\testdata.properties");

		properties.load(Lis);
		
		//Generatereportsonleavetype

        driver.findElement(By.id(properties.getProperty("Username"))).sendKeys(username);

		driver.findElement(By.id(properties.getProperty("Password"))).sendKeys(password);

		driver.findElement(By.id(properties.getProperty("Login"))).click();

		driver.findElement(By.id(properties.getProperty("Leave"))).click();

		driver.findElement(By.id(properties.getProperty("leavereports"))).click();

		driver.findElement(By.id(properties.getProperty("usagereports"))).click();

		WebElement generatelt=driver.findElement(By.id(properties.getProperty("generstefor")));
		
		generatelt.click();
	
		Select reportsonleave=new Select(generatelt);

		reportsonleave.selectByVisibleText(generate);

		WebElement tyleave=driver.findElement(By.id(properties.getProperty("balanceleavetype")));
		
		tyleave.click();

		Select reportsonleavetype=new Select(tyleave);

		reportsonleavetype.selectByVisibleText(tleave);

		WebElement date=driver.findElement(By.id(properties.getProperty("Leaveperiod")));
		
		date.click();

		Select from=new Select(date);

		Thread.sleep(2000);

		from.selectByVisibleText(fromda);

		Thread.sleep(2000);

		WebElement jt=driver.findElement(By.id(properties.getProperty("reportsjobtitle")));
		
		jt.click();
		
		Select jobtitle=new Select(jt);

		jobtitle.selectByVisibleText(jobTitle);

		WebElement ln=driver.findElement(By.id(properties.getProperty("reportslocation")));
		
		ln.click();

		Select Location=new Select(ln);

		Location.selectByVisibleText(location);

		WebElement su=driver.findElement(By.id(properties.getProperty("reportssubunit")));
		
		su.click();

		Select subunit=new Select(su);

	    subunit.selectByVisibleText(Subunit);

		driver.findElement(By.name(properties.getProperty("button"))).click();

		//rreportsonemployeetype
		
		WebElement empreports=driver.findElement(By.id(properties.getProperty("empusagereports")));
		
		empreports.click();

		Select reportsonemployeetype=new Select(empreports);

	    reportsonemployeetype.selectByVisibleText(generateemp);

		WebElement employeetype=driver.findElement(By.name(properties.getProperty("empreportname")));

		employeetype.click();

		employeetype.clear();

		employeetype.sendKeys(name);

		Actions actionemployee = new Actions(driver);

		actionemployee.sendKeys(Keys.DOWN);

		actionemployee.sendKeys(Keys.ENTER);

		actionemployee.perform();

	    WebElement empfrom=driver.findElement(By.id(properties.getProperty("Leaveperiod")));
	    
		empfrom.click();

		Select employeefrom=new Select(empfrom);

		employeefrom.selectByVisibleText(fromda);

		driver.findElement(By.id(properties.getProperty("empreportbutton"))).click();
        
		//myleaveentitlementandusagereports
		driver.findElement(By.id(properties.getProperty("leavereports"))).click();
		
        driver.findElement(By.id(properties.getProperty("myleaveusage"))).click();
		
		WebElement mle=driver.findElement(By.id(properties.getProperty("Leaveperiod")));
		
		mle.click();
		
		Select myleaventitlementsreports=new Select(mle);
		
		myleaventitlementsreports.selectByVisibleText(fromda);
		
	    driver.findElement(By.name(properties.getProperty("myleaveviewbtn"))).click();
		

	}

	@DataProvider(name="leavetypereports")
	public Object[][] MultipleaddEntitlements() throws Exception{

		return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "Reports");
	}





}
