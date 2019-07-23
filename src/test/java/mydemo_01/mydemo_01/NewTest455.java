package mydemo_01.mydemo_01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class NewTest455 {
  @Test
  public void workbook() throws IOException {
	  XSSFWorkbook wk1=new XSSFWorkbook();
	  FileOutputStream out=new FileOutputStream(new File("sd.xlsx"));
	  wk1.write(out);
	  out.close();
  }
}
