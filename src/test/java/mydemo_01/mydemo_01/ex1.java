package mydemo_01.mydemo_01;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

public class ex1 {
	  @BeforeMethod
	  public void beforeMethod() {
	  System.out.println("Before Method");
	  }
	@Test
  public void t1() {
	  System.out.println("1");
  }
  @Test
  public void t2() {
	  System.out.println("2");
  }
  @Test
  public void t5() {
	  System.out.println("5");
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }

}
