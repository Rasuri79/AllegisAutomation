
package testBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.FindTalentPage;
import pageObjects.LoginPage;

public class BaseClass {

	public Logger logger; // log4j
	public Properties p;
	public static WebDriver driver;
	public FindTalentPage Fp;
	public LoginPage Lp;

	// Set WebDriver (used for initializing the driver in tests)
	public static void setDriver(WebDriver driver) {
		BaseClass.driver = driver;
	}

	// Get WebDriver (used for retrieving the driver instance)
	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeClass(groups = { "Sanity", "Master", "Regression" })
	@Parameters({ "browser" }) // values comming from parameters in testng.xml
	public void setup(String br) throws IOException {

		// initiating and assining class to logger
		logger = LogManager.getLogger(this.getClass());

		// Reading the config file from location
		FileReader File = new FileReader("./src//test//resources//Config.properties");

		p = new Properties();
		// loading the file
		p.load(File);
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.notifications", 2); // 2 means block notifications

		switch (br.toLowerCase()) {
		case "chrome":
			ChromeOptions Chroptions = new ChromeOptions();
			Chroptions.setExperimentalOption("prefs", prefs);
			// Exclude the 'enable-automation' switch to prevent detection
			Chroptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
             // Add more options if necessary
			Chroptions.addArguments("--disable-blink-features=AutomationControlled"); // Prevents detection of WebDriver
			// Chroptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(Chroptions);
			break;
		case "firefox":
			FirefoxOptions Fireoptions = new FirefoxOptions();
			Fireoptions.addPreference("prefs", prefs);
			driver = new FirefoxDriver(Fireoptions);
			break;
		case "edge":
			EdgeOptions Edgeoptions = new EdgeOptions();
			Edgeoptions.setExperimentalOption("prefs", prefs);
			driver = new EdgeDriver(Edgeoptions);
			break;
		default:
			System.out.println("invalid browser");
			return;
		}
		// Set the WebDriver instance using the setDriver method
		setDriver(driver);

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(p.getProperty("appURL")); // reading URL from config properties file
		driver.manage().window().maximize();
		Lp = new LoginPage(driver); // Initialize your page objects
		Fp = new FindTalentPage(driver);

	}

	@AfterClass(groups = { "Sanity", "Master", "Regression" })
	public void teardown() {
		if (driver != null) {
			driver.quit(); // Quit the WebDriver
		}
	}

	public String getrandomString(int n) {

		return RandomStringUtils.randomAlphabetic(n);
	}

	public String getrandomNumber(int n) {

		return RandomStringUtils.randomNumeric(n);
	}

	public String getAlphaNumeric(int n) {

		String generatedString = RandomStringUtils.randomAlphabetic(n);
		String generatedNumber = RandomStringUtils.randomNumeric(n);

		return (generatedString + "*$#" + generatedNumber);
	}

	public String CaptureScreenShot(String tname) {

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;

		File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);
		String targetfilepath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timestamp + ".png";
		File targetfile = new File(targetfilepath);
		sourcefile.renameTo(targetfile);
		return targetfilepath;
	}

	public static void processWebElements(List<WebElement> element, String target) {
		// TODO Auto-generated method stub
		for (WebElement x : element) {
			if (x.getText().toLowerCase().equals(target.toLowerCase())) {
				x.click(); // Click the matched element
				break; // Exit the loop after clicking
			}
		}

	}

	public void jsclick(WebElement eleLocator) {
		// this.driver = driver;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll the element into view
		js.executeScript("arguments[0].scrollIntoView(true);", eleLocator);
		// Click the element
		js.executeScript("arguments[0].click();", eleLocator);

	}

	// Method to upload a file using the Robot class
	public void uploadFile(WebElement fileloader, String filePath) throws AWTException {
		// Click the upload button
		fileloader.click();

		// Create a Robot instance
		Robot robot = new Robot();

		// Set the file path to be copied to the clipboard
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		// Paste the file path
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Press Enter to confirm the file selection
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
