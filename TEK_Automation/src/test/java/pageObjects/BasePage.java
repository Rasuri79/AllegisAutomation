package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	 WebDriver driver;
	// WebDriverWait wait;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		//this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(40)); // 40 seconds wait
		PageFactory.initElements(driver, this);
	}
	
	
   
}
