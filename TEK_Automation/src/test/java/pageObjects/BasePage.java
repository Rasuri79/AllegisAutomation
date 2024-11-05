package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	 WebDriver driver;
	 WebDriverWait wait;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(40)); // 40 seconds wait
		PageFactory.initElements(driver, this);
	}
	
	 // Wait for an element to be visible
    public WebElement waitForElementVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for an element to be clickable
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
 // Wait for an element to be clickable
//    public WebElement waitForElementPresence(WebElement findorAddTalent) {
//        return wait.until(ExpectedConditions.presenceOfElementLocated(findorAddTalent));
//    }
    public void jsscroll( WebElement eleLocator) {
		//this.driver = driver;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll the element into view
		js.executeScript("arguments[0].scrollIntoView(true);", eleLocator);
		// Click the element
		

	}
}
