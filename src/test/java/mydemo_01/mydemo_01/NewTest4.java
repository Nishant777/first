package mydemo_01.mydemo_01;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class NewTest4 {
	WebDriver driver;
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  @Test(dataProvider = "cred")
  public void login(String n, String s) throws InterruptedException {
	   // Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'SignIn')]")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(n);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(s);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		String e="Home";
		String a=driver.getTitle();
		if(a.equals(e))
		{
			System.out.println("Login Done and Verified");	
		}	
  }

  @DataProvider
  public Object[][] cred() {
    return new Object[][] {
      new Object[] { "qwerty1", "aqwerty" },
      new Object[] { "qwerty2", "bqwerty" },
      new Object[] { "qwerty3", "cqwerty" },
      new Object[] { "qwerty4", "dqwerty" },
    };
  }
 @AfterMethod
 public void logout() {
	 driver.findElement(By.xpath("//a[contains(text(),'SignOut')]")).click();
 }
@BeforeClass
public void open() {
	System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://10.232.237.143:443/TestMeApp");
}
@AfterClass
public void exit() {
driver.close();
}
 }
