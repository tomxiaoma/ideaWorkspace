package day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/01/25 0025.
 */
public class fourDemo {

    private WebDriver driver;

    @BeforeMethod
    public void Befroe(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\ideaWorkspace\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }

    @Test
    public void robotTest() throws Exception{
        driver.get("http://www.baidu.com");

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_S);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_ENTER);

    }

    @Test
    public void ddemo(){

        String path = "D://";

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("profile.default_content_settings.popus",0);
        map.put("download.default_directory",path);

        ChromeOptions profile = new ChromeOptions();
        profile.setExperimentalOption("op",map);


    }

    @AfterMethod
    public void afterD() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
