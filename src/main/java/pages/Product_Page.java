package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Page {
	
	WebDriver driver;
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[@role = \"listitem\"][1]")
	///html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[@role = "listitem"]
	WebElement product;
	
	public Product_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void select_the_product() {
		product.click();
	}

}
