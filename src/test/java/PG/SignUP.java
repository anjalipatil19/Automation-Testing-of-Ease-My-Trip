package PG;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.Scanner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignUP {
	@FindBy(xpath ="//*[@id=\\\"myTopnav\\\"]/div[2]/div[4]/div[2]/i") WebElement e_down_arrow;
	@FindBy(id ="shwlogn") WebElement e_sign_up;
	@FindBy(name ="btn_Login") WebElement e_sign_up2;
	@FindBy(xpath ="//*[@id=\"txtEmail\"]") WebElement e_email;
	@FindBy(xpath ="//*[@id=\"shwotp\"]") WebElement e_continue;
	@FindBy(id ="txtEmail1") WebElement e_OTP_enter;
	@FindBy(id ="OtpLgnBtn") WebElement e_OTP_click;
	@FindBy(id ="shwlgnOTP") WebElement e_OTP_LogIN;
	@FindBy(id ="RegValidEmail") WebElement e_Invalid_MailMessage;
	@FindBy(xpath ="//*[@id=\"ValidOtp\"]") WebElement e_ValidOTP_message;
	@FindBy(id ="shwlgnOTP") WebElement e_LogINWithOTP;
	@FindBy(id ="txtEmail2") WebElement e_PWD;
	@FindBy(xpath="//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input") WebElement e_PWD_Login;
	
	//@FindBy(id ="RegValidEmPh") WebElement e_InvalidEmailMobile_message;
	@FindBy(xpath ="(//div[@id='RegValidEmPh'])[1]") WebElement e_InvalidEmailMobile_message;
	//@FindBy(id = "txtPassword") WebElement e_pwd;
	//public WebDriver driver;
	
	public void doRegister(String user) throws Exception
	{
		e_sign_up.click();
		e_email.clear();
		e_email.sendKeys(user);
		e_continue.click();
		Thread.sleep(500);
		  Scanner s1 =new Scanner(System.in);
		  System.out.println("Enter your OTP for Sign UP:");
		  int otp=s1.nextInt();
		  Thread.sleep(9000);		  
		  e_OTP_enter.sendKeys(String.valueOf(otp));
		  e_OTP_click.click();
	}	
	public void SignUP_WithInvalidEmail(String user) throws Exception
	{
		Thread.sleep(1000);
		e_sign_up.click();
		e_email.clear();
		e_email.sendKeys(user);
		e_continue.click();
		//assertTrue(e_Invalid_MailMessage.isDisplayed());
		//String msg=e_Invalid_MailMessage.getText();
		//assertEquals("* Enter a valid Email",msg);
		//System.out.println(e_Invalid_MailMessage.getText());
		
		Thread.sleep(1000);
		Boolean x=e_continue.isDisplayed();
		assertTrue(x);
	}
	public void wrongOTPValidation(String user) throws Exception{
		e_sign_up.click();
		e_email.clear();
		e_email.sendKeys(user);
		e_continue.click();
		  Scanner s1 =new Scanner(System.in);
		  System.out.println("Enter your Wrong OTP :");
		  int otp=s1.nextInt();
		  Thread.sleep(9000);		  
		  e_OTP_enter.sendKeys(String.valueOf(otp));
		  e_OTP_click.click();
		  //String msg=e_ValidOTP_message.getText();
		  //System.out.println(msg);
		  //assertEquals("* Enter the valid OTP.",msg);
		  
		  Thread.sleep(1000);
		  Boolean x=e_OTP_click.isDisplayed();
			assertTrue(x);
	}
	public void withoutOTPValidation(String user) throws Exception{
		Thread.sleep(600);
		e_sign_up.click();
		e_email.clear();
		e_email.sendKeys(user);
		e_continue.click();
		 
		Thread.sleep(2000);		  
		e_OTP_click.click();
		//String msg=e_ValidOTP_message.getText();
		//System.out.println(msg);
		//assertEquals("* Enter the valid OTP.",msg);
		Thread.sleep(1000);
		Boolean x=e_OTP_click.isDisplayed();
		assertTrue(x);
	}
		
}
