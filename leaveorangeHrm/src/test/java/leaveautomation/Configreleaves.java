package leaveautomation;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;


public class Configreleaves extends OrangeHrmloginandlogout{
	
	@Test(priority = 8,dataProvider = "editleavesperiod")

	public void editLeave(String username,String password,String month,String date,String day,String week ) throws Exception {
		
		Properties properties = new Properties(); 
		
		FileInputStream Lis= new FileInputStream("C:\\Automationworkspace\\Facebook\\src\\test\\java\\datafile\\testdata.properties");
		
	    properties.load(Lis);

		driver.findElement(By.id(properties.getProperty("Username"))).sendKeys(username);
		
		driver.findElement(By.id(properties.getProperty("Password"))).sendKeys(password);
		
		driver.findElement(By.id(properties.getProperty("Login"))).click();
		
		driver.findElement(By.id(properties.getProperty("Leave"))).click();
		
		driver.findElement(By.linkText(properties.getProperty("editleave"))).click();
		
		driver.findElement(By.linkText(properties.getProperty("editleaveperiod"))).click();
		
		driver.findElement(By.name(properties.getProperty("editbutton"))).click();
		
		WebElement sm=driver.findElement(By.id(properties.getProperty("editstartmonth")));
		
		sm.click();
		
		Select startmonth=new Select(sm);
		
		startmonth.selectByVisibleText(month);
		
		WebElement sd=driver.findElement(By.id(properties.getProperty("editstartdate")));
		
		sd.click();
		
		Select startdate=new Select(sd);
		
		startdate.selectByVisibleText(date);
		
		driver.findElement(By.name(properties.getProperty("editbutton"))).click();
		
		//edit
		
	    driver.findElement(By.name(properties.getProperty("editbutton"))).click();
		
		//Reset 
		
		driver.findElement(By.name(properties.getProperty("resetbutton"))).click();
		
	    //addanddeleteleavetypes
		driver.findElement(By.linkText(properties.getProperty("editleave"))).click();
		
        driver.findElement(By.linkText(properties.getProperty("addleavetype"))).click();
		
		driver.findElement(By.name(properties.getProperty("addbutton"))).click();
		
		driver.findElement(By.name(properties.getProperty("addleavetypename"))).sendKeys(day);
		
		driver.findElement(By.id(properties.getProperty("savebutton"))).click();
		
		
        //delete leave type
		
		driver.findElement(By.name(properties.getProperty("select"))).click();
		
	    driver.findElement(By.id(properties.getProperty("delete"))).click();
		
		driver.findElement(By.id(properties.getProperty("okbutton"))).click();
		
		//editworkweek
		driver.findElement(By.linkText(properties.getProperty("editleave"))).click();
		
		driver.findElement(By.linkText(properties.getProperty("editworkweek"))).click();

		driver.findElement(By.id(properties.getProperty("editsave"))).click();
		
		WebElement ww=driver.findElement(By.name(properties.getProperty("day")));
		
		ww.click();

		Select workweek = new Select(ww);

		workweek.selectByVisibleText(week);

		driver.findElement(By.id(properties.getProperty("savebn"))).click();


		
		
		
		
	
	}
	
	@DataProvider(name="editleavesperiod")
	
		
public Object[][] MultipleaddEntitlements() throws Exception{
		
		return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "configure");
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

}
