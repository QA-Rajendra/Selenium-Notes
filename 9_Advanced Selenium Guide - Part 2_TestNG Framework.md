# TestNG and Automation Framework Guide

## 🔍 What is TestNG?

TestNG is a Java-based testing framework that simplifies automation with features like annotations, test sequencing, grouping, and built-in reporting.

> 🧠 **Tip:** Use TestNG for structured, scalable test suites with easy reporting.

---

## 🌟 Features & Benefits of TestNG
   🔧 Feature | 📄 Description |
 |-----------|----------------|
 | ✅ **Annotations** | Lifecycle methods like `@Test`, `@BeforeSuite`, `@AfterMethod` |
 | 🔄 **Grouping** | Organize and run related tests together |
 | ⏱ **Parallel Execution** | Run tests concurrently to save time |
 | 📊 **Data Provider** | Pass dynamic test data using `@DataProvider` |
 | 📈 **Reports** | Auto-generates HTML/XML reports after execution |
 | 🔗 **Dependency** | Define test method execution dependencies |

---

## 🔽 How to Download and Install TestNG?

### 🖥️ In Eclipse:
1. Go to `Help → Eclipse Marketplace`
2. Search for **TestNG**
3. Click **Install** and restart Eclipse

### 📦 Using Maven:

```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.8.0</version>
    <scope>test</scope>
</dependency>
🧠 Tip: Maven ensures consistent TestNG versions across teams/projects.

🧩 Key Annotations in TestNG
Copy
@BeforeSuite    // Before all tests in the suite
@BeforeClass    // Before the first method of the class
@BeforeMethod   // Before every @Test
@Test           // Actual test case
@AfterMethod    // After every @Test
@AfterClass     // After all methods in the class
@AfterSuite     // After all tests in the suite
🧪 How to Run a Test Suite in TestNG?
Create testng.xml:

Copy
<suite name="MySuite">
  <test name="MyTests">
    <classes>
      <class name="com.test.LoginTest"/>
      <class name="com.test.RegistrationTest"/>
    </classes>
  </test>
</suite>
Run via:

Eclipse: Right-click on testng.xml → Run As → TestNG Suite
CI tools like Jenkins
Maven CLI
🎯 Other Key Concepts
Groups in TestNG:
Copy
@Test(groups = {"smoke", "regression"})
Depends On:
Copy
@Test
public void login() {}

@Test(dependsOnMethods = {"login"})
public void verifyDashboard() {}
Test Case Priority:
Copy
@Test(priority = 1)
public void startTest() {}
TestNG Reports:
After execution, reports are generated in:

Copy
/test-output/index.html
Parameters:
Copy
@Parameters("browser")
public void setup(String browser) {
    // Launch browser dynamically
}
Parallel Testing Setup:
Copy
<suite name="ParallelTests" parallel="tests" thread-count="2">
🧠 TestNG Interview Questions
What are TestNG annotations and their execution order?
How do you perform parallel testing using TestNG?
How do you group test cases in TestNG?
How do you create and execute a test suite in TestNG?
💡 What is an Automation Framework?
A reusable structure of tools and standards that helps in writing reliable, maintainable, and scalable test automation scripts.

🧠 Tip: A well-designed framework reduces maintenance overhead and boosts productivity.

✅ Features of a Good Automation Framework
📌 Feature	📘 Description
📁 Structured Folders	Separate folders for tests, reports, data, logs
🔄 Reusable Components	Shared functions, helpers, utilities
📈 Rich Reporting	Detailed reports (TestNG, Allure, Extent)
🧪 Integration with TestNG	Easily plug into JUnit/TestNG
⚙️ CI/CD Compatibility	Jenkins, GitHub Actions, Azure Pipelines etc.
📈 Benefits of Frameworks
Benefit	🔍 Description
🔁 Reusability	Reuse code across modules
⏱ Scalability	Handles growing test suites easily
🔍 Maintainability	Modular design simplifies updates
🧪 Reliability	Reduces manual errors
📊 Reporting	Auto-generates test result reports
🔄 Types of Automation Frameworks
🛠 Type	📋 Description
🔢 Data Driven	Uses Excel/CSV/DB for input data
📚 Keyword Driven	External keywords map to actions
🔄 Hybrid	Combines multiple frameworks (data + keyword + POM)
📐 Modular	Scripts broken into independent, reusable pieces
📦 POM (Page Object Model)	Each page has a separate class with elements + actions
💡 POM (Page Object Model) Design Pattern
OOP-based model where each web page is represented by a class containing:

🎯 WebElements (using @FindBy or By)
📥 Methods that perform actions
🧾 Example (Non-PageFactory):
Copy
public class LoginPage {
    WebDriver driver;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
🧠 Tip: POM increases code readability, reusability, and simplifies maintenance.

📌 Automation Framework – Interview Questions
What are the components of your automation framework?
What is Page Object Model and how is it implemented?
What is the difference between POM and Page Factory?
How do you manage test data in your framework?
How do you integrate reporting and logging?
