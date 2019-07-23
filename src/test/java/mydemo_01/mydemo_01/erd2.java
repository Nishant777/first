package mydemo_01.mydemo_01;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class erd2 {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@Test(dataProvider="dp")
  public void f1(String n , String s) {
	  test=extent.createTest("tc_01","Title validation");
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(n);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(s);
      driver.findElement(By.xpath("//input[@name='Login']")).click();
      String e="Home";
	  String a=driver.getTitle();
	  Assert.assertEquals(e,a);
	  driver.findElement(By.xpath("//a[contains(text(),'SignOut')]")).click();
	  driver.close();
  }
  @AfterMethod
  public void getResult(ITestResult result) throws IOException
  {
	 if(result.getStatus()==ITestResult.FAILURE)
	 {
		 test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
		 TakesScreenshot snapshot = (TakesScreenshot)driver;
		 File src=snapshot.getScreenshotAs(OutputType.FILE);
		 String Path= System.getProperty("user.dir")+"/test-output/screens/"+result.getName()+".png";
		 FileUtils.copyFile(src,new File(Path));
		 test.addScreenCaptureFromPath(Path, result.getName());
		 test.fail(result.getThrowable());
	 }
	 else if(result.getStatus()==ITestResult.SUCCESS)
	 {
		 test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ",ExtentColor.GREEN));
	 }
	 else
	 {
		 test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ",ExtentColor.ORANGE));
		 test.skip(result.getThrowable());
	 }
  }
  @Parameters({"OS","browser"})
  @BeforeTest
  public void startReport(String os,String browser)
  {
	  htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
	  extent=new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  extent.setSystemInfo("OS",os);
	  extent.setSystemInfo("browser",browser);
//	  htmlReporter.config().setCharVisibilityOnOpen(true);
	  htmlReporter.config().setDocumentTitle("Extent Report Demo");
	  htmlReporter.config().setReportName("Test Report");
//	  htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	  htmlReporter.config().setTheme(Theme.STANDARD);
	  htmlReporter.config().setTimeStampFormat("EEEE,MMMM,dd,yyyy,hh:mm a'('zzz')'");
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Nishant", "asdfghjkl" },
      new Object[] { "qwerty", "bqwerty" },
    };
  }
}