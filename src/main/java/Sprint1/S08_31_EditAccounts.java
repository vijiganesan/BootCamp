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

public class S08_31_EditAccounts extends ParentClass {
	@Test(priority=2)
	//public static void main(String[] args) throws InterruptedException {
	public void runEditAccounts() throws InterruptedException {

		//2. Click on toggle menu button from the left corner
						
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//driver.findElement(By.linkText("Setup Home")).click();
								
		//4) Click on the App Laucher Icon left to Setup
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("sales");
						
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						
		//5) Click on Accounts
		WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();",accounts );
		
		//6) Search for the Account Using the unique account name created by you 
		//input[@type='search']
		String searchAccText = "Salesforce Automation by Viji Ganesan";
		WebElement search = driver.findElement(By.xpath("//input[@name='Account-search-input']"));
		search.sendKeys(searchAccText,Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='slds-popover__body']")).click();
		
		//7) Click on the displayed Account Dropdown icon and select Edit
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(@class,'slds-icon-utility-down')])[1]")).click();
		driver.findElement(By.xpath("//li/a[@title='Edit']")).click();
		
		//8) Select Type as Technology Partner
		driver.findElement(By.xpath("//button[@aria-label='Type, --None--']")).click();
		WebElement type = driver.findElement(By.xpath("//span[@title='Technology Partner']"));
		driver.executeScript("arguments[0].click();",type);
		
		//15) Enter Unique Number in Phone Field
		/*String ph = "7542298651";
		WebElement phNo = driver.findElement(By.xpath("(//div/input[@name='Phone']"));
		driver.executeScript("arguments[0].sendKeys(ph);",phNo);*/
		
		String ph = "07542249870";
		driver.findElement(By.xpath("//div/input[@name='Phone']")).sendKeys(ph);
		
		//9) Select Industry as Healthcare 
		driver.findElement(By.xpath("//button[@aria-label='Industry, --None--']")).click();
		WebElement industry = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']"));
		driver.executeScript("arguments[0].click();",industry );
		
		//10)Enter Billing Address
		driver.findElement(By.xpath("(//div/textarea[@name='street'])[1]")).sendKeys("Chennai");
		driver.findElement(By.xpath("(//div/input[@name='city'])[1]")).sendKeys("Chennai");
		driver.findElement(By.xpath("(//div/input[@name='province'])[1]")).sendKeys("Tamil Nadu");
		driver.findElement(By.xpath("(//div/input[@name='postalCode'])[1]")).sendKeys("600 092");
		driver.findElement(By.xpath("(//div/input[@name='country'])[1]")).sendKeys("India");
	
		//11)Enter Shipping Address
		driver.findElement(By.xpath("(//div/textarea[@name='street'])[2]")).sendKeys("Chennai");
		driver.findElement(By.xpath("(//div/input[@name='city'])[2]")).sendKeys("Chennai");
		driver.findElement(By.xpath("(//div/input[@name='province'])[2]")).sendKeys("Tamil Nadu");
		driver.findElement(By.xpath("(//div/input[@name='postalCode'])[2]")).sendKeys("600 092");
		driver.findElement(By.xpath("(//div/input[@name='country'])[2]")).sendKeys("India");
		
		//12)Select Customer Priority as Low
		Thread.sleep(2000);
		WebElement custPri = driver.findElement(By.xpath("//button[@aria-label='Customer Priority, --None--']"));
		driver.executeScript("arguments[0].click();",custPri );
		WebElement custPriSel = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']"));
		driver.executeScript("arguments[0].click();",custPriSel );
		
		//13)Select SLA as Silver
		driver.findElement(By.xpath("//button[@aria-label='SLA, --None--']")).click();
		WebElement sla = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Silver']"));
		driver.executeScript("arguments[0].click();",sla );
		
		//14) Select Active as NO 
		WebElement activeloc=driver.findElement(By.xpath("//button[@aria-label='Active, --None--']"));
		driver.executeScript("arguments[0].click();",activeloc );
		WebElement activelocSel =driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']"));
		driver.executeScript("arguments[0].click();",activelocSel );
		
		//16)Select Upsell Oppurtunity as No
		driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity, --None--']")).click();
		WebElement upOpp = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']"));
		driver.executeScript("arguments[0].click();",upOpp );
		
		//17)Click on save and 
		WebElement saveEdit = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		driver.executeScript("arguments[0].click();",saveEdit );
		
		//18) verfiy Phone number
		//driver.findElement(By.xpath("//tbody/tr/td[4]//span[contains(@class,'forceOutputPhone')]"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody//th//a")).click();
		//driver.findElement(By.xpath("//lightning-formatted-phone/a")).getText();
		String actualPhNo = driver.findElement(By.xpath("//lightning-formatted-phone/a")).getText();
		System.out.println(ph + " , " + actualPhNo);
		Assert.assertEquals(actualPhNo, ph);
		System.out.println("End!----------------!");
		
		driver.findElement(By.xpath("//span[@data-aura-class='forceSocialPhoto']//span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'logout')]")).click();

		
	}

}
