package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindTalentPage extends BasePage {

	public FindTalentPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//a[@title='Find or Add Talent']")
	private WebElement FindorAddTalent;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][1]//label//following-sibling::input")
	private WebElement FirstName;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][2]//label//following-sibling::input")
	private WebElement LastName;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][3]//label//following-sibling::input")
	private WebElement City;

	@FindBy(xpath = "(//div[@role='listbox'])[1]/preceding-sibling::div")
	private WebElement State;

	@FindBy(xpath = "(//div[@role='listbox'])[2]/preceding-sibling::div")
	private WebElement Country;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][6]//label//following-sibling::input")
	private WebElement Postalcode;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][7]//label//following-sibling::input")
	private WebElement Phone;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][7]//label//following-sibling::input")
	private WebElement Email;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][7]//label//following-sibling::input")
	private WebElement PreferredFirstName;

	@FindBy(xpath = "//div[contains(@class,'slds-size_1-of-5')][7]//label//following-sibling::input")
	private WebElement TalentId;

	@FindBy(xpath = "//button[@title='Search']")
	private WebElement Search;

	@FindBy(xpath = "//div[@class='vp-width'][1]//*[name()='svg']")
	private WebElement AddTalentResume;

	@FindBy(xpath = "(//*[name()='svg'][@class='slds-button__icon slds-button__icon_left'])[3]")
	private WebElement UploadFile;

	@FindBy(xpath = "(//span[@class='slds-form-element__label slds-m-left_medium'])[1]")
	private WebElement ResumeDoc;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	private WebElement Save;

	@FindBy(xpath = "//button[normalize-space()='Add a New Talent']")
	private WebElement AddNewTalent;
	
	@FindBy(xpath = "//input[@id='googleLookup_Add']")
	private WebElement Location;
	
	@FindBy(xpath = "//span[contains(@class,'option-text_entity')]")
	private List<WebElement> LocSugg;
	
	@FindBy(xpath = "//input[@class='search-input']")
	private WebElement Jobtitle;

	@FindBy(xpath = "//li[contains(@class,'slds-p-left_small')]")
	private List<WebElement> JobSugg;
	
	public void Location(String loc) {
		 Location.sendKeys(loc);
	}
	public List<WebElement> LocSugg() {
		return LocSugg;
	}
	
	public WebElement FindorAddTalent() {
		return FindorAddTalent;

	}

	public void FirstName(String fname) {
	 FirstName.sendKeys(fname);
	}

	public void LastName(String lname) {
		LastName.sendKeys(lname);
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

	public void Search() {
		 Search.click();
	}

	public WebElement AddTalentResume() {
		return AddTalentResume;
	}

	public WebElement UploadFile() {
	 //UploadFile.click();
	 return UploadFile;
	 
	}

	public String ResumeDoc() {
		return ResumeDoc.getText();
	}

	public WebElement Save() {
		//Save.click();
		return Save;
	}

	public void AddNewTalent() {
		AddNewTalent.click();

	}

	public String FindTalentPageTitle() {
		return driver.getTitle();
	}
	
	public void Jobtitle(String title) {
		 Jobtitle.sendKeys(title);
	}
	public List<WebElement> JobSugg() {
		return JobSugg;
	}

}
