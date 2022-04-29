package Amazone_Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestSuit extends Utility {

    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyDellLaptopTotalProductName() {
        clickOnElement(By.id("sp-cc-accept"));
        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");
        clickOnElement(By.id("nav-search-submit-button"));
        clickOnElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]"));

        WebElement productDell=driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        int countProducts = products.size();
        List<String> actualListName = new ArrayList<>();
        for (WebElement element : products) {
            actualListName.add(element.getText());
        }
        //verify products count
        if (productDell.isDisplayed()){
            Assert.assertEquals("Check number of products : ",countProducts,30);}
        //print the products list
        System.out.println("Prodcuts Name:" + actualListName);



    }


}
