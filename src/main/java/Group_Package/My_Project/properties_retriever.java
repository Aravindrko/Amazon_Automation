package Group_Package.My_Project;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class properties_retriever {
	public static String Data(String Key_Value) throws IOException {
		FileReader reader = new FileReader(System.getProperty("user.dir")+"/Resources/Login_Details.Properties");
		Properties p = new Properties();
		p.load(reader);
		String s = (String)p.get(Key_Value);
		return s;
	}

}
