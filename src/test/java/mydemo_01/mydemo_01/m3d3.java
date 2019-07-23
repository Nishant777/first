package mydemo_01.mydemo_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class m3d3 {
	static WebDriver driver;
	public static void main(String[] args) {
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://10.232.237.143:443/TestMeApp");
			driver.manage().window().maximize();
			driver.quit();
	}

}
