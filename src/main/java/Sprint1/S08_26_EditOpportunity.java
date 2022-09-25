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

public class S08_26_EditOpportunity {
	@Test
	//public static void main(String[] args) throws InterruptedException {
	public void TC_S08_26() throws InterruptedException {
		// download the chromedriver and set the path
		WebDriverManager.chromedriver().setup();

		// Handle Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		// 1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();

		Thread.sleep(2000);

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
		//driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by Viji" + Keys.ENTER);
		String searchOppText = "SF AT by Viji Ganesan for Edit";
		WebElement search = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		search.sendKeys(searchOppText,Keys.ENTER);
		
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
		int i=Integer.parseInt(todayDate)+1;
		driver.findElement(By.xpath("//span[text()='"+i+"']")).click();
		
		//8. Select 'Stage' as Perception Analysis
		driver.findElement(By.xpath("//button[contains(@aria-label,'Stage')]")).click();
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		
		//9. Select Deliver Status as In Progress
		WebElement statusButton = driver.findElement(By.xpath("//button[@aria-label='Delivery/Installation Status, --None--']"));
		driver.executeScript("arguments[0].click();", statusButton);
		driver.findElement(By.xpath("//span[@title='In progress']")).click();
		
		//10. Enter Description as SalesForce
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SalesForce"+Keys.ENTER);
		
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
		
		driver.close();

	}

}
