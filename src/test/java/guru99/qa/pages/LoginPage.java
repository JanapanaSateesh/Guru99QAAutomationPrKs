package guru99.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import guru99.qa.helpers.Helpers;
import guru99.qa.utilities.TestNGListners;
import junit.framework.Assert;

public class LoginPage extends Helpers {

	

	WebDriver driver;
	ExtentTest test;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[name='uid']")
	private WebElement usernameInput;

	@FindBy(css = "input[name='password']")
	private WebElement passwordInput;
	
	@FindBy(css = "input[name='btnLogin']")
	private WebElement loginBtn;
	
	public HomePage LoginWithValidCredentials(String username, String password) {
		test=TestNGListners.extentThreadLocal.get();
		
		ExplicitWait(usernameInput);
		usernameInput.sendKeys(username);
		test.info("Entered Username: "+username);
		passwordInput.sendKeys(password);
		test.info("Entered Password: "+password);
		loginBtn.click();
		test.info("Click on Login button");
		return new HomePage(driver);
	}
	
	public void LoginWithValidUserNameAndInValidPassword(String username, String wrongpwd, String expectedalertmsg) {
		test=TestNGListners.extentThreadLocal.get();
		
		ExplicitWait(usernameInput);
		usernameInput.sendKeys(username);
		test.info("Entered Username: "+username);
		passwordInput.sendKeys(wrongpwd);
		test.info("Entered Password: "+wrongpwd);
		loginBtn.click();
		test.info("Click on Login button");
		String actualalertmessage=getAlertMessage();
		Assert.assertEquals(actualalertmessage, expectedalertmsg);
		test.info("Verified the error message");
		
	}
}
