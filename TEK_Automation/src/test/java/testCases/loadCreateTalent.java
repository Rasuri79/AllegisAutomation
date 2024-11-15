package testCases;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AddTalentPage;
import pageObjects.FindTalentPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class loadCreateTalent extends BaseClass {

	String filepath = "C:\\Users\\rrkumar\\Downloads\\ress_res.pdf";
	String SuccessMsg;
	List<String> skillsList;

	@Test(groups = { "Sanity", "Master", "Regression" })
	public void SalesforceLogin() throws InterruptedException {

		logger.info("SalesforceLogin Test case started ");

		Lp.LoadLogin();
		logger.info("Logged in to connected");
		logger.info("SalesforceLogin Test case executed ");

	}

	@Test(dependsOnMethods = { "SalesforceLogin" }, groups = { "Sanity", "Master", "Regression" })
	public void Talentcreation() throws AWTException {
		try {
			// Thread.sleep(10000);
			logger.info("Talentcreation testcase started");
//			String title = Fp.FindTalentPageTitle();
//			Assert.assertEquals(title, "Home | Salesforce");
//			logger.info("Title Validated");
			isClickable(Fp.FindorAddTalent(), 5);
			scrollToElement(Fp.FindorAddTalent());
			jsclickElement(Fp.FindorAddTalent());
			Fp.FirstName(getrandomString(9));
			Fp.LastName(getrandomString(9));
			Fp.Search();

			scrollToElement(Fp.AddTalentResume());
			Fp.AddTalentResume().click();
			isDisplayed(Fp.UploadFile(), 5);

			Fp.UploadFile().click();
			Thread.sleep(5000);
			uploadFile(filepath);
			logger.info(Fp.ResumeDoc());
			isDisplayed(Fp.Save(), 20);
			Fp.Save().click();
			Thread.sleep(15000);
			// isDisplayed(Fp.AddNewTalent(), 20);
			scrollToElement(Fp.AddNewTalent());
			Fp.AddNewTalent().click();
			Ap.Location(p.getProperty("Location"));
			selectAutoSugg(Ap.LocSugg(), p.getProperty("Location"));
			Ap.Jobtitle(p.getProperty("JobTitle"));
			selectAutoSugg(Ap.JobSugg(), p.getProperty("JobTitle"));
			skillsList = Arrays.asList("java", "selenium");

			for (String skill : skillsList) {
				Ap.Skillinput(skill);
				selectAutoSugg(Ap.SkillSugg(), skill);
			}
			scrollToElement(Ap.Save());
			Ap.Save().click();
			isDisplayed(Ap.ToastMsg(), 2);

			SuccessMsg = Ap.ToastMsg().getText();
			Assert.assertEquals(SuccessMsg, "Success!");
			logger.info(SuccessMsg);

		} catch (Exception e) {
			Assert.fail();
			logger.debug("Talentcreation Test Case Failed", e.getMessage());

		}
		logger.info(" Talentcreation Test Case Finished");
	}

	@Test(dependsOnMethods = { "Talentcreation" }, groups = { "Sanity", "Master", "Regression" })
	public void EditTalent() throws InterruptedException {
		try {
		logger.info(" EditTalent test case is started");
		// Thread.sleep(10000);
		isClickable(Ap.Editbtn(), 10);
		// scrollToElement(Ap.Editbtn());
		jsclickElement(Ap.Editbtn());
		Thread.sleep(3000);
		enterTextIfEmpty(Ep.FirstName(), getrandomString(9));
		enterTextIfEmpty(Ep.LastName(), getrandomString(9));
		enterTextIfEmpty(Ep.MobilePhone(), getrandomNumber(10));
		enterTextIfEmpty(Ep.Email(), p.getProperty("email"));
		enterTextIfEmpty(Ep.JobTitle(), p.getProperty("JobTitle"));
		enterTextIfEmpty(Ep.CurrentCompany(), p.getProperty("CurrentCompany"));
		enterTextIfEmpty(Ep.SkillComments(), p.getProperty("SkillComments"));
		enterTextIfEmpty(Ep.Goals_Interests(), p.getProperty("Goals_Interests"));
		// enterTextIfEmpty(Ep.PlacementType(),p.getProperty("PlacementType"));
		enterTextIfEmpty(Ep.Schedule(), p.getProperty("Schedule"));
		enterTextIfEmpty(Ep.WorkPlaceType(), p.getProperty("WorkPlaceType"));
		enterTextIfEmpty(Ep.PreRateLow(), p.getProperty("PreRateLow"));
		enterTextIfEmpty(Ep.PreRateHigh(), p.getProperty("PreRateHigh"));
		enterTextIfEmpty(Ep.PreSalLow(), p.getProperty("PreSalLow"));
		enterTextIfEmpty(Ep.PreSalHigh(), p.getProperty("PreSalHigh"));
		enterTextIfEmpty(Ep.Frequency(), p.getProperty("Frequency"));
		enterTextIfEmpty(Ep.Currency(), p.getProperty("Currency"));
		enterTextIfEmpty(Ep.BonusAmt(), p.getProperty("BonusAmt"));
		enterTextIfEmpty(Ep.AddCompensation(), p.getProperty("AddCompensation"));
		//enterTextIfEmpty(Ep.Country(), p.getProperty("Country"));
		//enterTextIfEmpty(Ep.State(), p.getProperty("State"));
		enterTextIfEmpty(Ep.City(), p.getProperty("City"));
		enterTextIfEmpty(Ep.G2Comments(), p.getProperty("G2Comments"));
		scrollToElement(Ep.EditSave());
		jsclickElement(Ep.EditSave());
		// Ep.EditSave().click();

		} catch (Exception e) {
			Assert.fail();
			logger.debug("EditTalent Test Case Failed", e.getMessage());

		}
		logger.info(" EditTalent Test Case Finished");
	}
}