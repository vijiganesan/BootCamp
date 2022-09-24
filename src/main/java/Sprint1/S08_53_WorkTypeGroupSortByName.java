package Sprint1;

import java.text.DateFormat;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class S08_53_WorkTypeGroupSortByName {

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

		// 3. Click View All and click Work Type Groups from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//div/input[@class='slds-input']")).sendKeys("Work Type Groups");
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();

		// 4. Click on the work type group tab
		driver.findElement(By.xpath("//span[contains(text(),'Work Type Groups')]")).click();
		
		//5. Click the sort arrow in the Work Type Group Name
		// before the sorting order

		Thread.sleep(3000);
		String totalRecString = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		System.out.println("printing ---------- totalRecString : " + totalRecString);

		int position = totalRecString.indexOf(" ");
		System.out.println("printing ---------- position : " + position);
		int totalRecCount = Integer.parseInt(totalRecString.substring(0, position));

		System.out.println("printing ---------- totalRecCount : " + totalRecCount);

		List<WebElement> rowElementsBf = driver.findElements(By.xpath("//tbody/tr/th"));

		List<String> beforeWTGName = new ArrayList<String>();

		for (int i = 1; i <= totalRecCount; i++) {

			WebElement moveToEleBf = driver.findElement(By.xpath("//tbody/tr[" + i + "]/th"));
			driver.executeScript("arguments[0].scrollIntoView(true);", moveToEleBf);
			String nameBf = moveToEleBf.getText();

			beforeWTGName.add(nameBf);
		}
		System.out.println("printing before sorting --------------beforeWTGName: " +beforeWTGName);
		//sorting the ArrayList 
		Collections.sort(beforeWTGName);
		System.out.println("printing after sorting --------------beforeWTGName: " +beforeWTGName);
		Collections.reverse(beforeWTGName);
		System.out.println("printing after reverse --------------beforeWTGName: " +beforeWTGName);
		
		//sort the Last Modified Date
		WebElement moveToWTGName = driver.findElement(By.xpath("//span[@title='Work Type Group Name']")); 
		driver.executeScript("arguments[0].scrollIntoView(true);", moveToWTGName);
		Thread.sleep(2000);
		driver.executeScript("arguments[0].click();", moveToWTGName);
		
		// 6. Verify the Work Type Group displayed in ascending order by Work Type Group Name.
		// after the sorting order
		Thread.sleep(2000);
		List<WebElement> rowElementsAf = driver.findElements(By.xpath("//tbody/tr/th"));

		List<String> afterWTGName = new ArrayList<String>();

		for (int i = 1; i <= totalRecCount; i++) {
			WebElement moveToEleAf = driver.findElement(By.xpath("//tbody/tr[" + i + "]/th"));
			driver.executeScript("arguments[0].scrollIntoView(true);", moveToEleAf);

			String nameAf = moveToEleAf.getText();
			afterWTGName.add(nameAf);
		}
		System.out.println("afterWTGName sorted list value ----------- : " +afterWTGName );
		
		// compare beforeLastModifiedDate with afterLastModifiedDate
        if (beforeWTGName.equals(afterWTGName) == true) {
            System.out.println(" Array List are equal");
        }
        else
        {
            System.out.println(" Array List are not equal");
        }
		
		
		System.out.println("End " );
				
	}

}
