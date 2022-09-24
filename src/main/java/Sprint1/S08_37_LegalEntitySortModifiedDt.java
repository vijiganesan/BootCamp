package Sprint1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_37_LegalEntitySortModifiedDt {

	public static void main(String[] args) throws InterruptedException, ParseException {
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
		WebElement legalEntity = driver.findElement(By.xpath("//a[contains(@title,'Legal Entities')]"));
		driver.executeScript("arguments[0].click();",legalEntity );
				
		//5. Click the sort arrow in the Last Modified Date.
		//before the sorting order
		
		Thread.sleep(3000);
		String totalRecString = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText(); 
		System.out.println("printing ---------- totalRecString : " + totalRecString);
		
		int position = totalRecString.indexOf(" ");
		System.out.println("printing ---------- position : " + position);
		int totalRecCount = Integer.parseInt(totalRecString.substring(0,position));
		
		System.out.println("printing ---------- totalRecCount : " + totalRecCount);
		
		List<WebElement> rowElementsBf = driver.findElements(By.xpath("//tbody/tr/td[3] "));
		
		List<Date> beforeLastModifiedDate = new ArrayList<Date>();
		
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	
		for (int i = 1; i <= totalRecCount; i++) {

			WebElement moveToEleBf = driver.findElement(By.xpath("//tbody/tr[" +i+ "]/td[3]")); 
			driver.executeScript("arguments[0].scrollIntoView(true);", moveToEleBf);
			
			String lastModBf = moveToEleBf.getText();
			int dtEndPos = lastModBf.indexOf(",");
			String lastModStringBf = lastModBf.substring(0,dtEndPos);
			System.out.println("printing ------------- lastModDtBf : " +lastModBf +" ---- " +lastModStringBf);
			
			//beforeLastModifiedDate.add(lastModDtBf);
		}
		
		//sorting the ArrayList 
		Collections.sort(beforeLastModifiedDate);
		Collections.reverse(beforeLastModifiedDate);
		System.out.println("beforeLastModifiedDate sorted list value ----------- : " +beforeLastModifiedDate );
		
		//sort the Last Modified Date
		WebElement moveToLastModDate = driver.findElement(By.xpath("//span[@title='Last Modified Date']")); 
		driver.executeScript("arguments[0].scrollIntoView(true);", moveToLastModDate);
		Thread.sleep(2000);
		driver.executeScript("arguments[0].click();", moveToLastModDate);
		
		//after the sorting order
		Thread.sleep(2000);
		List<WebElement> rowElementsAf = driver.findElements(By.xpath("//tbody/tr/td[3] "));
		
		List<Date> afterLastModifiedDate = new ArrayList<Date>();
	
		for (int i = 1; i <= totalRecCount; i++) {
			WebElement moveToEleAf = driver.findElement(By.xpath("//tbody/tr[" +i+ "]/td[3]")); 
			driver.executeScript("arguments[0].scrollIntoView(true);", moveToEleAf);
					
			String lastModAf = moveToEleAf.getText();
			int dtEndPosAf = lastModAf.indexOf(",");
			Date lastModDtBf = df.parse(lastModAf.substring(0,dtEndPosAf));
			
			afterLastModifiedDate.add(lastModDtBf);
		}
		
		System.out.println("afterLastModifiedDate sorted list value ----------- : " +afterLastModifiedDate );
		
		// compare beforeLastModifiedDate with afterLastModifiedDate
        if (beforeLastModifiedDate.equals(afterLastModifiedDate) == true) {
            System.out.println(" Array List are equal");
        }
        else
        {
            System.out.println(" Array List are not equal");
        }
		
		
		System.out.println("End " );
		
		
		
		
		
		
		
		
		//6. Verify the Legal Entities displayed in ascending order by Last Modified Date.
		
	}

}
