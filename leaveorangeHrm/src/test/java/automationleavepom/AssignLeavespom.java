package automationleavepom;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;
import propertiesfile.pageobjectmodel.Loginpage;
import propertiesfile.pomtest.Assignleavespom;

public class AssignLeavespom extends OrangeHrmloginandlogout {
	@Test(priority = 13,dataProvider = "assignleave")
	public void assignLeave(String username,String password,String name,String leavetype,String fromdate,String todate) throws Exception {
	
		//openbrowser
		
		Loginpage alle=new Loginpage(driver);
		alle.orangelogin(username, password);
		
		//Assignleave
		
		Assignleavespage aaa=new Assignleavespage(driver);
		aaa.assignLeaves();
		aaa.assignl(name, leavetype);
		aaa. assignle(fromdate);
		aaa.assignleave(todate);
		
		//CloseBrowser
		
	    //CloseOrange assl=new CloseOrange(driver);
	    //assl.closeOrange();
	
	}

@DataProvider(name="assignleave")

public Object[][] MultipleaddEntitlements() throws Exception{
	
	 return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "assignleaves");	
		
	}
	

}


