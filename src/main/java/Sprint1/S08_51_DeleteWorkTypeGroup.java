package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_51_DeleteWorkTypeGroup {
	@Test
	//public static void main(String[] args) throws InterruptedException {
	public void TC_S08_51() throws InterruptedException {
		// 1. Login to https://login.salesforce.com
		// download the chromedriver and set the path
		WebDriverManager.chromedriver().setup();

		// Handle Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();

		Thread.sleep(2000);

		// 2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click View All and click Work Type Groups from App Launcher
		// 4. Click on the Work Type Group tab
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("Work Type Groups");
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();

		// 5. Search the Work Type Group 'Salesforce Automation by Your Name'
		String workTypeGroupText = "Salesforce Automation by Viji Ganesan";
		WebElement search = driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']"));
		search.sendKeys(workTypeGroupText, Keys.ENTER);

		// 6. Click on the Dropdown icon and Select Delete
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(@class,'slds-icon-utility-down')])[1]")).click();
		driver.findElement(By.xpath("//li/a[@title='Delete']")).click();
		
		//7.Click on the Delete option in the displayed popup window.
		driver.findElement(By.xpath("//button/span[text()='Delete']")).click();
		
		//8. Verify Whether Work Type group is Deleted using Work Type Group Name
		Thread.sleep(5000);
		String searchResult = driver.findElement(By.xpath("//div[contains(@class,'emptyContent ')]")).getText();
		System.out.println("printing-------------------------: " +searchResult);
		Assert.assertEquals(searchResult, "No items to display.");
		System.out.println("End!--------------------------!");
		Thread.sleep(3000);
		driver.close();

	}

}
