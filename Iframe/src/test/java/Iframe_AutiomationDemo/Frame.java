package Iframe_AutiomationDemo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	@Test
	public void iframe() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='Multiple']/iframe")));
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div/div/iframe")));
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("1425");
		driver.switchTo().parentFrame();
		
		

		
	}
}
