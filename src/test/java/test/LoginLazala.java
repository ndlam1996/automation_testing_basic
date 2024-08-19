package test;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;

public class LoginLazala {

    WebDriver driver;

    @Test
    public void testLogin() throws InterruptedException {
        System.out.println("Login test");
        intiChromeDriver();
        launchApplication();
        waitForPageToLoad();
        navigateToWebSiteTesting();
        veridyLoadPageWebSiteTesting();
        closeBrowser();
    }

    // funtion to test login

    public void  intiChromeDriver() { // khoi tao Chrome Driver
        System.out.println("Init Chrome Driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void launchApplication() throws InterruptedException {
        System.out.println("Launch Application");
        driver.get("https://anhtester.com/");
        Thread.sleep(5000);
    }

   public void navigateToWebSiteTesting() {
       System.out.println("Navigate to Website Testing");
       WebElement websitetestingelement = driver.findElement(By.cssSelector(".category-item a[href='/courses/website-testing']"));
       websitetestingelement.click();

    }
    public void veridyLoadPageWebSiteTesting() {
        System.out.println("Verify Load Page Website Testing");

        WebElement element = driver.findElement(By.cssSelector("h1"));
        System.out.println(element.getText());
        assert element.getText().equals("Website Testing Courses");
    }
    public void closeBrowser() {
        System.out.println("Close Browser");
        driver.quit();
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
