package teamhomework28032020;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import utility.Utility;


public class Books extends Utility {


    @Before

    public void openBrowser() {

        openBrowser1("https://demo.nopcommerce.com/");

    }

    @Test

    public void verifyUserShouldNavigateToBooksPage() {


        clickonElement(By.linkText("Books"));

        String expectedText = "Books";
        String actualText = getTextFromElement(By.xpath("//div[@class=\"page-title\"]//h1"));

        Assert.assertEquals(expectedText, actualText);

        System.out.println("Expected message on Page : " + expectedText);
        System.out.println("Actual message on Page : " + actualText);
    }




    @Test
    public void booksPageSortingAToZ() throws InterruptedException {

        clickonElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));

        clickonElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));

        Thread.sleep(2000);
        sortingAToZ(By.tagName("h2"));


    }
    @Test
    public void verifyMessageOfWishList() throws InterruptedException {

        clickonElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));

        clickonElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));

        clickonElement(By.xpath("//select[@name='products-orderby']"));

        Thread.sleep(3000);

        clickonElement(By.xpath(" //div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));

        Thread.sleep(3000);

        String expectedText = "The product has been added to your wishlist";
        String actualText = getTextFromElement(By.xpath("//p[@class='content']"));

        Assert.assertEquals(expectedText,actualText);

        System.out.println("Expected message on Page : " + expectedText);
        System.out.println("Actual message on Page : " + actualText);

    }
    @After
    public void closeBrowser(){

        driver.quit();
    }

}
