package testCases;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AddTalentPage;
import pageObjects.FindTalentPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class CreateTalent extends BaseClass {
//	public FindTalentPage Fp;
//	public LoginPage Lp;
//	public AddTalentPage Ap;
	String filepath = "C:\\Users\\rrkumar\\Downloads\\Elton_Odonnell.pdf";

//	@BeforeMethod
//	public void setup() {
//		Lp = new LoginPage(driver);
//		Fp = new FindTalentPage(driver);
//		Ap = new AddTalentPage(driver);
//	}

	@Test(groups = { "Sanity", "Master", "Regression" })
	public void SalesforceLogin() {

		logger.info("SalesforceLogin Test case started ");

		Lp.Username(p.getProperty("Username"));

		Lp.Password(p.getProperty("password"));
		Lp.Loginbtn();
		logger.info("Logged in to connected");
		logger.info("SalesforceLogin Test case executed ");

	}

	@Test(groups = { "Sanity", "Master", "Regression" })
	public void validateConnectedTitle() throws AWTException {
		try {
			String title = Fp.FindTalentPageTitle();
			Assert.assertEquals(title, "Home | Salesforce");
			logger.info("Title Validated");
			logger.info(p.getProperty("JobTitle"));
			scrollToElement(Fp.FindorAddTalent());
			jsclickElement(Fp.FindorAddTalent());
			inputTextToElement(Fp.FirstName(), getrandomString(9));
			inputTextToElement(Fp.LastName(), getrandomString(9));
			click(Fp.Search());
			Thread.sleep(2000);
			scrollToElement(Fp.AddTalentResume());
			Fp.AddTalentResume().click();
			click(Fp.UploadFile());
			Thread.sleep(5000);
			uploadFile(filepath);
			Thread.sleep(5000);
			logger.info(Fp.ResumeDoc());
			click(Fp.Save());
			Thread.sleep(30000);
			Fp.AddNewTalent();

			//Thread.sleep(10000);
			// scrollToElement(Ap.Jobtitle());
			//Ap = new AddTalentPage(driver);
			Fp.Location(p.getProperty("Location"));
			sendKeysUsingJavaScript(Ap.Location(),p.getProperty("Location"));
			//inputTextToElement(Fp.Location(), p.getProperty("Location"));
			processWebElements(Fp.LocSugg(), p.getProperty("Location"));
			inputTextToElement(Ap.Jobtitle(), p.getProperty("JobTitle"));
			processWebElements(Ap.JobSugg(), p.getProperty("JobTitle"));

			// Assert.assertTrue(true);
			// Assert.assertTrue();
		} catch (Exception e) {
			Assert.fail();
			logger.debug("Test Case Failed");

		}
		logger.info(" Login Test Case Finished");
	}

}
