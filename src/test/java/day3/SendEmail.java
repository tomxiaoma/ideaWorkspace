package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/01/31 0031.
 */
public class SendEmail {
    private WebDriver driver;

    @BeforeMethod
    public void loginBefor() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.163.com");
        Thread.sleep(3000);
    }

    @Test
    public void sendEmailTest() throws InterruptedException {
        SendEmail.loginFuntion(driver,"15900796431","mwt2832018");

        WebDriverWait driverWait = new WebDriverWait(driver,10);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='dvNavTop']/ul/li/span[contains(text(),\"写 信\")]")));

        driver.findElement(By.xpath("//*[@id='dvNavTop']/ul/li/span[contains(text(),\"写 信\")]")).click();
        driver.findElement(By.xpath("//*[@class='nui-editableAddr-ipt']")).sendKeys("752876417@qq.com");
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("傻逼王大壮");
        driver.findElement(By.xpath(".//*[@title=\"点击添加附件\"]/input")).sendKeys("F:\\raxtone.jpeg");

        WebElement webElement = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(webElement);
        driver.findElement(By.xpath("/html/body")).sendKeys("这是内容！！！！");

        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[text()=\"发送\"]")).click();


    }

    public static void loginFuntion(WebDriver driver,String userName,String pwd){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }

    @AfterMethod
    public void LoginAfter() throws InterruptedException {
        Thread.sleep(7000);
        driver.quit();
    }
}
