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

public class S08_50_EditWorkTypeGroup extends ParentClass {
	@Test(priority=2)
	//public static void main(String[] args) throws InterruptedException {
	public void runEditWorkTypeGroup() throws InterruptedException {
	/*	// 1. Login to https://login.salesforce.com
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
*/
		// 2. Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		// 3. Click View All and click Work Type Groups from App Launcher
		//4. Click on the Work Type Group tab 
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("Work Type Groups");
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();
	
		//5. Search the Work Type Group 'Salesforce Automation by Your Name'
		String workTypeGroupText = "Salesforce Automation by Viji Ganesan";
		WebElement search = driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']"));
		search.sendKeys(workTypeGroupText,Keys.ENTER);
		
		//6. Click on the Dropdown icon and Select Edit
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(@class,'slds-icon-utility-down')])[1]")).click();
		driver.findElement(By.xpath("//li/a[@title='Edit']")).click();
		
		//7.Enter Description as 'Automation'.
		String descExpected = "Automation";
		driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys(descExpected);
		
		//8.Select Group Type as 'Capacity'
		//a[@class='select']
		Thread.sleep(2000);
		WebElement grpType = driver.findElement(By.xpath("//a[@class='select']"));
		driver.executeScript("arguments[0].click();",grpType );
		
		//9.Click on Save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		//10. Click on 'Salesforce Automation by Your Name'and Verify Description as 'Automation'
		WebElement firstRow = driver.findElement(By.xpath("//tbody/tr//th/span/a"));
		driver.executeScript("arguments[0].click();",firstRow );
		
		
		String descActual = driver.findElement(By.xpath("//div/span[text()='Description']//following::span")).getText();
		
		System.out.println(descActual);
		
		Assert.assertEquals(descExpected, descActual);
		
		System.out.println("End!---------------!");
		
	//	driver.close();
		
	}

}
