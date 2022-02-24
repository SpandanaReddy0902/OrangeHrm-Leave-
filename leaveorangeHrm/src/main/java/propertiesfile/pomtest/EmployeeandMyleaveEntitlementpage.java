 package propertiesfile.pomtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeandMyleaveEntitlementpage {
	
	@FindBy(id="menu_leave_viewLeaveModule")
	public WebElement leaveorange=null;
	
	@FindBy(id="menu_leave_Entitlements")
	public WebElement  entitlement=null;
	
	@FindBy(id="menu_leave_viewLeaveEntitlements")
	public WebElement emplent=null;
	
	@FindBy(id="entitlements_employee_empName")
	public WebElement empentname=null;
	
	@FindBy(id="entitlements_leave_type")
	public WebElement empleavtp=null;
	
	@FindBy(id="period")
	public WebElement empleavp=null;
	
	@FindBy(id="searchBtn")
	public WebElement empleaventsearch=null;
	
	@FindBy(id="menu_leave_viewMyLeaveEntitlements")
	public WebElement myleaveentitlement=null;
	
	@FindBy(id="entitlements_leave_type")
	public WebElement myleavetype=null;

	//@FindBy(name = "chkSelectRow[]")
	//public WebElement deleteleave=null;
	
	//@FindBy(id="btnDelete")
	//public WebElement deletemyleave=null;

	
	public EmployeeandMyleaveEntitlementpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void empentit() {
		leaveorange.click();
		entitlement.click();
		emplent.click();
		
	}
	public void empnameenti(String employeename) {
		empentname.click();
		empentname.clear();
		empentname.sendKeys(employeename);
		empentname.sendKeys(Keys.DOWN,Keys.ENTER);
		
	}
	public void empentitlementleavetp(String leavtyp) {
		empleavtp.click();
	    Select ee=new Select(empleavtp);
		ee.selectByVisibleText(leavtyp);
	}
	
	public void empentitlementperiod(String prleave) {
		empleavp.click();
		Select eep=new Select(empleavp);
		eep.selectByVisibleText(prleave);
		empleaventsearch.click();
	}
	
public void myleaveent(String leavtyp) {
	    entitlement.click();
		myleaveentitlement.click();	
		myleavetype.click();
		Select mlt=new Select(myleavetype);
		mlt.selectByVisibleText(leavtyp);
		
	}
	
	
	public void myleavep(String prleave) {
		empleavp.click();
		Select mlp=new Select(empleavp);
		mlp.selectByVisibleText(prleave);
		empleaventsearch.click();
		
		
	}
	
	//public void myleavedelete() {
		
		//deleteleave.click();
		
		//deletemyleave.click();
	//}
	
}


