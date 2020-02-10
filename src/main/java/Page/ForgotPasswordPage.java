package Page;

import Base.BasePage;
import Data.TestDataDueFocus;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static Base.BaseTest.getDriver;
import static Data.TestDataDueFocus.LoginUser.USER3;

public class ForgotPasswordPage extends BasePage {

    public WebDriver driver;

    By forgotPassword = By.xpath("//a[contains(@class,'forgotPass')]");
    By forgotPassword2 = By.xpath("//p[contains(text(),'Forgot password?')]");
    By emailAddress = By.xpath("//input[contains(@class,'loginInputField')and contains(@placeholder,'Your email address')]");
    By gmailEnterEmail = By.xpath("//input[@type='email' and @id='Email']");
    By gmailEnterPassword = By.xpath("//*[@id='Passwd']");
    By nextButtonGmail = By.xpath("//*[@id='next']");
    By nextButtonGmailPassword = By.xpath("//*[@id='signIn']");
    By resetPasswordEmail = By.xpath("//table[@role='grid']//tr[1]");
   // By resetPasswordEmail = By.xpath("//span[@id=':2y']//child::span[contains(text(),'DueFocus password reset')]");
    By sendMeInstructions = By.xpath("//button[contains(text(),'Send Me Instructions')]");
    By enterYourEmailRecommendation = By.xpath("//span[contains(@class,'recommendation')and contains(text(),'Enter your email address')]");
    By resetButtonInEmail = By.xpath("//a[contains(text(),'Reset')]");
    By resetHeaderInEmail = By.xpath("//span[.='Reset your password']");
    By tryOneMoreTimeGmailAccount = By.xpath("//*[.='Повторить попытку']");
    By link = By.linkText("//*[@id=\"root\"]/section/section/div/div/form/section[2]/a/p");
    By link2 = By.partialLinkText("/login/recovery");
    By allDiv = By.xpath("//div");

    By addGmailAccountButton = By.xpath("//*[@id='account-chooser-add-account']");
    By deleteButtonInEmail = By.xpath("//*[@id=':4']/div[2]/div[1]/div/div[2]/div[3]/div");
    By firstCheckBoxForDeleteEmail = By.xpath("//table[@role='grid']//tbody//div[@role='checkbox'][1]");
    By firstEmailFromList = By.xpath("//table[@role='grid']//tr[@role='row'][1]");
    By deleteButtonInPopUpAfterRightClickOnEmail = By.xpath("//div[@role='menu']//div[@role='menuitem']//div[.='Удалить']");
    By enteredGmail = By.xpath("//div[contains(@title, 'Поиск') and contains(text(),'Входящие')]");
    By chainInBasket = By.xpath("//span[contains(text(),'Цепочка помещена в корзину')]");

    By signIn = By.xpath("//button[contains(@class,'signInBtn1')]");

   // <button type="submit" id="choose-account-0" name="Email" value="slava.varych11@gmail.com"
    // class="V2qUud" tabindex="0" jsname="mzNpsf" data-value="slava.varych11@gmail.com">
    // <img class="zHvs5" alt="" src="https://lh3.googleusercontent.com/-FMG8p1q1OyA/AAAAAAAAAAI/AAAAAAAAAAA/ACHi3rcLHYIC5ixGCXmL2DmmpxW3lztfkQ/photo.jpg?sz=64"
    // id="account-image-0"><span class="tRmeue EcSOLd"> <br> </span><span class="gu0k2c EcSOLd">slava.varych11@gmail.com</span><span class="EcSOLd OEYkZe" id="signin_status"><em>Ви вийшли з облікового запису</em></span></button>


    int waitTime = 20;
    String gmailURL = "https://mail.google.com/";


    public ForgotPasswordPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickForgotPassword(){
      //  waitAllPresenceOfAllElements(forgotPassword2, waitTime);
      //  click(forgotPassword2, waitTime);
        clickUntilClicked(forgotPassword2, sendMeInstructions, waitTime );
    }

    public void clickSendMeInstructions(){

        click(sendMeInstructions, waitTime);
    }


    public void verifyAssertViaEnterEmailRecommendation(boolean shouldBeVisible){

        verifyElementIsVisible(enterYourEmailRecommendation, shouldBeVisible, waitTime);

    }

    public void enterEmailToEmailFieldOnDueFocus(TestDataDueFocus.LoginUser USER){
        clearField(emailAddress, waitTime);
        sendDataToField(emailAddress, waitTime, USER.getLogin());
    }


    public void loginToGmailAccount(TestDataDueFocus.LoginUser USER){
        sendDataToField(gmailEnterEmail,waitTime, USER.getLogin());
        click(nextButtonGmail, waitTime);
        sendDataToField(gmailEnterPassword, waitTime, USER.getPassword());
        click(nextButtonGmailPassword, waitTime);
        retryingFindElementClick(resetPasswordEmail,waitTime);
       // click(resetPasswordEmail, waitTime);
    }

    public void verifyAssertViaResetButtonInEmail() throws InterruptedException {

        retryingFindElement(resetButtonInEmail, waitTime);

        verifyElementIsVisible(resetButtonInEmail, true, waitTime);




        verifyElementIsVisible(resetButtonInEmail, true, waitTime);
    }

    public void deleteResetLetter(){
        click(deleteButtonInEmail,waitTime);
    }

    public void deleteResetLetter2() throws InterruptedException {



         retryingFindElementClick(firstCheckBoxForDeleteEmail, waitTime);


        retryingFindElement(firstEmailFromList, waitTime);
        rightClick(firstEmailFromList,waitTime);
        retryingFindElementClick(deleteButtonInPopUpAfterRightClickOnEmail, waitTime);


       }

       public void EmailIsDeletedWaiter(){
           retryingFindElement(chainInBasket,waitTime);
           waitVisibilityAndInvisibilityElement(chainInBasket, waitTime);

       }


    public void openNewWindow(TestDataDueFocus.LoginUser USER) throws AWTException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_N);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_N);


        // Set focus to the newly opened browser window
        ArrayList<String> tabs = new ArrayList (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tabs.size()-1));
        for (String windowHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(windowHandle);
        }
        // Continue your actions in the new browser window
        getDriver().get(gmailURL);
    if(getIsVisible(gmailEnterEmail, waitTime)){
        loginToGmailAccount(USER);
        System.out.println("openNewWindow(): Success first try!");
        } else if(getIsVisible(addGmailAccountButton, waitTime)){
        click(addGmailAccountButton, waitTime);
        loginToGmailAccount(USER);
        System.out.println("openNewWindow(): Success second try!");

    }else if(getIsVisible(tryOneMoreTimeGmailAccount, waitTime)) {

        click(tryOneMoreTimeGmailAccount, waitTime);
        click(addGmailAccountButton, waitTime);
        loginToGmailAccount(USER);
        System.out.println("openNewWindow(): Success reach Gmail Acc third time!");

        }
    }


    public void selectFirstEmail(){

        retryingFindElementClick(firstEmailFromList, waitTime);
        try {
            verifyAssertViaResetButtonInEmail();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        retryingFindElementClick(enteredGmail, waitTime);
    }


    public void openNewWindow2() throws AWTException {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_N);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_N);

        // Set focus to the newly opened browser window
        ArrayList<String> tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tabs.size() - 1));
        for (String windowHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(windowHandle);

        }

        // Continue your actions in the new browser window
        getDriver().get("https://mail.google.com/");

    }




    public void retryingFindElement2(){
        retryingFindElement(signIn, waitTime);
    }

//    getDriver().findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("slava.varych11@gmail.com");
//    getDriver().findElement(By.xpath("//*[@id=\"next\"]")).click();
//    getDriver().findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys("!QAZxsw2");
//    getDriver().findElement(By.xpath("//*[@id=\"signIn\"]")).click();
//    getDriver().findElement(By.xpath("//span[@id=':2y']//child::span[contains(text(),'DueFocus password reset')]")).click();

}
