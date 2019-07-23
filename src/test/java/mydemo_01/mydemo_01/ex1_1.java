package mydemo_01.mydemo_01;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

public class ex1_1 {
  @Test
  public void t3() {
	  System.out.println("3");
  }
  @Test
  public void t4() {
	  System.out.println("4");
  } 
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }

}
