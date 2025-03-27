package pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Page {
	
	WebDriver driver;
	AtomicInteger iterator = new AtomicInteger();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[@role = \"listitem\"][1]")
	WebElement product;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[1]/ul/span/span/li/span/a/span")
	List<WebElement> delivery_day_check_box_item_name;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[1]/ul/span/span/li/span/a/div")
	List<WebElement> delivery_day_check_box;
	
	By delivery_day_check_boxes = By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[2]/div[1]/ul/span/span/li/span/a/div");
	
	public Product_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void select_the_product() {
		product.click();
	}
	
	public void check_the_checkbox_deliveryday(String item_name) {
		delivery_day_check_box_item_name.forEach((WebElement item_source_name)->{
			String source_name = item_source_name.getText();
			int i = iterator.incrementAndGet();
			if(item_name.equalsIgnoreCase(source_name)) {
				try {
					System.out.println("entered into the check box condition");
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(delivery_day_check_boxes).get(i))).click();
				}catch(Exception e) {
					i--;
				}
			}else {
				System.out.println("Provided value is not available or value Null");
			}
		});
		
	}

}
