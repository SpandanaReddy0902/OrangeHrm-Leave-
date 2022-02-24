package propertiesfile.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Logoutpage {

	
	@FindBy(id="welcome")
	public WebElement Welcome;
	
	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement logout;
	
	
 public Logoutpage(WebDriver driver) {
  PageFactory.initElements(driver, this);
	
	
}


	public void closeOrange() throws Exception {
		
		Welcome.click();
		Thread.sleep(2000);
		//((JavascriptExecutor)driver).executeScript("arguments[0].click", logout);
		logout.click();
		
		
	}
	

}