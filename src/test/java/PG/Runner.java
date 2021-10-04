package PG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Runner {
	WebDriver driver;
	
	 @Test(enabled=false, description="Login with OTP")
	  public void TC_01_LoginWithOTP() throws Exception {
		  driver.get("https://www.easemytrip.com/");
		  Actions ac = new Actions(driver);
		  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
		  ac.moveToElement(e).perform();
		  Thread.sleep(1000);
		  Log_In lp= PageFactory.initElements(driver, Log_In.class);
		  lp.loginWithOTP("7757862996");	    
		  ac.moveToElement(e).perform();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[text()='Log Out']")).click();  
	  }
	  @Test(enabled=false)
	  public void TC_02_LoginWithPWD() throws Exception {
		  driver.get("https://www.easemytrip.com/");
		  Actions ac = new Actions(driver);
		  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
		  ac.moveToElement(e).perform();
		  Log_In lp= PageFactory.initElements(driver,  Log_In.class);
		  lp.loginWithPWD("rupalipatil161982@gmail.com","Rupali");	    
		  ac.moveToElement(e).perform();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[text()='Log Out']")).click();  
	  }
	  @Test(enabled=false)
	  public void TC_03_LoginWithWrongOTP() throws Exception {
		  driver.get("https://www.easemytrip.com/");
		  Actions ac = new Actions(driver);
		  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
		  ac.moveToElement(e).perform();
		  Log_In lp= PageFactory.initElements(driver,  Log_In.class);
		  lp.loginWithWrongOTP("anjalipatil7757@gmail.com");	     
	  }
	  @Test(enabled=true, description="reset password with invalid email")
	  public void TC_04_reset_password() throws Exception {
		  driver.get("https://www.easemytrip.com/");
		  driver.manage().deleteAllCookies();
		  driver.navigate().refresh();
		  Actions ac = new Actions(driver);
		  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
		  ac.moveToElement(e).perform();
		  Thread.sleep(1000);
		  Log_In lp= PageFactory.initElements(driver, Log_In.class);
		  lp.reset_pass("anjalipatil7757@gmail.com","anjali");
		  Thread.sleep(3000);
		  driver.switchTo().alert().accept();
		  
	  }
	 
	 @Test(enabled=true, description="For checking if user is able to reset password")
	  public void TC_05_reset_password_invalid_email() throws Exception {
		  driver.get("https://www.easemytrip.com/");
		  driver.manage().deleteAllCookies();
		  driver.navigate().refresh();
		  Actions ac = new Actions(driver);
		  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
		  ac.moveToElement(e).perform();
		  Thread.sleep(1000);
		  Log_In lp= PageFactory.initElements(driver, Log_In.class);
		  lp.reset_pass_invalid_email("anjalipatil7757@gmail.com");
		    
	  }
	 @Test(enabled=true, description="Reseting password with invalid OTP")
	  public void TC_06_reset_password_invalid_OTP() throws Exception {
		  driver.get("https://www.easemytrip.com/");
		  driver.manage().deleteAllCookies();
		  driver.navigate().refresh();
		  Actions ac = new Actions(driver);
		  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
		  ac.moveToElement(e).perform();
		  Thread.sleep(1000);
		  Log_In lp= PageFactory.initElements(driver, Log_In.class);
		  lp.reset_pass_invalid_OTP("anjalipatil7757@gmail.com","anjali");
		  Thread.sleep(2000);
		  Alert a=driver.switchTo().alert();
		  assertEquals(a.getText(),"invalid OTP!!!!");
		  a.accept();
		    
	  }
	 @Test(enabled=true, description="Checking with empty email")
	  public void TC_07_empty_email() throws Exception {
		  driver.get("https://www.easemytrip.com/");
		  Actions ac = new Actions(driver);
		  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
		  ac.moveToElement(e).perform();
		  Thread.sleep(1000);
		  Log_In lp= PageFactory.initElements(driver, Log_In.class);
		  lp.emptyEmail();
	  }
  @Test(enabled=true, description="Signup functionality")
  public void TC_08_signUP() throws Exception {
	  driver.get("https://www.easemytrip.com/");
	  Actions ac = new Actions(driver);
	  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
	  ac.moveToElement(e).perform();
	  Thread.sleep(1000);
	  SignUP lp= PageFactory.initElements(driver, SignUP.class);
	  lp.doRegister("9527564221");	  
	  ac.moveToElement(e).perform();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[text()='Log Out']")).click();  
  }
  @Test(enabled=true, description="sign up with invalid OTP")
  public void TC_09_invalid_email() throws Exception {
	  driver.get("https://www.easemytrip.com/");
	  Actions ac = new Actions(driver);
	  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
	  ac.moveToElement(e).perform();
	  Thread.sleep(1000);
	  SignUP lp= PageFactory.initElements(driver, SignUP.class);
	  lp.SignUP_WithInvalidEmail("anjali");
  }
  @Test(enabled=true, description="Sign up with invalid OTP")
  public void TC_10_wrongOTP() throws Exception {
	  driver.get("https://www.easemytrip.com/");
	  Actions ac = new Actions(driver);
	  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
	  ac.moveToElement(e).perform();
	  Thread.sleep(1000);
	  SignUP lp= PageFactory.initElements(driver, SignUP.class);
	  lp.wrongOTPValidation("9527564221");	  
	  
  }
  @Test(enabled=true, description="Sign up with without OTP")
  public void TC_11_withoutOTP() throws Exception {
	  driver.get("https://www.easemytrip.com/");
	  Actions ac = new Actions(driver);
	  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
	  ac.moveToElement(e).perform();
	  Thread.sleep(1000);
	  SignUP lp= PageFactory.initElements(driver, SignUP.class);
	  lp.withoutOTPValidation("7757862996");	    
  }
 

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
	  System.setProperty("webdriver.chrome.driver", "src/test/resources/driver2/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() throws Exception{
	  System.out.println("After test");
	  Thread.sleep(3000);
	  driver.quit();  
  }
 
}
