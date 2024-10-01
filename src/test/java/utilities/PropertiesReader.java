
package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties");

		Properties prop = new Properties();
		prop.load(fr);
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("testurl"));

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("testurl");
		System.out.println(browser);
		System.out.println(url);
	}
}
