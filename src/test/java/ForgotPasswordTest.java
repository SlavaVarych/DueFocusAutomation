import Base.BaseTest;
import Data.TestDataDueFocus;
import Page.ForgotPasswordPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;



public class ForgotPasswordTest extends BaseTest {

    ForgotPasswordPage objForgotPassword;

    /**
     * In this method we click Forgot Password link from Login Page and click Send Me Instructions
     */
    @Test
    public void forgotPasswordWithoutEmail() throws InterruptedException {
        objForgotPassword = new ForgotPasswordPage(getDriver());

        objForgotPassword.clickForgotPassword();
        objForgotPassword.clickSendMeInstructions();
        objForgotPassword.verifyAssertViaEnterEmailRecommendation(true);
    }
    @Test
    public void forgotPasswordWithEmail() throws InterruptedException {
        objForgotPassword = new ForgotPasswordPage(getDriver());

        objForgotPassword.clickForgotPassword();
        objForgotPassword.enterEmailToEmailFieldOnDueFocus(TestDataDueFocus.LoginUser.USER2);
        objForgotPassword.clickSendMeInstructions();
    }

   // @Test(invocationCount = 10)
    @Test
    public void checkResetEmail() throws AWTException, InterruptedException {
        objForgotPassword = new ForgotPasswordPage(getDriver());

        objForgotPassword.clickForgotPassword();
        objForgotPassword.enterEmailToEmailFieldOnDueFocus(TestDataDueFocus.LoginUser.USER4);
        objForgotPassword.clickSendMeInstructions();
        objForgotPassword.openNewWindow(TestDataDueFocus.LoginUser.USER4);
        objForgotPassword.selectFirstEmail();
        objForgotPassword.deleteResetLetter2();
        objForgotPassword.EmailIsDeletedWaiter();
    }


    @Test
    public void debugP() throws AWTException, InterruptedException {
            objForgotPassword = new ForgotPasswordPage(getDriver());
            objForgotPassword.openNewWindow2();

    }

    @Test
    public void debugG(){
        objForgotPassword = new ForgotPasswordPage(getDriver());
        objForgotPassword.retryingFindElement2();
    }
}
