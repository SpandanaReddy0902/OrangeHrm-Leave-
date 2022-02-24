 package automationleavepom;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import propertiesfile.base.OrangeHrmloginandlogout;
import propertiesfile.excelhelper.Dataproviderexcel;
import propertiesfile.pageobjectmodel.Loginpage;
import propertiesfile.pomtest.Leavelistpage;

public class Leavelistpom extends OrangeHrmloginandlogout {

	@Test(priority = 12,dataProvider = "Searchcancelreset")
	public void searchandCancelandResetleaves(String username,String password,String fromdate,String dateto,String empna) throws Exception {
		//openbrowser
		
		Loginpage sercanres=new Loginpage(driver);
		sercanres.orangelogin(username, password);
		
		//searchandcancelandresetleaves
		
		 Leavelistpage scr=new  Leavelistpage(driver);	
		 scr.serachle();
		 scr.leavef(fromdate);
		 scr.leavet(dateto);
		 scr.leaveeee(empna);
		
		//closebrowser

		//CloseOrange scrle=new CloseOrange(driver);
		//scrle.closeOrange();
	
	}
	
	@DataProvider(name="Searchcancelreset")
	public Object[][] MultipleaddEntitlements() throws Exception{
		
		return Dataproviderexcel.getTest("./src/main/java/propertiesfile/exceldata/Leave.xlsx", "searchandcancelandreset");
		
	}

}

	
	
	
	

