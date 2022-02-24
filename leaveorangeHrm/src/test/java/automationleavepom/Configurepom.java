package automationleavepom;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;
import propertiesfile.pageobjectmodel.Loginpage;
import propertiesfile.pomtest.Configurepage;

public class Configurepom extends OrangeHrmloginandlogout {

	@Test(priority = 8,dataProvider = "editleavesperiod")

	public void editLeave(String username,String password,String month,String date,String day,String week) throws Exception {
		
//openBrowser
		
		Loginpage ellp=new Loginpage(driver);
		ellp.orangelogin(username, password);
	
//editleaveperiod
		
		Configurepage elporange=new Configurepage(driver);
		elporange.editLeav();
		elporange.editMonthLeavep(month);
		elporange.editStartDatelp(date);
		elporange.saveEditReset();
		elporange.leaveTypes(day);
		elporange.lTy();
		elporange.editWorkweek();
		elporange.editW(week);
		
		

		
		
				
		
//closebrowser
		
		//CloseOrange editlp=new CloseOrange(driver);
		//editlp.closeOrange();
	
		
		
	}
	
	@DataProvider(name="editleavesperiod")
	
		
public Object[][] MultipleaddEntitlements() throws Exception{
		

		return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "configure");
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

}


