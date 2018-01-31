package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by mawentao on 2018/01/30 0030.
 */
public class RegisterTest {
    private WebDriver driver;

    @BeforeMethod
    public void waitBefore(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com");
    }

    @Test
    public void registTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().frame("x-URS-iframe");
        WebElement element = driver.findElement(By.id("changepage"));
        element.click();

       String handle = driver.getWindowHandle();
       for (String handles : driver.getWindowHandles()){
            if(handles.equals(handle)){
                continue;
            }
            driver.switchTo().window(handles);
       }
        driver.findElement(By.id("nameIpt")).sendKeys("opiopiee");
        driver.findElement(By.id("mainPwdIpt")).sendKeys("mwt123456");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("mwt123456");
        driver.findElement(By.id("mainMobileIpt")).sendKeys("15900796431");

        Thread.sleep(5000);
    }

    @AfterMethod
    public void quitBrown(){
        driver.quit();
    }
}
