package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import testBase.BaseClass;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // UI of the Report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest Test; // creating test case entries in the report and update status of the test
							// methods

	String repName;

	public void onStart(ITestContext testcontext) {

	/*	SimpleDateFormat Df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String currentdatetimestamp = Df.format(dt);*/

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //timestamp
		
		
		repName = "Test-Report-" + timestamp + ".html";

		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);//specify location of the report
		sparkReporter.config().setDocumentTitle("Automation Report"); //Title of the report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("computer Name", "localHost");
		extent.setSystemInfo("Environment ", "QA");
		extent.setSystemInfo("Tester Name ", System.getProperty("user.name"));

		String os = testcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);

		String browser = testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String> includedGroups = testcontext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}

	}

	public void onTestSuccess(ITestResult result) {
		Test = extent.createTest(result.getClass().getName()); // create new entry into the report
		Test.assignCategory(result.getMethod().getGroups()); // diplay groups in report
		Test.log(Status.PASS, "Test Case passed is " + result.getName()); // update status
	}

	public void onTestFailure(ITestResult result) {
		Test = extent.createTest(result.getClass().getName()); // create new entry int the report
		Test.assignCategory(result.getMethod().getGroups()); // diplay groups in report
		Test.log(Status.FAIL, "Test Case Failed is " + result.getName()); // update status
		Test.log(Status.INFO, "Test Case Failed cause is " + result.getThrowable().getMessage());

		try {
			String imppath = new BaseClass().CaptureScreenShot(result.getName());
			Test.addScreenCaptureFromPath(imppath);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		Test = extent.createTest(result.getName()); // create new entry int he report
		Test.log(Status.SKIP, "Test Case passed is " + result.getName()); // update status
		Test.log(Status.INFO, "Test Case Failed cause is " + result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {
		extent.flush();

		String pathofextentReport = System.getProperty("user.dir") + ".\\reports\\" + repName;
		File extentReport = new File(pathofextentReport);

		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

//		
//		try {
//			
//			URL url = new URL("file:///"+System.getProperty("user.dir")+".\\reports\\"+ repName);
//			
//			//create the email message
//			ImageHtmlEmail  email = new ImageHtmlEmail();
//			email.setDataSourceResolver(new DataSourceUrlResolver(url));
//			email.setHostName("smtp.googlemail.com");
//			email.setSmtpPort(465);
//			email.setAuthenticator(new DefaultAuthenticator("rasuri79@gmail.com","password'"));
//			email.setSSLOnConnect(true);
//			email.setFrom("rasuri79@gmail.com");//sender
//            email.setSubject("Test Results");
//            email.setMsg("please find attached report");
//            email.addTo("rajk.kumar218@gmail.com");//Receiver
//            email.attach(url,"extent report","please check report");
//            email.send();
//		}	catch(Exception e1)
//		{
//			e1.printStackTrace();
//		}

	}

}
