package checking;

import org.testng.annotations.DataProvider;

public class Dataprovider{
	@DataProvider
	public Object[] data() {
		return new Object[]{1, "word"};
	}

}
