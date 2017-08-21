import org.junit.Test;

public class SearchItemTest extends TestBaseClass{
    @Test
    public void searchItemTest(){

        // Search for “iphone”
        SearchResultsPage searchResultsPage = homePage.searchItem("iphone");

        CategoryResultsPage categoryResultsPage = searchResultsPage.categoryResultsPage();

        // Check the prices for the first product displayed “Telefon mobil Apple iPhone SE 16GB, iOS”
        System.out.println("The price of Apple iPhone SE 16GB, iOS is: "+ categoryResultsPage.getPrice());

        SelectedItemPage selectedItemPage = categoryResultsPage.selectedItemPage();

        // Get the number of the displayed shops per page
        System.out.println("Displayed Shops Number Per Page: "+ selectedItemPage.getDisplayedShopsNoPerPage());

        // Get the number of all the displayed shops
        System.out.println("Total Shops Number Displayed: "+selectedItemPage.getTotalShopsNoDisplayed());

        // Print the shop name and price where this phone has the minimum price
        System.out.println(selectedItemPage.getMinPrice());

        //Verify the maximum price for this phone and print the shop name and price
        System.out.println(selectedItemPage.getMaxPrice());

        //Hover over 'parfumuri' category
        homePage.hoverOverElement();

        UnisexPerfumesPage unisexPerfumesPage = homePage.unisexPerfumesPage();
        //Verify the number of stars received by the first product displayed and print it

        System.out.println("No of stars: "+ unisexPerfumesPage.getTheNumberOfStars());

        //Verify the number of offers displayed under stars
        System.out.println("No of offers: "+ unisexPerfumesPage.getTheNumberOfOffers());
    }
}
