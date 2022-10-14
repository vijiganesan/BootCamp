package Sprint1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_26_EditOpportunity extends ParentClass {
	
	@BeforeTest
	public void sendFileName() {
		
		workBookName = "EditOpportunity";

	}
	
	@Test(dependsOnMethods= {"Sprint1.S08_25_CreateOpportunity.runCreateOpportunity"}, dataProvider="fetchData")// ( dataProvider="fetchData") //
	//public static void main(String[] args) throws InterruptedException {
	public void runEditOpportunity(String module, String opportunityName, String description) throws InterruptedException {

		// 2. Click on toggle menu button from the left corner

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		// driver.findElement(By.linkText("Setup Home")).click();

		// 3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys(module);

		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 4. Click on Opportunity tab
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);

		// 5. Search the Opportunity 'Salesforce Automation by Your Name'
		//driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by Viji" + Keys.ENTER);
		//String searchOppText = "Salesforce Automation by Viji Ganesan";
		WebElement search = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		search.sendKeys(opportunityName,Keys.ENTER);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-popover__body']")).click();
		
				
		//6. Click on the Dropdown icon and Select Edit
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr/td[8]//a")).click();
		
		Thread.sleep(5000);
		WebElement editButton = driver.findElement(By.xpath("//div[@title='Edit']"));
		driver.executeScript("arguments[0].click();", editButton);
		
		//7. Choose close date as Tomorrow date
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		WebElement today = driver.findElement(By.xpath("//tbody//td[contains(@class,'slds-is-today')]"));
		String todayDate = today.getText();
		System.out.println("printing todayDate : " +todayDate);
		int i=Integer.parseInt(todayDate)+1;
		System.out.println("printing nextdate : " +i);
		WebElement nextDate = driver.findElement(By.xpath("//span[text()='"+i+"']"));
		driver.executeScript("arguments[0].click();", nextDate);
		//driver.findElement(By.xpath("//span[text()='"+i+"']")).click();
		System.out.println("printing 1************************");
		
		//8. Select 'Stage' as Perception Analysis
		WebElement stage = driver.findElement(By.xpath("//button[contains(@aria-label,'Stage')]"));
		driver.executeScript("arguments[0].click();", stage);
		//driver.findElement(By.xpath("//button[contains(@aria-label,'Stage')]")).click();
		
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		System.out.println("printing 2************************");
		//9. Select Deliver Status as In Progress
		WebElement statusButton = driver.findElement(By.xpath("//button[@aria-label='Delivery/Installation Status, --None--']"));
		driver.executeScript("arguments[0].click();", statusButton);
		driver.findElement(By.xpath("//span[@title='In progress']")).click();
		System.out.println("printing 3************************");
		//10. Enter Description as SalesForce
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys(description+Keys.ENTER);
		System.out.println("printing 4************************");
		//11. Click on Save  
		WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
		driver.executeScript("arguments[0].click();", saveButton);
		//driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		// 12. Verify Stage as Perception Analysis
		//driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by Viji_2" + Keys.ENTER);
		Thread.sleep(5000);
		String stageActual = driver.findElement(By.xpath("(//tbody/tr/td[5])[1]")).getText();
	//	System.out.println(stageActual);
		Assert.assertEquals(stageActual, "Perception Analysis");
	//	System.out.println("after assertion");
		System.out.println("End!---------------");
		Thread.sleep(3000);

	}
/*	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		
		return ReadExcel.readData("EditOpportunity");

	}
*/
}
