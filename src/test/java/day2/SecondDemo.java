package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/01/24 0024.
 */
public class SecondDemo {

    private WebDriver driver;

    @BeforeMethod
    public void waitBefore(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void waitTest(){
        driver.get("http://www.baidu.com");
        WebDriverWait driverWait = new WebDriverWait(driver,10);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("kw")));
    }

    @Test
    public void ActionsDemo(){
        driver.get("http://www.baidu.com");
        List<WebElement> elements = driver.findElements(By.id("su"));
        Actions ac = new Actions(driver);
        ac.keyDown(Keys.CONTROL)
                .click(elements.get(0))
                .click(elements.get(2)).keyUp(Keys.CONTROL)
                .perform();
    }

    @AfterMethod
    public void waitAfter() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();

    }

}
