package utimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/** 1. Setup chrome browser.
 2. Open URL.
 3. Print the title of the page.
 4. Print the current url.
 5. Print the page source.
 6. Click on ‘Sign In’ link
 7. Print the current url
 8. Enter the email to email field.
 9. Enter the password to password field.
 10. Click on Login Button.
 11. Navigate to baseUrl.
 12. Navigate forward to Homepage.
 13. Navigate back to baseUrl.
 14. Refresh the page.
 15. Close the browser.
 */
public class UltimateQa {

    static String browser = "Chrome";
    static String baseURL = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        // Open URL
        driver.get(baseURL);
        // Maximise the browser
        driver.manage().window().maximize();
        // Implicit the wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Print the title of the page
        System.out.println("The title of the page is: " + driver.getTitle());
        // Print the current URL
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        //Print the page source
        System.out.println("The page source of current URL is: " + driver.getPageSource());
        //Click on sign in link
        WebElement signIn = driver.findElement(By.linkText("Sign In"));
        signIn.click();
        //Print the current URL
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        // Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("Prime456@gmail.com");
        // Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("6543");
        //Click on Login button
        WebElement loginButton = driver.findElement(By.partialLinkText("Sign"));
        loginButton.click();
        Thread.sleep(5000);
        //Navigate to base URL
        driver.navigate().to(baseURL);
        //Navigate forward to Home page
        driver.navigate().forward();
        //Navigate back to baseURL
        driver.navigate().to(baseURL);
        // Refresh the page
        driver.navigate().refresh();
        // Close the browser
        driver.quit();

    }
}
