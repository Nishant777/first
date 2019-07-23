package mydemo_01.mydemo_01;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class windemo2 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/htdocs/common/onlineservices/netbankingloginsafe_nri.htm");
		String win_name1=driver.getWindowHandle();
		System.out.println(win_name1);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/htdocs/nri_banking/accounts/fixed_deposits/fixed_deposits.htm']")).click();
		Thread.sleep(5000);
		Set<String> t_windows=driver.getWindowHandles();
		int cnt=t_windows.size();
		System.out.println(cnt);
		for(String s:t_windows)
		{
			driver.switchTo().window(s);
			System.out.println(driver.getWindowHandle());
		}
		driver.findElement(By.xpath("//img[@src='/htdocs/nri_banking/product_page/images/primnav/loans.gif']")).click();
		String a= driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[4]/div[2]/ul[1]/li[1]")).getText();
		String e="Attractive interest rates";
		if (a.equals(e))
		System.out.println("SAME");
  }
  }
