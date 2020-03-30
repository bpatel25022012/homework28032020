package teamhomework28032020;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.Random;


public class RegistrationTest extends Utility {

    @Before
    public void openBrowser() {
        openBrowser1("https://demo.nopcommerce.com/");

    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessFully() {

        clickonElement(By.xpath("//a[@class=\"ico-register\"]"));

        String expectedText = "Your Personal Details";

        String actualText = getTextFromElement(By.xpath("//strong[contains(text(),'Your Personal Details')]"));

        Assert.assertEquals(expectedText,actualText);

        System.out.println("Expected Message On The Screen : " + expectedText);
        System.out.println("Actual Message On The Screen : " + actualText);
    }


    @Test
    public void userShouldRegisterSuccessfully() throws InterruptedException {

        clickonElement(By.xpath("//a[@class=\"ico-register\"]"));

        Thread.sleep(2000);

        clickonElement(By.xpath("//span[@class='male']//input[@name='Gender']"));

        sendTextToElement(By.xpath("//input[@id=\"FirstName\"]"),"Bhavesh" );

        sendTextToElement(By.xpath("//input[@id=\"LastName\"]"),"Patel");

        selectByIndexFromDropDownMenu(By.xpath("//select[@name=\"DateOfBirthDay\"]"),4);

        sendTextToElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),"April");

        selectByIndexFromDropDownMenu(By.xpath("//select[@name=\"DateOfBirthYear\"]"),15);

        Thread.sleep(2000);

        Random anyEmail = new Random();
        int randomInt = anyEmail.nextInt(1000);

        sendTextToElement(By.xpath("//input[@id=\"Email\"]"),+randomInt+"@gmail.com");

        clickonElement(By.xpath("//input[@id=\"Email\"]"));

        sendTextToElement(By.xpath("//input[@id=\"Company\"]"), "Testing Team");

        sendTextToElement(By.xpath("//input[@id=\"Password\"]"), "Tiger123");

        sendTextToElement(By.xpath("//input[@id=\"ConfirmPassword\"]"), "Tiger123");

        clickonElement(By.xpath("//input[@id=\"register-button\"]"));

        String expectedText = "Your registration completed";
        String actualText = getTextFromElement(By.xpath("//div[@class='result']"));

        Assert.assertEquals(expectedText,actualText);

        System.out.println("Expected Message On The Screen : " + expectedText);
        System.out.println("Actual Message On The Screen : " + actualText);

    }

    @Test

    public void userShouldNotRegisterSuccessfully() throws InterruptedException {

        clickonElement(By.xpath("//a[@class=\"ico-register\"]"));

        Thread.sleep(2000);

        clickonElement(By.xpath("//span[@class='male']//input[@name='Gender']"));

        sendTextToElement(By.xpath("//input[@id=\"FirstName\"]"),"Bhavesh" );

        sendTextToElement(By.xpath("//input[@id=\"LastName\"]"),"Patel");

        selectByIndexFromDropDownMenu(By.xpath("//select[@name=\"DateOfBirthDay\"]"),4);

        sendTextToElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),"April");

        selectByIndexFromDropDownMenu(By.xpath("//select[@name=\"DateOfBirthYear\"]"),15);

        Thread.sleep(2000);

        Random anyEmail = new Random();
        int randomInt = anyEmail.nextInt(1000);

        sendTextToElement(By.xpath("//input[@id=\"Email\"]"),+randomInt+"@gmail.com");

        clickonElement(By.xpath("//input[@id=\"Email\"]"));

        sendTextToElement(By.xpath("//input[@id=\"Company\"]"), "Testing Team");

        sendTextToElement(By.xpath("//input[@id=\"Password\"]"), "Tiger123");

        sendTextToElement(By.xpath("//input[@id=\"ConfirmPassword\"]"), "Tiger124");

        clickonElement(By.xpath("//input[@id=\"register-button\"]"));

        String expectedText = "The password and confirmation password do not match.";
        String actualText = getTextFromElement(By.xpath("//span[contains(text(),'The password and confirmation password do not matc')]"));

        Assert.assertEquals(expectedText,actualText);

        System.out.println("Expected Message On The Screen : " + expectedText);
        System.out.println("Actual Message On The Screen : " + actualText);

    }

    @After
    public void browserClosing() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }
}
