Advanced Selenium Guide - Part 2
✅ 14) TestNG Framework
TestNG (Test Next Generation) is an open-source testing framework inspired by JUnit, offering enhanced functionalities for robust test case management.
🔍 What is TestNG?
TestNG is a Java-based framework designed to streamline test automation with powerful annotations, grouping, sequencing, and configuration features.

🧠 Tip: Use TestNG for structured, scalable test suites with built-in reporting capabilities.

🌟 Features & Benefits of TestNG



Feature
Description



✅ Annotations
Lifecycle annotations like @Test, @BeforeSuite, @AfterMethod


🔄 Grouping
Organize and run related tests using groups


⏱ Parallel Execution
Execute multiple tests simultaneously to reduce runtime


📊 Data Provider
Supply dynamic test data to methods


📈 Reports
Generate HTML/XML reports automatically


🔗 Dependency
Define dependencies between test methods


🔽 How to Download and Install TestNG?

Open Eclipse:

Navigate to Help → Eclipse Marketplace
Search for TestNG, click Install
Restart Eclipse


Using Maven:
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.8.0</version>
    <scope>test</scope>
</dependency>




🧠 Tip: Maven simplifies dependency management and ensures consistent TestNG versions across projects.

🧩 Key Annotations in TestNG
@BeforeSuite   // Runs before all tests in the suite  
@BeforeClass   // Runs before the first method of the current class  
@BeforeMethod  // Runs before each @Test method  
@Test          // Marks a method as a test case  
@AfterMethod   // Runs after each @Test  
@AfterClass    // Runs after all methods in the class  
@AfterSuite    // Runs after all tests in the suite

🧪 How to Run a Test Suite in TestNG?
Create a testng.xml file to organize tests:
<suite name="MySuite">
  <test name="MyTests">
    <classes>
      <class name="com.test.LoginTest"/>
      <class name="com.test.RegistrationTest"/>
    </classes>
  </test>
</suite>

Run using:

Eclipse: Right-click testng.xml → Run As → TestNG Suite
Maven or CI pipeline integration

🎯 Other Key Concepts

Groups in TestNG:
@Test(groups = {"smoke", "regression"})


Depends On in TestNG:
@Test
public void login() {}

@Test(dependsOnMethods = {"login"})
public void verifyDashboard() {}


Test Case Sequencing:
@Test(priority = 1)
public void startTest() {}


TestNG Reports:

Generated under /test-output/index.html after execution.


Parameters in TestNG:
@Parameters("browser")
public void setup(String browser) {
    // Launch browser dynamically
}


Multi-browser & Parallel Testing:
<suite name="ParallelTests" parallel="tests" thread-count="2">



🧠 Interview Questions – TestNG

What are TestNG annotations and their execution order?
How do you perform parallel testing using TestNG?
How do you group test cases in TestNG?
How do you create and execute a test suite in TestNG?

✅ 15) Automation Framework
An Automation Framework is a structured set of rules, tools, and libraries designed to create, manage, and execute automated tests efficiently.
💡 What is an Automation Framework?
A reusable structure that promotes consistent, efficient test automation across projects.

🧠 Tip: A well-designed framework reduces maintenance overhead and improves scalability.

✅ Features of a Good Automation Framework

📁 Structured folder design (tests, data, reports)
🔄 Reusable functions and methods
📈 Comprehensive test reports and logs
🧪 Seamless integration with TestNG/JUnit
⚙️ CI/CD pipeline compatibility

📈 Benefits of Using Frameworks



Benefit
🔍 Description



🔁 Reusability
Reuse functions across modules


⏱ Scalability
Handle growing test suites with ease


🔍 Maintainability
Modular design simplifies debugging


🧪 Reliability
Reduces manual errors


📊 Reporting
Generates detailed reports (TestNG, Allure)


🔄 Types of Automation Framework



Type
Description



🔢 Data Driven
Separates test logic and data (Excel, CSV, DB)


🔄 Hybrid
Combines data-driven, keyword-driven, or POM approaches


📚 Keyword Driven
Uses external files to define test steps


📐 Modular
Independent, reusable modules


📦 POM (Page Object Model)
Each web page has a dedicated class for elements and actions


💡 Page Object Model (POM) Design Pattern
What is POM?
An OOP-based design pattern where each web page is represented by a Java class containing:

🎯 WebElements using @FindBy or By locators
📥 Methods for actions like login, click, etc.

Example (Non-Page Factory):
public class LoginPage {
    WebDriver driver;
    
    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("login");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String user, String pass){
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}


🧠 Tip: Use POM to enhance code maintainability and reduce duplication in Selenium tests.

📌 Interview Questions – Automation Framework

What are the components of your automation framework?
What is Page Object Model, and how is it implemented?
What is the difference between Page Factory and POM?
How do you handle test data in your framework?
How do you integrate reports and logging?
