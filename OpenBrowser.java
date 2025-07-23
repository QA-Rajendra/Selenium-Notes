//📌 Way 1: Launch Browser using System.setProperty()

// Import Selenium and WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowserUsingSystemProperty {
    public static void main(String[] args) {
        // Step 1: Set the system property with the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

        // Step 2: Create a new instance of ChromeDriver (this launches Chrome)
        WebDriver driver = new ChromeDriver();

        // Step 3: Open a URL in the launched browser
        driver.get("https://www.google.com");

        // Step 4: Optional - Print the title of the opened page
        System.out.println("Page Title is: " + driver.getTitle());

        // Step 5: Close the browser
        driver.quit();
    }
}
//📌 Way 2: Launch Browser Using WebDriverManager (No manual path setting)
//👉 This requires you to include the WebDriverManager library from Bonigarcia.

/*🔧 Maven Dependency for WebDriverManager:

<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.8.0</version> <!-- or latest -->
</dependency>*/

//✅ Java Code:

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowserUsingWebDriverManager {
    public static void main(String[] args) {
        // Step 1: Setup ChromeDriver automatically using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Step 2: Launch the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Step 3: Navigate to a website
        driver.get("https://www.example.com");

        // Step 4: Print page title
        System.out.println("Opened URL title: " + driver.getTitle());

        // Step 5: Close the browser
        driver.quit();
    }
}
/*🔍 Summary
Method	Uses	Manual Setup?
System.setProperty()	  Requires path to driver	   ✅ Yes
WebDriverManager.setup()	Automatically manages driver	❌ No  */
