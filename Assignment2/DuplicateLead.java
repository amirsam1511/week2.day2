package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[@class = 'x-tab-strip-inner']/following::span[3]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("chandrasekar.89@gmail.com");
		driver.findElement(By.xpath("//td[contains(@class,'btn-center')]/following::button[6]")).click();
		Thread.sleep(3000);
		String firstName = driver.findElement(By.xpath("//div[contains(@class,'grid3-col-firstName')]/a")).getText();
		driver.findElement(By.xpath("//div[contains(@class,'grid3-col-firstName')]/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//input[contains(@class,'Submit') ]")).click();
		String duplicatedName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(duplicatedName.equals(firstName)) {
			System.out.println("Duplicated lead name is same as Captured name");
		}
		else {
			System.out.println("Duplicated lead name is not as same as Captured name");
		}
		driver.close();
		
	}

}
