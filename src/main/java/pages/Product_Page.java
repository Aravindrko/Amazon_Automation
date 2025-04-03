package pages;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Page {
	
	WebDriver driver;
	AtomicInteger iterator = new AtomicInteger();
	WebDriverWait wait;
	Actions action;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div")
	WebElement product;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/a")
	WebElement product_link;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[1]/ul/span/span/li/span/a/span")
	List<WebElement> delivery_day_check_box_item_name;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[1]/ul/span/span/li/span/a/div")
	List<WebElement> delivery_day_check_box;
	
	@FindBy(xpath = "//*[@id=\"p_36/range-slider_slider-item_lower-bound-slider\"]")
	WebElement low_end_nob;
	
	@FindBy(xpath = "//*[@id=\"p_36/range-slider_slider-item_upper-bound-slider\"]")
	WebElement high_end_nob;
	
	By delivery_day_check_boxes = By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[1]/ul/span/span/li/span/a/div");
	
	By check_box_name = By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[1]/ul/span/span/li/span/a/span");
	
	By product1 = By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[@role = \"listitem\"][1]");
	
	public Product_Page(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	public void select_the_product() {
		
			wait.until(ExpectedConditions.elementToBeClickable(product));
			product.click();
	}
	
	public void check_the_checkbox_deliveryday(String item_name) {
		delivery_day_check_box_item_name.forEach((WebElement item_source_name)->{
			String source_name;
			int i = iterator.incrementAndGet();
			try {
				source_name = wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(check_box_name).get(i-1))).getText();
			}catch(Exception e) {
				source_name = wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(check_box_name).get(i-1))).getText();
			}
			if(item_name.equalsIgnoreCase(source_name)) {
				try {
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(delivery_day_check_boxes).get(i-1))).click();
				}catch(Exception e) {
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(delivery_day_check_boxes).get(i-1))).click();
				}
			}else {
				System.out.println("Provided value is not available or value Null");
			}
		});
		
	}
	
	public void select_price_using_drag() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement low = driver.findElement(By.xpath("//input[@type = \"range\" and @aria-label= \"Minimum price\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(low));
		js.executeScript("arguments[0].value = 30;", low);
		js.executeScript("arguments[0].dispatchEvent(new Event('input'));", low);
		
	}
	
	public void select_the_product_with_link() {
		String Product_Link = product_link.getAttribute("href");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(Product_Link);
		//product_link.getAttribute("href");
	}

}
