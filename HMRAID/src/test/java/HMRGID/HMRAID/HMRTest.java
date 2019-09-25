package HMRGID.HMRAID;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class HMRTest {
   WebDriver bo;
   String bpath="http://apps.qaplanet.in/qahrm/login.php";
	
	//sandy yamini prammi
	@Test
  public void Tc_1() {
		bo.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("qaplanet1");
		bo.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("lab1");
		bo.findElement(By.xpath("//input[@name='Submit']")).click();
		System.out.println(bo.getTitle());
		Assert.assertEquals("OrangeHRM",bo.getTitle());
	}
	@Test
	  public void Tc_2() {
			bo.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("qaplanet1");
			bo.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("lab11");
			bo.findElement(By.xpath("//input[@name='Submit']")).click();
			System.out.println(bo.getTitle());
			Assert.assertEquals("Invalid Login",bo.findElement(By.xpath("//font[contains(text(),'Invalid Login')]")).getText());
		}
	@Parameters("browser")
	@BeforeMethod
  
  public void beforeMethod(String sr) {
	  if(sr.equalsIgnoreCase("ff")){
		  System.setProperty("webdriver.gecko.driver","D:\\selenium\\chrome\\geckodriver.exe");
		  bo=new FirefoxDriver();
		  bo.get(bpath);
	  }
	  else if(sr.equalsIgnoreCase("gg")){
		  
		  System.setProperty("webdriver.chrome.driver","D:\\selenium\\chrome\\chromedriver.exe");
		  bo=new ChromeDriver();
		  bo.get(bpath);
	  }
	  
  }

  @AfterMethod
  public void afterMethod() {
	  bo.close();
  }

}
