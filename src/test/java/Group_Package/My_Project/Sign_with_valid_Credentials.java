package Group_Package.My_Project;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Sign_with_valid_Credentials extends Log_adder{
	
	WebDriver driver;
	WebDriverWait wait;
	Page_Initializer Page_select;
	Driver_Selectable driver_select = new Driver_Selectable();
	@BeforeMethod
	public void selecting_Browser() throws IOException {
		String browser = properties_retriever.Data("browser");
		driver = driver_select.Select_The_Driver(browser);
		Page_select = new Page_Initializer(driver);
		logger.info("WebDriver of type "+browser+" driver has been selected...");
		System.out.println("WebDriver of type "+browser+" driver has been selected...");
	}
	
	@Test
	public void case2() throws InterruptedException, IOException {
		driver.get("https://www.amazon.in");
		logger.info("URL has been launched");
		driver.manage().window().maximize();
		logger.info("Window has been maximized");
		Page_select.home_page.signin_click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		logger.info("Entering the email address.."+Page_select.signin_page.check_element_of_email());
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"continue\"]/span/input"))));
		System.out.println("Entering the email address.."+Page_select.signin_page.check_element_of_email());
		/*if(Page_select.signin_page.check_element_of_email() == "ap_email_login") {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"ap_email_login\"]]"))));
			Page_select.signin_page.Enter_email_address_2(properties_retriever.Data("valid_email"));
		}else {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"ap_email\"]"))));
			Page_select.signin_page.Enter_email_address(properties_retriever.Data("valid_email"));
		}*/
		logger.info("Done entering the email address..");
		logger.info("Clicking on Signin..");
		Page_select.signin_page.Click_on_Signin();
		logger.info("Done clicking on Signin..");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Page_select.signin_page.enter_password(properties_retriever.Data("valid_password"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Page_select.signin_page.clickon_password_signin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		if(Page_select.home_page.get_signed_name() == "Hello, Aravind") {
			logger.info("Successfully logged into the system..");
		}else {
			logger.info("Unable to log into the system, some issue occurred.."+Page_select.home_page.get_signed_name());
		}
		driver.quit();
	}

}
