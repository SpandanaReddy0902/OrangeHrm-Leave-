package automationleavepom;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;
import propertiesfile.pageobjectmodel.Loginpage;
import propertiesfile.pomtest.Reportspage;

public class Reportspom extends OrangeHrmloginandlogout {
	
	@Test(priority = 6,dataProvider = "leavetypereports")
	public void generatereportsonLeaveType(String username,String password,String generate,String tleave,String fromda,String jobTitle,String location,String Subunit,String generateemp,String name) throws Exception {

//open Browser
		
		Loginpage generatereports=new Loginpage(driver);
		generatereports.orangelogin(username, password);
		
//Generate Reports on leavetype
		
		Reportspage reportse=new Reportspage(driver);
		reportse.employeerep();
		reportse.generateReports(generate);
		reportse.leaveTypebalance(tleave);
		reportse.reportsperiod(fromda);
		reportse.reportsJobtitle(jobTitle);
		reportse.reportslocation(location);
		reportse.reportsSubunit(Subunit);
		
//GeneratereportsonemployeetypeGenerateReports
		
		reportse.employeeusagerepo(generateemp);
		reportse.employeereportername(name);
		reportse.employeereportperiod(fromda);
		
//MyLeaveentitlementandusagereport
		
		reportse.leavPeriodselent(fromda);
	
	
				
		
//close Browser

		//CloseOrange generaterep=new CloseOrange(driver);
		//generaterep.closeOrange();
	
		
	}

	@DataProvider(name="leavetypereports")
	public Object[][] reportsLeave() throws Exception{

		return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "Reports");
	}





}


