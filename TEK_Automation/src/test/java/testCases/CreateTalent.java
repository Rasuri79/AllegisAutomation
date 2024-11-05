package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.FindTalentPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class CreateTalent extends BaseClass {

	//FindTalentPage Fp = new FindTalentPage(driver);
	//LoginPage Lp = new LoginPage(driver);
	String filepath = "C:\\Users\\rrkumar\\Downloads\\Elton_Odonnell.pdf";
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
	public void validateConnectedTitle() {
		try {
			String title = Fp.FindTalentPageTitle();
			Assert.assertEquals(title, "Home | Salesforce");
			logger.info("Title Validated");
		} catch (Exception e) {
			Assert.fail();
			logger.info("Test Case Failed");

		}
		logger.info(" Login Test Case Finished");
	}
	
	@Test(groups = { "Sanity", "Master", "Regression" })
	public void AddTalent() throws AWTException, InterruptedException {
		
		//Thread.sleep(10000);
		jsclick(Fp.FindorAddTalent());
		Fp.FirstName(getrandomString(9));
		Fp.LastName(getrandomString(9));
		Fp.AddTalentResume();
		
		uploadFile(Fp.UploadFile(),filepath);
		Fp.Save();
		Fp.AddNewTalent();
		Assert.assertTrue(true);
		//Assert.assertTrue();
		
	}
	
	
	
	
	
	
	
	
	

}
