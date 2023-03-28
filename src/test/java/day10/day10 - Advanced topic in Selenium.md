# Day 9: Advanced topic in Selenium Webdriver


## Handling AJAX calls using WebDriver
Step to handle ajax call:
1. Identify the elements that trigger AJAX calls: You can use browser developer tools to identify the elements that trigger AJAX calls on a page.
2. Wait for AJAX calls to complete: Use the WebDriverWait class to wait for AJAX calls to complete before performing any further actions. You can specify the maximum time to wait for the AJAX call to complete using the ExpectedConditions class.

For example, if you want to wait for an AJAX call to complete before clicking on an element, you can use the following code:

```java
WebElement element = driver.findElement(By.id("my-element"));
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.presenceOfElementLocated(By.id("my-element")));
element.click();
```
4. Verify that the AJAX call has completed: You can use the ExpectedConditions class to verify that the AJAX call has completed. For example, if you want to verify that an element has been updated after an AJAX call, you can use the following code:
```java
WebElement element = driver.findElement(By.id("my-element"));
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.textToBePresentInElement(element, "Updated text"));
```
5. Use the JavascriptExecutor interface: If the WebDriverWait class doesn't work for you, you can use the JavascriptExecutor interface to execute JavaScript code that waits for AJAX calls to complete. Here's an example:
   
```java
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeAsyncScript(
    "var callback = arguments[arguments.length - 1];" +
    "var xhr = new XMLHttpRequest();" +
    "xhr.onreadystatechange = function() {" +
    "  if (xhr.readyState == 4) {" +
    "    callback();" +
    "  }" +
    "};" +
    "xhr.open('GET', '/my-ajax-url', true);" +
    "xhr.send();");
```
In this example, the JavaScript code sends an AJAX request to /my-ajax-url and waits for the readystatechange event to fire with readyState equal to 4, which indicates that the AJAX call has completed.

## Handling dynamic web elements
Handling dynamic web elements in Selenium WebDriver with Java can be a bit tricky, but with the right approach, it can be done easily. Here is a step-by-step guide on how to handle dynamic web elements in Selenium WebDriver with Java:
Identify the dynamic element: The first step is to identify the dynamic element on the web page. Dynamic elements are those that change their properties such as ID, name, or class name every time the page is loaded or refreshed.
- Use explicit wait: Explicit wait is used to wait for a particular condition to occur before performing the next action. In the case of dynamic elements, we can use explicit wait to wait for the element to become visible or clickable before performing any action on it.
- Use relative xpath or CSS selector: Instead of using absolute xpath or CSS selector, use relative xpath or CSS selector to locate the dynamic element. Relative xpath or CSS selector will not change even if the element's properties change.
- Use dynamic values: If the dynamic element has a changing ID, name, or class name, you can use dynamic values in xpath or CSS selector. For example, if the ID of the element changes every time the page is loaded, you can use the 'contains' function in xpath to locate the element.
Here is an example code snippet for handling a dynamic element using Selenium WebDriver with Java:
```java
// Identify the dynamic element
WebElement dynamicElement = driver.findElement(By.xpath("//div[contains(@id,'dynamicID')]"));

// Use explicit wait to wait for the element to become clickable
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.elementToBeClickable(dynamicElement));

// Perform an action on the dynamic element
dynamicElement.click();
```
In summary, identifying dynamic web elements and using explicit wait, relative xpath/CSS selector, and dynamic values are some effective strategies to handle dynamic web elements in Selenium WebDriver with Java.

## Handling synchronization issues
Synchronization is an essential concept when working with Selenium WebDriver. When working with dynamic web pages, it is important to ensure that the web elements are loaded properly before performing any actions on them. In Java, there are different ways to handle synchronization issues in Selenium WebDriver, including:

1. `Implicit Wait`: This is a time-based wait condition that instructs the WebDriver to wait for a certain amount of time before throwing an exception. You can set this wait condition using the driver.manage().timeouts().implicitlyWait() method.
   Example:
```java
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
```
This code sets an implicit wait of 10 seconds, which means that WebDriver will wait up to 10 seconds for an element to appear before throwing an exception.

3. `Explicit Wait`: This is a more precise wait condition that waits for a specific web element to be available on the page. You can set this wait condition using the WebDriverWait class.
   Example:
```java
WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("element-id")));
```
This code waits up to 10 seconds for the element with ID "element-id" to be clickable. Once the element is available, it is returned as a WebElement object.

3. `Thread.sleep()`: This is a hard wait that instructs the WebDriver to wait for a specified amount of time before executing the next step. This is not recommended as it can cause unnecessary delays and slow down your test scripts.
   Example:
```java
Thread.sleep(5000); // wait for 5 seconds
```
In conclusion, when working with Selenium WebDriver, it is important to handle synchronization issues properly to avoid unexpected errors and ensure the accuracy of your test scripts. You can use implicit wait, explicit wait, or thread.sleep() depending on your specific needs.