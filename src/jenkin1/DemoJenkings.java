package jenkin1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoJenkings {

	@Test
	public void testJ(){
		
		System.out.println("done whoooooooooooo");
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle());
        System.out.println(driver.getTitle());
        driver.quit();
		
		
	}
}
