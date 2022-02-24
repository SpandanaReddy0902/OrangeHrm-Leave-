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

public class EmployeeAndMyleaveEntitlements extends OrangeHrmloginandlogout {

	@Test(priority = 3,dataProvider = "Employeeentitlements")
	public void employeeEntitlements(String username,String password,String employeename,String leavtyp,String prleave ) throws Exception {
	
	Properties properties=new Properties();
	
	FileInputStream Lis= new FileInputStream("C:\\Automationworkspace\\Facebook\\src\\test\\java\\datafile\\testdata.properties");
	
    properties.load(Lis);
    	
	driver.findElement(By.id(properties.getProperty("Username"))).sendKeys(username);
	
	driver.findElement(By.id(properties.getProperty("Password"))).sendKeys(password);
	
	driver.findElement(By.id(properties.getProperty("Login"))).click();
	
	driver.findElement(By.id(properties.getProperty("Leave"))).click();
	
	driver.findElement(By.id(properties.getProperty("Addsingleentitlement"))).click();
	
	driver.findElement(By.id(properties.getProperty("entitlementsemp"))).click();
	
	WebElement employee=driver.findElement(By.id(properties.getProperty("emplname")));
	
	employee.click();
	
	employee.clear();
	
    employee.sendKeys(employeename);
	
	Actions actionl = new Actions(driver);
	
	actionl.sendKeys(Keys.DOWN);
	
	actionl.sendKeys(Keys.ENTER);
	
	actionl.perform();
	
	WebElement lt=driver.findElement(By.id(properties.getProperty("Leavetype")));
	
	lt.click();
	
    Select sele=new Select(lt);
	
	sele.selectByVisibleText(leavtyp);;
	
	WebElement lp=driver.findElement(By.id(properties.getProperty("Leaveperiod")));
	
	lp.click();
	
	Select leaveperiod=new Select(lp);

	leaveperiod.selectByVisibleText(prleave);
	
	driver.findElement(By.id(properties.getProperty("search"))).click();
	
	//Myleaveentitlement
	driver.findElement(By.id(properties.getProperty("Addsingleentitlement"))).click();
	
	driver.findElement(By.id(properties.getProperty("myleaveentitlements"))).click();
	
	WebElement elt=driver.findElement(By.id(properties.getProperty("Leavetype")));
	
	elt.click();
	
	Select leaveetype=new Select(elt);
	
	leaveetype.selectByVisibleText(leavtyp);
	
	WebElement pl=driver.findElement(By.id(properties.getProperty("Leaveperiod")));
	
	pl.click();
	
	Select periodleave=new Select(pl);
	
	periodleave.selectByVisibleText(prleave);
	
	driver.findElement(By.id(properties.getProperty("search"))).click();
	
	//delete 
	
	//driver.findElement(By.name("chkSelectRow[]")).click();
	
	//Thread.sleep(2000);
	
	//driver.findElement(By.id("btnDelete")).click();
	
	//Thread.sleep(2000);
	
}

	
	
	
	
	@DataProvider(name="Employeeentitlements")
	
public Object[][] MultipleaddEntitlements() throws Exception{
		
		return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "EmployeeandmyleaveEntitlements");
		
	
	}

		
	
	

}
