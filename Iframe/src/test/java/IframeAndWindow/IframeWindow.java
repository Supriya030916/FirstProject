package IframeAndWindow;

import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class IframeWindow {

	@Test
	public void iframeWindow() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		driver.findElement(By.id("account_dd")).click();
		driver.findElement(By.id("user_sign_in_sign_up")).click();
		WebElement frameElement=driver.findElement(By.xpath("//iframe[@class=\"modalIframe\"]"));
		driver.switchTo().frame(frameElement);
		// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"modalIframe\"]")));
		
		WebElement frameElement1=driver.findElement(By.xpath("//iframe[@title=\"Sign in with Google Button\"]"));
		driver.switchTo().frame(frameElement1); 
		driver.findElement(By.xpath("//span[contains(text(),'Sign in with Google')][1]")).click();
		
		String mainwin=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for (String window : windows) {
			if(!window.equals(mainwin)) {
				driver.switchTo().window(window);
				
			}
		}
		
		driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("Kiran@gmail.com");
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().defaultContent();
		driver.close();
	}
}
