package propertiesfile.pomtest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Reportspage {

	@FindBy(id="menu_leave_viewLeaveModule")
	public WebElement empleave=null;
	
	@FindBy(id="menu_leave_Reports")
	public WebElement empleavrep=null;
	
	@FindBy(id="menu_leave_viewLeaveBalanceReport")
	public WebElement empleavusagerep=null;
	
	@FindBy(id="leave_balance_report_type")
	public WebElement empusagerep=null;
	
	@FindBy(name="leave_balance[employee][empName]")
	public WebElement emprepname=null;
	
	@FindBy(id="period")
	public WebElement empleavepe=null;
	
	@FindBy(id="viewBtn")
	public WebElement empbutton=null;
	
	@FindBy(id="leave_balance_leave_type")
	public WebElement reportsleavetype=null;
	
	@FindBy(id="leave_balance_job_title")
	public WebElement jobtitle=null;
	
	@FindBy(id="leave_balance_location")
	public WebElement Location=null;
	
	@FindBy(id="leave_balance_sub_unit")
	public WebElement subunit=null;
	
	@FindBy(name="view")
	public WebElement myleavbtn=null;
	
	@FindBy(id="menu_leave_viewMyLeaveBalanceReport")
	public WebElement myleavee=null;
	
	public Reportspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void employeerep() {
		empleave.click();
		empleavrep.click();
		empleavusagerep.click();
	}
	public void generateReports(String generate) {
    	empusagerep.click();
    	Select gr=new Select(empusagerep);
    	gr.selectByVisibleText(generate);
    	
    }
    
    public void leaveTypebalance(String tleave) {
    	reportsleavetype.click();
    	Select rlt=new Select(reportsleavetype);
    	rlt.selectByVisibleText(tleave);
    	
    }
    
    public void reportsperiod(String fromda) {
    	empleavepe.click();
    	Select rlp=new Select(empleavepe);
    	System.out.println("h");
    	rlp.selectByVisibleText(fromda);
    	System.err.println("g");
    	
    }
    public void reportsJobtitle(String jobTitle) {
    	jobtitle.click();
    	Select rjt=new Select(jobtitle);
    	rjt.selectByVisibleText(jobTitle);
    	
    }
    public void reportslocation(String location) {
    	Location.click();
    	Select rl=new Select(Location);
    	rl.selectByVisibleText(location);
    	
    }
    public void reportsSubunit(String Subunit) {
    	subunit.click();
    	Select rs=new Select(subunit);
    	rs.selectByVisibleText(Subunit);
    	myleavbtn.click();
    }
	
	
	public void employeeusagerepo(String generateemp) {
		empleavrep.click();
		empusagerep.click();
		Select eur=new Select(empusagerep);
		eur.selectByVisibleText(generateemp);
	}
	
	public void employeereportername(String name) {
		emprepname.click();
		emprepname.clear();
		emprepname.sendKeys(name);
		emprepname.sendKeys(Keys.DOWN,Keys.ENTER);
		
	}
	
	public void employeereportperiod(String fromda) {
		
		empleavepe.click();
		Select erp=new Select(empleavepe);
		erp.selectByVisibleText(fromda);
		empbutton.click();
	}
	
    
	public void leavPeriodselent(String fromda) {
		empleavrep.click();
		 myleavee.click();
		Select lps=new Select(empleavepe);
		lps.selectByVisibleText(fromda);
		myleavbtn.click();
		
		
	}
}


