# Day 5: WebDriver Actions	
## Understanding actions class	
In Selenium WebDriver with Java, an action class is used to perform complex user interactions such as clicking and dragging, double-clicking, and hovering over elements. The Actions class provides a way to chain multiple actions together to create a more complex user interaction. It is important to understand the Action class in Selenium WebDriver in order to create more realistic and efficient test scripts.

## Working with mouse and keyboard actions	
- `Working with mouse`:

```java
import org.openqa.selenium.interactions.Actions; 

Actions actions = new Actions(driver); 
//To click an element:
actions.click(element).build().perform();
//To double-click an element:
actions.doubleClick(element).build().perform();
//To right-click an element:
actions.contextClick(element).build().perform();
//To move the mouse pointer to an element:
actions.moveToElement(element).build().perform();
```

- `Working with keyboard:`
```java
import org.openqa.selenium.Keys;
//To type a text in a text box:
driver.findElement(By.xpath("//input")).sendKeys("Text to be typed");
//To press a key on the keyboard:
driver.findElement(By.xpath("//input")).sendKeys(Keys.ENTER);
//To combine keys: (ex: Ctrl + C):
driver.findElement(By.xpath("//input")).sendKeys(Keys.chord(Keys.CONTROL, "c"));

//Handling drag and drop	
//Import the Actions class:
import org.openqa.selenium.interactions.Actions;
//Locate the source and destination elements:
WebElement source = driver.findElement(By.xpath("xpath_of_source_element"));
WebElement destination = driver.findElement(By.xpath("xpath_of_destination_element"));
//Create an instance of the Actions class and perform the drag and drop action
Actions actions = new Actions(driver);
actions.dragAndDrop(source, destination).build().perform();
//Alternatively, you can use the clickAndHold(), moveByOffset() and release() methods of the Actions class to simulate a drag and drop action:
Actions actions = new Actions(driver);
actions.clickAndHold(source).moveByOffset(xOffset, yOffset).release(destination).build().perform();
```