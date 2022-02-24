package automationleavepom;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;
import propertiesfile.pageobjectmodel.Loginpage;
import propertiesfile.pomtest.AddSingleandMultipleEntitlementpage;



public class AddSingleandMultipleLeaveEntitlementpom extends OrangeHrmloginandlogout {
	@Test(priority = 2, dataProvider = "singleleaveEntitlements")
	public void singleLeaveEntitlements(String username, String password, String name,String typeleave,String levaep,String entitlements,String location,String subunit)throws Exception {
			

		//openorange
		
		Loginpage orangeopen=new Loginpage(driver);
		
		orangeopen.orangelogin(username,password);
		
		// singleleaveentitlement
		
		AddSingleandMultipleEntitlementpage leaveentitlement=new  AddSingleandMultipleEntitlementpage(driver);
		leaveentitlement.singleLeaveEntitlement();
		leaveentitlement.employeese(name);
		leaveentitlement.empleavetype(typeleave);
		leaveentitlement.empleaveperiod(levaep);
		leaveentitlement.empentitlements(entitlements);
		
		//Multipleleaveentitlement
	    
		
		leaveentitlement.addmultipleleave();
		leaveentitlement.addmulleavent(location);
		leaveentitlement.addsubunit(subunit);
		leaveentitlement.addleavetype(typeleave);
		leaveentitlement.addleaveperiod(levaep);
		leaveentitlement.enterentitlement(entitlements);
		
		
// close orange
		
		//CloseOrange close=new CloseOrange(driver);
		
		//close.closeOrange();
		
		
		
		

		

	}
 
	@DataProvider(name = "singleleaveEntitlements")

	public Object[][] singleleaveentitlements() throws Exception {
		
		return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "Singleleaveandmultipleleaveentitlements");

	}
}

