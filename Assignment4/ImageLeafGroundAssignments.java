package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageLeafGroundAssignments {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[contains(text(),'image')]/following::img[1]")).click();
		driver.navigate().back();
		int height = driver.findElement(By.xpath("//label[contains(text(),'Broken')]/following::img[1]")).getSize().getHeight();
		if(height==16) {
			System.out.println("Image is broken");
		}
		else {
			System.out.println("Image is not broken");
		}
		driver.findElement(By.xpath("//label[contains(text(),'Mouse')]/following::img[1]")).click();
		driver.close();
	}

}
