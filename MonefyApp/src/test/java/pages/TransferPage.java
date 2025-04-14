package pages;

import java.util.NoSuchElementException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TransferPage extends BasePage {
	
	private AppiumDriver<MobileElement> _driver;
	
	public TransferPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		_driver = driver;
	}
	@AndroidFindBy(id="com.monefy.app.pro:id/amount_text")
	private MobileElement btnAmountInput;
	
	@AndroidFindBy(id="com.monefy.app.pro:id/keyboard_action_button")
	private MobileElement btnAddTransfer;
	
	
	
	public void openInputAmount()
	{
		clickOnElementButton(btnAmountInput);
	}
	
	public void addTransfer()
	{
		clickOnElementButton(btnAddTransfer);
	}	
}
