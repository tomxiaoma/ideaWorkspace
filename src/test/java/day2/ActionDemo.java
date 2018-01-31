package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/01/24 0024.
 */
public class ActionDemo {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTets(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void ActionTest(){
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.id("su"));
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
    }

    @AfterMethod
    public void arterclose() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
