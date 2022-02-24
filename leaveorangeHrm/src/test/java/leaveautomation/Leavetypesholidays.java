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



public class Leavetypesholidays extends OrangeHrmloginandlogout{

	@Test(priority = 11,dataProvider = "Seeadddeleteholidays")
		public void seeandAddDeleteholidays(String username,String password,String fromdate,String todate,String day,String holidayadd,String holidaylen) throws Exception {
//see Holidays
		
		Properties properties = new Properties(); 
		FileInputStream Lis= new FileInputStream("C:\\Automationworkspace\\Facebook\\src\\test\\java\\datafile\\testdata.properties");
		
	    properties.load(Lis);
		
			driver.findElement(By.id(properties.getProperty("Username"))).sendKeys(username);
			
			driver.findElement(By.id(properties.getProperty("Password"))).sendKeys(password);
			
			driver.findElement(By.id(properties.getProperty("Login"))).click();
			
			driver.findElement(By.id(properties.getProperty("Leave"))).click();
			
			driver.findElement(By.linkText(properties.getProperty("editleave"))).click();
			
			driver.findElement(By.id(properties.getProperty("seeholidays"))).click();
			
			WebElement seefrom=driver.findElement(By.id(properties.getProperty("holidaysfrom")));
			
			seefrom.click();
			
		    seefrom.clear();
			
			seefrom.sendKeys(fromdate);
			
			Actions seefromdate =new Actions(driver);
			
			seefromdate.sendKeys(Keys.DOWN);
			
			seefromdate.sendKeys(Keys.ENTER);
			
			seefromdate.perform();
			
			WebElement seedateto=driver.findElement(By.id(properties.getProperty("holidaysto")));
			
			seedateto.click();
			
			seedateto.clear();
			
			seedateto.sendKeys(todate);
			
			Actions seetodate =new Actions(driver);
			
			seetodate.sendKeys(Keys.DOWN);
			
			seetodate.sendKeys(Keys.ENTER);
			
			seetodate.perform();
			
			driver.findElement(By.id(properties.getProperty("holidayssearch"))).click();
			
			//Add Holidays
			
			driver.findElement(By.id(properties.getProperty("holidaysadd"))).click();
			
		    driver.findElement(By.id(properties.getProperty("holiday"))).sendKeys(day);
			
			WebElement addholiday=driver.findElement(By.id(properties.getProperty("holidaydate")));
			
			addholiday.click();
			
			addholiday.clear();
			
			addholiday.sendKeys(holidayadd);
			
		    Actions addtodate =new Actions(driver);
				
		    addtodate.sendKeys(Keys.DOWN).perform();;
				
		    addtodate.sendKeys(Keys.ENTER).perform();;
				
			Select add=new Select(driver.findElement(By.id(properties.getProperty("holidaylength"))));
			
		    add.selectByVisibleText(holidaylen);;
			
		    driver.findElement(By.id(properties.getProperty("savebutton"))).click();
			
		    //delete holiday
			
			WebElement deleteholiday=driver.findElement(By.name(properties.getProperty("selectbox")));
			
			deleteholiday.click();
		
			driver.findElement(By.id(properties.getProperty("delete"))).click();
			
			driver.findElement(By.id(properties.getProperty("okbutton"))).click();
			
	}
	
	@DataProvider(name="Seeadddeleteholidays")
	
public Object[][] MultipleaddEntitlements() throws Exception{
		
		return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "seeAdddeleteHoliday");
		
	}			

}
