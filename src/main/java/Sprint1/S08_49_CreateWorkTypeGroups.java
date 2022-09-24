package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_49_CreateWorkTypeGroups {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("Work Type Groups");
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();

		// 4. Click on the Dropdown icon in the work type group tab
		driver.findElement(By.xpath("//a[@title='Work Type Groups']//following::one-app-nav-bar-item-dropdown")).click();

		// 5. Click on New Work Type Group
		WebElement newWorkTypeGroup = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		driver.executeScript("arguments[0].click();", newWorkTypeGroup);

		// 6. Enter Name as 'Salesforce Automation by Your Name'
		String workTypeGroupName = "Salesforce Automation by Viji Ganesan";
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(workTypeGroupName);

		// 7.Click save and verify Work Type Group Name
		driver.findElement(By.xpath("//button[@title='Save']")).click();

		// *************explicit wait for 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));

		WebElement toast = driver.findElement(By.xpath("//div[contains(@class,'toastContent ')]/div"));

		wait.until(ExpectedConditions.textToBePresentInElement(toast, workTypeGroupName));

		// int startPos = indexOf()
		String workTypeGrouptoast = toast.getText();
		int posSubString = workTypeGrouptoast.indexOf("\"");
		int posSubStringend = workTypeGrouptoast.indexOf("\"",workTypeGrouptoast.indexOf("\"")+1);
		String workTypeGroupActual = workTypeGrouptoast.substring(posSubString+1,posSubStringend);
		
		System.out.print("printing --------------- workTypeGroupName : "+workTypeGroupName);
		System.out.println("printing --------------- : "+workTypeGroupActual);

		Assert.assertEquals(workTypeGroupName, workTypeGroupActual);
		
		System.out.println("End!----------------");

		Thread.sleep(3000);

		// driver.close();

	}


}
