package Group_Package.My_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Project_functions {
	
	public static void main(String[]args) {
		List<Integer> Quantity_of_items = new ArrayList<Integer>();
		Quantity_of_items.add(3);
		Quantity_of_items.add(5);
		AtomicInteger index = new AtomicInteger();
		System.out.println("item in the list: "+Quantity_of_items.get(0));
		Quantity_of_items.forEach((Integer Quantity) -> {
			int i = index.getAndIncrement();
			//String count = Quantity.getText();
			int cnt = Quantity;
			for(int j = cnt; j>1; j--) {
				if(j > 1) 
				{
					//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					//wait.until(ExpectedConditions.elementToBeClickable(quantity_number.get(j-1)));
					//quantity_number.get(i-1).click();
					System.out.println(j);
				}else {
					break;
				}
			}
			System.out.println("value of I: "+i);
		});
	}

}
