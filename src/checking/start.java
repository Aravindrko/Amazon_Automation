package checking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class start {
	@Test(priority = '1', groups = {"regression"})
	public void you2() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Resources/chromedriver_folder/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
	}
	@Test(priority = '2', dataProvider = "data", dataProviderClass = Dataprovider.class)
	public void you1(Object o) {
		System.out.println("checking2: "+o);
	}
	@Test(priority = '0', dataProvider = "test_dataProvider", dependsOnMethods = "you1")
	public void you3(Integer i, String o) {
		System.out.println("value from data Provider is: "+i+" And string value is: "+o);
	}
	@DataProvider(name = "test_dataProvider")
	public Iterator<Object[]> dataprovider() {
		List<Object[]> l = new ArrayList<>();
		l.add(new Object[]{3, "String"});
		l.add(new Object[] {4, "Integer"});
		return l.iterator();
		//return l;
	}

}
