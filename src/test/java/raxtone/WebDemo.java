package raxtone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/12/14 0014.
 */
public class WebDemo {

    WebDriver webDriver = null;

    WebDriver driver =null;

    @BeforeTest
    public void publicTest(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void openFirefox(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\tools\\chromedriver.exe");
        webDriver = new ChromeDriver();
         webDriver.get("http://www.baidu.com");
         webDriver.manage().window().maximize();
         System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());
    }

    @Test
    public void fun2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\tools\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        webDriver.get("http://www.hao123.com");
        Thread.sleep(3000);
        webDriver.navigate().back();
        Thread.sleep(3000);
        webDriver.navigate().forward();
        Dimension dimension = new Dimension(800,900);
        webDriver.manage().window().setSize(dimension);

        System.out.println(webDriver.getCurrentUrl());
    }

    @Test
    public void fun3(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://www.baidu.com");
       WebElement element = webDriver.findElement(By.id("kw"));
        List<WebElement> list = webDriver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i=0;i<list.size();i++){
            String text = list.get(i).getText();
            System.out.println(text);
        }

    }

    @Test
    public void fun4(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://www.baidu.com");
        Boolean findone = webDriver.findElement(By.id("su")).isDisplayed();
        System.out.println(findone);
        Assert.assertTrue(findone);
    }

    @Test
    public void fun5(){

        webDriver = new ChromeDriver();
        webDriver.get("http://www.baidu.com");

        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun6(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://www.baidu.com");

    }

    @Test
    public void alertDemo(){
        driver.get("http://www.baidu.com");
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

   @AfterTest
    public void closeFireFox() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }
}
