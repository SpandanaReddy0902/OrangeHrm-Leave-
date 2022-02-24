package leaveautomation;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;



public class LeaveList extends OrangeHrmloginandlogout{
	
	@Test(priority = 12,dataProvider = "Searchcancelreset")
	public void searchandCancelandResetleaves(String username,String password,String fromdate,String dateto,String empna) throws Exception {
		//leavelist
		Properties properties = new Properties(); 
		
		FileInputStream Lis= new FileInputStream("C:\\Automationworkspace\\Facebook\\src\\test\\java\\datafile\\testdata.properties");
		
	    properties.load(Lis);
	
			driver.findElement(By.id(properties.getProperty("Username"))).sendKeys(username);
			
			driver.findElement(By.id(properties.getProperty("Password"))).sendKeys(password);
			
			driver.findElement(By.id(properties.getProperty("Login"))).click();
			
			driver.findElement(By.id(properties.getProperty("Leave"))).click();
			
			driver.findElement(By.linkText(properties.getProperty("leavelist"))).click();
			
			WebElement search=driver.findElement(By.id(properties.getProperty("fromdate")));
			
		    search.click();
			
			search.clear();
			
			search.sendKeys(fromdate);
			
		    Actions searc =new Actions(driver);
			
            searc.sendKeys(Keys.DOWN).perform();;
			
			searc.sendKeys(Keys.ENTER).perform();;
			
			WebElement todate=driver.findElement(By.id(properties.getProperty("todate")));
			
			todate.click();
			
			todate.clear();
			
		    todate.sendKeys(dateto);
			
			Actions sear =new Actions(driver);
				
			sear.sendKeys(Keys.DOWN).perform();
				
		    sear.sendKeys(Keys.ENTER).perform();
				
		    WebElement checkbox=driver.findElement(By.id(properties.getProperty("checkBox")));
			
			checkbox.click();
			
		    WebElement employeename=driver.findElement(By.id("leaveList_txtEmployee_empName"));
			
			employeename.click();
			
		    employeename.clear();
			
			employeename.sendKeys(empna);
			
		    Actions name=new Actions(driver);
		
	        name.sendKeys(Keys.DOWN);
			
	        name.sendKeys(Keys.ENTER);
			
		    name.perform();
			
	        //Select subunit=new Select(driver.findElement(By.name("leaveList[cmbSubunit]")));
			
		    //Thread.sleep(2000);
			
			//subunit.selectByIndex(11);
			
			//Thread.sleep(2000);
			
			driver.findElement(By.id(properties.getProperty("leavesearch"))).click();
			
		    //cancel leaves
			
			//Select cancelleav=new Select(driver.findElement(By.xpath("//select[@class='select_action quotaSelect']")));
			//Tread.sleep(2000);
			//cancelleav.selectByVisibleText(text);
			//Thread.sleep(2000);
			//driver.findElement(By.name("btnSave")).click();
			//reset leaves
			
			driver.findElement(By.name(properties.getProperty("leavereset"))).click();
	}
			
				
	@DataProvider(name="Searchcancelreset")
	public Object[][] MultipleaddEntitlements() throws Exception{
		
    return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "searchandcancelandreset");
		
	}
		


}
