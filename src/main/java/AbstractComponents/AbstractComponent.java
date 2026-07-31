package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	 WebDriverWait wait;
	
	 public AbstractComponent(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	  public void removeAds() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        js.executeScript(
	            "document.querySelectorAll('.adsbygoogle, .grippy-host, iframe[src*=google]').forEach(e => e.remove());"
	        );
	    }
	 public void handleAdsAfterPageLoad() {
		    wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete'"));
		    removeAds();
		}
	 public void getselectByVisibleText(WebElement element, String value) {
	        Select select = new Select(element);
	        select.selectByVisibleText(value);
	    }
	 public void waitForElementToAppear(By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	 public void waitForElementToAppear(WebElement locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(locator));
	    }
	 public void getScroll(WebElement ele) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", ele);
		}
	 public void hover(WebElement product) {
		    Actions actions = new Actions(driver);
		    actions.moveToElement(product).perform();
		}
	 public WebElement waitForElementToBeClickable(By locator) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
	 public WebElement waitForElementToBeClickable(WebElement ele) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    return wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
	 public void handleGoogleVignette() {
		    if (driver.getCurrentUrl().contains("google_vignette")) {
		        driver.navigate().back();
		    }
		}
}
