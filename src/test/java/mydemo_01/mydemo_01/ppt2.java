package mydemo_01.mydemo_01;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ppt2 {
  @Test(dataProvider="login")
  public void loginmethod(String n,String s) {
	  System.out.println("user is "+n);
	  System.out.println("password is "+s);
  }  
  @DataProvider
  public Object[][] login() {
    return new Object[][] {
      new Object[] { "user111", "abcdef" },
      new Object[] { "user222", "qwerty" },
    };
}
}

 