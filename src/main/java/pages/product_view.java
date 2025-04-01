package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class product_view {
	WebDriver driver;
	
	public product_view(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
	WebElement add_to_cart;
	
	@FindBy(xpath = "//*[@id=\"buy-now-button\"]")
	WebElement buy_now;
	
	public void add_to_cart() {
		add_to_cart.click();
	}
	
	public void buy_now() {
		buy_now.click();
	}

}
