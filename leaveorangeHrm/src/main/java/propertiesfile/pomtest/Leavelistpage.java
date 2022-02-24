package propertiesfile.pomtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Leavelistpage  {

	
	@FindBy(id="menu_leave_viewLeaveModule")
	public WebElement leaveo=null;
	
	@FindBy(linkText="Leave List")
	public WebElement listleave=null;
	
	@FindBy(id="calFromDate")
	public WebElement fromdat=null;
	
	@FindBy(id="calToDate")
	public WebElement datet=null;
	
	@FindBy(id="leaveList_chkSearchFilter_checkboxgroup_allcheck")
	public WebElement boxcheck=null;
	
	@FindBy(id="leaveList_txtEmployee_empName")
	public WebElement emna=null;
	
	@FindBy(id="btnSearch")
	public WebElement searchleavess=null;
	
	
	@FindBy(id="btnReset")
	public WebElement resetlea=null;
	
	public Leavelistpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void serachle() throws Exception {
		leaveo.click();
		listleave.click();
		
	}
	public void leavef(String fromdate) {
		fromdat.click();
		fromdat.clear();
		fromdat.sendKeys(fromdate);
		fromdat.sendKeys(Keys.DOWN,Keys.ENTER);
	}
	public void leavet(String dateto) {
		datet.click();
		datet.clear();
		datet.sendKeys(dateto);
		datet.sendKeys(Keys.DOWN,Keys.ENTER);
	}
	public void leaveeee(String empna) {
		boxcheck.click();
		searchleavess.click();
		emna.click();
		emna.clear();
		emna.sendKeys(empna);
		emna.sendKeys(Keys.DOWN,Keys.ENTER);
		resetlea.click();
		
	}
}
