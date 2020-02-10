import Base.BaseTest;
import Page.LoginPage;
import org.testng.annotations.Test;

import static Data.TestDataDueFocus.LoginUser.USER1;
import static Data.TestDataDueFocus.LoginUser.USER2;

public class LoginPageTest extends BaseTest {

    LoginPage objLogin;

    @Test
/**
 * Test with lowercase letters + numbers password and invalid login
  */
    public void loginTestWithLowerCaseNumbersInvLogin() throws InterruptedException {
        objLogin = new LoginPage(getDriver());

        objLogin.loginToDueFocus(USER1);

        objLogin.verifyAssertByEmail(true);


    }


    @Test
/**
 * Test with lowercase letters + numbers password and valid login
  */
    public void loginTestWithLowerCaseNumbers() throws InterruptedException {
        objLogin = new LoginPage(getDriver());

        objLogin.loginToDueFocus(USER2);

        objLogin.verifyAssertByEmail(false);





    }




}


