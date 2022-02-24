package propertiesfile.pomtest;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddSingleandMultipleEntitlementpage {
	

	@FindBy(id = "menu_leave_viewLeaveModule")
	public WebElement orangeleave = null;

	@FindBy(id = "menu_leave_Entitlements")
	public WebElement addsingle = null;

	@FindBy(id = "menu_leave_addLeaveEntitlement")
	public WebElement singleleave = null;

	@FindBy(id = "entitlements_employee_empName")
	public WebElement emplselect = null;

	@FindBy(id = "entitlements_leave_type")
	public WebElement empleavetype = null;

	@FindBy(id = "period")
	public WebElement empleaveperiod=null;;

	@FindBy(id = "entitlements_entitlement")
	public WebElement emplents = null;

	@FindBy(id = "btnSave")
	public WebElement singlesave = null;
	
	@FindBy(id="menu_leave_addLeaveEntitlement")
	public WebElement addmultiple;
	
	@FindBy(id="entitlements_filters_bulk_assign")
	public WebElement multiplecheckbox;
	
	@FindBy(id="entitlements_filters_location")
	public WebElement multipleloca;
	
	@FindBy(id="entitlements_filters_subunit")
	public WebElement multipleleavesubunit;

	@FindBy(id="entitlements_leave_type")
	public WebElement multipleleavetype;
	
	@FindBy(id="period")
	public WebElement multipleempleaveperiod;
	
	@FindBy(id="entitlements_entitlement")
	public WebElement multiplelevent;
	
	@FindBy(id="btnSave")
	public WebElement multipleleavsave;
	

	public AddSingleandMultipleEntitlementpage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void singleLeaveEntitlement() {

		orangeleave.click();
		addsingle.click();
		singleleave.click();
	}
public void employeese(String name) throws Exception {
		emplselect.click();
		emplselect.clear();
		emplselect.sendKeys(name);
		emplselect.sendKeys(Keys.DOWN, Keys.ENTER);
	}

	public void empleavetype(String typeleave) {
		
		Select ssle = new Select(empleavetype);
		ssle.selectByVisibleText(typeleave);

	}

	public void empleaveperiod(String levaep) {

		Select selp = new Select(empleaveperiod);
		selp.selectByVisibleText(levaep);

	}

	public void empentitlements(String entitlements) {

		emplents.sendKeys(entitlements);

		singlesave.click();

	}
	
    public void addmultipleleave() {
		
    	addsingle.click();
		addmultiple.click();
		multiplecheckbox.click();
		
	}
	public void addmulleavent(String location) {
		
		multipleloca.click();
		
		Select amle=new Select(multipleloca);
		
		amle.selectByVisibleText(location);
			
	}
	
	public void addsubunit(String subunit) {
		
		multipleleavesubunit.click();
		
		Select asu=new Select(multipleleavesubunit);
		
		asu.selectByVisibleText(subunit);
		
	}
	
	public void addleavetype(String typeleave) {
		
		multipleleavetype.click();
		
		Select mlt=new Select(multipleleavetype);
		
		mlt.selectByVisibleText(typeleave);
			
		
	}
	
	public void addleaveperiod(String levaep) {
		
		multipleempleaveperiod.click();
		
		Select mlp=new Select(multipleempleaveperiod);
		
		mlp.selectByVisibleText(levaep);
	}
	
	public void enterentitlement(String entitlements) {
		
		multiplelevent.sendKeys(entitlements);
		
		multipleleavsave.click();
		
		
	}
	
}
