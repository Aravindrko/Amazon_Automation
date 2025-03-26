package Group_Package.My_Project;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Verifying_elements_in_cart extends Log_adder{	
	WebDriver driver;
	WebDriverWait wait;
	Page_Initializer Page_select;
	Driver_Selectable driver_select = new Driver_Selectable();
	@BeforeClass
	public void Initilizer() throws IOException {
		String browser = properties_retriever.Data("browser");
		driver = driver_select.Select_The_Driver(browser);
		Page_select = new Page_Initializer(driver);
		logger.info("WebDriver of type "+browser+" driver has been selected...");
		System.out.println("WebDriver of type "+browser+" driver has been selected...");
	}
	
	@Test
	public void Signin_to_the_application() throws InterruptedException, IOException {
		driver.get("https://www.amazon.in");
		logger.info("URL has been launched");
		driver.manage().window().maximize();
		logger.info("Window has been maximized");
		Page_select.home_page.signin_click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Page_select.signin_page.Enter_email_address(properties_retriever.Data("valid_email"));
		logger.info("Done entering the email address..");
		logger.info("Clicking on Signin..");
		Page_select.signin_page.Click_on_Signin();
		logger.info("Done clicking on Signin..");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Page_select.signin_page.enter_password(properties_retriever.Data("valid_password"));
		Page_select.signin_page.clickon_password_signin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-logo-sprites\"]")));
		logger.info("Successfully Logged in to the application..");
	}
	
	@Test(priority = 1, dependsOnMethods = "Signin_to_the_application", enabled = false)
	public void verifying_the_cart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Page_select.home_page.click_on_cart();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		logger.info("Number of items available in the cart: "+Page_select.cart_page.number_of_items_in_cart());
		driver.navigate().back();
	}
	
	@Test(priority = 2, dependsOnMethods = "Signin_to_the_application", enabled = true)
	public void reducing_the_item_count() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Page_select.home_page.click_on_cart();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Page_select.cart_page.removing_item_count_more_than_1();
	}
	
	

}
