package automationleavepom;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;
import propertiesfile.pageobjectmodel.Loginpage;
import propertiesfile.pomtest.EmployeeandMyleaveEntitlementpage;


public class EmployeeandMyleaveEntitlementpom extends OrangeHrmloginandlogout {
	
	@Test(priority = 4,dataProvider = "Employeeentitlements")
	public void employeeEntitlements(String username,String password,String employeename,String leavtyp,String prleave) throws Exception {
	
	//open browser
		
		Loginpage empenti=new Loginpage(driver);
		
		empenti.orangelogin(username,password);
		
	//Employee Entitlement
		
		EmployeeandMyleaveEntitlementpage empentitlement=new EmployeeandMyleaveEntitlementpage(driver);
		empentitlement.empentit();
		empentitlement.empnameenti(employeename);
		empentitlement.empentitlementleavetp(leavtyp);
		empentitlement.empentitlementperiod(prleave);
		
		//My Leave Entitlement
		empentitlement.myleaveent(leavtyp);
		empentitlement.myleavep(prleave);
		
				
		
	//Close Browser
		
		//CloseOrange empenclose=new CloseOrange(driver);
		
		//empenclose.closeOrange();
	
	
	
	
	}
	@DataProvider(name="Employeeentitlements")
	
	public Object[][] MultipleaddEntitlements() throws Exception{
		
		return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "EmployeeandmyleaveEntitlements");
		
	
	}

}



