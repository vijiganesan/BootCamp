package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_52_WorkTypeGroupWOMandFields {
	@Test
	//public static void main(String[] args) throws InterruptedException {
	public void TC_S08_52() throws InterruptedException {
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
				
				//6.Enter Description as 'Automation'.
				String descExpected = "Automation";
				driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys(descExpected);
				
				//7.Select Group Type as 'Capacity'
				Thread.sleep(2000);
				WebElement grpType = driver.findElement(By.xpath("//a[@class='select']"));
				driver.executeScript("arguments[0].click();",grpType );
				
				// 8.Click save 
				driver.findElement(By.xpath("//button[@title='Save']")).click();
				
				//9. Verify the Alert message (Complete this field) displayed for Work Type Group Name
				String alertActualMsg = driver.findElement(By.xpath("//ul[contains(@class,'has-error uiInputDefaultError')]")).getText();
				System.out.println("Printing------------alertActualMsg : "+alertActualMsg);
				Assert.assertEquals(alertActualMsg, "Complete this field.");
				System.out.println("End!---------------------!");
				
				Thread.sleep(2000);
				driver.close();

	}

}
