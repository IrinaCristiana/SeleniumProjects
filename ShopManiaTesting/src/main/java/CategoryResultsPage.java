import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryResultsPage {

    @FindBy(xpath = ".//div[@id='main_products_container']/ul//div[3]/p[@class='text-xl']/a")
    private List<WebElement> categoryResultsList;

    @FindBy(xpath = ".//div[@id='main_products_container']/ul/li[1]/div[2]/div[@class='div-offer']/div[2]/a[@class='price-offer']")
    private WebElement price;

    @FindBy(xpath = " .//div[@id='main_products_container']/ul/li[1]/div[3]/p[@class='text-xl']/a")
    private WebElement firstItem;

    private WebDriver webDriver;

    public CategoryResultsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    // Check the prices for the first product displayed “Telefon mobil Apple iPhone SE 16GB, iOS”
    public String getPrice(){
        return price.getText();
    }

    //Click on the first product displayed “Telefon mobil Apple iPhone SE 16GB, iOS”
    public SelectedItemPage selectedItemPage(){
        firstItem.click();

        SelectedItemPage selectedItemPage = PageFactory.initElements(webDriver, SelectedItemPage.class);
        selectedItemPage.waitUntilCompleteLoadItems();
        return selectedItemPage;
    }

    public void waitUntilCompleteLoadCategoryResults(){
        WebDriverWait wait = new WebDriverWait(webDriver, 5000);
        wait.until(ExpectedConditions.visibilityOfAllElements(categoryResultsList));
    }
}
