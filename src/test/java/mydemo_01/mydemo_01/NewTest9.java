package mydemo_01.mydemo_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewTest9 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement el1=driver.findElement(By.xpath("//input[@name='q']"));
		Actions act1=new Actions(driver);
		act1.keyDown(el1,Keys.ALT).sendKeys("accenture").keyUp(Keys.ALT).build().perform();
		Thread.sleep(5000);
		act1.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
  }
  }