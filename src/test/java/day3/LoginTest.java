package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/01/30 0030.
 */
public class LoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void loginBefor() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com");
        Thread.sleep(3000);
    }

    @Test
    public void LoginTest() throws InterruptedException {
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("15900796431");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("mwt2832018");
        driver.findElement(By.id("dologin")).click();

        WebDriverWait driverWait = new WebDriverWait(driver,10);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),\"退出\")]")));

        String element = driver.findElement(By.xpath("//a[contains(text(),\"退出\")]")).getText();
        Assert.assertEquals(element,"退出");
    }

    @AfterMethod
    public void LoginAfter(){
        driver.quit();
    }

}
