package mydemo_01.mydemo_01;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
public class myprog05 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'SignUp')]")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("rmmgsdfh");
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
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("rmmgsdfh");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'SignOut')]")).click();
		
	}

}