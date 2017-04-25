package E2E_once_a_day;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PS_PNP {
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
		  driver.findElement(By.id("prog_input")).sendKeys("60622");
			Select dropdown = new Select(driver.findElement(By.id("prog_results")));
			Thread.sleep(1000);
			dropdown.selectByIndex(2);
			Thread.sleep(1000);
			driver.findElement(By.id("prog_input")).sendKeys("math");
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='prog_results']/li[3]/a")).click();
			
			driver.findElement(By.id("cart_quantity1")).sendKeys("4");
			
			driver.findElement(By.id("cartSubmit")).click();
		  
		  
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.pearsonschool.com/index.cfm?locator=PS1t3p");
			
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  
		  
		  
		  Set<Cookie> cookiesList =  driver.manage().getCookies();
			for(Cookie getcookies :cookiesList) {
				
				if (getcookies.getName().contains("LB")) {
			    System.out.println(getcookies.getName() +"  "+ getcookies.getValue() + " E2E PS");
				}else {}
			}
			
			driver.findElement(By.xpath(".//input[@title='Guest Checkout']")).click();
			
			Assert.assertEquals(driver.getTitle(), "Pearson Education Address Page");
		 
			driver.close();
	  }

	}
