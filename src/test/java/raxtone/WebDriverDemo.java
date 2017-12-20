package raxtone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/12/15 0015.
 */
public class WebDriverDemo {

    private WebDriver driver;

    @BeforeTest
    public void beforeTsst(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }

    @Test
    public void fun(){
        WebElement textValue = driver.findElement(By.xpath(".//*[@id='kw']"));
        WebElement clickValue = driver.findElement(By.xpath(".//*[@id='su']"));
        textValue.sendKeys("selenium");
        clickValue.click();
    }

    @AfterTest
    public void closeWin() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
