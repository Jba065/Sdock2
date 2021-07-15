package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	protected WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jebaraj Isaac J\\eclipse-workspace\\sdock2\\src\\test\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}
}
