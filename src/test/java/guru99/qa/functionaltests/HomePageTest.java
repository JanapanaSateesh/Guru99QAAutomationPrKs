package guru99.qa.functionaltests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import guru99.qa.pages.HomePage;
import guru99.qa.pages.LoginPage;
import guru99.qa.utilities.TestNGListners;


public class HomePageTest extends BaseTest {
	LoginPage loginpageobject;

	@Test(groups = {"sanity","regression","home"})
	public void TC006_VerifyAllMenuItemsAreVisible() throws InterruptedException {
		loginpageobject=new LoginPage(driver);
		HomePage homepageobject= loginpageobject.LoginWithValidCredentials(uname, pwd);
		String[] MenuItems= {"New Customer","Edit Customer", "Delete Customer"};
		homepageobject.verifyIsAllMenuItemsVisible(MenuItems);

	}
	
}
