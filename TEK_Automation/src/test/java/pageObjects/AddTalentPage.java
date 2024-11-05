package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTalentPage extends BasePage {

	public AddTalentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='googleLookup_Add']")
	private WebElement Location;
	
	@FindBy(xpath = "//span[contains(@class,'option-text_entity')]")
	private WebElement LocSugg;
	
	@FindBy(xpath = "//label[contains(@title,'Phone')]/following-sibling::div/input")
	private WebElement Phone;
	

	@FindBy(xpath = "//input[@class='search-input']")
	private WebElement Jobtitle;

	@FindBy(xpath = "//li[contains(@class,'slds-p-left_small')]")
	private WebElement JobSugg;

	@FindBy(xpath = "//div[contains(@class,'1-of-2')]/div[3]//input")
	private WebElement Skillinput;

	@FindBy(xpath = "//div[contains(@class,'slds-is-open')]//ul/li")
	private WebElement SkillSugg;

	
	@FindBy(xpath = "//div[@class='slds-col'][2]//span[normalize-space()='Save']")
	private WebElement Save;

	
	
	@FindBy(xpath = "//span[normalize-space()='Find or Add Talent']")
	private WebElement FindorAddTalent;

	public void Location(String loc) {
		Location.sendKeys(loc);
	}
	public WebElement LocSugg() {
		return LocSugg;
	}
	public void Phone(String phone) {
		Phone.sendKeys(phone);
	}
	public void Jobtitle(String jobtitle) {
		Jobtitle.sendKeys(jobtitle);
	}
	public WebElement JobSugg() {
		return JobSugg;
	}
	public void Skillinput(String skillinput) {
		Skillinput.sendKeys(skillinput);
	}
	public WebElement SkillSugg() {
		return SkillSugg;
	}
	public void Save() {
		Save.click();
	}
	
	
	
}
