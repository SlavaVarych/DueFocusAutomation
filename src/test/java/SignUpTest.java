import Base.BaseTest;
import Data.TestDataDueFocus;
import Page.SignUpPage;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.UUID;

public class SignUpTest extends BaseTest {

    SignUpPage objSignUp;


    @Test(priority = 0)
    public void positiveSignUpTest(){
        objSignUp = new SignUpPage(getDriver());

        objSignUp.positiveLogin(TestDataDueFocus.SignUpUser.USER1);
        objSignUp.assertViaNextButtonInNextPage(true);
    }

    @Test(priority = 1)
    public void logoutAfterSignUpTest(){
        objSignUp = new SignUpPage(getDriver());

        objSignUp.logoutAfterSignUp();
    }





}
