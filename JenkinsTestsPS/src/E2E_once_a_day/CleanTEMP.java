package E2E_once_a_day;

import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.Runtime;
public class CleanTEMP {
  @Test
  public void f() {
	  
	  
	 
	  
	  try {
          String[] command = {"cmd.exe", "/c", "Start", "C:\\Users\\vkoloyu\\del.bat"};
          Process p =  Runtime.getRuntime().exec(command);           
      } catch (IOException ex) {
      }
	  
	  
	  
  }
}
