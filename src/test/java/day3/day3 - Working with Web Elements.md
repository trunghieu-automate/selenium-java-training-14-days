# Day 3: Working with Web Elements

## Interacting with web elements (click, type, clear)

1. Clicking an element:
   Clicking an element is one of the most common interactions in Selenium WebDriver. To click an element, you first need to find it using a locator. Once you have found the element, you can use the click() method to click it. Here's an example:

```java
WebElement element = driver.findElement(By.id("my-element"));
element.click();
```

2. Typing into a text field: Typing into a text field is another common interaction in Selenium WebDriver. To type into a text field, you first need to find it using a locator. Once you have found the element, you can use the sendKeys() method to enter text into the field. Here’s an example:
```java
WebElement element = driver.findElement(By.name("my-text-field"));
element.sendKeys("Hello, World!");
```

3. Clearing a text field: Clearing a text field is useful if you want to enter new text into it. To clear a text field, you first need to find it using a locator. Once you have found the element, you can use the clear() method to clear the text field. Here’s an example:
```java
WebElement element = driver.findElement(By.name("my-text-field"));
element.sendKeys("Hello, World!");
element.clear();
```

## Handling different types of input fields (text boxes, radio buttons, checkboxes, dropdowns)
1. Textbox:
```java
// locate the textbox element 
WebElement textbox = driver.findElement(By.id(“textboxId”)); 
// enter text into the textbox 
textbox.sendKeys(“Text to be entered”);
```

2. check-box, radio button:
- Use click() method to interact with them
- Use isSelected() method return boolean value for checking if they are selected or not

3. Dropdown:
Sample code for selecting an option in a dropdown element:
```java
// locate the dropdown element 
WebElement dropdown = driver.findElement(By.id(“dropdownId”)); 
// create a select object 
Select select = new Select(dropdown); 
// select an option by visible text 
select.selectByVisibleText(“Option Text”);
```

## Understanding the different states of web elements
* In Selenium WebDriver, an element can have different states depending on its visibility, interactability, and availability. Here are some common states of an element:

1. Enabled: 
An element is enabled when it is visible on the page and can be interacted with. In other words, it is not disabled or grayed out. You can check if an element is enabled using the isEnabled() method, which returns a boolean value.
```java
WebElement element = driver.findElement(By.id("elementId"));
boolean isEnabled = element.isEnabled();
```
2. Displayed: An element is displayed when it is visible on the page. You can check if an element is displayed using the isDisplayed() method, which returns a boolean value.
```java
WebElement element = driver.findElement(By.id("elementId"));
boolean isDisplayed = element.isDisplayed();
```
3. Selected: An element is selected when it is in a selected state, such as a radio button or checkbox that has been selected. You can check if an element is selected using the isSelected() method, which returns a boolean value.

```java
WebElement element = driver.findElement(By.id("elementId"));
boolean isSelected = element.isSelected(); 
```

4. Present: An element is present when it exists in the DOM, but it may or may not be visible on the page. You can check if an element is present using the findElement() method, which returns an exception if the element is not found.
```java
try {
    WebElement element = driver.findElement(By.id("elementId"));
} catch (NoSuchElementException e) {
    // handle element not found exception
}
```
5. Absent: An element is absent when it does not exist in the DOM. You can check if an element is absent by attempting to find the element and handling the exception if it is not found.
```java

try {
    WebElement element = driver.findElement(By.id("elementId"));
    // handle element found
    } catch (NoSuchElementException e) {
    // handle element not found
}

// function return element boolean value if an element is present or absent
public boolean isElementPresent(By locatorKey) {
    try {
        driver.findElement(locatorKey);
        return true;
    } catch (NoSuchElementException e) {
        return false;
    }
}
```
These are some of the common states of an element in Selenium WebDriver. Depending on your use case, you may need to check for additional states or modify the code to suit your needs.