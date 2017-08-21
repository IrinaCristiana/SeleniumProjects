import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectedItemPage {

    @FindBy(xpath = ".//div[@id='product_offers_container']//ul/li/div[2]/div[2]/p[1]/a")
    private List<WebElement> shopsList;

    @FindBy(xpath = ".//div[@id='product_offers_container']/ul/li/div[2]/div[3]/p[1]/a")
    private List<WebElement> priceList;

    @FindBy(xpath = ".//div[@id='prod_row_166766615']/div[1]/div/div[1]/div/p[1]/span[3]/b/span")
    private WebElement totalJobs;

    private WebDriver webDriver;

    public SelectedItemPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //Get the number of available shops per page
    public Integer getDisplayedShopsNoPerPage(){
        return shopsList.size();
    }

    //Get the number of all available shops
    public Integer getTotalShopsNoDisplayed(){
        return Integer.valueOf(totalJobs.getText());
    }

    //Print the shop name and price where this phone has the minimum price
    public Double getMinPrice () {
         String min = priceList.get(0).getText();
         Double minValue = Double.parseDouble(min.replaceAll("[^0-9\\]]+",""));

         for (Integer i = 1; i < priceList.size(); i++) {
             Double currentValue = Double.parseDouble(priceList.get(i).getText().replaceAll("[^0-9\\]]+",""));
             if(currentValue < minValue){
                 minValue = currentValue;
                 System.out.println("Shop with min price: "+ shopsList.get(i).getAttribute("title"));
                 break;
             }
         }
          System.out.print("Min price: ");
          return minValue;
     }

    //Verify the maximum price for this phone and print the shop name and price
    public Double getMaxPrice () {
        String max = priceList.get(0).getText();
        Double maxValue = Double.parseDouble(max.replaceAll("[^0-9\\]]+", ""));

        Double currentValue = null;
        for (Integer i = 1; i < priceList.size(); i++) {
            currentValue = Double.parseDouble(priceList.get(i).getText().replaceAll("[^0-9\\]]+", ""));
            if (currentValue > maxValue) {
                currentValue = maxValue;
                System.out.println("Shop with max price: " + shopsList.get(i).getAttribute("title"));
                break;
            }
        }
        System.out.print("Max price: ");
        return currentValue;
    }

    public void waitUntilCompleteLoadItems(){
        WebDriverWait wait = new WebDriverWait(webDriver, 5000);
        wait.until(ExpectedConditions.visibilityOfAllElements(shopsList));
    }
}
