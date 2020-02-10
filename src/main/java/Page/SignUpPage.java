package Page;

import Base.BasePage;
import Data.TestDataDueFocus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePage {
    
    public WebDriver driver;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    By createNewAccount = By.xpath("//a[contains(text(),'Create New Account')]");
    By firstNameField = By.xpath("//input[contains(@placeholder,'First name')]");
    By lastNameField = By.xpath("//input[contains(@placeholder,'Last name')]");
    By emailField = By.xpath("//input[contains(@placeholder,'Email')]");
    By passwordField = By.xpath("//input[contains(@placeholder,'Password at least 8 characters')]");

    By checkBox = By.xpath("//label[contains(@class,'checkboxLabel')]");
    By signUpButton = By.xpath("//button[contains(text(),'Sign Up')]");
    By passwordHint = By.xpath("//div[contains(@class,'passwordHint')]");
    By nextButtonAfterSignUp = By.xpath("//button[contains(text(),'Next')]");

    By avatarButton = By.xpath("//img[contains(@class,'avatar')]");


    int waitTime = 15;

    public static Integer count = 0;

    public void positiveLogin(TestDataDueFocus.SignUpUser USER){


        click(createNewAccount, waitTime);
        sendDataToField(firstNameField, waitTime, USER.getFirstName());
        sendDataToField(lastNameField, waitTime, USER.getLastName());
        sendDataToField(emailField, waitTime, USER.getEmail());
        sendDataToField(passwordField, waitTime, USER.getPassword());
        click(passwordHint, waitTime);
        click(checkBox, waitTime);
        click(signUpButton, waitTime);
        count++;

    }

   public static Integer getCount(){
        return count;
   }

    public void assertViaNextButtonInNextPage(boolean shouldBeVisible){
        verifyElementIsVisible(nextButtonAfterSignUp, shouldBeVisible, waitTime);
    }

    public void logoutAfterSignUp(){
        click(nextButtonAfterSignUp, waitTime);
        click(nextButtonAfterSignUp, waitTime);
        click(nextButtonAfterSignUp, waitTime);
        click(avatarButton, waitTime);

    }


    





    

}
