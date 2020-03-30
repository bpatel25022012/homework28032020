package teamhomework28032020;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;




public class Electrionics extends Utility {

    @Before
    public void openBrowser() {

        openBrowser1("https://demo.nopcommerce.com/");
    }

    @Test
    public void mouseOverElectronics() throws InterruptedException {

        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));

        Thread.sleep(3000);

        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));

        String expectedResult = "Camera & photo";
        String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Camera & photo')]"));

        Assert.assertEquals(expectedResult, actualResult);

        System.out.println("Expected message on page : " +expectedResult);
        System.out.println("Actual message on page : " +actualResult);
    }

    @Test
    public void assertPositionLowToHigh() throws InterruptedException {

        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));

        Thread.sleep(3000);

        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));

        selectByVisibleTextFromDropDownMenu(By.xpath("//select[@id='products-orderby']"),"Price: Low to High");

        sortPriceLowToHigh(By.className("prices"));

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
