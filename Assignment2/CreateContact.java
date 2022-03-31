package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Test");
		driver.findElement(By.id("lastNameField")).sendKeys("Leaf");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("XXX");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("YYY");
		driver.findElement(By.xpath("//input[contains(@id,'department')]")).sendKeys("IT");
		driver.findElement(By.xpath("//textarea[contains(@id,'description')]")).sendKeys("TestLeaf started up in 2009, and we�ve been on an epic ride ever since. From our beginnings as an training company, we�ve tried to stay true to our core beliefs and to deliver an exceptional learning experience and job support for our customers and learners.");
		driver.findElement(By.xpath("//input[contains(@id,'Email')]")).sendKeys("XYZ@testleaf.com");
		WebElement option = driver.findElement(By.xpath("//select[contains(@id,'StateProvinceGeoId') ]"));
		Select selectOption = new Select(option);
		selectOption.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[contains(@class,'Submit') ]")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Updated Description");
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
	}

}
