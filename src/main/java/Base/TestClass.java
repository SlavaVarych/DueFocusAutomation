package Base;

import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class TestClass extends BaseTest{

    @Test
    public void clickSignInButton(){
        getDriver().findElement(By.xpath("//*[@id=\"root\"]/section/section/div/div/form/button")).click();
        System.out.println("Element clicked!");

        getDriver().findElement(By.xpath("//*[@id=\"root\"]/section/section/div/div/form/section[1]/input")).sendKeys("DAtaaaa");
        System.out.println("Element clicked!");

    }
//    @Test
//    public void setDataToEmail(){
//        getDriver().findElement(By.xpath("//*[@id=\"root\"]/section/section/div/div/form/section[1]/input")).sendKeys("DAtaaaa");
//        System.out.println("Element clicked!");
//    }
}
