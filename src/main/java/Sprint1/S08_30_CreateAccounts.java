package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_30_CreateAccounts extends ParentClass {
	@Test(priority=1)
	//public static void main(String[] args) throws InterruptedException {
	public void runCreateAccounts() throws InterruptedException {

		//2. Click on toggle menu button from the left corner
				
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//driver.findElement(By.linkText("Setup Home")).click();
						
		//3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("sales");
				
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		//4. Click on Accounts tab 
		WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();",accounts );
				
		//5. Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//6. Enter 'your name' as account name
		String accName = "Salesforce Automation by Viji Ganesan";
		driver.findElement(By.xpath("//div/input[@name='Name']")).sendKeys(accName);
		
		//7. Select Ownership as Public  
		WebElement ownership = driver.findElement(By.xpath("//button[@aria-label='Ownership, --None--']"));
		ownership.click();
		driver.findElement(By.xpath("//span[@title='Public']")).click();
		
		//8. Click save and verify Account name 
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		//Expected Result:
		//Account should be created Successfully
		String AccCreated = driver.findElement(By.xpath("//div[@data-aura-class='sfaOutputNameWithHierarchyIcon']/lightning-formatted-text")).getText();
		//System.out.println(accName +" , " + AccCreated);
		Assert.assertEquals(accName, AccCreated);
		System.out.println("End!----------------!");
		driver.findElement(By.xpath("//span[@data-aura-class='forceSocialPhoto']//span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'logout')]")).click();

	}

}
