package mydemo_01.mydemo_01;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class windemo1 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://retail.onlinesbi.com/retail/login.htm");
		String win_name1=driver.getWindowHandle();
		System.out.println(win_name1);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//img[@src='/sbijava/retail/images/HomeLoanButton.png']")).click();
		Thread.sleep(5000);
		Set<String> t_windows=driver.getWindowHandles();
		int cnt=t_windows.size();
		System.out.println(cnt);
		for(String s:t_windows)
		{
			driver.switchTo().window(s);
			System.out.println(driver.getWindowHandle());
		}
		driver.findElement(By.linkText("Apply Now")).click();
  }
}
