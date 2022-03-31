package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkLeafGroundAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Page')]")).click();
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		String attribute = driver.findElement(By.partialLinkText("clicking")).getAttribute("href");
		System.out.println(attribute);
		WebElement brokenPage = driver.findElement(By.partialLinkText("broken"));
		brokenPage.click();
		String title = driver.getTitle();
		if(title.equals("404 Not Found")) {
			System.out.println("Page is broken");
		}
		else {
			System.out.println("Page is not broken");
		}
		driver.navigate().back();
		driver.findElement(By.xpath("//label[@for='position']/preceding::a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='Link']")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//section[@class = 'innerblock']//a"));
		System.out.println(findElements.size());
	}

}
