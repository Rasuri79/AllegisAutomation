package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindTalentPage extends BasePage {

	public FindTalentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@title='Find or Add Talent']")
	WebElement FindorAddTalent;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][1]//label//following-sibling::input")
	private WebElement FirstName;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][2]//label//following-sibling::input")
	WebElement LastName;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][3]//label//following-sibling::input")
	WebElement City;

	@FindBy(xpath = "(//div[@role='listbox'])[1]/preceding-sibling::div")
	WebElement State;

	@FindBy(xpath = "(//div[@role='listbox'])[2]/preceding-sibling::div")
	WebElement Country;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][6]//label//following-sibling::input")
	WebElement Postalcode;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][7]//label//following-sibling::input")
	WebElement Phone;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][7]//label//following-sibling::input")
	WebElement Email;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][7]//label//following-sibling::input")
	WebElement PreferredFirstName;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][7]//label//following-sibling::input")
	WebElement TalentId;

	@FindBy(xpath = "//button[@title='Search']")
	WebElement Search;

	@FindBy(xpath = "//div[@class='vp-width'][1]//*[name()='svg']")
	WebElement AddTalentResume;

	@FindBy(xpath = "(//*[name()='svg'][@class='slds-button__icon slds-button__icon_left'])[3]")
	WebElement UploadFile;

	@FindBy(xpath = "(//span[@class='slds-form-element__label slds-m-left_medium'])[1]")
	WebElement ResumeDoc;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement Save;

	@FindBy(xpath = "//button[normalize-space()='Add a New Talent']")
	WebElement AddNewTalent;
	
	@FindBy(xpath = "//input[@id='googleLookup_Add']")
	private WebElement Location;
	
	@FindBy(xpath = "//span[contains(@class,'option-text_entity')]")
	private List<WebElement> LocSugg;
	
	public void Location(String loc) {
		 Location.sendKeys(loc);;
	}
	public List<WebElement> LocSugg() {
		return LocSugg;
	}
	
	public WebElement FindorAddTalent() {
		return FindorAddTalent;

	}

	public WebElement FirstName() {
		return FirstName;
	}

	public WebElement LastName() {
		return LastName;
	}

	public void City(String city) {
		City.sendKeys(city);
	}

	public void State(String state) {
		State.sendKeys(state);
	}

	public void Country(String country) {
		Country.sendKeys(country);
	}

	public void Postalcode(String postalcode) {
		Postalcode.sendKeys(postalcode);
	}

	public void Email(String email) {
		Email.sendKeys(email);
	}

	public void Phone(String phone) {
		Phone.sendKeys(phone);
	}

	public void PreferredFirstName(String preFirstName) {
		PreferredFirstName.sendKeys(preFirstName);
	}

	public void TalentId(String talentId) {
		TalentId.sendKeys(talentId);
	}

	public WebElement Search() {
		return Search;
	}

	public WebElement AddTalentResume() {
		return AddTalentResume;
	}

	public WebElement UploadFile() {
		return UploadFile;
	}

	public boolean ResumeDoc() {
		return ResumeDoc.isDisplayed();
	}

	public WebElement Save() {
		return Save;
	}

	public void AddNewTalent() {
		AddNewTalent.click();

	}

	public String FindTalentPageTitle() {
		return driver.getTitle();
	}

}
