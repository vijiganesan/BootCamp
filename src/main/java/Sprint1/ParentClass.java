package Sprint1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentClass {
	
	ChromeDriver driver;
	public String workBookName;
	

	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {

		return ReadExcel.readData(workBookName);

	}
	

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void openBrowser(String url, String uName, String pWord) throws InterruptedException {
		// download the chromedriver and set the path
		WebDriverManager.chromedriver().setup();

		// Handle Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		// 1. Login to https://login.salesforce.com
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.id("Login")).click();

		Thread.sleep(2000);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
