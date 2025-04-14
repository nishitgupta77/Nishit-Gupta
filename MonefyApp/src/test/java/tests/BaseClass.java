package tests;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import pages.DashboardPage;

public class BaseClass {
	
	public AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setup() {
		try {
			
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config.properties");
			Properties prop=new Properties();
			prop.load(fs);
			
			File appDir = new File("src");
			File app = new File(appDir,prop.get("appApk").toString());

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("deviceName"));
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.get("platformVersion"));
			cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
			
		    driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception e) {
			System.out.println("Cause is :" + e.getCause());
			System.out.println("Cause is :" + e.getMessage());
			e.printStackTrace();
		}
	}	
	
	@AfterMethod
	public void Cleanup() {
		driver.quit();
	}

}
