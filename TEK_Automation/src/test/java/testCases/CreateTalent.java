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

public class CreateTalent extends BaseClass {

	String filepath = "C:\\Users\\rrkumar\\Downloads\\Elton_Odonnell.pdf";
	String SuccessMsg;
	List<String> skillsList;
	@Test(groups = { "Sanity", "Master", "Regression" })
	public void SalesforceLogin() {

		logger.info("SalesforceLogin Test case started ");

		Lp.Username(p.getProperty("Username"));

		Lp.Password(p.getProperty("password"));
		Lp.Loginbtn();
		logger.info("Logged in to connected");
		logger.info("SalesforceLogin Test case executed ");

	}

	@Test(dependsOnMethods = { "SalesforceLogin" },groups = { "Sanity", "Master", "Regression" })
	public void Talentcreation() throws AWTException {
		try {
			//logger.info("Talentcreation testcase started");
			String title = Fp.FindTalentPageTitle();
			Assert.assertEquals(title, "Home | Salesforce");
			logger.info("Title Validated");
			//isClickable(Fp.FindorAddTalent(), 5);
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
			isDisplayed(Fp.Save(), 10);
			Fp.Save().click();
			Ap.Location(p.getProperty("Location"));
			selectAutoSugg(Ap.LocSugg(), p.getProperty("Location"));
			Ap.Jobtitle(p.getProperty("JobTitle"));
			selectAutoSugg(Ap.JobSugg(), p.getProperty("JobTitle"));
			skillsList = Arrays.asList("java","selenium");

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
			logger.debug("Test Case Failed", e.getMessage());

		}
		logger.info(" Login Test Case Finished");
	}

	@Test(dependsOnMethods = { "Talentcreation" },groups = { "Sanity", "Master", "Regression" })
	public void EditTalent() {

	}
}