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
	
	public WebElement FirstName() {
		return FirstName;
	}
	public WebElement LastName() {
		return LastName;
	}
	public WebElement Location() {
		return Location;
	}
	public WebElement MobilePhone() {
		return MobilePhone;
	}
	public WebElement Email() {
		return Email;
	}
	public WebElement JobTitle() {
		return JobTitle;
	}
	public WebElement CurrentCompany() {
		return CurrentCompany;
	}
	public WebElement SkillComments() {
		 return SkillComments;
	}
	public WebElement Goals_Interests() {
		 return Goals_Interests;
	}
	public WebElement Skills() {
		return  Skills;
	}
	public WebElement PlacementType() {
		return  PlacementType;
	}
	public WebElement Schedule() {
		return Schedule;
	}
	public WebElement WorkPlaceType() {
		return WorkPlaceType;
	}
	public WebElement PreRateLow() {
		return PreRateLow;
	}
	public WebElement PreRateHigh() {
		return PreRateHigh;
	}
	public WebElement PreSalLow() {
		return PreSalLow;
	}
	public WebElement PreSalHigh() {
		return PreSalHigh;
	}
	public WebElement Frequency() {
		return Frequency;
	}
	
	
	public WebElement Currency() {
		return Currency;
	}
	public WebElement BonusAmt() {
		return BonusAmt;
	}
	public WebElement AddCompensation() {
		return AddCompensation;
	}
	public void BonusPerc(String bonusPerc) {
		BonusPerc.sendKeys(bonusPerc);
	}
	
	public WebElement Country() {
		return Country;
	}
	public WebElement State() {
		return State;
	}
	public WebElement City() {
		return City;
	}
	public WebElement G2Comments() {
		return G2Comments;
	}
	
	public WebElement EditSave() {
		return EditSave;
	}
	
	
}

	
	