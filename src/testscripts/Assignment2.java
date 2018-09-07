package testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Assignment2 {

	WebDriver driver = new ChromeDriver();

	@Test(priority = 0)
	public void navigation() throws InterruptedException {

		// maximize the browser
		driver.manage().window().maximize();

		// navigate to facebook sign up page
		driver.get("http://www.fb.com");

		// get current url to a string variable
		String currentUrl = driver.getCurrentUrl();

		// compare two urls using assert
		// Assert.assertEquals(currentUrl, "https://www.facebook.com/");

		System.out.println(currentUrl);

		// This method also can be used to compare two urls.
		if (currentUrl.equals("https://www.facebook.com/")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}

		// added a wait time to identify the element is present
		Thread.sleep(5000);

		// Check whether Create an account text is present in the page
		driver.getPageSource().contains("Create an account");

	}
	@Test(priority = 1)
	public void creatAccount() throws InterruptedException {

		// Fill in the text boxes
		driver.findElement(By.id("u_0_j")).sendKeys("John");

		driver.findElement(By.id("u_0_l")).sendKeys("Doe");

		driver.findElement(By.id("u_0_o")).sendKeys("automating@gmail.com");

		driver.findElement(By.id("u_0_r")).sendKeys("automating@gmail.com");

		driver.findElement(By.id("u_0_v")).sendKeys("test.123");

		// Fill in the drop downs
		Select date = new Select(driver.findElement(By.id("day")));
		date.selectByValue("5");

		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("10");

		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("1990");

		Thread.sleep(5000);

		// selecting the radio button
		driver.findElement(By.id("u_0_a")).click();

		// clicking sign up button
		driver.findElement(By.id("u_0_11")).click();

	}

	@BeforeTest
	public void beforeTest() {
		System.getProperty("webdriver.geckodriver.exe", ":\\\\QA\\\\ToolsQA\\\\QATechHub\\\\chromedriver.exe");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
