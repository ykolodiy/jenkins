package E2E_once_a_day;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PS {
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
		//click search button
			driver.findElement(By.xpath("//*[@class='icon-search']")).click();
			//enter the word to search
			driver.findElement(By.xpath("//*[@id='prog_input_header']")).sendKeys("Literacy");
			//press enter
			driver.findElement(By.xpath("//*[@id='prog_input_header']")).sendKeys(Keys.RETURN);
			Thread.sleep(2000);
			//select 1st value shown
			driver.findElement(By.xpath("//*[@class='programRollupDisplay']//li[1]/div/a")).click();
			Thread.sleep(2000);
			//click overlay proceed to the page
			driver.findElement(By.xpath("//*[@class='aButton buttonArrowRight']")).click();
			Thread.sleep(1000);
			
			
			
			driver.findElement(By.linkText("Shop")).click();
			Thread.sleep(1000);
			
			
			
			
			//select firdt grade
			driver.findElement(By.xpath(".//*[@id='progHeader']/div/div/div/div/ul/li[4]/ul/li[2]/a")).click();
			
			
			
			//select amount of some product
			driver.findElement(By.xpath(".//*[@name='cart_quantity1']")).sendKeys("3");
			//click submit order
			driver.findElement(By.xpath(".//*[@name='cartSubmit']")).click();
			Thread.sleep(1000);
		
			
			//click first element
			
			//driver.findElement(By.xpath("//div[starts-with(@id,'prodItem')][1]/div/strong/a")).click();
		
			
		
			
			//click checkout
			driver.findElement(By.linkText("Checkout")).click();
			Thread.sleep(1000);
			//confirm type of account
			//driver.findElement(By.xpath("//*[@name='Register Checkout']")).click();
		  
		  
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.pearsonschool.com");
			
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  
		  
		  
		  Set<Cookie> cookiesList =  driver.manage().getCookies();
			for(Cookie getcookies :cookiesList) {
				
				if (getcookies.getName().contains("LB")) {
			    System.out.println(getcookies.getName() +"  "+ getcookies.getValue() + " E2E PS");
				}else {}
			}
			
			driver.findElement(By.xpath("//*[@name='Register Checkout']")).click();
			
			Assert.assertEquals(driver.getCurrentUrl(), "https://k12oasis.pearson.com/ordering/oaLogin.aspx");
		 
			driver.close();
	  }

	}
