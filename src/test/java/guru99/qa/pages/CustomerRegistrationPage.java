package guru99.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import guru99.qa.helpers.Helpers;
import guru99.qa.utilities.TestNGListners;
import junit.framework.Assert;

public class CustomerRegistrationPage extends Helpers {
	WebDriver driver;
	ExtentTest test;

	public CustomerRegistrationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@id='customer']//td//p")
	private WebElement getCustomerRegistrationSuccessmessage;
	
	@FindBy(xpath="//td[contains(text(),'Customer ID')]//following-sibling::td")
	private WebElement getCustomerID;
	
	
	public void VerifyCustomerRegisteredSuccessfulAndGetCustomerID() {
		test=TestNGListners.extentThreadLocal.get();
		
		ExplicitWait(getCustomerRegistrationSuccessmessage);
		
		String actualCustomerRegistrationmsg= getVisibleText(getCustomerRegistrationSuccessmessage);
		test.info("Actual Registration Message: "+actualCustomerRegistrationmsg);
		Assert.assertEquals("Customer Registered Successfully", actualCustomerRegistrationmsg);
		test.info("Registration verification is success");
		String CustomerID= getVisibleText(getCustomerID);
		test.info("Extracted Customer ID: "+CustomerID);
		Assert.assertNotNull(CustomerID);
		test.info("Verified Customer ID is not null");
		System.out.println("CustomerID: "+CustomerID);
		
	}
	
	
	
}
