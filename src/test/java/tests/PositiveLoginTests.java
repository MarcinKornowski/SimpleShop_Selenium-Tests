package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigations.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase{

    @Test
    public void asUserLoginWithCorrectPasswordAndLogin() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        boolean isLogoDisplayed = loginPage
                .typeIntoUserNameField("j2ee")
                .typeIntoUserPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerLogoDisplayed();

        assertTrue(isLogoDisplayed);

    }

}
