package mydemo_01.mydemo_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class NewTest454 {
@Test
public void workbookread() throws IOException {
	  File src=new File ("C:\\Users\\training_d2.03.07\\Desktop\\New folder\\mydemo_01\\qaw.xlsx");
	  FileInputStream f=new FileInputStream(src);
	  XSSFWorkbook wk1=new XSSFWorkbook(f);
	  XSSFSheet sheet1=wk1.getSheetAt(0);
	  int row=sheet1.getLastRowNum();
	  System.out.println("Total no of rows is :"+row);
	  for(int i=0;i<=row;i++)
	  {
		  String data=sheet1.getRow(i).getCell(0).getStringCellValue();
		  System.out.println("value is :"+data);
		  String data1=sheet1.getRow(i).getCell(1).getStringCellValue();
		  System.out.println("value is :"+data1);
	  }
	  
	  sheet1.getRow(0).createCell(2).setCellValue("Result");
	  sheet1.getRow(1).createCell(2).setCellValue("Result2");
	  sheet1.getRow(2).createCell(2).setCellValue("Result3");
	  FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\training_d2.03.07\\Desktop\\New folder\\mydemo_01\\qaw.xlsx"));
	  wk1.write(fout);
	  fout.close();
}
}

