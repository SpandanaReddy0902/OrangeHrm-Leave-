package propertiesfile.pomtest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Configurepage {

     @FindBy(id="menu_leave_viewLeaveModule")	
	 public WebElement orangeleavep=null;
	 
     @FindBy(id="menu_leave_Configure")
	 public WebElement configureleav=null;
	 
     @FindBy(id="menu_leave_defineLeavePeriod")
	 public WebElement editleav=null;
     
	 @FindBy(name="btnEdit")
	 public WebElement editbtn=null;
	 
	 @FindBy(id="leaveperiod_cmbStartMonth")
	 public WebElement editmonth=null;
	 
	 @FindBy(id="leaveperiod_cmbStartDate")
	 public WebElement editdate=null;
	 
	 @FindBy(name="btnReset")
	 public WebElement reset=null;
	 	
	 @FindBy(id="menu_leave_leaveTypeList")
	 public WebElement leavelist=null;
	 
	 @FindBy (id="btnAdd")
	 public WebElement leave=null;
	 
	 @FindBy(id="menu_leave_leaveTypeList")
	 public WebElement leavetype=null;
	 
	 @FindBy(id="leaveType_txtLeaveTypeName")
	 public WebElement leavename=null;
	 
	 @FindBy(id="saveButton")
	 public WebElement leaveb=null;
	 
	 @FindBy(name="chkSelectRow[]")
	 public WebElement leavesel=null;
	 
	 @FindBy (id="btnDelete")
	 public WebElement deletee=null;
	
	 @FindBy(id="btnReset")
	 public WebElement resetlea=null;
	 	
	 @FindBy(linkText="Work Week")
	 public WebElement workweekedit=null;
		
	 @FindBy(id="saveBtn")
	 public WebElement saveedit=null;
		
	 @FindBy(name="WorkWeek[day_length_Monday]")
	 public WebElement editday=null;
		
	 @FindBy(id="saveBtn")
	 public WebElement editsavebtn=null;
	 
	 @FindBy(id="dialogDeleteBtn")
	 public WebElement deleteok=null;
	 
	 public Configurepage(WebDriver driver) {
		 
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void editLeav() {
		 orangeleavep.click();
		 configureleav.click();
		 editleav.click();
		 editbtn.click();
		 
	 }
	 public void editMonthLeavep(String month) {
		 editmonth.click();
		 Select emlp=new Select(editmonth);
		 emlp.selectByVisibleText(month);
	 }
	 
	 public void editStartDatelp(String date) {
		 editdate.click();
		 Select esdlp=new Select(editdate);
		 esdlp.selectByVisibleText(date);
	 }
	 
	 public void saveEditReset()  {
		 editbtn.click();
		 editbtn.click();
		 reset.click();
	 }
	 public void leaveTypes(String day) throws Exception  {
		 configureleav.click();
		 leavetype.click();
		 leave.click();
		 Thread.sleep(2000);
		 leavename.sendKeys(day);
		 leaveb.click();
	 
	 }
			
    public void lTy() {			
			
    	leavesel.click();
    	deletee.click();
    	deleteok.click();
    	
    }
 
    public void editWorkweek() {
    	 configureleav.click();
		workweekedit.click();
		saveedit.click();
		
    }
    public void editW(String week) {
		Select eww=new Select(editday);
		eww.selectByVisibleText(week);
		editsavebtn.click();
}
    
    
}    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
