package Sprint1;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_86_CreateNewChart {
	@Test
	//public static void main(String[] args) throws InterruptedException {
	public void TC_S08_86() throws InterruptedException {

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

		Thread.sleep(5000);
	
		//String landingPage = driver.findElement(By.xpath("//div//li/a")).getText();//"Switch to Lightning Experience"
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		
		if (!pageTitle.equals("Home | Salesforce") && !pageTitle. equals("Lightning Experience")) {
		//if(pageTitle.contains("Lightning")) {
			driver.findElement(By.xpath("//a[@class='switch-to-lightning']")).click();
			Thread.sleep(7000);
			System.out.println("Printing ------------- inside if");
		}
		Thread.sleep(7000);
		System.out.println("Printing ------------- 1");
		// 2. Click on menu button from the Left corner
		WebElement waffle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		driver.executeScript("arguments[0].click();", waffle);
		System.out.println("Printing ------------- 2");

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
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath("//button[@title='Display as Split View']//lightning-primitive-icon")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@title=\"Table\"]")).click();
		} catch (Exception e) {
			System.out.println("inside catch ------------ ");
			driver.findElement(By.xpath("//button[@title='Display as Table']//lightning-primitive-icon")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@title=\"Table\"]")).click();
		}
		
		//6. Click on Chart icon under New Button
		Thread.sleep(2000);

		WebElement showChart = driver.findElement(By.xpath("//span[text()='Show charts']"));
		driver.executeScript("arguments[0].click();", showChart);
		
		//7. Click New Chart
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//a[@class='trigger']/lightning-icon")).click();
			driver.findElement(By.xpath("//a[@title='New Chart']")).click();
		} catch (Exception e) {
			//System.out.println("inside catch : "+e.getMessage());
			System.out.println("inside catch ------------ ");
			driver.findElement(By.xpath("//span[text()='New Chart']")).click();
		}
		
		//driver.findElement(By.xpath("//a[@class='trigger']/lightning-icon")).click();
		//driver.findElement(By.xpath("//a[@title='New Chart']")).click();
		//driver.findElement(By.xpath("//span[text()='New Chart']")).click();
		
		//8. Give Chart Name and Select Chart Type
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']/input")).sendKeys("Viji Ganesan");
		Thread.sleep(2000);
		WebElement horizontalBarChart = driver.findElement(By.xpath("//div[@class='uiMenu']//a[text()='Horizontal Bar Chart']"));
		driver.executeScript("arguments[0].click();", horizontalBarChart);
		
		WebElement verticalBarChart = driver.findElement(By.xpath("//div[@class='select-options']//a[@title='Vertical Bar Chart']"));
		driver.executeScript("arguments[0].click();", verticalBarChart);
		
		
		//9. Select Aggregate Type as Average 
		driver.findElement(By.xpath("//div[@class='uiMenu']//a[text()='Count']")).click();
		driver.findElement(By.xpath("//div[@class='select-options']//a[@title='Average']")).click();
		
		//and aggregate Field as Amount
		WebElement aggFieldAccount =driver.findElement(By.xpath("//span[text()='Aggregate Field']//following::a[@class='select']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", aggFieldAccount);
		driver.executeScript("arguments[0].click();", aggFieldAccount);
		
		WebElement aggFieldAmount = driver.findElement(By.xpath("//div[@class='select-options']//a[@title='Amount']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", aggFieldAmount);
		driver.executeScript("arguments[0].click();", aggFieldAmount);
		
	// ---- its not working -----------------	
		//10. Select Grouping Field as Account 
		WebElement grpFieldAccount = driver.findElement(By.xpath("//span[text()='Grouping Field']//following::a[@class='select']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", grpFieldAccount);
		driver.executeScript("arguments[0].click();", grpFieldAccount);
		
		WebElement grpFieldSel = driver.findElement(By.xpath("//div[@class='select-options']//a[@title='Account']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", grpFieldSel);
		driver.executeScript("arguments[0].click();", grpFieldSel);
	
		
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
