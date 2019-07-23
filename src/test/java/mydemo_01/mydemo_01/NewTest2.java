package mydemo_01.mydemo_01;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class NewTest2 {
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
	  System.out.println("user "+n);
	  System.out.println("password "+s);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Nishant", "a" },
      new Object[] { "Ranjan", "b" },
    };
  }
 @AfterMethod
 public void logout() {
	 System.out.println("Code for Logout");
 }
@BeforeMethod
public void h() {
	 System.out.println("Code");
}
 }
