package guru99.qa.functionaltests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import guru99.qa.utilities.ReadConfigData;

public class BaseTest {
	WebDriver driver;
	ReadConfigData readconfigdataobj;
	
	String url="";
	String browser="";
	String uname="";
	String pwd="";
	

	@BeforeMethod(alwaysRun = true)
	public void SetUp(ITestContext context) throws IOException {
		readconfigdataobj=new ReadConfigData();
		url=readconfigdataobj.getPropertyValue("url");
		browser=readconfigdataobj.getPropertyValue("browser");
		uname=readconfigdataobj.getPropertyValue("username");
		pwd=readconfigdataobj.getPropertyValue("password");
		
		switch(browser.toLowerCase()) {
		case "chrome": driver=new ChromeDriver();
		break;
		
		case "edge":driver=new EdgeDriver();
		break;
		
		case "ie": driver=new InternetExplorerDriver();
		break;
		
		default : throw new IllegalArgumentException("Please enter correct browsername");
		
		}
		
		//WebDR driver=new ChromeDriver();
		context.setAttribute("driver", driver);
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod(alwaysRun = true)
	public void TearDown() {
		driver.quit();
	}
}
