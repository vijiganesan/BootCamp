package Sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_85_CreateNewRefund {
	@Test
	//public static void main(String[] args) throws InterruptedException {
	public void TC_S08_85() throws InterruptedException {

		// 1. Login to https://login.salesforce.com/?locale=in
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
		// 3. Click view All and click Service Console from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Service Console']")).click();
		Thread.sleep(3000);

		// 4. Click on the drop down and select Refunds
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		driver.findElement(By.xpath("//a[@data-label='Refunds']")).click();

		// 5. Click on New
		Thread.sleep(3000);
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
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		// 6. Select Account name
		Thread.sleep(2000);
	/*	driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("//span[@title='New Account']")).click();
		
		Thread.sleep(3000);
		*/
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).sendKeys("Viji Ganesan");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(@class,'lookup__item')]//following::mark")).click();
		
		// 7. Select Status as Canceled
		driver.findElement(By.xpath("//div[@class='uiPopupTrigger']//a[text()='--None--']")).click();
		driver.findElement(By.xpath("//a[@title='Canceled']")).click();
		
		// 8. Give Amount as 50000 
		driver.findElement(By.xpath("//input[contains(@class,'uiInputSmartNumber')]")).sendKeys("50000");
		
		//and select Referenced in Type
		driver.findElement(By.xpath("//span[text()='Type']//following::a[text()='--None--']")).click();
		driver.findElement(By.xpath("//a[@title='Referenced']")).click();
		
		// 9. Select Processing Mode as External
		driver.findElement(By.xpath("//span[text()='Processing Mode']//following::a[text()='--None--']")).click();
		driver.findElement(By.xpath("//a[@title='External']")).click();
		
		// 10. Click Save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		System.out.println("End!-----------------------!");
	}

}
