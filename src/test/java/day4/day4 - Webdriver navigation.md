# Day 4: Webdriver navigation

## Navigating to different pages using WebDriver

```java
// Navigate to a web page
driver.get("https://www.example.com");

// Navigate to the previous web page
driver.navigate().back();

// Navigate to the next web page
driver.navigate().forward();

// Refresh the current web page
driver.navigate().refresh();

// Navigate to a different web page
driver.navigate().to("https://www.google.com");

// closing every associated window.
driver.quit();

// Close the currently focused window (meaning the curently focused tab), 
// quitting the driver if the current window is the only open window. 
// If there are no windows open, it will error out.
driver.close();
```
## Understanding window handles	
In Selenium WebDriver, windows refer to the various browser windows or tabs that can be opened during a test session. When a new window is opened, Selenium WebDriver needs to be able to handle it in order to interact with the elements on the new window. To switch between windows: If a test scenario requires interaction with multiple windows or tabs, Selenium WebDriver needs to be able to switch between them to perform actions on the correct window. To handle pop-up windows: Pop-up windows can sometimes appear during a test, and Selenium WebDriver needs to be able to handle them in order to interact with the elements on the pop-up. To handle multiple tabs: When a user opens multiple tabs in a browser, Selenium WebDriver needs to be able to handle each tab independently to interact with the correct tab. We need to handle windows in Selenium WebDriver whenever a test scenario requires interaction with multiple windows, pop-up windows, or multiple tabs.

## Working with multiple windows	
To handle windows in Selenium WebDriver, we can use the getWindowHandles() method to get a list of all open windows, and the switchTo().window() method to switch to a specific window. Once we have switched to a window, we can interact with the elements on that window using the standard Selenium WebDriver commands.
```java
// Navigate to the first web page
driver.get(""https://www.google.com"");

// Open a new tab in selenium 4
driver.switchTo().newWindow(WindowType.TAB);

// Navigate to the second web page in the new tab
driver.get(""https://www.example.com"");

// Get the handle of the first tab
String firstTab = driver.getWindowHandle();

// Get the handles of all the open tabs
Set<String> allTabs = driver.getWindowHandles();

// Switch to the first tab
driver.switchTo().window(firstTab);

// Close the current tab
driver.close();

// Switch to the second tab
for (String tab : allTabs) {
    if (!tab.equals(firstTab)) {
        driver.switchTo().window(tab);
    }
}

// Close the second tab
driver.close();
```

## Handling pop-ups and alerts	
There are 2 types of alert
- `Alert pops-up`: These pops-up that contains a message with an `Ok` and `Cancel` button.
- `Non alert pops-up`: These pops-up is not a part of current browser window and can contain any HTML
  
We have to handle each of these pops-up:
1. `Alert pops-up`:
```java
// Switch to alert pop-up
Alert alert = driver.switchTo().alert();

// Read the message on the alert pop-up
String alertMessage = alert.getText();

// Click on the ""OK"" or ""Cancel"" button as required
alert.accept(); // To click on the ""OK"" button
alert.dismiss(); // To click on the ""Cancel"" button

// Switch back to the main window
driver.switchTo().defaultContent();
```
2. `Non alert pops-up`:
```java
// Get the window handle of the main window
String mainWindowHandle = driver.getWindowHandle();

// Switch to the non-alert pop-up
for (String handle : driver.getWindowHandles()) {
    if (!handle.equals(mainWindowHandle)) {
        driver.switchTo().window(handle);
        break;
    }
}
// perform action on the pop up
driver.findElementById(""okButtonElementId"").click();

// Switch to main window
driver.switchTo().defaultContent();
```