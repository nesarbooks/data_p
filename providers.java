package Data_provider;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class providers {
	static WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String n, String s) throws InterruptedException {
	  driver.findElement(By.id("email")).sendKeys(n);
	  Thread.sleep(3000);
	  driver.findElement(By.id("pass")).sendKeys(s);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@aria-label='Log In']")).click();
	  Thread.sleep(5000);
	  driver.navigate().back();
	  Thread.sleep(6000);
	  driver.findElement(By.id("email")).clear();
	  Thread.sleep(6000);
	  driver.findElement(By.id("pass")).clear();
	  Thread.sleep(4000);
	  Reporter.log("This is just checking if invalid credentials works or not");
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	new Object[] {"abc@gmail.com", "abc" },
        new Object[] {"def@hotmail.com", "def" },
        new Object[] {"ghi@yahoo.com", "ghi"},
        new Object[] {"5719849347", "jkl"}
    };
  }
  @BeforeClass
  @Parameters("browser")
  public void beforeClass(String browsers) throws Exception {
	    if(browsers.equalsIgnoreCase("chrome")) {
	     System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yoga\\eclipse-workspace\\Automation_aps_code\\Drivers\\chromedriver.exe");
	      driver=new ChromeDriver();
	      driver.navigate().to("https://www.facebook.com");
	      }else if (browsers.equalsIgnoreCase("firefox")){
	         System.setProperty("webdriver.gecko.driver", "C:\\Users\\Yoga\\eclipse-workspace\\Automation_aps_code\\Drivers\\geckodriver.exe");
	         driver=new FirefoxDriver();
	         driver.navigate().to("https://www.facebook.com");
	         
	      }else {
	         throw new Exception("the browser not found");
	      }
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
