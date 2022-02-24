package propertiesfile.pomtest;


import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ConfigureLeavetypeholidayspage {
	
	@FindBy(id="menu_leave_viewLeaveModule")
	public WebElement leaveeorange=null;
	
	@FindBy(linkText="Configure")
	public WebElement configureedit=null;
	
	@FindBy(id="menu_leave_viewHolidayList")
	public WebElement holidayssee=null;
	
	@FindBy(id="calFromDate")
	public WebElement fromholidays=null;
	
	@FindBy(id="calToDate")
	public WebElement toholidays=null;
	
	@FindBy(id="btnSearch")
	public WebElement searchholidays=null;
	
	@FindBy(id="btnAdd")
	public WebElement addholidays=null;
	
	@FindBy(id="holiday_description")
	public WebElement holidays=null;
	
	@FindBy(id="holiday_date")
	public WebElement dateholiday=null;
	
	@FindBy(id="holiday_length")
	public WebElement lengthholiday=null;
	
	@FindBy(id="saveBtn")
	public WebElement buttonsave=null;
	
	@FindBy(name="chkSelectRow[]")
	public WebElement boxselect=null;
	
	@FindBy(id="btnDelete")
	public WebElement delete=null;
	
	@FindBy(id="dialogDeleteBtn")
	public WebElement deleteok=null;
	
	public ConfigureLeavetypeholidayspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	public void seeHolidays() {
		leaveeorange.click();
		configureedit.click();
		holidayssee.click();
		
	}
	public void from(String fromdate) {
		fromholidays.click();
		fromholidays.clear();
		fromholidays.sendKeys(fromdate);
		fromholidays.sendKeys(Keys.DOWN,Keys.ENTER);
		
	}
	public void to(String todate) {
		toholidays.click();
		toholidays.clear();
		toholidays.sendKeys(todate);
		toholidays.sendKeys(Keys.DOWN,Keys.ENTER);
		searchholidays.click();
		}
	public void addHolidays(String day,String holidayadd) {
		addholidays.click();
		holidays.sendKeys(day);
		dateholiday.click();
		dateholiday.clear();
		dateholiday.sendKeys(holidayadd);
		dateholiday.sendKeys(Keys.DOWN,Keys.ENTER);
		
	}
	public void seah(String holidaylen) {
	    Select ah=new Select(lengthholiday);
	    ah.selectByVisibleText(holidaylen);
	    buttonsave.click();
	    }
	public void deleteHolidays() {
		boxselect.click();
		delete.click();
		deleteok.click();
	}
	
}
