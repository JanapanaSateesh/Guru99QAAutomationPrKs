package guru99.qa.helpers;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

	WebDriver driver;
	
	public Helpers(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getTitle() {
		String currentTitle= driver.getTitle();
		return currentTitle;
	}
	
	public String getAlertMessage() {
		String getAlertMessage= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return getAlertMessage;
	}
	
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public String getVisibleText(WebElement element) {
		return element.getText();
	}
	
	public String generateCurrentDate() {
		   DateTimeFormatter formatter =
		            DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		    return LocalDateTime.now().format(formatter);
	}
	
	public void ExplicitWait(WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
