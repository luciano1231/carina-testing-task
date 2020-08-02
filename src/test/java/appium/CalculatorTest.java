package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {

//	private final static Logger LOGGER = LogManager.getLogger(CalculatorTest.class);
	static AppiumDriver<MobileElement> apDriver;

	public static void main(String[] args) {

		try {
			openCalculator();
		} catch (MalformedURLException e) {

			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

	}

	public static void openCalculator() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Samsung S8");
		cap.setCapability("udid", "98899a4141434f4350");
		cap.setCapability("platformName", "Android");
		cap.setCapability("addPackage", "com.samsung.android.contacts");
		cap.setCapability("addActivity", "com.samsung.android.contacts.contacslist.IntentTestActivity");

		// cap.setCapability("addPackage", "com.sec.android.app.popupcalculator");
//		cap.setCapability("addActivity", "com.sec.android.app.popupcalculator.NewUnitConverterActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		apDriver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("Application Started.........");

	}

}
