package dayly_check;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search {
 
	
	WebDriver driver;
	
	
	
	  @Test (priority=1)
	  public void acorn1() {
		  Cookie name = new Cookie("LB", "acorn1");
			driver.manage().addCookie(name);
		  		  Seearch();
		  
	  }
	  
	  @Test (priority=2)
	  public void acorn2() {
		  Cookie name = new Cookie("LB", "acorn2");
			driver.manage().addCookie(name);
			 Seearch();
	  }
	  
	  
	  @Test (priority=3)
	  public void acorn3() {
		  Cookie name = new Cookie("LB", "acorn3");
			driver.manage().addCookie(name);
			 Seearch();
	  }
	  
	  
	  public void Seearch () {
		  driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/ul/li[2]/a/span")).click();
		  
		  driver.findElement(By.id("prog_input_header")).sendKeys("algebra");
			driver.findElement(By.id("prog_input_header")).sendKeys(Keys.RETURN);
		
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.pearsonschool.com");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='site-content']/div/div/div[1]/h1")).getText(), "Search");
		  
		  Set<Cookie> cookiesList =  driver.manage().getCookies();
			for(Cookie getcookies :cookiesList) {
				
				if (getcookies.getName().contains("LB")) {
			    System.out.println(getcookies.getName() +"  "+ getcookies.getValue() +" SEARCH");
				}else {}
			}
		  driver.close();
	  }

	}
