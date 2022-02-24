package propertiesfile.pomtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyLeaveandMyleavepage {

	@FindBy(id="menu_leave_viewLeaveModule")
	public WebElement orangeleave=null;
	
	
	@FindBy(id="menu_leave_viewLeaveModule")
	public WebElement orangeapplyleave=null;
	
	@FindBy(linkText = "My Leave")
	public WebElement orangemyleave=null;
	
	@FindBy(id = "calFromDate")
	public WebElement fromd=null;
	
	@FindBy(id="calToDate")
	public WebElement tod=null;
	
	@FindBy(id="leaveList_chkSearchFilter_checkboxgroup_allcheck")
	public WebElement checkbox=null;
	
	@FindBy(id="btnSearch")
	public WebElement search=null;

	
	
	public ApplyLeaveandMyleavepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public void applyLeave() {
		
		orangeleave.click();
		
		orangeapplyleave.click();
	}
	
    public void myLeavepom(String fromdate,String todate ) {

			
    	orangemyleave.click();
			fromd.click();
			fromd.clear();
	
    }
    
    public void leavePom(String fromdate) {
			
			fromd.sendKeys(fromdate);
			fromd.sendKeys(Keys.DOWN,Keys.ENTER);  	 
			tod.click();
			tod.clear();
    }
    
    public void leaveTo(String todate) {
    	
			tod.sendKeys(todate);
			tod.sendKeys(Keys.DOWN,Keys.ENTER);
			checkbox.click();
			checkbox.click();
			search.click();
			
				
		
	}
	
	
	
}
