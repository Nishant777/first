package mydemo_01.mydemo_01;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewTest8 {
	WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		WebElement el1=driver.findElement(By.xpath("//span[text()='AboutUs']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(el1).build().perform();
		WebElement el2=driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/a/span"));
		Actions act2=new Actions(driver);
		act2.moveToElement(el2).build().perform();
		driver.findElement(By.linkText("Bangalore")).click();
		Set<String> t_windows=driver.getWindowHandles();
		for(String s:t_windows)
		{
			driver.switchTo().window(s);
			//System.out.println(driver.getWindowHandle());
		}
		driver.switchTo().frame(driver.findElement(By.name("main_page")));
		String qq=driver.findElement(By.xpath("/html/body/div[1]/div/div/div")).getText();
		System.out.println(qq);
		}
}