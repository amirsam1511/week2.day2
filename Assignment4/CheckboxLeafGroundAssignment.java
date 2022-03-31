package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxLeafGroundAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[contains(text(),'languages')]/following::input[1]")).click();
		WebElement selectedCheckbox = driver.findElement(By.xpath("//label[contains(text(),'Selenium')]/following::input[1]"));
		if(selectedCheckbox.isSelected()) {
			System.out.println("Selenium is checked");
		}
		else {
			System.out.println("Selenium is not checked");
		}
		driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]//following::input[2]")).click();
		List<WebElement> selectAllCheckbox = driver.findElements(By.xpath("//label[contains(text(),'below')]/following::input"));
		for (WebElement selectedCheck : selectAllCheckbox) {
			if(selectedCheck.isSelected()!=true){
				selectedCheck.click();
			}
		}
	}

}
