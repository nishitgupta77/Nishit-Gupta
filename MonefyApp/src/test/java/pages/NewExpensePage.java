package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewExpensePage extends BasePage {

    private final AppiumDriver<MobileElement> driver;

    public NewExpensePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }

    @AndroidFindBy(id = "com.monefy.app.pro:id/keyboard_action_button")
    private MobileElement btnChooseCategory;

    @AndroidFindBy(xpath = "//*[@text='Bills']")
    private MobileElement btnBills;

    @AndroidFindBy(xpath = "//*[@text='Salary']")
    private MobileElement btnSalary;

    @AndroidFindBy(xpath = "//*[@text='Savings']")
    private MobileElement btnSavings;

    @AndroidFindBy(id = "com.monefy.app.pro:id/keyboard_action_button")
    private MobileElement btnAddExpense;

    /**
     * Enters amount by simulating key presses.
     *
     * @param input String containing characters (0-9, ., etc.)
     */
    public void enterAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input amount cannot be null or empty.");
        }

        try {
            waitForElement(btnChooseCategory); // Assuming this ensures screen is ready
            for (char ch : input.toCharArray()) {
                String keyId = "com.monefy.app.pro:id/buttonKeyboard" + ch;
                MobileElement keyButton = driver.findElement(By.id(keyId));
                waitForElement(keyButton);
                keyButton.click();
            }
        } catch (NoSuchElementException e) {
            System.err.println("Failed to enter amount due to missing key: " + e.getMessage());
            e.printStackTrace(); // Consider using a logger
        }
    }

    /**
     * Adds a new expense and selects category by visible text.
     */
    public void addNewExpense(String amount, String category) {
        enterAmount(amount);
        clickOnElementButton(btnChooseCategory);

        try {
            MobileElement selectedCategory = driver.findElement(By.xpath("//*[@text='" + category + "']"));
            clickOnElementButton(selectedCategory);
        } catch (NoSuchElementException e) {
            System.err.println("Category '" + category + "' not found.");
            e.printStackTrace();
        }
    }

    /**
     * Quickly adds an expense and confirms it with the action button.
     */
    public void confirmExpense(String amount) {
        enterAmount(amount);
        clickOnElementButton(btnAddExpense);
    }
}
