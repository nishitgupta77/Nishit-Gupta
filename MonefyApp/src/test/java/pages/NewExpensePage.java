package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewExpensePage extends BasePage {

	private AppiumDriver<MobileElement> _driver;

	public NewExpensePage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		_driver = driver;
	}
	
	@AndroidFindBy(id="com.monefy.app.pro:id/keyboard_action_button")
	private MobileElement btnChooseCategory;

	@AndroidFindBy(xpath="//*[@text='Bills']")
	private MobileElement btnBills;

	@AndroidFindBy(xpath="//*[@text='Salary']")
	private MobileElement btnSalary;

	@AndroidFindBy(xpath="//*[@text='Savings']")
	private MobileElement btnSavings;

	@AndroidFindBy(xpath="com.monefy.app.pro:id/buttonKeyboard")
	private MobileElement btnCalculator;
	
	@AndroidFindBy(id="com.monefy.app.pro:id/keyboard_action_button")
	private MobileElement btnAddExpense;

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

	public void addNewExpense(String income, String category) {
		clickKeyBoardCharacters(income);	
		clickOnElementButton(btnChooseCategory);
		MobileElement selectCategory = _driver.findElementByXPath("//*[@text='"+category+"']");
		clickOnElementButton(selectCategory);
	}

	public void addIconExpense(String expense) {
		clickKeyBoardCharacters(expense);
		clickOnElementButton(btnAddExpense);
	}
}


