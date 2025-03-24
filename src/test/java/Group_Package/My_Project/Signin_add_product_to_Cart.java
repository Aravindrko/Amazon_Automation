package Group_Package.My_Project;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Signin_add_product_to_Cart extends Log_adder{
	
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
	public void Signin_to_the_application() throws InterruptedException, IOException {
		driver.get("https://www.amazon.in");
		logger.info("URL has been launched");
		driver.manage().window().maximize();
		logger.info("Window has been maximized");
		Page_select.home_page.signin_click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		logger.info("Entering the email address.."+Page_select.signin_page.check_element_of_email());
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"continue\"]/span/input"))));
		System.out.println("Entering the email address.."+Page_select.signin_page.check_element_of_email());
		if(Page_select.signin_page.check_element_of_email() == "ap_email_login") {
			Page_select.signin_page.Enter_email_address_2(properties_retriever.Data("valid_email"));
		}else {
			Page_select.signin_page.Enter_email_address(properties_retriever.Data("valid_email"));
		}
		logger.info("Done entering the email address..");
		logger.info("Clicking on Signin..");
		Page_select.signin_page.Click_on_Signin();
		logger.info("Done clicking on Signin..");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Page_select.signin_page.enter_password(properties_retriever.Data("valid_password"));
		Page_select.signin_page.clickon_password_signin();
		wait.until(ExpectedConditions.urlToBe(properties_retriever.Data("signin_url")));
		logger.info("Successfully Logged in to the application..");
		
	}
	
	@Test(dependsOnMethods = "Signin_to_the_application")
	public void search_and_add_product_to_cart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		try {
			Page_select.home_page.Data_entry_to_searchbox(properties_retriever.Data("search_for"));
			logger.info("Successfully entered the search criteria into the search field..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info("unable to enter the search criteria into the search field reason: "+e.getMessage());
		}
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER);
		action.keyUp(Keys.ENTER);
		action.build().perform();
		logger.info("searching for the product..");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String page1 = driver.getWindowHandle();
		logger.info("opening the product");
		Page_select.page.select_the_product();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String page2 = driver.getWindowHandle();
		driver.switchTo().window(page2);
		Page_select.productview.add_to_cart();
		logger.info("Successfully added product to the cart..");
	}

}
