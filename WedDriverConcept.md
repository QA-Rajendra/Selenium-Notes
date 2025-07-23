# 🌐 Browser & Navigation Commands in Selenium WebDriver (Java)

This guide covers essential browser control and navigation functions using Selenium WebDriver in Java.

---

## 🚀 1. Launch Browser & Open URL

```java
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
WebDriver driver = new ChromeDriver();
driver.get("https://www.google.com");
```

📝 The browser will launch and navigate to the specified URL.

---

## 🏷️ 2. Verify Page Title

### 🧠 Concept

Use `getTitle()` to get the current page title and compare it with the expected one.

```java
String expectedTitle = "Google";
String actualTitle = driver.getTitle();

if (expectedTitle.equals(actualTitle)) {
    System.out.println("✅ Title matched!");
} else {
    System.out.println("❌ Title did not match.");
}
```

📝 Validates if the correct page is loaded.

---

## 📄 3. Get Page Source

### 🧠 Concept

Retrieve the full HTML content of the current page using `getPageSource()`.

```java
String sourceCode = driver.getPageSource();
System.out.println(sourceCode);
```

📝 Useful for content verification or debugging.

---

## 🛑 4. Difference Between `close()` and `quit()`

| Method    | Purpose                                   | Affects        |
| --------- | ----------------------------------------- | -------------- |
| `close()` | Closes the current tab/window             | One tab only   |
| `quit()`  | Closes all browser windows & ends session | Entire browser |

```java
driver.close(); // Closes current tab
driver.quit();  // Closes entire browser session
```

📝 Always use `quit()` at the end of tests to avoid memory leaks.

---

## 🔀 5. Navigate Back & Forward

### 🧠 Concept

Selenium can simulate browser navigation history using:

```java
driver.get("https://example.com/home");
driver.navigate().to("https://example.com/about");

// ⬅️ Go back to previous page
driver.navigate().back();

// ➡️ Go forward
driver.navigate().forward();
```

📝 Mimics browser's back and forward buttons.

---

## 🔁 6. Refresh the Page

```java
driver.navigate().refresh(); // Refreshes current page
```

📝 Used to test page reload behaviors or auto-refresh content.

---

## 🔗 7. Open URL Using `navigate().to()`

```java
driver.navigate().to("https://www.google.com");
```

📝 Internally similar to `get()`, but allows chaining with other navigation commands.

---

## 🎤 Interview Q\&A – Browser & Navigation Commands

> **❓ Q1. How do you open a website in Selenium?**
> ✔️ `driver.get("https://example.com");`

> **❓ Q2. What is the difference between `get()` and `navigate().to()`?**
> ✔️ Both open a URL. `get()` waits for full page load. `navigate().to()` is more flexible and used in navigation chaining.

> **❓ Q3. Difference between `close()` and `quit()`?**
> ✔️ `close()` shuts current tab, `quit()` closes all browser windows.

> **❓ Q4. How to get the title of a web page?**
> ✔️ `String title = driver.getTitle();`

> **❓ Q5. How to get the HTML source of a page?**
> ✔️ `String html = driver.getPageSource();`

> **❓ Q6. How to perform back and forward navigation?**
> ✔️
>
> ```java
> driver.navigate().back();  
> driver.navigate().forward();
> ```

> **❓ Q7. How to refresh the current browser page?**
> ✔️ `driver.navigate().refresh();`

---

## ✅ Summary Table

| Task             | Selenium Command                              |
| ---------------- | --------------------------------------------- |
| Open URL         | `driver.get("url")` or `navigate().to("url")` |
| Get Title        | `driver.getTitle()`                           |
| Get Page Source  | `driver.getPageSource()`                      |
| Close Tab        | `driver.close()`                              |
| Quit Browser     | `driver.quit()`                               |
| Navigate Back    | `driver.navigate().back()`                    |
| Navigate Forward | `driver.navigate().forward()`                 |
| Refresh Page     | `driver.navigate().refresh()`                 |

---

📘 **Pro Tip**: Always add `driver.quit()` at the end of your scripts to close browser sessions cleanly and free up system resources.
