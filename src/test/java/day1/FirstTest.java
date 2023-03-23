package day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FirstTest {
    By toWebdriverPage = By.xpath("//a[@href='/documentation/webdriver/']");
    String webDriverPageTitle = "WebDriver | Selenium";

    @BeforeClass
    public void beforeEachClass (){
        System.out.println("Summary: Run tests on 3 main browsers properly");
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

    @Test(enabled=false)
    public void chromeBrowserTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        driver.findElement(toWebdriverPage).click();
        Assert.assertEquals(driver.getTitle(), webDriverPageTitle);
        driver.quit();
    }

    @Test
    public void firefoxBrowserTest(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        driver.findElement(toWebdriverPage).click();
        Assert.assertEquals(driver.getTitle(), webDriverPageTitle);
        driver.quit();
    }

    @AfterClass
    public void afterEachClass(){
        // Method runs lastly
        System.out.println("Done");
    }
}
