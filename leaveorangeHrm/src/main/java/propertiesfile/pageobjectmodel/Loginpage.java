package propertiesfile.pageobjectmodel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage{

@FindBy(id="txtUsername")
public WebElement usernameorange;

@FindBy(id="txtPassword")
public WebElement passwordorange;

@FindBy(id="btnLogin")
public WebElement loginbn;

public Loginpage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	
	
	
}

public void orangelogin(String username,String password) {
	
	usernameorange.sendKeys(username);
	passwordorange.sendKeys(password);
	loginbn.click();
	
}


}

 
