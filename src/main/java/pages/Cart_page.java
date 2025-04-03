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

public class Cart_page {
	WebDriver driver;
	AtomicInteger index = new AtomicInteger();
	WebDriverWait wait;
	
	public Cart_page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]/div/form/div[2]/div[@role = \"listitem\"]")
	List<WebElement> cart_item_list;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]/div/form/div[2]/div/div[4]/div/div[3]/div[1]/span[1]/span[1]/div/div[2]/span[2]")
	List<WebElement> Quantity_of_items; //number of items available
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]/div/form/div[2]/div/div[4]/div/div[3]/div[1]/span[1]/span[1]/div/button[1]/span")
	List<WebElement> delete_buttons; //quantity of each item
	
	By remove_item_button_xpath = By.xpath("/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]/div/form/div[2]/div/div[4]/div/div[3]/div[1]/span[1]/span[1]/div/button[1]/span");
	
	public int number_of_items_in_cart() {
		return cart_item_list.size();
	}
	
	public void removing_item_count_more_than_1() {
		Quantity_of_items.forEach((WebElement Quantity) -> {
			int i = index.getAndIncrement();
			String count = Quantity.getText();
			int cnt = Integer.parseInt(count);
			for(int j = cnt; j>1; j--) {
				if(j > 1) 
				{
					try {
						
						wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(remove_item_button_xpath).get(i))).click();
						
					}catch(Exception e) {
						
						j++;
						
					}
					
				}else {
					break;
				}
			}
		});
	}

}
