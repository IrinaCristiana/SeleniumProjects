import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {
    @FindBy(xpath = ".//div[@id='main_products_container']/ul//div[@class='prod-name']/a['class=\"text-lg prod-name']")
    private List<WebElement>searchResultsList;

    @FindBy(xpath = ".//div[@id='main_col']/div[@class='nav-cnt cfix']/ul[@class='nav-vertical text-sm']/li[8]/a")
    private WebElement category;

   @FindBy(id = "btn-close")
    private WebElement closePop_up;

    private WebDriver webDriver;

    public SearchResultsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //Select “Telefoane mobile” category
    public CategoryResultsPage categoryResultsPage(){
        category.click();
        CategoryResultsPage categoryResultsPage = PageFactory.initElements(webDriver, CategoryResultsPage.class);
        categoryResultsPage.waitUntilCompleteLoadCategoryResults();
        return categoryResultsPage;
    }

    public void waitUntilCompleteLoadSearchResults(){
        WebDriverWait wait = new WebDriverWait(webDriver, 5000);
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResultsList));
    }
}
