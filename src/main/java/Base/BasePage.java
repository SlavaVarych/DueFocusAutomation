package Base;


import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Date;
import java.util.UUID;

import static Base.BaseTest.getDriver;


public class BasePage {

private WebDriver driver;

public BasePage(){this.driver = getDriver();}

public void waitVisibilityOfElement(By element, int waitTime){
    WebDriverWait wait = new WebDriverWait(getDriver(),waitTime);
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));

}

public void waitAllPresenceOfAllElements(By element, int waitTime){
    WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
    wait.until(ExpectedConditions.elementToBeClickable(element));

}

public void waitVisibilityAndInvisibilityElement(By element, int waitTime){

    WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
   try {
       wait.until(ExpectedConditions.visibilityOfElementLocated(element));
   }catch (Exception e){
       System.out.println("waitVisibilityAndInvisibilityElement Element isn't visible in try block");
       e.printStackTrace();
   }finally{
       wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
   }

}

public boolean getIsVisible(By element, int waitTime){
    try{
        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return getDriver().findElement(element).isDisplayed();
    } catch (Exception e){
        return false;
    }
}

    public boolean getIsVisible(String element, int waitTime){
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
            return getDriver().findElement(By.xpath(element) ).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

public void verifyElementIsVisible(By element, boolean shouldBeVisible, int waitTime){
    if (shouldBeVisible){
        Assert.assertTrue(getIsVisible(element, waitTime), "Element with locator [" + element +"] should be visible");
    } else {
        Assert.assertFalse(getIsVisible(element, waitTime), "Element with locator [" + element +"] shouldn't be visible");
    }
}

    public void verifyElementIsVisible(String element, boolean shouldBeVisible, int waitTime){
        if (shouldBeVisible){
            Assert.assertTrue(getIsVisible(element, waitTime), "Element with locator [" + element + "] should be visible");
        } else {
            Assert.assertFalse(getIsVisible(element, waitTime), "Element with locator [" + element + "] shouldn't be visible");
        }
    }

public void rightClick(By element, int waitTime){
    WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    WebElement element1 = getDriver().findElement(element);

    Actions actions = new Actions(getDriver());
    actions.contextClick(element1).perform();
}

public void click(By element, int waitTime){
    WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    getDriver().findElement(element).click();
}

    public WebElement retryingFindElement(By element, int waitTime) {

       WebElement result = null;
      //  boolean result = false;
        int attempts = 0;
        while(attempts < 3) {
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                WebElement element2 = getDriver().findElement(element);
                element2.sendKeys(Keys.SPACE);
                result = element2;
                System.out.println("Element is found from first time");
                break;
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("Element isn't found from first time");
            }
            attempts++;
        }
        return result;

    }

    public boolean retryingFindElementClick(By element, int waitTime) {

        boolean result = false;
        int attempts = 0;
        while(attempts < 3) {
            try {
                WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                getDriver().findElement(element).click();
                result = true;

                System.out.println("retryingFindElementClick(): Element is found from first time");
                break;
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("retryingFindElementClick(): Element isn't found from first time");
            }
            attempts++;
        }
        return result;

    }



public void clickUntilClicked(By element, By element2, int waitTime){


    try { WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        getDriver().findElement(element).click();

    if(getIsVisible(element2, waitTime)) {
        System.out.println("clickUntilClicked(): Clicked from first time!");
    } else {for (int i=0; i<=waitTime; i++){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            getDriver().findElement(element).click();
            if (getIsVisible(element2, waitTime)){
                break;
            }
            System.out.println("clickUntilClicked(): Clicked from second and more times");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }}}
  catch (Exception e){
      e.printStackTrace();
  }

}

public void clearField(By element, int waitTime){
    WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    getDriver().findElement(element).clear();

}

public void sendDataToField(By element, int waitTime, String data){
    WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    getDriver().findElement(element).sendKeys(data);
}

    public String createGUIDName(){
        String name = UUID.randomUUID().toString().replace("-","");
        String onlyAlphaNumeric = name.replaceAll("[^a-zA-z]", "");
        System.out.println(name);
        System.out.println(onlyAlphaNumeric);
        return "RandName" + onlyAlphaNumeric;


    }

    public String createUniqueEmail() {
        Date date = new Date();
        String email = "duefocus.user." + date.toString().replaceAll("\\s+", "").replaceAll(":", ".") + "@duefocus.com";
        return email;
    }





    }

