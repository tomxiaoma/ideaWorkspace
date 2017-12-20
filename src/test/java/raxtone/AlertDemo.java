package raxtone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/12/18 0018.
 */
public class AlertDemo {

    private WebDriver webDriver;

    @BeforeTest
    public void before(){
        System.setProperty("webdriver.chrome.driver", "D:\\ideaWorkspace\\tools\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void alertTest(){
        System.out.print("hello world");
    }
}
