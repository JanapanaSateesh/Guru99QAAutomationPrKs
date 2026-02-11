package guru99.qa.functionaltests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import guru99.qa.pages.CustomerRegistrationPage;
import guru99.qa.pages.HomePage;
import guru99.qa.pages.LoginPage;
import guru99.qa.pages.NewCustomerPage;
import guru99.qa.utilities.ExcelDataProvider;
import guru99.qa.utilities.TestNGListners;


public class CustomerCreationTests extends BaseTest {
	LoginPage loginpageobject;
//This is comment from Kaushik Branch

	@Test(priority = 1, enabled = true,groups = {"regression","smoke","customerCreation"} ,dataProviderClass = ExcelDataProvider.class, dataProvider = "GetNewCustomerTestData_TC001")
	public void CreateNewCustomerAndVerify(String customername,
			String dob,
			String address,
			String city,
			String state,
			String pin,
			String mobileNumber,
			String password
			
			) {
		loginpageobject=new LoginPage(driver);
		HomePage homepageobject= loginpageobject.LoginWithValidCredentials(uname, pwd);
		NewCustomerPage newcustomerpageobject= homepageobject.NavigateToNewCustomerPage("New Customer");
		CustomerRegistrationPage registraionpageobject= newcustomerpageobject.CreateNewCustomerAndVerify(customername,dob,address,
				city,state,pin,mobileNumber,password
				);
		registraionpageobject.VerifyCustomerRegisteredSuccessfulAndGetCustomerID();

	}
	
	@Test(priority = 2, enabled = true,groups = {"sanity","regression","customerCreation"} ,dataProviderClass = ExcelDataProvider.class, dataProvider = "GetNewCustomerTestData_TC001")
	public void CreateNewCustomer_WithoutEmailField(
			String customername,
			String dob,
			String address,
			String city,
			String state,
			String pin,
			String mobileNumber,
			String password
			) {
		loginpageobject=new LoginPage(driver);
		HomePage homepageobject= loginpageobject.LoginWithValidCredentials(uname, pwd);
		NewCustomerPage newcustomerpageobject= homepageobject.NavigateToNewCustomerPage("New Customer");
	   newcustomerpageobject.VerifyCustomerCreationWithoutEmail(customername,dob,address,
				city,state,pin,mobileNumber,password);
		
	}
	
	@Test(priority = 3, enabled = true,groups= {"sanity","regression"})
	public void CreateNewCustomer_VerifyCustomerNameWithNumbers() {
		loginpageobject=new LoginPage(driver);
		HomePage homepageobject= loginpageobject.LoginWithValidCredentials(uname, pwd);
		NewCustomerPage newcustomerpageobject= homepageobject.NavigateToNewCustomerPage("New Customer");
	   newcustomerpageobject.VerifyCustomerNameWithNumbers("Sateesh123");
		
	}
}
