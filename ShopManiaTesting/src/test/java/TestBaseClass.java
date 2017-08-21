import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TestBaseClass {

    protected static HomePage homePage;
    private static WebDriver webDriver;

    @BeforeClass
    public static void beforeClass(){
        System.setProperty("geckodriver.exe","C:/Users/icristea/Downloads/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        // Navigate to “www.shopmania.ro”
        webDriver.get("http://www.shopmania.ro");
        homePage = PageFactory.initElements(webDriver, HomePage.class);
    }

    @AfterClass
    public static void afterClass(){
        webDriver.quit();
    }
}
