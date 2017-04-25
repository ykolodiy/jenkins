package dayly_check;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PSHomePage {
 
	
	WebDriver driver;
	
	
	
	  @Test (priority=1)
	  public void acorn1() {
		  Cookie name = new Cookie("LB", "acorn1");
			driver.manage().addCookie(name);
		  
		  
		  
	  }
	  
	  @Test (priority=2)
	  public void acorn2() {
		  Cookie name = new Cookie("LB", "acorn2");
			driver.manage().addCookie(name);
		    
	  }
	  
	  
	  @Test (priority=3)
	  public void acorn3() {
		  Cookie name = new Cookie("LB", "acorn3");
			driver.manage().addCookie(name);
		  
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.pearsonschool.com");
			
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  Assert.assertEquals(driver.getTitle(), "Instructional Resources | K-12 Education Solutions | Pearson");
		  
		  
		  Set<Cookie> cookiesList =  driver.manage().getCookies();
			for(Cookie getcookies :cookiesList) {
				
				if (getcookies.getName().contains("LB")) {
			    System.out.println(getcookies.getName() +"  "+ getcookies.getValue() + "HOME");
				}else {}
			}
		  driver.close();
	  }

	}
