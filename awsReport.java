import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class awsReport {

	private static WebDriver driver;
	private static String baseURL;

	
	public static void main(String[] args) throws InterruptedException {
			
		final String accountId = "505698109262";
		final String username = "feeroz.alam";
		final String password = "Nikira@Test18";
		baseURL = "https://subexaws.signin.aws.amazon.com/console";
		
		// Load the browser and URL
		setUp();
		
		//Perform login
		loginPage.performLogin(driver, baseURL, accountId, username, password);
		
		//Navigate to Running Instances page
		driver.findElement(By.className("service-name")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Running Instances")).click();
		
		driver.findElement(By.xpath("//span[text()='x']")).click()		// Close the Notification
		driver.findElement(By.xpath("//input[@contains(@class,'gwt-TextBox')]")).clear();
		driver.findElement(By.xpath("//input[@contains(@class,'gwt-TextBox')]")).sendKeys("feeroz");
		
		
		

	}
	
	public static void setUp()  {
		System.out.println("Opening browser...");     
        System.setProperty("webdriver.chrome.driver", "D:\\PersonalData\\FEEROZ\\SELENIUM\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Browser is opened.");
    }

}
