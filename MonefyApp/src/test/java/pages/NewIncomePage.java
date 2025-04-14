package pages;

import java.util.NoSuchElementException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewIncomePage extends BasePage {

	public enum IncomeType {
		DEPOSIT, SALARY, SAVINGS
	}

	@AndroidFindBy(id = "com.monefy.app.pro:id/keyboard_action_button")
	private MobileElement btnChooseCategory;

	@AndroidFindBy(xpath = "//*[@text='Deposits']")
	private MobileElement btnDeposit;

	@AndroidFindBy(xpath = "//*[@text='Salary']")
	private MobileElement btnSalary;

	@AndroidFindBy(xpath = "//*[@text='Savings']")
	private MobileElement btnSavings;

	public NewIncomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickKeyBoardCharacters(String characters) {
		try {
			waitForElement(btnChooseCategory);
			for (char ch : characters.toCharArray()) {
				String keyId = "com.monefy.app.pro:id/buttonKeyboard" + ch;
				MobileElement keyButton = driver.findElementById(keyId);
				waitForElement(keyButton);
				keyButton.click();
			}
		} catch (NoSuchElementException e) {
			System.err.println("Keyboard character not found: " + e.getMessage());
		}
	}

	public void addNewIncome(String income, IncomeType incomeType) {
		clickKeyBoardCharacters(income);
		clickOnElementButton(btnChooseCategory);

		switch (incomeType) {
			case DEPOSIT:
				clickOnElementButton(btnDeposit);
				break;
			case SALARY:
				clickOnElementButton(btnSalary);
				break;
			case SAVINGS:
				clickOnElementButton(btnSavings);
				break;
			default:
				throw new IllegalArgumentException("Unsupported income type: " + incomeType);
		}
	}
}
