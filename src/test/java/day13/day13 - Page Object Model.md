# Day 13: Webdriver & Page Object Model

## Introduction to Page Object Model
- The Page Object Model (POM) is a design pattern used in Selenium WebDriver to create reusable and maintainable code for test automation. It separates the test code from the page-specific code, making it easier to maintain and update the tests.
- In POM, each web page is represented by a separate class, known as a Page Object. The Page Object contains the elements of the web page, their locators, and the methods to interact with them. The Page Objects are then used in the test code to interact with the web page.

*The benefits of using POM in Selenium WebDriver include:*
1. Improved code reusability: Page Objects can be reused in multiple tests, reducing code duplication and making the tests easier to maintain.
2. Improved code maintainability: By separating the page-specific code from the test code, the tests become easier to maintain and update.
3. Improved test readability: Using Page Objects makes the test code more readable and understandable.
4.Improved test reliability: Page Objects help to reduce the flakiness of the tests by providing a stable and reliable way to interact with the web page elements.

## POM best pratices for implementation

*Best practices for implementing the Page Object Model design:*
1. `Keep page-specific functionality in separate classes`: Each page in your application should have its own Page Object Model class that encapsulates the functionality specific to that page. This helps to keep the code organized and maintainable, and allows you to easily reuse page-specific functionality across different tests.
2. `Use meaningful names for methods and variables`: The names you use for methods and variables should be meaningful and descriptive, so that it is clear what they do. This helps to make your code more readable and easier to understand, especially for other developers who may need to work on your code in the future.
3. `Avoid using PageFactory`: While PageFactory can make it easier to initialize and access web elements, it can also make your code more complex and harder to maintain. Instead, consider using the By class to locate elements, and encapsulate the element access in methods.
4. `Use assertion helpers`: Separate assertion functionality into a separate class, and use assertion helper methods to perform common assertions. This helps to keep the Page Object Model classes focused on page-specific functionality, and makes it easier to reuse assertion functionality across different pages and tests.
5. `Use inheritance and interfaces`: Consider using inheritance and interfaces to create a hierarchy of Page Object Model classes. This can make it easier to reuse functionality across related pages, and can make your code more organized and easier to maintain.
6. `Avoid using Thread.sleep()`: Thread.sleep() is a poor practice for waiting in Selenium tests because it can lead to flaky tests. Instead, use the built-in wait functionality provided by Selenium, such as WebDriverWait, to wait for elements to appear or for conditions to be met.
7. `Use a WebDriver manager`: Instead of manually managing the WebDriver instances, consider using a WebDriver manager like WebDriverManager or Selenide. This helps to simplify the setup and configuration of the WebDriver, and can make it easier to run tests in parallel.

*By following these best practices, you can create a robust and maintainable Page Object Model design for your Selenium WebDriver tests.*

## Introducing singleton driver and Page Factory design pattern

Singleton design pattern for driver object sample:
```java
public class DriverManager {
private static WebDriver driver;
private static final String CHROME_DRIVER_PATH = "/path/to/chromedriver";

    private DriverManager() {}

    public static WebDriver getDriver() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
```
*In the above code, the DriverManager class is a Singleton class that manages the WebDriver object. The WebDriver object is created only once and is reused throughout the test execution.*

Here's how to use this Singleton class in your test code:
```java
public class MyTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @Test
    public void myTest() {
        // Test code
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
```
*In the above code, the `setUp()` method initializes the WebDriver object by calling the `getDriver()` method from the DriverManager class. The `tearDown()` method quits the WebDriver object by calling the `quitDriver()` method from the DriverManager class.*


## The Factory design pattern
The Factory design pattern is a creational pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. In the context of Selenium WebDriver, this pattern can be used to create different types of Page Object Model classes based on the input provided to a factory method.
First, we define an abstract Page class that represents the common functionality of all pages in our application

```java
public abstract class Page {
protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void navigateTo();
}
```

Next, we define concrete classes that extend the Page class and represent specific pages in our application. For example, here's a `LoginPage` class:

```java
public class LoginPage extends Page {
private WebElement usernameInput;
private WebElement passwordInput;
private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get("https://example.com/login");
    }

    public void setUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
```

*Next, we define a `PageFactory` class that provides a factory method for creating Page objects based on the input provided*
```java
public class PageFactory {
    public static Page getPage(WebDriver driver, String pageType) {
        if (pageType.equals("login")) {
            return new LoginPage(driver);
        } else if (pageType.equals("home")) {
            return new HomePage(driver);
        } else {
            throw new IllegalArgumentException("Invalid page type: " + pageType);
        }
    }
}
```
*This `PageFactory` class provides a `getPage()` method that takes in a WebDriver instance and a string representing the type of page to create. Based on the input provided, it creates and returns an instance of the appropriate Page subclass.*

*To use this `PageFactory`, we can create a WebDriver instance and use it to create instances of different Page subclasses:*

```java
WebDriver driver = new ChromeDriver();
Page loginPage = PageFactory.getPage(driver, "login");
loginPage.navigateTo();
((LoginPage) loginPage).setUsername("username");
((LoginPage) loginPage).setPassword("password");
((LoginPage) loginPage).clickLoginButton();

Page homePage = PageFactory.getPage(driver, "home");
homePage.navigateTo();
// perform actions on home page
```
*By using the Factory design pattern, we can decouple the creation of Page objects from the code that uses them, and make our code more modular and maintainable.*



