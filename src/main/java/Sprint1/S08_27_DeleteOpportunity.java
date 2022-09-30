package Sprint1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_27_DeleteOpportunity extends ParentClass {
	@Test(priority=3)
	//public static void main(String[] args) throws InterruptedException {
	public void runDeleteOpportunity() throws InterruptedException {
		// 2. Click on toggle menu button from the left corner

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		// driver.findElement(By.linkText("Setup Home")).click();

		// 3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("sales");

		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 4. Click on Opportunity tab
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);

		// 5. Search the Opportunity 'Salesforce Automation by Your Name'
		//driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by Viji"+Keys.ENTER);
		String searchOppText = "Salesforce Automation by Viji Ganesan";
		WebElement search = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		search.sendKeys(searchOppText);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-popover__body']")).click();
		
		// 6. Click on the Dropdown icon and Select Delete
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tbody/tr/td[8]//a")).click();
		
		Thread.sleep(5000);
		WebElement deleteButton = driver.findElement(By.xpath("//div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", deleteButton);
		
		driver.findElement(By.xpath("//button/span[text()='Delete']")).click();
		
		// 7. Verify Whether Oppurtunity is Deleted using Oppurtunity Name
		Thread.sleep(5000);
		String searchResult = driver.findElement(By.xpath("//div[contains(@class,'emptyContent ')]")).getText();
		System.out.println(searchResult);
		Assert.assertEquals(searchResult, "No items to display.");
		System.out.println("End");
		Thread.sleep(3000);
	}

}
