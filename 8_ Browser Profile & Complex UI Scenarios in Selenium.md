## 🤖 13) Browser Profile & Complex UI Scenarios in Selenium

---

### 🔐 What is a Browser Profile?

A **Browser Profile** is a custom user session in a browser (Chrome, Firefox) where data like cookies, extensions, saved passwords, and preferences are stored.

#### ✅ Why is it important in automation?

* Helps simulate **logged-in sessions**
* Needed to **bypass 2FA** or login prompts
* Ensures tests **run with consistent settings**

---

## 🛠️ 1. **Browser Profile Setup**

### 🌐 ChromeOptions with User Profile

```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeProfileTest {
    public static void main(String[] args) {
        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/YourName/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--profile-directory=Profile 1"); // Specific profile name

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.linkedin.com");

        // Your automation steps
    }
}
```

🔐 **Use Case**: Automate LinkedIn without logging in every time.

---

### 🥊 Firefox Profile Example

```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxProfileTest {
    public static void main(String[] args) {
        FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\YourName\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\abc.default"));
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://secure-site.com");

        // Your automation steps
    }
}
```

---

## 💡 2. Handle Complex UI Scenarios

---

### 📦 2.1 Handle AJAX Elements

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajaxResult")));
System.out.println("Loaded: " + result.getText());
```

✅ **Use Case**: Loading search results or suggestions dynamically.

---

### 📅 2.2 Handle Complex Calendars

```java
driver.findElement(By.id("calendar")).click(); // Open calendar popup

while (!driver.findElement(By.className("monthLabel")).getText().contains("December")) {
    driver.findElement(By.className("nextMonth")).click();
}

driver.findElement(By.xpath("//td[text()='25']")).click(); // Select date
```

✅ **Use Case**: Flight booking, hotel reservations.

---

### 📊 2.3 Handle Paginated Tables

```java
boolean found = false;
while (!found) {
    List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
    for (WebElement row : rows) {
        if (row.getText().contains("Rajendra")) {
            System.out.println("Found: " + row.getText());
            found = true;
            break;
        }
    }
    if (!found) {
        driver.findElement(By.xpath("//a[text()='Next']")).click(); // Move to next page
    }
}
```

✅ **Use Case**: Admin panels, inventory systems.

---

### ♻️ 2.4 Infinite Scroll (LinkedIn, Facebook)

```java
JavascriptExecutor js = (JavascriptExecutor) driver;
long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

while (true) {
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    Thread.sleep(2000);
    long newHeight = (long) js.executeScript("return document.body.scrollHeight");
    if (newHeight == lastHeight) break;
    lastHeight = newHeight;
}
```

✅ **Use Case**: Social feed, product listing, job portals.

---

### 🕳️ 2.5 Shadow DOM Elements

```java
JavascriptExecutor js = (JavascriptExecutor) driver;

WebElement shadowHost = driver.findElement(By.cssSelector("custom-element"));
WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
WebElement input = shadowRoot.findElement(By.cssSelector("input"));
input.sendKeys("Shadow DOM Test");
```

✅ **Use Case**: Chrome settings page, custom widgets.

---

### 📈 2.6 SVG Elements (Graphs, Charts)

```java
WebElement svgElement = driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='circle']"));
Actions actions = new Actions(driver);
actions.moveToElement(svgElement).perform();
```

✅ **Use Case**: Financial dashboards, data visualization.

---

### 🪟 2.7 Handling Nested Frames

```java
driver.switchTo().frame("outerFrame");
driver.switchTo().frame("innerFrame");

driver.findElement(By.id("submit")).click();
driver.switchTo().defaultContent(); // Go back to main page
```

✅ **Use Case**: Web-based tools, banking dashboards.

---

### 🎨 2.8 Handling Pseudo Elements (::before, ::after)

```java
JavascriptExecutor js = (JavascriptExecutor) driver;

String content = (String) js.executeScript(
    "return window.getComputedStyle(document.querySelector('button'), '::before').getPropertyValue('content')");
System.out.println("Psuedo Content: " + content);
```

✅ **Use Case**: Validation icons, tooltips.

---

## ⏳ 3. Advanced Waits – Timing Matters

### Implicit Wait

```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

### Explicit Wait

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn"))).click();
```

### Fluent Wait

```java
Wait<WebDriver> fluentWait = new FluentWait<>(driver)
    .withTimeout(Duration.ofSeconds(30))
    .pollingEvery(Duration.ofSeconds(5))
    .ignoring(NoSuchElementException.class);

WebElement delayedElement = fluentWait.until(driver -> driver.findElement(By.id("delayed")));
```

---

## 🎤 Interview Questions Recap

| ❓ Question                 | 💡 Tip                         |
| -------------------------- | ------------------------------ |
| What is a browser profile? | Stores session, settings       |
| Why use ChromeOptions?     | Load saved profile for auth    |
| How to handle AJAX?        | Use WebDriverWait              |
| Select calendar date?      | Loop through calendar widgets  |
| Table with pagination?     | Loop and check row, click next |
| Infinite scroll?           | JavaScript scroll in loop      |
| Shadow DOM?                | JS + shadowRoot                |
| SVG interaction?           | Use local-name() in XPath      |
| Nested iFrames?            | Use switchTo().frame()         |
| Psuedo elements?           | JavaScript getComputedStyle    |
