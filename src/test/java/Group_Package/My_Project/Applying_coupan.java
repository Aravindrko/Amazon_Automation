package Group_Package.My_Project;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Applying_coupan extends Log_adder{
	WebDriver driver;
	WebDriverWait wait;
	Page_Initializer Page_select;
	Driver_Selectable driver_select = new Driver_Selectable();
	Actions action;
	@BeforeClass
	public void selecting_Browser() throws IOException {
		String browser = properties_retriever.Data("browser");
		driver = driver_select.Select_The_Driver(browser);
		Page_select = new Page_Initializer(driver);
		action = new Actions(driver);
		logger.info("WebDriver of type "+browser+" driver has been selected...");
		System.out.println("WebDriver of type "+browser+" driver has been selected...");
	}
	
	@Test()
	public void Signin_to_the_application() throws InterruptedException, IOException {
		driver.get(properties_retriever.Data("testing_url"));
		logger.info("URL has been launched");
		driver.manage().window().maximize();
		logger.info("Window has been maximized");
		Page_select.home_page.signin_click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@name = \"email\"]"))));
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
	
	@Test(dependsOnMethods = "Signin_to_the_application")
	public void search_for_the_product() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		try {
			Page_select.home_page.Data_entry_to_searchbox(properties_retriever.Data("search_for"));
			logger.info("Successfully entered the search criteria into the search field..");
		} catch (IOException e) {
			logger.info("unable to enter the search criteria into the search field reason: "+e.getMessage());
		}
		action.keyDown(Keys.ENTER);
		action.keyUp(Keys.ENTER);
		action.build().perform();
		logger.info("searching for the product..");
		String page1 = driver.getWindowHandle();
		logger.info("opening the product");
		Page_select.page.select_the_product_with_link();
		Set<String> handles = driver.getWindowHandles();
		for(String handle: handles) {
			if(page1 == handle) {
				continue;
			}else {
				driver.switchTo().window(handle);
			}
		}
		
	}
	
	@Test(dependsOnMethods = "search_for_the_product")
	public void get_the_offers_available() throws IOException {
		Page_select.productview.print_offers();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Page_select.productview.buy_now();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Page_select.address.click_on_add_address();
		Page_select.address.entering_name(properties_retriever.Data("name"));
		Page_select.address.enter_address(properties_retriever.Data("address"));
		Page_select.address.enter_phone(properties_retriever.Data("phone"));
		Page_select.address.enter_postal(properties_retriever.Data("zip"));
		//Page_select.address.enter_town(properties_retriever.Data("city"));
		//Page_select.address.enter_state(properties_retriever.Data("state"));
		Page_select.address.click_on_add_address();
		System.out.println("end of the class");
		
		
	}

}
