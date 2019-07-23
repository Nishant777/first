package mydemo_01.mydemo_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class framedemo2 {
	WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.tsrtconline.in/oprs-web/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@value='Check Availability']")).click();
		String s= driver.switchTo().alert().getText();
		System.out.println(s);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		driver.close();
  }
}
