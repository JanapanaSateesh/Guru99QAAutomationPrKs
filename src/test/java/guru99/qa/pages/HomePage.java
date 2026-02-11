package guru99.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import guru99.qa.helpers.Helpers;

public class HomePage extends Helpers{

	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getMenuItem(String MenuName) {
		WebElement menuelement=driver.findElement(By.xpath("//a[text()='"+MenuName+"']"));
		return menuelement;
	}
	

	public void VerifyTitle(String expectedTitle) {
		String currentTitle=getTitle();
		Assert.assertEquals(currentTitle, expectedTitle);
		
	}
	
	
	public void verifyIsAllMenuItemsVisible(String[] menuItem) throws InterruptedException {
		Thread.sleep(4000);
		
		for(String menu:menuItem) {
			Assert.assertTrue(isElementDisplayed(getMenuItem(menu)));
		}	
		
	}
	
	public NewCustomerPage NavigateToNewCustomerPage(String NavigatePageName) {
		getMenuItem(NavigatePageName).click();
		return new NewCustomerPage(driver);
	}
	

	
	 
}
