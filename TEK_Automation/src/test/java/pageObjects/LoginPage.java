package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath = "//input[@id='username']")
	 WebElement Username;
	
	@FindBy(xpath = "//input[@id='password']")
	 WebElement Password;
	
	@FindBy(xpath = "//input[@id='Login']")
	 WebElement Loginbtn;
	
	public void Username(String user) {
		//Username.clear();
		Username.sendKeys(user);
	}
	public void Password(String pwd) {
		//Password.clear();
		Password.sendKeys(pwd);
	}
	public void Loginbtn() {
		Loginbtn.click();
	}
	
	public String HomepageTitle() {
		return driver.getTitle();
	}

}
