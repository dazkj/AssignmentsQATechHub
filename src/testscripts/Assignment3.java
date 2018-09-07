package testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Assignment3 {

	WebDriver driver = new ChromeDriver();

	@Test(priority = 0)
	public void navigating() {

		driver.manage().window().maximize();

		// navigate to flipkart
		driver.get("https://www.flipkart.com/");

		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	}

	@Test(priority = 1)
	public void countLinks() {

		// creating a list to store all links in home page.since multiple web elements
		// findElements is used.
		java.util.List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		// print the link count
		System.out.println(allLinks.size());

	}

	@Test(priority = 2)
	public void printLinks() {
		java.util.List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		// print the link test
		for (int i = 0; i < allLinks.size(); i++) {

			System.out.println("Item-" + allLinks.get(i).getText());

		}
		// print the link urls
		for (WebElement link : allLinks) {

			// print the links i.e. http://example.com or https://www.example.com
			System.out.println(link.getAttribute("href"));
		}
	}

	@BeforeTest
	public void beforeTest() {

		System.getProperty("webdriver.geckodriver.exe", ":\\QA\\ToolsQA\\QATechHub\\chromedriver.exe");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
