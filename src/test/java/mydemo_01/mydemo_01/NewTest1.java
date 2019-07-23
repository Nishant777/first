package mydemo_01.mydemo_01;

//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NewTest1{
//static WebDriver driver;

  @Test(priority =1)
  public void Registration() 
  {
	  
	  System.out.println("registration");
  }
  @Test(priority =2)
  public void Login() 
  {
	  System.out.println("login");  
  }
  @Test(priority =3,enabled=false)
  public void signout() 
  {
	  System.out.println("signout");
  }
}
