package Page;

import Base.BasePage;
import Data.TestDataDueFocus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Data.TestDataDueFocus.LoginUser.USER2;


public class LoginPage extends BasePage {

public WebDriver driver;



By emailAddress = By.xpath("//input[contains(@class,'loginInputField')and contains(@type,'Email')]");
By password = By.xpath("//input[contains(@class,'loginInputField')and contains(@type,'password')]");
By signIn = By.xpath("//button[contains(@class,'signInBtn')]");
By loginInputBlock = By.xpath("//section[contains(@class,'loginInputBlock')]//child::label[contains(@class,'loginInputLabel')and contains(@for,'Email')]");
By errorMessageInvEmail = By.xpath("//span[contains(@class,'errorMessage')]");


int waitTime = 12;


public LoginPage(WebDriver driver){
    PageFactory.initElements(driver, this);
    this.driver = driver;
}

public void loginToDueFocus(TestDataDueFocus.LoginUser USER){
    sendDataToField(emailAddress,waitTime, USER.getLogin());
    sendDataToField(password, waitTime, USER.getPassword());
    click(signIn, waitTime);
}

public void verifyAssertByEmail(boolean shouldBeVisible){
    verifyElementIsVisible(errorMessageInvEmail, shouldBeVisible, waitTime);
}



}
