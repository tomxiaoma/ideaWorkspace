package day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/01/11 0011.
 */
public class FirstOne {

    private WebDriver driver;


    @BeforeMethod
    public void fun(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test(){
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.name("tj_trnews"));
        element.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    @Test
    public void sendKeys() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("selenium");
        Thread.sleep(3000);
        WebElement element1 = driver.findElement(By.id("su"));
        Thread.sleep(3000);
        element1.click();
    }

    public void clearKeys(){
        driver.get("http://www.baidu.com");
        String keys = driver.findElement(By.id("kw")).getText();
        Assert.assertEquals(keys,"新闻");
    }

    @Test
    public void tagName(){
        driver.get("http://www.baidu.com");
        String element = driver.findElement(By.id("su")).getTagName();
        Assert.assertEquals(element,"input");
    }

    @Test
    public void attr(){
        driver.get("http://www.baidu.com");
        String el = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(el,"百度一下");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
