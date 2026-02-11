package guru99.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import guru99.qa.helpers.Helpers;
import guru99.qa.utilities.TestNGListners;
import junit.framework.Assert;

public class NewCustomerPage extends Helpers {
	WebDriver driver;
	ExtentTest test;
	
	

	public NewCustomerPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement customerNameInput;
	
	@FindBy(xpath = "//input[@name='dob']")
	private WebElement dobInput;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	private WebElement addressInput;
	
	@FindBy(xpath = "//input[@name='city']")
	private WebElement cityInput;
	
	@FindBy(xpath = "//input[@name='state']")
	private WebElement stateInput;
	
	@FindBy(xpath = "//input[@name='pinno']")
	private WebElement pinNumberInput;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	private WebElement mobileNumberInput;
	
	@FindBy(xpath = "//input[@name='emailid']")
	private WebElement emailInput;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//input[@name='sub']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//label[@id='message']")
	private WebElement invalidInputMessage;
	
	
	
	public CustomerRegistrationPage CreateNewCustomerAndVerify(String customerName,
			String dob,
			String address,
			String city,
			String state,
			String pin,
			String mobileNumber,
			String password
			
			) {
		test=TestNGListners.extentThreadLocal.get();
		
		ExplicitWait(customerNameInput);
		customerNameInput.sendKeys(customerName);
		test.info("Entered Customer Name: "+customerName);
		
		ExplicitWait(dobInput);
		dobInput.sendKeys(dob);
		test.info("Entered DOB: "+dob);
		addressInput.sendKeys(address);
		test.info("Entered Address: "+address);
		cityInput.sendKeys(city);
		test.info("Entered City: "+city);
		stateInput.sendKeys(state);
		test.info("Entered State: "+state);
		pinNumberInput.sendKeys(pin);
		test.info("Entered Pin: "+pin);
		mobileNumberInput.sendKeys(mobileNumber);
		test.info("Entered MobileNumber: "+mobileNumber);
		String currentdate=generateCurrentDate();
		System.out.println("CurrentDate: "+currentdate);
		String email="Test"+currentdate+"@gmail.com";
		emailInput.sendKeys(email);
		test.info("Entered Email: "+email);
		passwordInput.sendKeys(password);
		test.info("Entered Password: "+password);
		submitBtn.click();
		test.info("clicked on Submit Button");
		return new CustomerRegistrationPage(driver);
	}
	
	public void VerifyCustomerCreationWithoutEmail(
			String customerName,
			String dob,
			String address,
			String city,
			String state,
			String pin,
			String mobileNumber,
			String password
			) {
		customerNameInput.sendKeys(customerName);
		dobInput.sendKeys(dob);
		addressInput.sendKeys(address);
		cityInput.sendKeys(city);
		stateInput.sendKeys(state);
		pinNumberInput.sendKeys(pin);
		mobileNumberInput.sendKeys(mobileNumber);
		passwordInput.sendKeys(password);
		submitBtn.click();
		String getActualAlertMessage= getAlertMessage();
		Assert.assertEquals("please fill all fields", getActualAlertMessage);
	}
	
	public void VerifyCustomerNameWithNumbers(String invalidName) {
		customerNameInput.sendKeys(invalidName);
		isElementDisplayed(invalidInputMessage);
	}
	
}
