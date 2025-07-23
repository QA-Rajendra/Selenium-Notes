# 🧙‍♂️ Selenium WebElement Commands – Complete Guide (Java)

This section covers all the most commonly used WebElement operations, enabling you to start writing real-world automation tests for any web application.

---

## 🔍 1. `findElement()` vs `findElements()`

### 🧠 Concept:

| Method           | Returns                       | When to Use                                 |
| ---------------- | ----------------------------- | ------------------------------------------- |
| `findElement()`  | First matching WebElement     | When you need **one** element               |
| `findElements()` | List of all matching elements | When you want **multiple elements** or loop |

### 💻 Java Example:

```java
// Single element
WebElement searchBox = driver.findElement(By.name("q"));

// Multiple elements
List<WebElement> allLinks = driver.findElements(By.tagName("a"));
System.out.println("Total links: " + allLinks.size());
```

---

## ✍️ 2. Enter & Clear Text in Input Fields

### 🧠 Concept:

Use `sendKeys()` to input text and `clear()` to clear existing input.

### 💻 Java Example:

```java
WebElement input = driver.findElement(By.id("username"));
input.clear();                      // 🧼 Clear existing value
input.sendKeys("testuser");         // ⌨️ Type new value
```

---

## 🔁️ 3. How Click Action Works Differently

### 🧠 Concept:

* For `<button>`, `<input type="submit">`, `<a>` tags → `click()` simulates a user action.
* May not work on hidden/overlapped elements (use JS in that case).

### 💻 Java Example:

```java
WebElement loginBtn = driver.findElement(By.id("loginBtn"));
loginBtn.click();  // 🎯 Performs a left-click
```

🗜️ If `click()` throws `ElementNotInteractableException`, try using `JavaScriptExecutor`.

---

## 🎛️ 4. Managing Input Fields, Buttons, and Links

### 💻 Java Example:

```java
// Text input
driver.findElement(By.id("email")).sendKeys("abc@test.com");

// Button
driver.findElement(By.id("submit")).click();

// Link
driver.findElement(By.linkText("Forgot Password?")).click();
```

---

## 🔗 5. Finding All Links on the Page

### 💻 Java Example:

```java
List<WebElement> links = driver.findElements(By.tagName("a"));
for (WebElement link : links) {
    System.out.println(link.getText() + " -> " + link.getAttribute("href"));
}
```

🗜️ Use this for link validation or broken link testing.

---

## 🗖️ 6. Extracting More Than One Object (Multiple Elements)

### 💻 Java Example:

```java
List<WebElement> buttons = driver.findElements(By.className("btn-primary"));
System.out.println("Button count: " + buttons.size());

for (WebElement btn : buttons) {
    System.out.println(btn.getText());
}
```

---

## 📍 7. Extracting Elements from a Specific Area

### 🧠 Concept:

Use **nested locators** to extract elements from a specific block like a `div` or section.

### 💻 Java Example:

```java
WebElement sidebar = driver.findElement(By.id("menu"));
List<WebElement> items = sidebar.findElements(By.tagName("li"));

for (WebElement item : items) {
    System.out.println(item.getText());
}
```

🗜️ Useful for filtering menus, headers, footers, or widgets.

---

## 🤔 8. Check if Element is Present, Displayed, Enabled, or Selected

| Check Type | Method Used                      | Description                              |
| ---------- | -------------------------------- | ---------------------------------------- |
| Exists     | `try-catch` with `findElement()` | If element is not found, catch exception |
| Displayed  | `isDisplayed()`                  | Visible to user                          |
| Enabled    | `isEnabled()`                    | Interactable (input, buttons)            |
| Selected   | `isSelected()`                   | Checkbox/radio selected or not           |

### 💻 Java Example:

```java
WebElement checkbox = driver.findElement(By.id("subscribe"));

if (checkbox.isDisplayed() && checkbox.isEnabled()) {
    if (!checkbox.isSelected()) {
        checkbox.click();
    }
}
```

---

# 💬 Selenium Interview Questions – WebElement

### ❓ Q1. What is the difference between `findElement()` and `findElements()`?

**✔️ A:**

* `findElement()` returns a single WebElement (first match).
* `findElements()` returns a list of WebElements. If none found, returns an empty list (no exception).

---

### ❓ Q2. How do you handle input fields in Selenium?

**✔️ A:**
Use `sendKeys()` to enter text, and `clear()` to erase existing input.

---

### ❓ Q3. What if a button is not clickable?

**✔️ A:**
It might be hidden, overlapped, or disabled. Use JavaScriptExecutor as an alternative:

```java
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click();", buttonElement);
```

---

### ❓ Q4. How can you verify if a checkbox or radio button is selected?

**✔️ A:**
Use `isSelected()` method:

```java
boolean status = driver.findElement(By.id("agree")).isSelected();
```

---

### ❓ Q5. How do you check if an element is present or visible?

**✔️ A:**

* Use `isDisplayed()` to check visibility.
* Wrap `findElement()` in try-catch to check existence.

---

### ❓ Q6. How to extract all links from a web page?

**✔️ A:**

```java
List<WebElement> links = driver.findElements(By.tagName("a"));
```

---

## ✅ Summary

| Action                     | WebElement Method              |
| -------------------------- | ------------------------------ |
| Enter text                 | `sendKeys("text")`             |
| Clear text                 | `clear()`                      |
| Click element              | `click()`                      |
| Get text                   | `getText()`                    |
| Get attribute              | `getAttribute("attr")`         |
| Check visibility           | `isDisplayed()`                |
| Check enabled state        | `isEnabled()`                  |
| Check if selected          | `isSelected()`                 |
| Get multiple elements      | `findElements()`               |
| Extract from specific area | `parentElement.findElements()` |

---

> 💡 **Pro Tip:** Always use validations (`isDisplayed()`, `isEnabled()`) before interacting with elements to avoid runtime failures.
