package guru99.qa.functionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import guru99.qa.pages.HomePage;
import guru99.qa.pages.LoginPage;
import guru99.qa.utilities.TestNGListners;


public class LoginTests extends BaseTest {
	LoginPage loginpageobj;

	@Test(priority = 1, groups = {"smoke","regression","login"})
	public void TC001_LoginWithValidCredentials() {
		loginpageobj=new LoginPage(driver);
		HomePage homepgaeobj= loginpageobj.LoginWithValidCredentials(uname,pwd);
		homepgaeobj.VerifyTitle("Guru99 Bank Manager HomePage");

	}
	
	@Test(priority = 2, groups = {"sanity","regression","login"})
	public void TC002_LoginWithValidUsernameAndInValidPwd() {
		loginpageobj=new LoginPage(driver);
		 loginpageobj.LoginWithValidUserNameAndInValidPassword(uname,"Test@123","User or Password is not valid");

	}
}
