package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FireFoxTest {
    By toWebdriverPage = By.xpath("//a[@href='/documentation/webdriver/']");
    String webDriverPageTitle = "WebDriver | Selenium";
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void edgeBrowserTest(){
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
