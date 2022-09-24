package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_86_CreateNewChart {

	public static void main(String[] args) throws InterruptedException {

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

		//3. Click view All and click Service Console from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();
		Thread.sleep(3000);
	

		// 4. Click on the drop down and select Refunds
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		driver.findElement(By.xpath("//span[text()='Refunds']")).click();
		
		//5.Click on drop down near Recently viewed and change into 'All'.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Select a List View']")).click();
		driver.findElement(By.xpath("//span[text()='All']")).click();
		
		//6. Click on Chart icon under New Button
		Thread.sleep(2000);

		WebElement showChart = driver.findElement(By.xpath("//span[text()='Show charts']"));
		driver.executeScript("arguments[0].click();", showChart);
		
		//7. Click New Chart
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='trigger']/lightning-icon")).click();
		driver.findElement(By.xpath("//a[@title='New Chart']")).click();
		//driver.findElement(By.xpath("//span[text()='New Chart']")).click();
		
		//8. Give Chart Name and Select Chart Type
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']/input")).sendKeys("Viji Ganesan");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='uiMenu']//a[text()='Horizontal Bar Chart']")).click();
		driver.findElement(By.xpath("//div[@class='select-options']//a[@title='Vertical Bar Chart']")).click();
		
		//9. Select Aggregate Type as Average 
		driver.findElement(By.xpath("//div[@class='uiMenu']//a[text()='Count']")).click();
		driver.findElement(By.xpath("//div[@class='select-options']//a[@title='Average']")).click();
		//and aggregate Field as Amount
		driver.findElement(By.xpath("//div[@class='uiMenu']//a[text()='Account']")).click();
		driver.findElement(By.xpath("//div[@class='select-options']//a[@title='Amount']")).click();
		
		
		//10. Select Grouping Field as Account 
		driver.findElement(By.xpath("(//div[@class='uiMenu']//a[text()='Account'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='select-options']//a[@title='Account']")).click();
		
		//and click Save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		//11. Click on settings icon and change the Chart Type
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@class='trigger']/lightning-icon")).click();
		driver.findElement(By.xpath("//a[@title='Donut Chart']")).click();
		
		Thread.sleep(3000);
		
		System.out.println("End --------------------- !");
		
		driver.close();
		

	}

}
