package Sprint1;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_25_CreateOpportunity extends ParentClass {
	@Test(priority=1)
	//public static void main(String[] args) throws InterruptedException {
	public void runCreateOpportunity() throws InterruptedException {
		
		//2. Click on toggle menu button from the left corner
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//driver.findElement(By.linkText("Setup Home")).click();
				
		//3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("sales");
		
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//4. Click on Opportunity tab 
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();",opportunity );
		//driver.findElement(By.xpath("//span[text()='Opportunities']")).click();
		
		//5. Click on New button
		driver.findElement(By.linkText("New")).click();
		
		//6. Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it 
		String oppName = "Salesforce Automation by Viji Ganesan";
		driver.findElement(By.xpath("//div/input[@name='Name']")).sendKeys(oppName);
				
		//7. Choose close date as Today
		driver.findElement(By.xpath("//div/input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		
		//8. Select 'Stage' as Need Analysis
		WebElement stage = driver.findElement(By.xpath("//button[contains(@aria-label,'Stage')]"));
		stage.click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

		//9. click Save and VerifyOppurtunity Name
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		//--- can use this later for explicit wait		
		//String oppCreated = driver.findElement(By.xpath("//span[text()='Opportunity']/a")).getText(); 
		
		String oppCreated = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText();
		//Assert.assertEquals(oppName, oppCreated);

	//	driver.close();
		
		//*************explicit wait for 10 seconds
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(300));
		
		
		WebElement toast = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]/a"));
		
		wait.until(ExpectedConditions.textToBePresentInElement(toast, oppName));

		
		String oppCreatedToast = toast.getText();
		
	//	System.out.println(oppCreatedToast);
		Thread.sleep(3000);
	
	}

}
