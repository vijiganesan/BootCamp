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

public class S08_35_EditLegalEntity extends ParentClass {
	@Test(priority=2)
	//public static void main(String[] args) throws InterruptedException {
	public void runEditLegalEntity() throws InterruptedException {
	/*	//1. Login to https://login.salesforce.com
				//download the chromedriver and set the path
				WebDriverManager.chromedriver().setup();
				
				//Handle Notification
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
				//2. Click on the toggle menu button from the left corner
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
						
				
				//3. Click View All and click Legal Entities from App Launcher
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("Legal Entities");
				driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();
				
				//4. Click on the Dropdown icon in the legal Entities tab
				driver.findElement(By.xpath("//a[@title='Legal Entities']/following::a")).click();
				
				//5) Search the Legal Entity 'Salesforce Automation by Your Name'
				//input[@type='search']
				String searchLegalEntityText = "Salesforce Automation by Viji Ganesan";
				WebElement search = driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"));
				search.sendKeys(searchLegalEntityText,Keys.ENTER);
				
				//6) Click on the Dropdown icon and Select Edit
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[contains(@class,'slds-icon-utility-down')])[1]")).click();
				driver.findElement(By.xpath("//li/a[@title='Edit']")).click();
				

				//7) Enter the Company name as 'Testleaf'.
				driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("Testleaf");
				
				//8) Enter Description as 'SalesForce'.
				driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys("SalesForce");
				
				//9) Select Status as 'Active'
				Thread.sleep(2000);
				WebElement status = driver.findElement(By.xpath("//a[@class='select']"));
				driver.executeScript("arguments[0].click();",status );
				WebElement statusSel = driver.findElement(By.xpath("//a[@title='Active']"));
				driver.executeScript("arguments[0].click();",statusSel );
				
				//10) Click on Save and Verify Status as Active
				driver.findElement(By.xpath("//button[@title='Save']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span/a[@data-refid='recordId'])[1]")).click();
				
				String statusActual = driver.findElement(By.xpath("(//div[contains(@class,'slds-truncate')])[3]")).getText();
				
				Assert.assertEquals(statusActual, "Active");
				System.out.println("End");
				Thread.sleep(3000);

			//	driver.close();
				
	}

}
