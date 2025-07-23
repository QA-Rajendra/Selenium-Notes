# Selenium: Web Tables, Checkboxes, Radio Buttons, and Dropdowns

This document provides **in-depth explanation** and **real-world examples** related to handling Web Tables, Checkboxes, Radio Buttons, and Dropdowns in Selenium WebDriver.

---

## 🔹 1. Handling Web Tables

### 🧠 Concept:

A web table is an HTML structure typically made using the `<table>` tag. Inside it, rows are represented by `<tr>` (table row), headers by `<th>`, and columns (cells) by `<td>`.

### ✅ Example Use Case:

Imagine you're automating a stock market dashboard. It displays company names, stock prices, and change percentages in a table.

```html
<table id="stockTable">
  <tr>
    <th>Company</th>
    <th>Price</th>
    <th>Change</th>
  </tr>
  <tr>
    <td>TCS</td>
    <td>3500</td>
    <td>+1.2%</td>
  </tr>
  <tr>
    <td>Infosys</td>
    <td>1450</td>
    <td>-0.5%</td>
  </tr>
</table>
```

### 🔍 Selenium Code:

```java
// Identify all rows (excluding header)
List<WebElement> rows = driver.findElements(By.xpath("//table[@id='stockTable']//tr[position()>1]"));

for (WebElement row : rows) {
    List<WebElement> cols = row.findElements(By.tagName("td"));
    String company = cols.get(0).getText();
    String price = cols.get(1).getText();
    String change = cols.get(2).getText();

    System.out.println(company + " | " + price + " | " + change);
}
```

---

## 🔹 2. Extracting Cell Value

### ✅ Use Case:

You want to extract the stock price of Infosys.

### 🔍 Code:

```java
String price = driver.findElement(By.xpath("//table[@id='stockTable']//tr[td[text()='Infosys']]/td[2]")).getText();
System.out.println("Infosys Stock Price: " + price);
```

---

## 🔹 3. Handling Dynamic Tables

### 🧠 Concept:

In real-world apps, table data can be dynamic, i.e., row count and content change based on backend response. So we loop through rows and columns.

### 🔍 Full Example:

```java
List<WebElement> rows = driver.findElements(By.xpath("//table[@id='stockTable']//tr[position()>1]"));
for (WebElement row : rows) {
    List<WebElement> cells = row.findElements(By.tagName("td"));
    for (WebElement cell : cells) {
        System.out.print(cell.getText() + "\t");
    }
    System.out.println();
}
```

---

## 🔹 4. Handling Dropdowns with Select Class

### 🧠 Concept:

Selenium provides the `Select` class to interact with `<select>` dropdown elements.

### ✅ Example HTML:

```html
<select id="country">
  <option value="IN">India</option>
  <option value="US">USA</option>
  <option value="UK">UK</option>
</select>
```

### 🔍 Code:

```java
Select countrySelect = new Select(driver.findElement(By.id("country")));

// Select by index
countrySelect.selectByIndex(0);

// Select by value
countrySelect.selectByValue("US");

// Select by visible text
countrySelect.selectByVisibleText("UK");
```

---

## 🔹 5. Multi-Select Dropdown

### ✅ HTML:

```html
<select id="fruits" multiple>
  <option value="apple">Apple</option>
  <option value="banana">Banana</option>
  <option value="mango">Mango</option>
</select>
```

### 🔍 Code:

```java
Select fruitSelect = new Select(driver.findElement(By.id("fruits")));
if (fruitSelect.isMultiple()) {
    fruitSelect.selectByVisibleText("Apple");
    fruitSelect.selectByValue("mango");
    fruitSelect.selectByIndex(1); // Banana
}
```

---

## 🔹 6. Deselect Options

```java
fruitSelect.deselectByIndex(1);
fruitSelect.deselectByValue("mango");
fruitSelect.deselectByVisibleText("Apple");
fruitSelect.deselectAll();
```

---

## 🔹 7. Handling Checkboxes

### ✅ HTML:

```html
<input type="checkbox" id="subscribe" /> Subscribe to newsletter
```

### 🔍 Code:

```java
WebElement checkbox = driver.findElement(By.id("subscribe"));
if (!checkbox.isSelected()) {
    checkbox.click();
}
```

---

## 🔹 8. Handling Radio Buttons

### ✅ HTML:

```html
<input type="radio" name="gender" id="male" value="M"> Male
<input type="radio" name="gender" id="female" value="F"> Female
```

### 🔍 Code:

```java
WebElement maleRadio = driver.findElement(By.id("male"));
if (!maleRadio.isSelected()) {
    maleRadio.click();
}
```

---

## 📌 Summary Table:

| Feature       | How to Handle in Selenium        |
| ------------- | -------------------------------- |
| Web Tables    | XPath + loop for rows/cols       |
| Cell Values   | XPath to specific `td`           |
| Dropdown      | `Select` class                   |
| Multi-select  | `selectBy...()` + `isMultiple()` |
| Deselect      | `deselectBy...()`                |
| Checkboxes    | `isSelected()` + `click()`       |
| Radio Buttons | `isSelected()` + `click()`       |

---

## 🧪 Bonus Tip:

Always use dynamic locators or proper XPath to ensure your automation doesn't break due to minor UI changes.

---

Let me know if you want this file in **PDF** or **Excel** format!
