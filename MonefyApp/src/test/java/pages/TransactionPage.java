package pages;

import java.util.NoSuchElementException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TransactionPage extends BasePage {
	
	private AppiumDriver<MobileElement> _driver;
	
	public TransactionPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		_driver = driver;
	}
	@AndroidFindBy(id="com.monefy.app.pro:id/textViewWholeAmount")
	private MobileElement btnViewWholeAmount;
	
	@AndroidFindBy(id="com.monefy.app.pro:id/textViewTransactionAmount")
	private MobileElement btnViewTransactionAmount;
	
	@AndroidFindBy(id="com.monefy.app.pro:id/buttonKeyboardClear")
	private MobileElement btnKeyboardClear;
	
	@AndroidFindBy(id="com.monefy.app.pro:id/delete")
	private MobileElement btnDeleteTransaction;
	
	@AndroidFindBy(id="com.monefy.app.pro:id/amount_text")
	private MobileElement txtCalculatorAmount;
	
	private MobileElement transactionType;
	
	
	public void openTransaction()
	{
		clickOnElementButton(btnViewWholeAmount);
		clickOnElementButton(btnViewTransactionAmount);	
	}
	
	public void clearTransaction()
	{
		waitForElement(txtCalculatorAmount);
		try {
			String amountDigits = txtCalculatorAmount.getText();
			for(int i = 0; i<amountDigits.length();i++)
			{
				clickOnElementButton(btnKeyboardClear);
			}	
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteTransaction()
	{
		clickOnElementButton(btnDeleteTransaction);
	}
	
	public void openTransactionType(String type)
	{
		transactionType = _driver.findElementByXPath("//*[@text='"+type+"']");
		if(type.equalsIgnoreCase("Bills"))
		{
			clickOnElementButton(transactionType);
		}
		
		clickOnElementButton(btnViewTransactionAmount);	
	}

}
