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

public class AddsingleandMultipleEntitlements extends OrangeHrmloginandlogout {

	@Test(priority = 2, dataProvider = "singleleaveEntitlements")
	public void singleLeaveEntitlements(String username, String password, String name,String typeleave,String levaep,String entitlements,String location,String subunit,String prleave) throws Exception {
			
        Properties properties = new Properties(); 
		
	    FileInputStream Lis= new FileInputStream("C:\\Automationworkspace\\Facebook\\src\\test\\java\\datafile\\testdata.properties");
		
        properties.load(Lis);
        
        //Singleleaveentitlement
        
        driver.findElement(By.id(properties.getProperty("Username"))).sendKeys(username);

		driver.findElement(By.id(properties.getProperty("Password"))).sendKeys(password);

		driver.findElement(By.id(properties.getProperty("Login"))).click();

		driver.findElement(By.id(properties.getProperty("Leave"))).click();

		driver.findElement(By.id(properties.getProperty("Addsingleentitlement"))).click();

		driver.findElement(By.id(properties.getProperty("Singleaddentitlement"))).click();

		WebElement dynamiclist = driver.findElement(By.id(properties.getProperty("Employeename")));

		dynamiclist.click();

		dynamiclist.clear();

		dynamiclist.sendKeys(name);

        Actions action = new Actions(driver);
		
		action.sendKeys(Keys.DOWN);
		
		action.sendKeys(Keys.ENTER);
		
		action.perform();

		Select leavetype = new Select(driver.findElement(By.id(properties.getProperty("Leavetype"))));

	    leavetype.selectByVisibleText(typeleave);;

	    WebElement drwn= driver.findElement(By.id(properties.getProperty("Leaveperiod")));
		
		drwn.click();
		
		Select dropdown = new Select(drwn);
         	
        dropdown.selectByVisibleText(levaep);

	    driver.findElement(By.id(properties.getProperty("Entitlement"))).sendKeys(entitlements);

		driver.findElement(By.id(properties.getProperty("Save"))).click();
		
		//Multipleaddleaveentitlement
		
        driver.findElement(By.id(properties.getProperty("Addsingleentitlement"))).click();
		
		driver.findElement(By.id(properties.getProperty("Singleaddentitlement"))).click();
		
		driver.findElement(By.id(properties.getProperty("multiplecheckbox"))).click();
		
			
		WebElement addloc=driver.findElement(By.id(properties.getProperty("multiplelocation")));
		
		addloc.click();
		
		Select Addlea=new Select(addloc);
		
		Addlea.selectByVisibleText(location);
		
        WebElement addleav=driver.findElement(By.id(properties.getProperty("multiplesubunit")));
		
		addleav.click();
		
		Select Addleave=new Select(addleav);
		
		Addleave.selectByVisibleText(subunit);
		
		WebElement letp=driver.findElement(By.id(properties.getProperty("multipleleavetype")));
		
		letp.click();
		
        Select leavetypee=new Select(letp);
		
	    leavetypee.selectByVisibleText(typeleave);

		Thread.sleep(2000);
		
		WebElement lp=driver.findElement(By.id(properties.getProperty("Leaveperiod")));
		
		lp.click();
		
		Select dropdownnn=new Select(lp);
		
		dropdownnn.selectByVisibleText(prleave);
		
		driver.findElement(By.id(properties.getProperty("multipleentitlement"))).sendKeys(entitlements);
		
        driver.findElement(By.id(properties.getProperty("Save"))).click();
		
		

	}
 
	@DataProvider(name = "singleleaveEntitlements")

	public Object[][] singleleaveentitlements() throws Exception {

		return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "Singleleaveandmultipleleaveentitlements");

	}

}
