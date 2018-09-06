package testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.Assert;


public class Assignment1 {
	
	//open a new chrome browser
	WebDriver driver = new ChromeDriver();
	
  @Test(priority=0)
  public void assignment1() {
	  
	  //maximize the browser
	  driver.manage().window().maximize();
	  
	  //navigate to http://qatechhub.com
	  driver.navigate().to("http://qatechhub.com");
	  
	  //Get the title of the page
	  String title = driver.getTitle();//another way to get the title -findElement(By.id("")).getText();
	  
	  Assert.assertEquals(title, "QA Automation Tools Trainings and Tutorials | QA Tech Hub");
	  
	 /* 
	  * This method can also be used to check whether title is correct ot not
	  if(title.equals("QA Automation Tools Trainings and Tutorials | QA Tech Hub")) {
		  System.out.println("Passed");
	  }else {
		  System.out.println("Failed");
	  }*/
  }
  @Test(priority=1)
  public void navigate() {
	  //navigate to facebook.com
	  driver.navigate().to("https://www.facebook.com");
	  
	  //navigate back to QA Tech hub
	  driver.navigate().back();
	  
	  //print the current url
	  System.out.println(driver.getCurrentUrl());
	  
	  //navigate forward
	  driver.navigate().forward();
	  
	  //refresh/reload the page
	  driver.navigate().refresh();
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.geckodriver.exe","D:\\QA\\ToolsQA\\QATechHub\\chromedriver.exe");
  }

  @AfterTest
  public void afterTest() {
	  //close the browser after running all commands
	  driver.close();
  }

}
