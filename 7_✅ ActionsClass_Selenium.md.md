# 🎯 Selenium: Actions Class 💡

> 🧪 The `Actions` class in Selenium is part of the **`org.openqa.selenium.interactions`** package and is used to handle **advanced user interactions** like mouse movements, hovering, drag and drop, and keyboard operations. These actions simulate real-user behaviors in complex web applications.

---

## 📘 What is `Actions` Class?

The `Actions` class allows testers to **simulate low-level user interactions** such as:

🖱️ Mouse movements  
🖱️ Hovering (mouseover)  
🖱️ Drag-and-drop  
⌨️ Keyboard key press & release  
🖱️ Double-click and Right-click

> 💡 Useful when working with dynamic web components like menus, sliders, or drag-and-drop widgets.

---

## 🔧 Setup: How to Use `Actions` Class in Java

```java
// Import the package
import org.openqa.selenium.interactions.Actions;

// Create Actions object
Actions actions = new Actions(driver);
```

---

## 🖱️ Mouse Hover Example (Menu Navigation)

```java
WebElement menu = driver.findElement(By.id("mainMenu"));
Actions actions = new Actions(driver);

// Perform hover over action
actions.moveToElement(menu).perform();
```

📌 **Use case:** Hovering over a menu item to reveal dropdown submenus.

---

## 📍 Finding Coordinates of a Web Element

```java
WebElement element = driver.findElement(By.id("logo"));
Point location = element.getLocation();

System.out.println("X Coordinate: " + location.getX());
System.out.println("Y Coordinate: " + location.getY());
```

🎯 Useful for custom animations or validation.

---

## 🧲 Drag and Drop Example

```java
WebElement source = driver.findElement(By.id("draggable"));
WebElement target = driver.findElement(By.id("droppable"));

Actions actions = new Actions(driver);
actions.dragAndDrop(source, target).build().perform();
```

✅ This will drag the source element and drop it on the target element.

---

## 🔄 Mouse Click / Right Click / Double Click

```java
WebElement element = driver.findElement(By.id("button"));

// Right Click
actions.contextClick(element).perform();

// Double Click
actions.doubleClick(element).perform();

// Click and Hold
actions.clickAndHold(element).perform();
```

---

## 🔠 Keyboard Actions Example

```java
WebElement inputBox = driver.findElement(By.id("search"));

actions.moveToElement(inputBox)
       .click()
       .keyDown(Keys.SHIFT)
       .sendKeys("selenium")
       .keyUp(Keys.SHIFT)
       .perform();
```

This will type "SELENIUM" in capital letters using SHIFT key.

---

## 🧠 Interview Questions 🎤

| No. | Question                                                                 | Suggested Answer |
|-----|--------------------------------------------------------------------------|------------------|
| 1️⃣ | What is the use of `Actions` class in Selenium?                          | To handle complex user gestures like mouse hover, drag and drop, etc. |
| 2️⃣ | How do you perform a mouse hover in Selenium?                            | Using `moveToElement()` method of Actions class. |
| 3️⃣ | How to perform drag and drop action?                                     | Use `dragAndDrop(source, target)` method. |
| 4️⃣ | Can Actions class simulate keyboard events?                              | Yes, using methods like `sendKeys`, `keyDown`, `keyUp`. |
| 5️⃣ | What is the difference between `perform()` and `build().perform()`?      | `build()` compiles the action chain; `perform()` executes it. Usually `perform()` is enough. |

---

## 🌈 Pro Tips & Best Practices 💎

✅ Always `.perform()` the action at the end.  
✅ Combine actions using chaining (`.click().sendKeys().build().perform()`)  
✅ Use Explicit Waits before interacting if elements are dynamic.

---

## 🔚 Summary

🔸 `Actions` class is essential when automating **rich UI interactions**  
🔸 Helps bridge the gap between simple automation and **real user-like behavior**  
🔸 Mastering this makes you a strong automation tester 🧠🔥

---

# 🎯 Selenium: Full Actions Class Example in Java

> This example demonstrates the use of the `Actions` class in Selenium with real browser interaction for:
> ✅ Mouse Hover, ✅ Drag and Drop, ✅ Double Click, ✅ Right Click, ✅ Keyboard Input

---

## 🧰 Prerequisites

- Java JDK installed
- Selenium Java Client Library
- ChromeDriver set up in system path or project
- Maven (optional)

---

## 🛠️ Maven Dependency (Optional)

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.16.1</version>
    </dependency>
</dependencies>
```

---

## 📄 Full Java Code Using Actions Class

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import java.time.Duration;

public class ActionsClassExample {
    public static void main(String[] args) {

        // Set path to your chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize the browser
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open a test website
        driver.get("https://demoqa.com/buttons");

        // Create Actions object
        Actions actions = new Actions(driver);

        // 1️⃣ Mouse Hover Example
        driver.get("https://demoqa.com/menu");
        WebElement menu = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        actions.moveToElement(menu).perform();
        System.out.println("Mouse Hovered on Main Item 2");

        // 2️⃣ Drag and Drop Example
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(source, target).perform();
        System.out.println("Drag and Drop performed");

        // 3️⃣ Double Click Example
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickBtn).perform();
        System.out.println("Double Click done");

        // 4️⃣ Right Click Example
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();
        System.out.println("Right Click done");

        // 5️⃣ Keyboard Actions (SHIFT + typing)
        driver.get("https://demoqa.com/text-box");
        WebElement input = driver.findElement(By.id("userName"));
        actions.moveToElement(input)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("automation tester")
                .keyUp(Keys.SHIFT)
                .perform();
        System.out.println("Typed in uppercase using SHIFT");

        // Close the browser
        driver.quit();
    }
}
```

---

## 🧪 Console Output

```
Mouse Hovered on Main Item 2
Drag and Drop performed
Double Click done
Right Click done
Typed in uppercase using SHIFT
```

---

## ✅ Summary

| Action        | Method Used                         |
|---------------|--------------------------------------|
| Mouse Hover   | `moveToElement()`                   |
| Drag & Drop   | `dragAndDrop(source, target)`       |
| Double Click  | `doubleClick(element)`              |
| Right Click   | `contextClick(element)`             |
| Keyboard Type | `keyDown(Keys.SHIFT)` + `sendKeys()`|

> 🎓 With this knowledge, you're ready to automate modern, interactive web applications using real user gestures!

