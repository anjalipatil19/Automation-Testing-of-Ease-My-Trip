package PG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameWork.Excel;
import PG.SignUP;

public class Runner_data_driven {
	public WebDriver driver;
	 @Test(dataProvider = "dp")
	  public void SignUP(long user) throws Exception {
		 //System.out.println(user);
		 driver.get("https://www.easemytrip.com/");
		  Actions ac = new Actions(driver);
		  WebElement e= driver.findElement(By.xpath("//*[@id=\"myTopnav\"]/div[2]/div[4]/div[2]/i"));
		  ac.moveToElement(e).perform();
		  Thread.sleep(1000);
		  SignUP lp= PageFactory.initElements(driver, SignUP.class);
		  String s =Long.toString(user);
		  lp.doRegister(s);	  
		  ac.moveToElement(e).perform();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[text()='Log Out']")).click();  
	  }

	  @DataProvider
	  public Object[][] dp() throws Exception {
		  Excel ex = new Excel("src/test/resources/data/loginData.xlsx");
		  Object data[][] = new Object[ex.getRowNum("Sheet1")][ex.getColNum("Sheet1")];
		  for(int i = 0 ; i<data.length ; i++){
			  
			  long temp=(long)ex.getNumericData("Sheet1", i, 0);
			  //String temp =ex.getData("Sheet1", i+1, 0);
			  data[i][0] = temp;
			 
		  }
		  //long temp1=(long)ex.getNumericData("Sheet1", 2, 0);
		  //System.out.println("  "+temp1);
		return data;
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
