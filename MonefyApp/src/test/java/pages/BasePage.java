package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasePage {

    protected AppiumDriver<MobileElement> driver;
    private static final int TIMEOUT_SECONDS = 20;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected void waitForElement(MobileElement element) {
        new WebDriverWait(driver, TIMEOUT_SECONDS)
            .until(ExpectedConditions.visibilityOf(element));
    }

    protected void clickOnElementButton(MobileElement element) {
        if (element != null) {
            waitForElement(element);
            element.click();
        } else {
            throw new IllegalArgumentException("Element to click cannot be null");
        }
    }

    protected void inputText(MobileElement element, String value) {
        if (element != null) {
            waitForElement(element);
            element.sendKeys(value);
        } else {
            throw new IllegalArgumentException("Element to input cannot be null");
        }
    }

    protected void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
      }
    }
}
