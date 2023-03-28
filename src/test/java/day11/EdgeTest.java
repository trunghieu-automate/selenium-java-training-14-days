package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class EdgeTest {
    By toWebdriverPage = By.xpath("//a[@href='/documentation/webdriver/']");
    String webDriverPageTitle = "WebDriver | Selenium";
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void edgeBrowserTest(){
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/");
        driver.findElement(toWebdriverPage).click();
        Assert.assertEquals(driver.getTitle(), webDriverPageTitle);
        driver.quit();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
