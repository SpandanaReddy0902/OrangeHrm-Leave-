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

public class AssignLeave extends OrangeHrmloginandlogout{
@Test(priority = 13,dataProvider = "assignleave")
	public void assignLeave(String username,String password,String name,String leavetype,String fromdate,String todate) throws Exception {
		// Assign Leave
	Properties properties = new Properties(); 
	
	FileInputStream Lis= new FileInputStream("C:\\Automationworkspace\\Facebook\\src\\test\\java\\datafile\\testdata.properties");
	
    properties.load(Lis);
	
            driver.findElement(By.id(properties.getProperty("Username"))).sendKeys(username);
			
			driver.findElement(By.id(properties.getProperty("Password"))).sendKeys(password);
			
			driver.findElement(By.id(properties.getProperty("Login"))).click();
			
			driver.findElement(By.id(properties.getProperty("Leave"))).click();
			
			driver.findElement(By.linkText(properties.getProperty("assiagnleave"))).click();
			
			WebElement assign=driver.findElement(By.id(properties.getProperty("assignleaveempname")));
			
			assign.click();
			
			assign.clear();
			
		    assign.sendKeys(name);
			
			Actions assignemployee=new Actions(driver);
			
			assignemployee.sendKeys(Keys.DOWN);
			
			assignemployee.sendKeys(Keys.ENTER); 
			
			assignemployee.perform();
			
			WebElement lta=driver.findElement(By.id(properties.getProperty("assignleavetype")));
			
			lta.click();
			
			Select leavetypeassign=new Select(lta);
			
			leavetypeassign.selectByVisibleText(leavetype);
			
			WebElement assigndate=driver.findElement(By.id(properties.getProperty("assignleavefrom")));
			
			assigndate.click();
			
			assigndate.clear();
			
			assigndate.sendKeys(fromdate);
			
			Actions assignfromdate=new Actions(driver);
			
			assignfromdate.sendKeys(Keys.DOWN).perform();;
			
			assignfromdate.sendKeys(Keys.ENTER).perform();;
			
			WebElement assignto=driver.findElement(By.id(properties.getProperty("assignleaveto")));
			
			assignto.click();
			
		    assignto.clear();
			
			assignto.sendKeys(todate);
			
			Actions assigntodate=new Actions(driver);
			
			assigntodate.sendKeys(Keys.DOWN).perform();;
			
			assigntodate.sendKeys(Keys.ENTER).perform();;
			
		    driver.findElement(By.id(properties.getProperty("assignbutton"))).click();
			
			//driver.findElement(By.id(properties.getProperty("assignok"))).click();
			
			

	}

@DataProvider(name="assignleave")

public Object[][] MultipleaddEntitlements() throws Exception{
	
  return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "assignleaves");	
	
}
	

}
