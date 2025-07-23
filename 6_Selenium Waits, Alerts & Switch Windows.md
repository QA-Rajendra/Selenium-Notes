# Selenium Waits, Alerts & Switch Windows 🕒🧠🪟

Automation testers often deal with **dynamic content**, **popups**, and **multiple windows/tabs**. Selenium provides various mechanisms like **waits**, **alert handling**, and **window management** to handle these scenarios effectively.

![Selenium Waits Overview](https://miro.medium.com/v2/resize\:fit:1200/format\:webp/1*-N9skmZXegVz9cABOUf5mg.png)

---

## 1. Selenium Waits ⏳

Waits in Selenium ensure that WebDriver waits for elements or conditions before proceeding with the next steps. There are 4 main types:

### a) Implicit Wait 🕰️

Automatically applies wait to all elements.

```java
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://example.com");
```

### b) Explicit Wait (WebDriverWait) 📌

Waits for a specific condition to occur.

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn")));
element.click();
```

### c) Fluent Wait 🔁

Allows polling frequency and ignores specific exceptions.

```java
Wait<WebDriver> fluentWait = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(30))
    .pollingEvery(Duration.ofSeconds(5))
    .ignoring(NoSuchElementException.class);

WebElement element = fluentWait.until(driver -> driver.findElement(By.id("dynamicElement")));
```

### d) Thread.sleep 💤 (Not recommended for automation)

```java
Thread.sleep(5000); // pauses for 5 seconds
```

### e) PageLoadTimeout & SetScriptTimeout 🕸️

```java
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
```

### f) Ajax/JS-Based Element Handling ⚡

```java
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
```

---

## 2. Alerts Handling ⚠️

Selenium provides `Alert` interface for popups:

### a) Simple Alert:

```java
Alert alert = driver.switchTo().alert();
alert.accept();
```

### b) Confirmation Alert:

```java
Alert alert = driver.switchTo().alert();
alert.dismiss(); // or alert.accept();
```

### c) Prompt Alert:

```java
Alert alert = driver.switchTo().alert();
alert.sendKeys("Test Input");
alert.accept();
```

---

## 3. Switching Windows/Tabs/Popups 🪟

### a) Get Window Handle:

```java
String mainWindow = driver.getWindowHandle();
```

### b) Get All Window Handles:

```java
Set<String> allWindows = driver.getWindowHandles();
```

### c) Switch to Child Window:

```java
for(String windowId : allWindows) {
    if(!windowId.equals(mainWindow)) {
        driver.switchTo().window(windowId);
    }
}
```

### d) Close Child and Return to Main:

```java
driver.close();
driver.switchTo().window(mainWindow);
```

### e) Example Use Case:

```java
// Click opens a new tab
WebElement link = driver.findElement(By.linkText("Open New Tab"));
link.click();

Set<String> allHandles = driver.getWindowHandles();
for(String id : allHandles) {
    driver.switchTo().window(id);
    if(driver.getTitle().contains("Target Page")) {
        break;
    }
}
```

---

## 4. Java Set Interface 🔁

### Key Points:

* Set is an unordered collection of unique elements
* Implementations: HashSet, LinkedHashSet, TreeSet
* Used with `getWindowHandles()`

```java
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
System.out.println(set);
```

---

## 5. Interview Questions 🎯

### Q1: What is the difference between Implicit and Explicit Wait?

**A:** Implicit is applied globally and waits for all elements, whereas Explicit waits for specific conditions per element.

### Q2: What is Fluent Wait and when do you use it?

**A:** Fluent Wait polls for a condition at regular intervals and handles exceptions. Used in highly dynamic environments.

### Q3: What is the use of `ExpectedConditions`?

**A:** It provides pre-defined conditions (like `visibilityOfElementLocated`) to be used with WebDriverWait.

### Q4: How do you handle AJAX elements?

**A:** Wait for loader/invisibility or visibility of a specific element using explicit wait.

### Q5: What is the difference between `getWindowHandle()` and `getWindowHandles()`?

**A:** `getWindowHandle()` returns the current window ID. `getWindowHandles()` returns a Set of all open windows.

### Q6: How to switch back to the main window?

**A:** Store the main window handle before switching and switch back using `driver.switchTo().window(mainHandle);`

### Q7: Can you handle alerts without switching to them?

**A:** No, Selenium requires switching to the alert using `driver.switchTo().alert()`.

### Q8: Why is Thread.sleep discouraged?

**A:** It is static and waits even when not needed, reducing performance and reliability.

---

## Summary 📝

* Use **WebDriverWait** for efficient wait strategies
* Use **Alert interface** to handle pop-ups
* Use **Window Handles and Set** to manage tabs and windows
* Prefer **Explicit and Fluent waits** over `Thread.sleep`

---

> "Efficient use of waits and window handling is the key to building stable Selenium frameworks."

---

Prepared by: *Your Name*
Date: 23 July 2025 📅
