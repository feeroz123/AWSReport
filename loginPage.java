package src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	private static void clearfields(WebDriver driver) {
		driver.findElement(By.id("account")).clear();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();	
		System.out.println("Cleared input fields");
	}
	
	public static void performLogin(WebDriver driver,String url, String accId, String uname, String pwd) throws InterruptedException {		
		driver.get(url);		
		System.out.println("URL is loaded");
		
		Thread.sleep(5000);
		clearfields(driver);
		driver.findElement(By.id("account")).sendKeys(accId);
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("signin_button")).click();
		
		System.out.println("Account details are submitted.");
	}
}
