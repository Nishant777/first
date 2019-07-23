package mydemo_01.mydemo_01;

import org.testng.annotations.Test;

public class ppt1 {
  @Test(priority=1)
  public void google() {
	  System.out.println("google");
  }
  @Test(priority=2,enabled=false)
  public void facebook() {
	  System.out.println("facebook");
  }
  @Test(priority=3)
  public void twitter() {
	  System.out.println("twitter");
  }
}
