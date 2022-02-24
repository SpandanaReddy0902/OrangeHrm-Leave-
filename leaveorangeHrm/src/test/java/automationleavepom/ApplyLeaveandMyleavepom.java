package automationleavepom;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;
import propertiesfile.pageobjectmodel.Loginpage;
import propertiesfile.pageobjectmodel.Logoutpage;
import propertiesfile.pomtest.ApplyLeaveandMyleavepage;

@Test(dataProvider = "applypomleave",priority = 1)

public class ApplyLeaveandMyleavepom extends OrangeHrmloginandlogout{
	
		public void applyLeave(String username,String password,String fromdate,String todate) throws Exception {
		
			//open orange
			
	    Loginpage orange=new Loginpage(driver);
					
		orange.orangelogin(username, password);
		
		//Applyleave
					
		ApplyLeaveandMyleavepage apply=new ApplyLeaveandMyleavepage(driver);
					
		apply.applyLeave();			
		 			
		apply.myLeavepom(fromdate,todate);
		
		apply.leavePom(fromdate);
		
		apply.leaveTo(todate);
		
		//close browser
		
		Logoutpage lo=new Logoutpage(driver);
		
		lo.closeOrange();
					
		}
		
		
		@DataProvider(name="applypomleave")
		public Object[][] MultipleaddEntitlements() throws Exception{
			
			return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "ApplyLeaveandmyleaves");
				
			}
			
					
					
					
					
			
			
					
					
}




