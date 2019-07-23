package mydemo_01.mydemo_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewTest5 {
	WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement el1=driver.findElement(By.xpath("//a[text()='Gmail']"));
		Actions act1=new Actions(driver);
		//act1.moveToElement(el1).build().perform();
		act1.contextClick(el1).build().perform();
  }
}