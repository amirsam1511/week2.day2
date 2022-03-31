package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeafGroundAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("sam@gmail.com");
		driver.findElement(By.xpath("//input[@value = 'Append ']")).sendKeys("Text");
		String defaultText = driver.findElement(By.xpath("//input[@value = 'TestLeaf']")).getAttribute("value");
		System.out.println(defaultText);
		driver.findElement(By.xpath("//input[@value = 'Clear me!!']")).clear();
		WebElement disabledfield = driver.findElement(By.xpath("//label[contains(@for,'disabled')]/following::input"));
		if(disabledfield.isEnabled()==true) {
			System.out.println("Field is enabled");
		}
		else {
			System.out.println("Field is disabled");
		}
		driver.close();
		
	}

}
