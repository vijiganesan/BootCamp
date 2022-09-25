package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_36_LegalEntityWOMandFields {
	@Test
	//public static void main(String[] args) throws InterruptedException {
	public void TC_S08_36() throws InterruptedException {
		//1. Login to https://login.salesforce.com
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
				
				//2. Click on the toggle menu button from the left corner
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
						
				
				//3. Click View All and click Legal Entities from App Launcher
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("Legal Entities");
				driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();
				
				//4. Click on the Dropdown icon in the legal Entities tab
				driver.findElement(By.xpath("//a[@title='Legal Entities']/following::a")).click();
				
				//5. Click on New Legal Entity
				WebElement legalEntityNew = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
				driver.executeScript("arguments[0].click();",legalEntityNew );
				
				//6) Enter the Company name as 'Testleaf'.
				driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("Testleaf");
				
				//7) Enter Description as 'SalesForce'.
				driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys("SalesForce");
				
				//8) Select Status as 'Active'
				Thread.sleep(2000);
				WebElement status = driver.findElement(By.xpath("//a[@class='select']"));
				driver.executeScript("arguments[0].click();",status );
				WebElement statusSel = driver.findElement(By.xpath("//a[@title='Active']"));
				driver.executeScript("arguments[0].click();",statusSel );
				
				//9) Click on Save 
				driver.findElement(By.xpath("//button[@title='Save']")).click();
				Thread.sleep(3000);

				
				//10) Verify the Alert message (Complete this field) displayed for Name
				String alertActualMsg = driver.findElement(By.xpath("//ul[contains(@class,'has-error uiInputDefaultError')]")).getText();
				
				Assert.assertEquals(alertActualMsg, "Complete this field.");
				System.out.println("End");
				
				//driver.close();
	}

}
