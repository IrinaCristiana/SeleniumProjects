import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(id="autocomplete_prod")
    private WebElement searchBox;

    @FindBy(xpath = ".//*[@id='main_menu_left']/li[4]/a")
    private WebElement hoverOverElement;

    @FindBy(xpath = ".//ul[@id='main_menu_left']/li[4]/div[@class='dropdown-menu']/div/div/div[1]/div/ul[2]/li[4]/a")
    private WebElement unisexBtn;

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //Search for “iphone”
    public SearchResultsPage searchItem(String itemName){
        searchBox.click();
        searchBox.sendKeys("iphone");
        searchBox.sendKeys(Keys.ENTER);

        SearchResultsPage searchResultsPage = PageFactory.initElements(webDriver, SearchResultsPage.class);
        searchResultsPage.waitUntilCompleteLoadSearchResults();
        return searchResultsPage;
    }

    //Hover over 'parfumuri' category
    public void hoverOverElement() {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(hoverOverElement).build().perform();
    }

    //Click on 'unisex' category
    public UnisexPerfumesPage unisexPerfumesPage(){
        unisexBtn.click();
        UnisexPerfumesPage unisexPerfumesPage = PageFactory.initElements(webDriver, UnisexPerfumesPage.class);
        unisexPerfumesPage.waitUntilCompleteLoadPerfumesPage();
        return unisexPerfumesPage;

    }
}
