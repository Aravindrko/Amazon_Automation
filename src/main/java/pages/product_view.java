package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Group_Package.My_Project.Log_adder;

public class product_view {
	WebDriver driver;
	Log_adder log = new Log_adder();
	
	public product_view(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
	WebElement add_to_cart;
	
	@FindBy(xpath = "//*[@id=\"buy-now-button\"]")
	WebElement buy_now;
	
	@FindBy(xpath = "//*/span/div/span/span[2]")
	List<WebElement> offers;
	
	@FindBy(xpath = "//*/span/h6")
	List<WebElement> offer_type;
	
	public void add_to_cart() {
		add_to_cart.click();
	}
	
	public void buy_now() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		buy_now.click();
	}
	
	public void print_offers() {
		System.out.println("Offers available:");
		log.logger.info("Offers Available: ");
		for(int i = 0; i<offers.size(); i++) {
			String off = offers.get(i).getText();
			String off_type = offer_type.get(i).getText();
			System.out.println(off_type);
			System.out.println(off);
			log.logger.info(off);
		}
	}

}
