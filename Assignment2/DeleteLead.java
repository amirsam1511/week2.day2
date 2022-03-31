package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//a[contains(@class,'x-tab-right')]/following::span")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9701331462");
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		String text = driver.findElement(By.xpath("//td[contains(@class,'first ')]/div[1]")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//td[contains(@class,'first ')]/div/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text() = 'Delete']")).click();
		driver.findElement(By.xpath("//a[text() = 'Find Leads']")).click();
		driver.findElement(By.name("id")).sendKeys(text);
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		Thread.sleep(3000);
		String recordDeleted = driver.findElement(By.xpath("//div[@class = 'x-paging-info']")).getText();
		if(recordDeleted.equals("No records to display")) {
			System.out.println("Record has been deleted");
		}
		else {
			System.out.println("Record has not been deleted");
		}
		driver.close();
		
	}

}
