package mydemo_01.mydemo_01;

import java.util.concurrent.TimeUnit;
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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class casestudy {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeClass
	public void launch() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		 // driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	}
  @Test(priority=1)
  public void registration() {
	  test = extent.createTest("TC_01","Registration");
	    driver.findElement(By.xpath("//a[contains(text(),'SignUp')]")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("kassihai");
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("qwerty");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("qwerty");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("qwerty");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("qwerty@qwerty.com");
		driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("9874561230");
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("05/15/1985");
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("123 numer asd");
		driver.findElement(By.xpath("//select[@name='securityQuestion']")).sendKeys("What is your Birth Place");
		driver.findElement(By.xpath("//input[@name='answer']")).sendKeys("qwerty");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
  }
  @Test(priority=2)
  public void testLogin() throws InterruptedException {
	  test = extent.createTest("TC_02","login");
	  //Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("kassihai");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		//Thread.sleep(5000);
	      String e="Home";
		  String a=driver.getTitle();
		  Assert.assertEquals(e,a);
		  System.out.println("Login Is Successful");
		
  }
  @Test(priority=3)
  public void testCart() throws InterruptedException {
	  test = extent.createTest("TC_03","cart");
	WebElement a=driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"));
	Actions act1=new Actions(driver);
	act1.moveToElement(a).build().perform();
	WebElement a1=driver.findElement(By.xpath("//span[text()='Electronics']"));
	Actions act2=new Actions(driver);
	act2.moveToElement(a1).build().perform();
	driver.findElement(By.xpath("//span[text()='Electronics']")).click();
	//Thread.sleep(7000);
	driver.findElement(By.xpath("//span[text()='Head Phone']")).click();
	//Thread.sleep(5000);
	driver.findElement(By.xpath("//a[contains(text(),' Add to cart')]")).click();
	//Thread.sleep(5000);
	driver.findElement(By.xpath("//a[contains(text(),' Cart')]")).click();
  }
  @Test(priority=4)
  public void testpayment() throws InterruptedException {
	  test=extent.createTest("TC_04","Test Payment");
	 // Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Checkout ')]")).click();//payment
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		//Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@456");
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='PayNow']")).click();
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
  @BeforeTest
  public void startReport()
  {
	  htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
	  extent=new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  htmlReporter.config().setDocumentTitle("Extent Report Demo 1");
	  htmlReporter.config().setReportName("Test Report");
	  htmlReporter.config().setTheme(Theme.STANDARD);
	  htmlReporter.config().setTimeStampFormat("EEEE,MMMM,dd,yyyy,hh:mm a'('zzz')'");
  }
  

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}
