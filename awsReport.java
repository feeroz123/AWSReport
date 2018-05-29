package src;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class awsReport {

	private static WebDriver driver;
	private static String baseURL;

	public static void setUp() {
		System.out.println("Opening browser...");
		System.setProperty("webdriver.chrome.driver", "D:\\Official\\SELENIUM\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Browser is opened.");
	}

	public static void teardown(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[contains(@title, accountId)]")).click();
		driver.findElement(By.xpath("//div[@id='aws-console-logout']")).click();
		System.out.print("User logged out");
		Thread.sleep(3000);
		driver.close();
		System.out.println("Browser closed.");
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		final String accountId = "";
		final String username = "";
		final String password = ";
		baseURL = "https://subexaws.signin.aws.amazon.com/console";

		// Load the browser and URL
		setUp();

		// Perform login
		loginPage.performLogin(driver, baseURL, accountId, username, password);

		// Navigate to Running Instances page
		driver.findElement(By.className("service-name")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Running Instances")).click();

		// Close the notification
		driver.findElement(By.xpath("//span[text()='x']")).click();

		// Apply filter as feeroz
		driver.findElement(By.xpath("//input[contains(@class,'gwt-TextBox')]")).clear();
		driver.findElement(By.xpath("//input[contains(@class,'gwt-TextBox')]")).sendKeys("feeroz");
		driver.findElement(By.xpath("//input[contains(@class,'gwt-TextBox')]")).sendKeys(Keys.ENTER);
		System.out.println("Filter applied");
		Thread.sleep(4000);
		
		// List generation
		System.out.println("");
		System.out.println("Generating the list ...");
		System.out.println("");
		WebElement element = driver.findElement(By.xpath("//div[@class='GEERFXXDNIG']//tbody"));
		List<WebElement> rows = element.findElements(By.tagName("tr"));
			
		for (int i = 0; i < rows.size(); i++) {
			
			// Looking for Running instances
			if (rows.get(i).getText().contains("running")) {
				
				WebElement projectName = rows.get(i).findElements(By.tagName("td")).get(1);
				WebElement launchTime = rows.get(i).findElements(By.tagName("td")).get(13);

				System.out.println("Project Name = " + projectName.getText());
				System.out.println("Launch Time = " + launchTime.getText());
			}
		}
		
		//teardown(driver);
		
		System.out.println("");
		System.out.println("Task completed.");

	}

}
