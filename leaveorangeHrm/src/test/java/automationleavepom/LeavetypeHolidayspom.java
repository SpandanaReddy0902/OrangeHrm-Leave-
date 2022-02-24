package automationleavepom;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;
import propertiesfile.pageobjectmodel.Loginpage;
import propertiesfile.pomtest.ConfigureLeavetypeholidayspage;


public class LeavetypeHolidayspom extends OrangeHrmloginandlogout {
	@Test(priority = 11,dataProvider = "Seeadddeleteholidays")
	public void seeandAddDeleteholidays(String username,String password,String fromdate,String todate,String day,String holidayadd,String holidaylen) throws Exception {

		//openBrowser
		
		Loginpage seead=new Loginpage(driver);
		seead.orangelogin(username, password);
		
		//seeadddelete
		
		ConfigureLeavetypeholidayspage see=new  ConfigureLeavetypeholidayspage(driver);
		see.seeHolidays();
		see.from(fromdate);
		see.to(todate);
		see.addHolidays(day, holidayadd);
		see.seah(holidaylen);
		see.deleteHolidays();
		
	
		//closeorange
		
        //CloseOrange sade=new CloseOrange(driver);
	    //sade.closeOrange();
	
		
		
}

@DataProvider(name="Seeadddeleteholidays")

public Object[][] MultipleaddEntitlements() throws Exception{
	
	return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "seeAdddeleteHoliday");
}
	
}


