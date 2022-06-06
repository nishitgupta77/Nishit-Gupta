package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewIncomePage extends BasePage {

	private AppiumDriver<MobileElement> _driver;

	public NewIncomePage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		_driver = driver;
	}
	
	@AndroidFindBy(id="com.monefy.app.pro:id/keyboard_action_button")
	private MobileElement btnChooseCategory;

	@AndroidFindBy(xpath="//*[@text='Deposits']")
	private MobileElement btnDeposit;

	@AndroidFindBy(xpath="//*[@text='Salary']")
	private MobileElement btnSalary;

	@AndroidFindBy(xpath="//*[@text='Savings']")
	private MobileElement btnSavings;

	@AndroidFindBy(xpath="com.monefy.app.pro:id/buttonKeyboard")
	private MobileElement btnCalculator;

	public void clickKeyBoardCharacters(String character) {

		try {
			waitForElement(btnChooseCategory);
			char[] ch = character.toCharArray();
			for(int i = 0; i<character.length();i++)
			{
				btnCalculator = _driver.findElementById("com.monefy.app.pro:id/buttonKeyboard" + ch[i]);
				waitForElement(btnCalculator);
				btnCalculator.click();
			}
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}

	public void addNewIncome(String income,String incomeType) {
		clickKeyBoardCharacters(income);	
		clickOnElementButton(btnChooseCategory);
		switch(incomeType)
		{
		case "Deposit":
	      	clickOnElementButton(btnDeposit);
	      	break;
		case "Salary":
	      	clickOnElementButton(btnSalary);
	      	break;
		case "Savings":
	      	clickOnElementButton(btnSavings);
	      	break;
	    default: 
	    	System.out.println("Invalid income Type");
		}
		
	}

}


