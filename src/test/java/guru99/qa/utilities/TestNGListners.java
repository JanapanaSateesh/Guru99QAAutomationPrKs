package guru99.qa.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestNGListners implements ITestListener {
	
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	

	
	
	
	public static ThreadLocal<ExtentTest> extentThreadLocal=new ThreadLocal<ExtentTest>();
	
	public void ConfigureReport()
	{
		htmlreporter=new ExtentSparkReporter("./Reports/SummaryReport.html");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setDocumentTitle("Guru99 Regression Report");
		
		reports=new ExtentReports();
		
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Author", "Conginzant QA Team");
	}
	
	public void EndReport()
	{
		reports.flush();
	}	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Start execuetd.");
		ConfigureReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start execuetd.");
		test=reports.createTest(result.getName());
		extentThreadLocal.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success execuetd.");
		test=extentThreadLocal.get();
		test.log(Status.PASS, result.getName()+"is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure execuetd.");
		String errormessage=result.getThrowable().getMessage();
		test.fail(errormessage);
		test=extentThreadLocal.get();
		
		WebDriver driver= (WebDriver) result.getTestContext().getAttribute("driver");
		String base64Image=TakeScreenCapture(driver);
		test.addScreenCaptureFromBase64String(base64Image);
		
		test.log(Status.FAIL, result.getName()+"is Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}



	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Test Finish execuetd.");
		EndReport();
	}
	
  public String TakeScreenCapture(WebDriver driver) {
	  
	  String base64Image= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	  return base64Image;
	  
  }
	

	
}
