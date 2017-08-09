package com.endava.yahooTest;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YahooTest {
    private static WebDriver webDriver;


    @BeforeClass
    public static void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/icristea/Desktop/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @Before
    public void goToLoginYahooPage(){
        webDriver.get("https://login.yahoo.com/");
    }

    @AfterClass
    public static void closeBrowser(){
        webDriver.close();
    }

    @Test
    public void sendEmail(){
        //Insert the email
        WebElement emailField = webDriver.findElement(By.id("login-username"));
        emailField.sendKeys("irina.cristiana19@yahoo.com");

        //Click "Next"
        WebElement nextBtn = webDriver.findElement(By.id("login-signin"));
        nextBtn.click();

        //Insert the password
        WebElement passwordField = webDriver.findElement(By.id("login-passwd"));
        passwordField.sendKeys("Plmoknijb19");

        //Click "Sign in"
        WebElement signInBtn = webDriver.findElement(By.id("login-signin"));
        signInBtn.click();

        //Click on "Mail"
        WebElement mailBtn = webDriver.findElement(By.id("uh-mail-link"));
        mailBtn.click();

        //Click on "Compose"
        WebElement composeBtn = webDriver.findElement(By.xpath(".//*[@id='Compose']/button"));
        composeBtn.click();

        //Insert a mail in "To field"
        WebElement toField = webDriver.findElement(By.id("to-field"));
        toField.sendKeys("irina.cristiana19@yahoo.com");

        //Subject field
        WebElement subjectField = webDriver.findElement(By.id("subject-field"));
        subjectField.sendKeys("test");

        //Content area
        WebElement contentArea = webDriver.findElement(By.id("rtetext"));
        contentArea.sendKeys("content test");

        //Click on "send email"
         WebElement sendEmailBtn = webDriver.findElement(By.xpath(".//div[@class='bottomToolbar squeeze-toolbar']//span[@class='btn default']"));
        sendEmailBtn.click();

        //Wait
        WebDriverWait wait = new WebDriverWait(webDriver, 500);

        //Verify with assert that the email was received and check the subject
        WebElement receivedMail = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='msg-list']//div[2]//div[@class='subj']//span[@title='test']")));
        Assert.assertEquals( "test", receivedMail.getText());

        //Open the email received
        receivedMail.click();

        //Verify the content of the email with an assert
         WebElement contentOfReceivedMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@style='visibility: visible;']//div[@aria-expanded='true' and contains(@class,'thread-item expanded')]//div[@class='email-wrapped']/div/div/div/div")));
         System.out.println("sddas");
         Assert.assertEquals( "content test", contentOfReceivedMail.getText());

        //Click on Sent
        WebElement clickOnSent = webDriver.findElement(By.xpath(".//li[@id='Sent']//a[@class='btn btn-sent']//span[@class='icon-text foldername']"));
        clickOnSent.click();

       //Last received mail
        WebElement lastReceivedMail = webDriver.findElement(By.xpath(".//div[@id='msg-list']//div[2]//div[contains(@class, 'name first')]"));
        Assert.assertEquals("irina.cristiana19@yahoo.com", lastReceivedMail.getText());

        //Click on Profile
        WebElement clickOnProfile = webDriver.findElement(By.xpath(".//b[@class='Lh(1.8) Va(m) yucs-trigger:h_Td(u) Lts(n) Fz(13px)']"));
        clickOnProfile.click();

        //Click on Signout
        WebElement clickOnSignout = webDriver.findElement(By.id("yucs-signout"));
        clickOnSignout.click();
    }
}
