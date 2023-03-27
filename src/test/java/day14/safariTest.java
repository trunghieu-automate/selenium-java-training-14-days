package day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class safariTest {
    By toWebdriverPage = By.xpath("//a[@href='/documentation/webdriver/']");
    String webDriverPageTitle = "WebDriver | Selenium";
    WebDriver driver;


    @BeforeClass
    public void beforeEachClass (){
        WebDriverManager.safaridriver().setup();
        SafariOptions options = new SafariOptions();
        options.setAutomaticInspection(false);
        options.setAutomaticProfiling(false);
        driver = new SafariDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Run safari browser test");

    }

    @Test
    public void safariBrowserTest(){
        driver.get("https://www.selenium.dev/");
        driver.findElement(toWebdriverPage).click();
        Assert.assertEquals(driver.getTitle(), webDriverPageTitle);

    }

    @AfterClass
    public void afterEachClass(){
        // Method runs lastly
        driver.quit();
        System.out.println("Done");
    }
}
