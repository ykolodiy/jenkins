/*
 * this script find and buy product in home school
 * 
 * del temp after you done 
 * create bat file:
 * del /q "C:\Users\vkoloyu\AppData\Local\Temp\*"
   FOR /D %%p IN ("C:\Users\vkoloyu\AppData\Local\Temp\*.*") DO rmdir "%%p" /s /q
 * 
 */

package E2E_once_a_day;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PS_HOMESCHOOL {
	WebDriver driver;

	  @Test (priority=1)
	  public void acorn1() throws Exception {
		  Cookie name = new Cookie("LB", "acorn1");
			driver.manage().addCookie(name);
			LaunchMethod ();
	  }
	  
	  @Test (priority=2)
	  public void acorn2() throws Exception {
		  Cookie name = new Cookie("LB", "acorn2");
			driver.manage().addCookie(name);
			LaunchMethod ();
	  }
	  
	  
	  @Test (priority=3)
	  public void acorn3() throws Exception {
		  Cookie name = new Cookie("LB", "acorn3");
			driver.manage().addCookie(name);
			LaunchMethod ();
	  }
	  
	  
	  public void LaunchMethod () throws Exception {
		  driver.findElement(By.id("prog_input")).sendKeys("tikatok");	
			Thread.sleep(1500);
				
			
			driver.findElement(By.xpath("//div[@id='prog_results_div']//*[@id='prog_results']/li[1]/a")).click();
		
			driver.findElement(By.linkText("Purchase Products")).click();
		
			driver.findElement(By.id("cart_quantity1")).sendKeys("12");
			
			driver.findElement(By.id("cartSubmit")).click();
		  
			Assert.assertEquals(driver.getTitle(), "Homeschool Curriculum: Textbooks, Materials, Lesson Plans & More - Pearson");
	  
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.pearsonhomeschool.com");
			
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  
		  
		  
		  Set<Cookie> cookiesList =  driver.manage().getCookies();
			for(Cookie getcookies :cookiesList) {
				
				if (getcookies.getName().contains("LB")) {
			    System.out.print(getcookies.getName() +"  "+ getcookies.getValue() + " E2E PS HomeSchool");
				}else {}
			}
			
			driver.findElement(By.xpath("//input[@value='Continue to Checkout']")).click();
			
			Assert.assertEquals(driver.getTitle(), "Pearson Education Address Page");
			System.out.println (" OK");
			driver.close();
	  }

	}

