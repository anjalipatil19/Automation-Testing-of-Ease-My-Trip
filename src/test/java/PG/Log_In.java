package PG;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class Log_In {
	@FindBy(xpath ="//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i") WebElement e_down_arrow;
	@FindBy(xpath ="//a[normalize-space()='Login or Signup']") WebElement e_sign_up;
	@FindBy(name ="btn_Login") WebElement e_sign_up2;
	@FindBy(xpath ="//*[@id=\"txtEmail\"]") WebElement e_email;
	@FindBy(xpath ="//*[@id=\"shwotp\"]") WebElement e_continue;
	@FindBy(id ="txtEmail1") WebElement e_OTP_enter;
	@FindBy(id ="OtpLgnBtn") WebElement e_OTP_click;
	@FindBy(id ="shwlgnOTP") WebElement e_OTP_LogIN;
	@FindBy(id ="RegValidEmail") WebElement e_Invalid_MailMessage;
	@FindBy(xpath ="//*[@id=\"ValidOtp\"]") WebElement e_ValidOTP_message;
	
	//@FindBy(xpath ="//*[@id=\"shwlgnOTP\"]") WebElement e_LogINWithOTP;
	//@FindBy(id ="shwlgnOTP") WebElement e_LogINWithOTP;
	@FindBy(xpath ="//*[text()='Login with OTP']") WebElement e_LogINWithOTP;
	
	@FindBy(id ="txtEmail2") WebElement e_PWD;
	@FindBy(xpath="//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input") WebElement e_PWD_Login;
	
	//@FindBy(id ="RegValidEmPh") WebElement e_InvalidEmailMobile_message;
	@FindBy(xpath ="(//div[@id='RegValidEmPh'])[1]") WebElement e_InvalidEmailMobile_message;
	//@FindBy(id = "txtPassword") WebElement e_pwd;
	
	//Reset buttons
	@FindBy(xpath="//a[normalize-space()='Reset Password']") WebElement e_reset;
	@FindBy(id="txtEmail5") WebElement e_reset_email;
	@FindBy(xpath="//*[@id=\"forgetpdBox\"]/div[1]/div[2]/div/div[10]/input") WebElement e_reset_continue;
	@FindBy(id ="otpFp") WebElement e_reset_OTP;
	@FindBy(id ="pass") WebElement e_reset_pass;
	@FindBy(xpath="//input[@value='Reset Password']") WebElement e_reset_password;
	@FindBy(id ="shwlgnbx") WebElement e_pass_LogIN;
	
	  public void loginWithOTP(String user) throws Exception{
		  Thread.sleep(1000);
		  e_sign_up.click();
			e_email.clear();
			e_email.sendKeys(user);
			e_continue.click();
			Thread.sleep(1000);
			if(e_OTP_LogIN.isDisplayed())
			{
				e_OTP_LogIN.click();
			}
			Scanner s1 =new Scanner(System.in);
			System.out.println("Enter OTP for Sign in:");
			int otp=s1.nextInt();
			Thread.sleep(9000);		  
			e_OTP_enter.sendKeys(String.valueOf(otp));
			e_OTP_click.click();
			// boolean x=e_ValidOTP_message.isDisplayed();
			boolean x=e_OTP_click.isDisplayed();
			assertTrue(x);
			
	  }
	  public void loginWithPWD(String user, String pwd)throws Exception{
		  Thread.sleep(1000);
		    e_sign_up.click();
			e_email.clear();
			e_email.sendKeys(user);
			e_continue.click();
			Thread.sleep(900);
			e_PWD.sendKeys(pwd);
			e_PWD_Login.click();				
	  }
	  public void loginWithWrongOTP(String user) throws Exception{
		  Thread.sleep(1000);
		  e_sign_up.click();
			e_email.clear();
			e_email.sendKeys(user);
			e_continue.click();
			Thread.sleep(1000);
			if(e_OTP_LogIN.isDisplayed())
			{
				e_OTP_LogIN.click();
			}
			Scanner s1 =new Scanner(System.in);
			System.out.println("Enter your Wrong OTP:");
			int otp=s1.nextInt();
			Thread.sleep(9000);		  
			e_OTP_enter.sendKeys(String.valueOf(otp));
			e_OTP_click.click();
			// boolean x=e_ValidOTP_message.isDisplayed();
			boolean x=e_OTP_click.isDisplayed();
			assertTrue(x);
	  }
	  public void emptyEmail() throws Exception{
		  Thread.sleep(1000);
		  e_sign_up.click();
			//e_email.clear();
			e_continue.click();
			Thread.sleep(1000);
			//Boolean x=e_continue.isDisplayed();
			//assertTrue(x);
			Boolean x=e_continue.isEnabled();
			assertFalse(x);
			
	  }
	  public void reset_pass(String user, String Newpass) throws Exception{
		  Thread.sleep(1000);
		  e_sign_up.click();
			e_email.clear();
			e_email.sendKeys(user);
			e_continue.click();
			Thread.sleep(2000);
			e_reset.click();
			e_reset_email.sendKeys(user);
			e_reset_continue.click();
			Scanner s1 =new Scanner(System.in);
			System.out.println("Enter your OTP:");
			int otp=s1.nextInt();
			Thread.sleep(8000);		  
			e_reset_OTP.sendKeys(String.valueOf(otp));
			e_reset_pass.sendKeys(Newpass);
			Thread.sleep(2000);
			e_reset_password.click();
	  }
	  public void reset_pass_invalid_email(String user) throws Exception{
		  Thread.sleep(1000);
		  e_sign_up.click();
			e_email.clear();
			e_email.sendKeys(user);
			e_continue.click();
			Thread.sleep(1000);
			e_reset.click();
			e_reset_email.sendKeys("anjali");
			e_reset_continue.click();
			Thread.sleep(3000);
			Boolean x=e_reset_continue.isDisplayed();
			assertTrue(x);
	  }
	  public void reset_pass_invalid_OTP(String user, String Newpass) throws Exception{
		  Thread.sleep(1000);
		  e_sign_up.click();
			e_email.clear();
			e_email.sendKeys(user);
			e_continue.click();
			Thread.sleep(900);
			if (e_pass_LogIN.isDisplayed()) {
				e_pass_LogIN.click();
			}
			e_reset.click();
			e_reset_email.sendKeys(user);
			e_reset_continue.click();
			Scanner s1 =new Scanner(System.in);
			System.out.println("Enter your Wrong OTP:");
			int otp=s1.nextInt();
			Thread.sleep(6000);		  
			e_reset_OTP.sendKeys(String.valueOf(otp));
			e_reset_pass.sendKeys(Newpass);
			Thread.sleep(2000);
			e_reset_password.click();
			Thread.sleep(4000);
			
	  }
		
}
