package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(name = "username")
    private WebElement userNameField;

    @FindBy(name = "password")
    private WebElement userPasswordInput;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage typeIntoUserNameField(String userName) {
        WaitForElement.waitUntilElementIsVisible(userNameField);
        userNameField.sendKeys(userName);
        logger.info("Typed into User Name field:{}", userName);
        return this;
    }

    public LoginPage typeIntoUserPasswordField(String userPassword) {
        userPasswordInput.clear();
        userPasswordInput.sendKeys(userPassword);
        logger.info("Typed into Password field:{}", userPassword);
        return this;
    }

    public PageFooter clickOnLoginButton() {
        signOnButton.click();
        logger.info("Clicked on Login Button");
        return new PageFooter();
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        logger.info("Returned warning message was:{}", messageLabel.getText());
        return messageLabel.getText();
    }
}
