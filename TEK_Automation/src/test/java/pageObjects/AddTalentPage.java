package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTalentPage extends BasePage {

	public AddTalentPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//input[@id='googleLookup_Add']")
	private WebElement Location;
	
	@FindBy(xpath = "//span[contains(@class,'option-text_entity')]")
	private List<WebElement> LocSugg;
	
	@FindBy(xpath = "//label[contains(@title,'Phone')]/following-sibling::div/input")
	private WebElement Phone;
	

	@FindBy(xpath = "//input[@class='search-input']")
	 private WebElement Jobtitle;

	@FindBy(xpath = "//li[contains(@class,'slds-p-left_small')]")
	private List<WebElement> JobSugg;

	@FindBy(xpath = "//div[contains(@class,'1-of-2')]/div[3]//input")
	private WebElement Skillinput;

	@FindBy(xpath = "//div[contains(@class,'slds-is-open')]//ul/li")
	private List<WebElement> SkillSugg;

	
	@FindBy(xpath = "//div[@class='slds-col'][2]//span[normalize-space()='Save']")
	private WebElement Save;

	
	
	@FindBy(xpath = "//div[@class='toastTitle slds-text-heading--small']")
	private WebElement ToastMsg;

	public void Location(String loc) {
		Location.sendKeys(loc);
	}
	public List<WebElement> LocSugg() {
		return LocSugg;
	}
	public void Phone(String phone) {
		Phone.sendKeys(phone);
	}
	public void Jobtitle(String title) {
		 Jobtitle.sendKeys(title);
	}
	public List<WebElement> JobSugg() {
		return JobSugg;
	}
	public void Skillinput(String skillinput) {
		Skillinput.clear();
		Skillinput.sendKeys(skillinput);
	}
	public List<WebElement> SkillSugg() {
		return SkillSugg;
	}
	public WebElement Save() {
	   return 	Save;
	}
	public WebElement ToastMsg() {
		   return 	ToastMsg;
		}
	
	
}
