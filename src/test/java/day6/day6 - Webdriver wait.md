# Day 6: WebDriver waits	

## Understanding different types of waits (implicit, explicit)	
In Selenium WebDriver, there are three types of waits that can be used to synchronize tests with the web application:

- `Implicit Wait`: This type of wait sets a timeout for all web elements to be found or loaded in the page. It tells WebDriver to wait for a certain amount of time before throwing an exception when an element is not found. The implicit wait time is set using the implicitlyWait method and the WebDriver will wait for the specified time before throwing a NoSuchElementException.

- `Explicit Wait`: This type of wait allows you to wait for a certain condition to occur before proceeding with the next step. It gives more control over the wait conditions by allowing you to define the expected conditions, timeout, and polling interval. The explicit wait time is set using the WebDriverWait class and the expected condition is defined using ExpectedConditions class.

- `Fluent Wait`: This type of wait is similar to explicit wait but with a more fluent interface. It provides more control over the polling frequency and timeout than the explicit wait. It allows you to define a maximum wait time and polling interval as well as the expected conditions. The fluent wait time is set using the Wait interface and the expected condition is defined using the ExpectedConditions class."

## Explicit wait best practices: 
Here are some best practices for using implicit waits in Selenium WebDriver with Java:
1. Set the implicit wait once per WebDriver instance: It is recommended to set the implicit wait only once for each instance of the WebDriver interface that controls the browser. You can set the implicit wait using the manage().timeouts().implicitlyWait() method of the WebDriver instance.
2. Set a reasonable timeout: It is important to set a reasonable timeout that is long enough for the web page to load and the elements to be located, but not too long that it slows down the test execution. A timeout of 10-20 seconds is usually sufficient.
3. Use explicit waits for more precise synchronization: Implicit waits are not always reliable and may cause unnecessary delays in test execution. For more precise synchronization, it is recommended to use explicit waits with expected conditions that check for specific element states or events.

Here is an example of setting an implicit & explicit wait in Java:
```java
// The implicit wait is set to 10 seconds for the ChromeDriver instance. 
// This means that if an element is not immediately found by WebDriver, it will wait for up to 10 seconds before throwing a NoSuchElementException.
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))

// Note that the implicit wait applies to all subsequent findElement() and findElements() calls on the WebDriver instance.
// It is recommended to use explicit waits in conjunction with implicit waits for more precise synchronization. 
// Here is an example of using an explicit wait to wait for an element to be clickable:
WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("myButton")));
element.click();
```
In this example, an explicit wait is created using the WebDriverWait class with a timeout of 10 seconds. The elementToBeClickable expected condition is used to wait for the ""myButton"" element to be clickable. Once the element is clickable, it is returned and clicked on."