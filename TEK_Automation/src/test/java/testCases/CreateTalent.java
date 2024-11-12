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

	@Test(groups = { "Sanity", "Master", "Regression" })
	public void SalesforceLogin() {

		logger.info("SalesforceLogin Test case started ");

		Lp.Username(p.getProperty("Username"));

		Lp.Password(p.getProperty("password"));
		Lp.Loginbtn();
		logger.info("Logged in to connected");
		logger.info("SalesforceLogin Test case executed ");

	}

	@Test(dependsOnMethods = { "SalesforceLogin" }, groups = { "Sanity", "Master", "Regression" })
	public void CreateTalent() throws AWTException {
		try {
//			String title = Fp.FindTalentPageTitle();
//			Assert.assertEquals(title, "Home | Salesforce");
//			logger.info("Title Validated");
//			logger.info(p.getProperty("JobTitle"));
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
			processWebElements(Ap.LocSugg(), p.getProperty("Location"));
			Ap.Jobtitle(p.getProperty("JobTitle"));
			processWebElements(Ap.JobSugg(), p.getProperty("JobTitle"));
			List<String> skillsList = Arrays.asList("java", "python", "selenium");

			for (String skill : skillsList) {
				Ap.Skillinput(skill);
				processWebElements(Ap.SkillSugg(), skill);
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

	@Test(dependsOnMethods = { "CreateTalent" },groups = { "Sanity", "Master", "Regression" })
	public void EditTalent() {

	}
}
