package Iframe_redBus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Iframe {

	@Test
	public void test1() {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver=new ChromeDriver(options);//added options for notifications
		driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("account_dd")).click();
		driver.findElement(By.id("user_sign_in_sign_up")).click();
		WebElement frameElement=driver.findElement(By.xpath("//iframe[@class='modalIframe']"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.id("mobileNoInp")).sendKeys("11536378");
		driver.switchTo().parentFrame();
}
}
