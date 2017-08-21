import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UnisexPerfumesPage {
    @FindBy(xpath = ".//div[@id='main_products_container']/ul/li[1]/div[3]/a[@class='text-middle']/i[@class='stars-sm-4']")
    private WebElement numberOfStars;

    @FindBy(xpath = ".//div[@id='main_products_container']/ul/li/div[2]/a ")
    private List<WebElement> perfumeList;

    @FindBy(xpath = ".//div[@id='main_products_container']/ul/li[1]/div[4]/a")
    private WebElement offersNo;

    WebDriver webDriver;

    public UnisexPerfumesPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    // Verify the number of stars received by the first product displayed and print it
    public Integer getTheNumberOfStars(){

       Integer numberOfStarsInt = Integer.parseInt((numberOfStars.getAttribute("class")).replaceAll("[^0-9\\]]+",""));

       return numberOfStarsInt;
   }

   //Verify the number of offers displayed under stars
    public Integer getTheNumberOfOffers(){

        Integer numberOfOffers = Integer.parseInt((offersNo.getText().replaceAll("[^0-9\\]]+","")));
        return numberOfOffers;
    }

    public void waitUntilCompleteLoadPerfumesPage(){
        WebDriverWait wait = new WebDriverWait(webDriver, 30000);
        wait.until(ExpectedConditions.visibilityOfAllElements(perfumeList));
    }
}
