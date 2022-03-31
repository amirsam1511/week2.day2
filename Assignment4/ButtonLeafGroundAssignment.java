package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonLeafGroundAssignment {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'Home')]")).click();
		driver.findElement(By.xpath("//img[@alt = 'Buttons']")).click();
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println(location);
		String colorCode = driver.findElement(By.xpath("//button[contains(text(),'color')]")).getCssValue("background-color");
		System.out.println(colorCode);
		Dimension size = driver.findElement(By.id("size")).getSize();
		System.out.println(size);
		driver.close();
	}

}
