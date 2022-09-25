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

public class S08_32_DeleteAccount {
	@Test
	//public static void main(String[] args) throws InterruptedException {
	public void TC_S08_32() throws InterruptedException {
		// TODO Auto-generated method stub
		//download the chromedriver and set the path
		WebDriverManager.chromedriver().setup();
						
		//Handle Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
						
		ChromeDriver driver = new ChromeDriver(options);
						
		driver.manage().window().maximize();
						
		//1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//3) Login with the credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		
		//2) Click Login
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);		

		//2. Click on toggle menu button from the left corner
						
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//driver.findElement(By.linkText("Setup Home")).click();
								
		//4) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("sales");
						
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						
		//5) Click on Accounts
		WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();",accounts );
		
		//6) Search for the Account Using the unique account name created by you 
		//input[@type='search']
		String searchAccText = "SF AT by Viji Ganesan for Deletion";
		WebElement search = driver.findElement(By.xpath("//input[@name='Account-search-input']"));
		search.sendKeys(searchAccText,Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-popover__body']")).click();
		
		//7) Click on the displayed Account Dropdown icon and select Delete
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(@class,'slds-icon-utility-down')])[1]")).click();
		driver.findElement(By.xpath("//li/a[@title='Delete']")).click();
		
		driver.findElement(By.xpath("//button/span[text()='Delete']")).click();
	
	    //7. Verify Whether Account is Deleted using Account Name
		Thread.sleep(5000);
		String searchResult = driver.findElement(By.xpath("//div[contains(@class,'emptyContent ')]")).getText();
		//System.out.println(searchResult);
		Assert.assertEquals(searchResult, "No items to display.");
		System.out.println("End");
		driver.close();
	}
	

}
