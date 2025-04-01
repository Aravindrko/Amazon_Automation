package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class add_address_page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"add-new-address-desktop-sasp-tango-link\"]/span/a")
	WebElement add_delivery_address;
	
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressFullName\"]")
	WebElement enter_name;
	
	public add_address_page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void click_on_add_address() {
		wait.until(ExpectedConditions.elementToBeClickable(add_delivery_address));
		add_delivery_address.click();
	}
	
	public void entering_name(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(enter_name));
		enter_name.sendKeys(name);
	}

}
