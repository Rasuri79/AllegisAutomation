
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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.AddTalentPage;
import pageObjects.FindTalentPage;
import pageObjects.LoginPage;

public class BaseClass {

	public Logger logger; // log4j
	public Properties p;
	public static WebDriver driver;
	public FindTalentPage Fp;
	public LoginPage Lp;
	public AddTalentPage Ap;
	public WebDriverWait wait;

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
//		setDriver(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100)); // 40 seconds wait
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get(p.getProperty("appURL")); // reading URL from config properties file
		driver.manage().window().maximize();
		Lp = new LoginPage(driver); // Initialize your page objects
		Fp = new FindTalentPage(driver);
		Ap = new AddTalentPage(driver);

	}

	@AfterClass(groups = { "Sanity", "Master", "Regression" })
	public void teardown() {
		if (driver != null) {
			driver.quit(); // Quit the WebDriver
		}
	}

	
	// Click an element using a WebElement
	public void jsclick(WebElement element) {

		scrollToElement(element); // Scroll to the element before clicking
		jsclickElement(element);
	}

	public void inputTextToElement(WebElement element, String text) {
		// wait.until(ExpectedConditions.visibilityOf(element));
		// element.clear();
		element.sendKeys(text);
	}

	// Send keys to a WebElement
	public void jssendKeys(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		scrollToElement(element); // Scroll to the element before sending keys
		element.clear();
		sendKeysUsingJavaScript(element, text);
	}

	// Scroll to the element using JavaScript
	public void scrollToElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void jsclickElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		
		jsExecutor.executeScript("arguments[0].click();", element);

	}

	public static void sendKeysUsingJavaScript(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// JavaScript code to set the value of the input field

		js.executeScript("arguments[0].value = arguments[1];", element, text); // Execute JavaScript
	}

	public void clickButton(WebElement buttonLocator ) {
       
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        button.click();
    }

//    // Method to get an element's visibility
//    public boolean isElementVisible(WebElement elevisible) {
//       
//        try {
//            WebElement element = wait.until(ExpectedConditions.visibilityOf(elevisible));
//            return element.isDisplayed();
//        } catch (TimeoutException e) {
//            return false;
//        }
//    }

//    // Method to check presence of an element in the DOM
//    public boolean isElementPresent(WebElement elementloc) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try {
//            WebElement element = wait.until(ExpectedConditions.(elementloc));
//            return element != null;
//        } catch (TimeoutException e) {
//            return false;
//        }
//    }

    // Method to handle alert presence
//    public void handleAlert() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try {
//            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//            alert.accept();  // Accept the alert
//        } catch (TimeoutException e) {
//            System.out.println("No alert present.");
//        }
//    }

	
	
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

	

	// Method to upload a file using the Robot class
	public void uploadFile(String filePath) throws AWTException {
		

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
	
	
	public boolean isDisplayed(WebElement element, int duration) {
        boolean flag = false;
        try {
            // Explicit wait for the element to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wait.until(ExpectedConditions.visibilityOf(element));  // Wait until element is visible
            flag = true;  // Element is visible
        } catch (Exception e) {
            // Log failure message if element is not visible
            logger.info("Element not visible after " + duration + " seconds: " + element.toString());
        }
        return flag;
    }
	
	public void enterTextIfEmpty(WebElement element,String text) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));

	    String currentText = element.getAttribute("value");

	    if (currentText == null || currentText.trim().isEmpty()) {
	    	element.sendKeys(text);
	    } else {
	        // Optionally, clear the field before entering new text
	    	element.clear();  // Clears the input field
	    	element.sendKeys(text);  // Send the new text
	    }
	}

}
