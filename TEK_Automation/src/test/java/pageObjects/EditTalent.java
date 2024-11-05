package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditTalent extends BasePage {

	public EditTalent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//div[contains(@class,'1-of-4')][1]//div[contains(@class,'1-of-2')][1]//input")
	private WebElement FirstName;
	
	@FindBy(xpath = "//div[contains(@class,'1-of-4')][1]//div[contains(@class,'1-of-2')][2]//input")
	private WebElement LastName;
	
	
	@FindBy(xpath = "//input[@id='googleLookup_Edit']")
	private WebElement Location;
	
	@FindBy(xpath = "//label[contains(@title,'email')]//following-sibling::div/input")
	private WebElement MobilePhone;
	
	@FindBy(xpath = "//span[normalize-space()='email']/ancestor::label/following-sibling::input")
	private WebElement Email;
	
	@FindBy(xpath = "//input[@class='search-input']")
	private WebElement JobTitle;
	
	@FindBy(xpath = "//input[contains(@class,'mixedCase search-req-field')]")
	private WebElement CurrentCompany;
	
	@FindBy(xpath = "//div[@id='skills-comments']//textarea")
	private WebElement SkillComments;
	
	@FindBy(xpath = "//div[@id='goals-n-interests']//textarea")
	private WebElement Goals_Interests;
	
	@FindBy(xpath = "//div[contains(@class,'inline-pill-container search-req-field')]//input")
	private WebElement Skills;
	@FindBy(xpath = "//div[contains(@class,'slds-is-hide')]//input")
	private WebElement PlacementType;
	
	@FindBy(xpath = "//div[contains(@class,'2-of-6')][1]//div[contains(@class,'1-of-2')][2]//select")
	private WebElement Schedule;
	
	@FindBy(xpath = "//div[contains(@class,'2-of-6')][1]//div[contains(@class,'x-small')][2]//input")
	private WebElement WorkPlaceType;
	
	@FindBy(xpath = "//div[contains(@class,'1-of-6')][1]//div[contains(@class,'1-of-2')][1]//input")
	private WebElement PreRateLow;
	
	@FindBy(xpath = "//div[contains(@class,'1-of-6')][1]//div[contains(@class,'1-of-2')][2]//input")
	private WebElement PreRateHigh;
	
	@FindBy(xpath = "//div[contains(@class,'1-of-6')][2]//div[contains(@class,'1-of-2')][1]//input")
	private WebElement PreSalLow;
	
	@FindBy(xpath = "//div[contains(@class,'1-of-6')][2]//div[contains(@class,'1-of-2')][2]//input")
	private WebElement PreSalHigh;
	
	@FindBy(xpath = "//div[contains(@class,'1-of-6')][1]//div[contains(@class,'2-of-2')]//select")
	private WebElement Frequency;
	
	@FindBy(xpath = "//div[contains(@class,'1-of-6')][2]//div[contains(@class,'2-of-2')]//select")
	private WebElement Currency;
	
	@FindBy(xpath = "//div[contains(@class,'2')][2]//div[contains(@class,'1')][1]//div[2]//input")
	private WebElement BonusAmt;
	
	@FindBy(xpath = "//div[contains(@class,'2')][2]//div[contains(@class,'1')][1]//div[4]//input")
	private WebElement AddCompensation;
	
	@FindBy(xpath = "//div[contains(@class,'2')][2]//div[contains(@class,'1')][2]/div[2]/input")
	private WebElement BonusPerc;
	
	@FindBy(xpath = "//td[1]//input")
	private WebElement Country;
	
	@FindBy(xpath = "//td[2]//input")
	private WebElement State;
	@FindBy(xpath = "//td[3]//input")
	private WebElement City;
	
	@FindBy(xpath = "//div[contains(@class,'G2')]//textarea")
	private WebElement G2Comments;
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement EditSave;
	
	public void FirstName(String fname) {
		FirstName.sendKeys(fname);;
	}
	public void LastName(String lname) {
		LastName.sendKeys(lname);
	}
	public void Location(String loc) {
		Location.sendKeys(loc);
	}
	public void MobilePhone(String phone) {
		MobilePhone.sendKeys(phone);
	}
	public void Email(String email) {
		Email.sendKeys(email);
	}
	public void JobTitle(String title) {
		JobTitle.sendKeys(title);
	}
	public void CurrentCompany(String company) {
		CurrentCompany.sendKeys(company);
	}
	public void SkillComments(String comments) {
		SkillComments.sendKeys(comments);
	}
	public void Goals_Interests(String Goal) {
		Goals_Interests.sendKeys(Goal);
	}
	public void Skills(String skill) {
		Skills.sendKeys(skill);
	}
	public void PlacementType(String placeType) {
		PlacementType.sendKeys(placeType);
	}
	public void Schedule(String schedule) {
		Schedule.sendKeys(schedule);
	}
	public void WorkPlaceType(String WorkType) {
		WorkPlaceType.sendKeys(WorkType);
	}
	public void PreRateLow(String RateLow) {
		PreRateLow.sendKeys(RateLow);
	}
	public void PreRateHigh(String RateHigh) {
		PreRateHigh.sendKeys(RateHigh);
	}
	public void PreSalLow(String SalLow) {
		PreSalLow.sendKeys(SalLow);
	}
	public void PreSalHigh(String SalHigh) {
		PreSalHigh.sendKeys(SalHigh);
	}
	public void Frequency(String freq) {
		Frequency.sendKeys(freq);
	}
	
	
	public void Currency(String Curr) {
		Currency.sendKeys(Curr);
	}
	public void BonusAmt(String Bonus) {
		BonusAmt.sendKeys(Bonus);
	}
	public void AddCompensation(String Compen) {
		AddCompensation.sendKeys(Compen);
	}
	public void BonusPerc(String bonusPerc) {
		BonusPerc.sendKeys(bonusPerc);
	}
	
	public void Country(String country) {
		Country.sendKeys(country);
	}
	public void State(String state) {
		State.sendKeys(state);
	}
	public void City(String city) {
		City.sendKeys(city);
	}
	public void G2Comments(String G2Comm) {
		G2Comments.sendKeys(G2Comm);
	}
	
	public void EditSave(String Save) {
		EditSave.click();
	}
	
	
}

	
	