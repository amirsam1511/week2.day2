package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form[@id = 'reg']//input[@name = 'firstname']")).sendKeys("XXX");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Y");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("zzzz@testleaf.com");
		driver.findElement(By.xpath("//input[@name = 'reg_email_confirmation__']")).sendKeys("zzzz@testleaf.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Admin@123");
		WebElement birthDay = driver.findElement(By.id("day"));
		Select selectDay = new Select(birthDay);
		selectDay.selectByValue("15");
		WebElement birthMonth = driver.findElement(By.id("month"));
		Select selectMonth = new Select(birthMonth);
		selectMonth.selectByVisibleText("Nov");
		WebElement birthYear = driver.findElement(By.id("year"));
		Select selectYear = new Select(birthYear);
		selectYear.selectByValue("1995");
		driver.findElement(By.xpath("//input[@value = '1']")).click();
		Thread.sleep(300);
		driver.findElement(By.name("websubmit")).click();
		driver.close();

	}

}
