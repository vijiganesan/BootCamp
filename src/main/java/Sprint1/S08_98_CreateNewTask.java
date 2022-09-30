package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_98_CreateNewTask extends ParentClass {

	 //public static void main(String[] args) throws InterruptedException {
	//@Test
	public void runCreateNewTask() throws InterruptedException {
/*
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

		Thread.sleep(2000);*/

		// 2. Click on toggle menu button from the left corner

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		// driver.findElement(By.linkText("Setup Home")).click();

		// 3. Click view All from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//4. Click on Content tab 
		driver.findElement(By.xpath("//span/p[text()='Content']")).click();

		//5. Click View All from Today's Task
		WebElement todaysTaskViewAll = driver.findElement(By.xpath("//a[@aria-label='View All Tasks']/span"));
		driver.executeScript("arguments[0].scrollIntoView(true);", todaysTaskViewAll);
		driver.executeScript("arguments[0].click();", todaysTaskViewAll);
		
		//6. Click on Show one more Action and click New Task
		
		Thread.sleep(5000);
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
		
		driver.findElement(By.xpath("//a[@title='New Task']")).click();
		
		//7. Select a Account Name in Assigned to field 
		//driver.findElement(By.xpath("//span[text()='Assigned To']/following::div/input[@title='Search People']")).click();
		driver.findElement(By.xpath("//span[text()='Derrick Dsouza']")).click();
		
		//8. Select a subject as Email
		driver.findElement(By.xpath("//label[text()='Subject']//following::input")).click();
		driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Email']")).click();
		
		//9. Set Priority as High and Status as In Progress
		
	}

}
