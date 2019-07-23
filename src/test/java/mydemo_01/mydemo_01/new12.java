package mydemo_01.mydemo_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class new12 {

	public static WebDriver getDriver(String browser) {
		
if (browser.equals("chrome"))
{
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	  return new ChromeDriver();
	} 
else if(browser.equals("ie"))
{
	  System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
	  return new InternetExplorerDriver();
}
else if(browser.equals("ff"))
{
	System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver-v0.24.0-win32\\geckodriver.exe");
	return new FirefoxDriver();
}
else 
	return null;
	}

}
