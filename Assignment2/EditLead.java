package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Edit")).click();
		WebElement beforeUpdate = driver.findElement(By.id("updateLeadForm_companyName"));
		beforeUpdate.clear();
		beforeUpdate.sendKeys("Updated Company Name");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
		WebElement updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp"));
		if(updatedCompanyName.isDisplayed()==true) {
			System.out.println("Company Name is Updated");
		}
		else {
			System.out.println("Company Name is not Updated");
		}
					driver.close();
	}

}