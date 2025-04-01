package Group_Package.My_Project;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Cart_page;
import pages.Home_Page;
import pages.Product_Page;
import pages.Signin_Page;
import pages.product_view;

public class Search_product_check_filters extends Log_adder{
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
		//System.out.println("Check2: "+driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties_retriever.Data("testing_url"));
		logger.info("URL has been launched");
		driver.manage().window().maximize();
		logger.info("Window has been maximized");
		Page_select.home_page.signin_click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Page_select.signin_page.Enter_email_address(properties_retriever.Data("valid_email"));
		logger.info("Done entering the email address..");
		logger.info("Clicking on Signin..");
		Page_select.signin_page.Click_on_Signin();
		logger.info("Done clicking on Signin..");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Page_select.signin_page.enter_password(properties_retriever.Data("valid_password"));
		Page_select.signin_page.clickon_password_signin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-logo-sprites\"]")));
		logger.info("Successfully Logged in to the application..");
	}
	
	@Test(dependsOnMethods = "Signin_to_the_application")
	public void select_category_of_search_box() throws IOException {
		System.out.println("Checking 3");
		Page_select.home_page.to_Select_Category();
		Page_select.home_page.select_category(properties_retriever.Data("category"));
		//Screenshot_taker.capture_screenshot(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Page_select.home_page.Data_entry_to_searchbox(properties_retriever.Data("search_for"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).perform();
		action.keyUp(Keys.ENTER).perform();
		//action.build().perform();
	}
	
	@Test(dependsOnMethods = "select_category_of_search_box")
	public void Selecting_filters() throws IOException {
		System.out.println("Checking 4");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//Page_select.page.check_the_checkbox_deliveryday(properties_retriever.Data("deliveryday_option"));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Page_select.page.select_price_using_drag();
	}

}
