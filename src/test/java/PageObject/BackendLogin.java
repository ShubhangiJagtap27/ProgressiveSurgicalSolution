package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BackendLogin extends BasePage {
	
	BackendLogin bl;
	public BackendLogin(WebDriver driver) {
		super(driver);
	

}
	public void loginToAdmin(WebDriver driver, String baseURL, String adminUsername, String adminPassword)
			throws Exception {
		
		bl = new BackendLogin(driver);
		driver.get(baseURL);
//		driver.get(baseURL+"/wp-admin");
		bl.AdminUsername.sendKeys(adminUsername);
 		bl.AdminPassword.sendKeys(adminPassword);
 		bl.Loginbutton.click();
	}
	

	 @FindBy(xpath="//span[normalize-space()='Login']")
	 public WebElement FrontendLoginBtn;
	 
	 @FindBy(xpath="//input[@autocomplete='username']")
	 public WebElement AdminUsername;
	 
	 @FindBy(xpath="//input[@type='password']")
	 public WebElement AdminPassword;
	 
	 @FindBy(xpath="//input[@value='Log In']")
	 public WebElement Loginbutton;
	 
	 
}
