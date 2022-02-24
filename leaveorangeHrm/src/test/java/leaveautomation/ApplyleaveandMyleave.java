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




@Test(priority = 1,dataProvider = "applyleave")
public class ApplyleaveandMyleave extends OrangeHrmloginandlogout {


	public void applyLeave(String username,String password,String fromdate,String todate) throws Exception {
	
		Properties properties = new Properties(); 
		
		FileInputStream Lis= new FileInputStream("C:\\Automationworkspace\\Facebook\\src\\test\\java\\datafile\\testdata.properties");
		
	    properties.load(Lis);
	    
//Applyleave	
				driver.findElement(By.id(properties.getProperty("Username"))).sendKeys(username);
				
				driver.findElement(By.id(properties.getProperty("Password"))).sendKeys(password);
				
				driver.findElement(By.id(properties.getProperty("Login"))).click();
				
				driver.findElement(By.id(properties.getProperty("Leave"))).click();
				
				driver.findElement(By.id(properties.getProperty("Applyleave"))).click();
				
//Myleave
					
				driver.findElement(By.linkText(properties.getProperty("myleave"))).click();
				
				WebElement from =driver.findElement(By.id(properties.getProperty("Leavefrom")));
				
				from.click();
				
				from.clear();
				
				from.sendKeys(fromdate);
				
				Actions fromleave=new Actions(driver);
				
				fromleave.sendKeys(Keys.DOWN);
				
				fromleave.sendKeys(Keys.ENTER);
				
				fromleave.perform();
				
				WebElement to=driver.findElement(By.id(properties.getProperty("Leaveto")));
			
				to.click();
				
				to.clear();
				
				to.sendKeys(todate);
				
				Actions Toleave=new Actions(driver);
				
				Toleave.sendKeys(Keys.DOWN);
				
				Toleave.sendKeys(Keys.ENTER);
				
				Toleave.perform();
				
				WebElement leavecheckbox=driver.findElement(By.id(properties.getProperty("Checkboxselect")));
				
				leavecheckbox.click();
				
				leavecheckbox.click();
					
				driver.findElement(By.id(properties.getProperty("LeaveSearch"))).click();
				
				
			
				
				
	}
		
	@DataProvider(name="applyleave")
	public Object[][] MultipleaddEntitlements() throws Exception{
		
			return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "ApplyLeaveandmyleaves");
				
			
	}
				
				
				
				
				
		
		
				
				
		
		
	}


