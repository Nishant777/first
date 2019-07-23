package mydemo_01.mydemo_01;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

public class NewTest {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeClass
	public void launch() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		 driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	}
  @Test(priority=1)
  public void registration() {
	    driver.findElement(By.xpath("//a[contains(text(),'SignUp')]")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("caesqqqy");
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
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("caesqqqy");
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
	//Thread.sleep(5000);
	driver.findElement(By.xpath("//a[contains(text(),'Checkout ')]")).click();
	//Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	//Thread.sleep(7000);
	driver.findElement(By.xpath("//*[@id=\"swit\"]/div[2]/div/label/i")).click();
	//Thread.sleep(5000);
	driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
	//Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123457");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@457");
	driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	//Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@457");
	driver.findElement(By.xpath("//input[@value='PayNow']")).click();
  }
}