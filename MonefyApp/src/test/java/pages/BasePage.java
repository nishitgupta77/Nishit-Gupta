package pages;

import java.awt.RenderingHints.Key;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	
	private static AppiumDriver<MobileElement> driver;

	public BasePage(AppiumDriver<MobileElement> driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void waitForElement(MobileElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickOnElementButton(MobileElement element)
    {
		waitForElement(element);
        element.click();
    }	
	
	public void inputElementField(MobileElement element, String value)
    {
		waitForElement(element);
	    element.sendKeys(value);
    }	
	public void hideKeyBoard() {
		driver.hideKeyboard();
		
	}
		
}
