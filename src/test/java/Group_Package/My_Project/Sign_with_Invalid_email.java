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

public class Sign_with_Invalid_email extends Log_adder{
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
	@Test(priority = '2')
	public void case2() throws InterruptedException, IOException {
		driver.get("https://www.amazon.in");
		logger.info("URL has been launched");
		driver.manage().window().maximize();
		logger.info("Window has been maximized");
		Page_select.home_page.signin_click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		logger.info("Entering the email address..");
		if(Page_select.signin_page.check_element_of_email() == "//*[@id=\"ap_email_login\"]") {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"ap_email_login\"]]"))));
			Page_select.signin_page.Enter_email_address_2(properties_retriever.Data("valid_email"));
		}else {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"ap_email\"]"))));
			Page_select.signin_page.Enter_email_address(properties_retriever.Data("valid_email"));
		}
		logger.info("Done entering the email address..");
		logger.info("Clicking on Signin..");
		Page_select.signin_page.Click_on_Signin();
		logger.info("Done clicking on Signin..");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String s = Page_select.signin_page.Read_the_Error();
		Assert.assertEquals("We cannot find an account with that email address", s);
		logger.error("Got an error upon entering the email address saying: "+"' "+s+" .'");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.quit();
	}

}
