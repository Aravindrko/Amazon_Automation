package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressPhoneNumber\"]")
	WebElement enter_phone;
	
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]")
	WebElement enter_postal;
	
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressLine1\"]")
	WebElement enter_address;
	
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressCity\"]")
	WebElement enter_town;
	
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressStateOrRegion\"]/span/span/span")
	WebElement state_drop;
	
	@FindBy(xpath = "//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")
	WebElement add_address_button;
	
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
	
	public void enter_phone(String phone) {
		wait.until(ExpectedConditions.elementToBeClickable(enter_phone));
		enter_phone.sendKeys(phone);
	}
	
	public void enter_postal(String post) {
		wait.until(ExpectedConditions.elementToBeClickable(enter_postal));
		enter_postal.sendKeys(post);
	}
	
	public void enter_address(String address) {
		wait.until(ExpectedConditions.elementToBeClickable(enter_address));
		enter_address.sendKeys(address);
	}
	
	public void enter_town(String town) {
		wait.until(ExpectedConditions.elementToBeClickable(enter_town));
		enter_town.sendKeys(town);
	}
	
	public void enter_state(String state) {
		wait.until(ExpectedConditions.elementToBeClickable(enter_town));
		List<WebElement>states = driver.findElements(By.xpath("/html/body/div[12]/div/div/ul/li/a"));
		state_drop.click();
		for(WebElement sta: states) {
			if(state == sta.getText()) {
				sta.click();
			}else {
				System.out.println("No such state Found");
			}
		}
	}
	
	public void add_address() {
		wait.until(ExpectedConditions.elementToBeClickable(add_address_button));
		add_address_button.click();
	}

}
