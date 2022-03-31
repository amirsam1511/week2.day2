package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownLeafGroundAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		WebElement findElement = driver.findElement(By.id("dropdown1"));
		Select selectIndex = new Select(findElement);
		selectIndex.selectByIndex(1);
		WebElement dropdown = driver.findElement(By.name("dropdown2"));
		Select selectText = new Select(dropdown);
		selectText.selectByVisibleText("Selenium");
		WebElement dropdown3 = driver.findElement(By.id("dropdown3"));
		Select selectValue = new Select(dropdown3);
		selectValue.selectByValue("1");
		WebElement dropdown4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select dropdownOptions = new Select(dropdown4);
		System.out.println(dropdownOptions.getOptions().size());
		WebElement dropdown5 = driver.findElement(By.xpath("//select[@class='dropdown']/following::div/select[1]"));
		dropdown5.sendKeys("Selenium");
		driver.findElement(By.xpath("//option[contains(text(),'programs')]/following::option")).click();
		driver.close();
	}

}
