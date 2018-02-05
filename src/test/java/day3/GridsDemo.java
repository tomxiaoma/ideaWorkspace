package day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Administrator on 2018/02/01 0001.
 */
public class GridsDemo {

    @DataProvider(name="data4")
    public static Object[][] test(){
        return new Object[][]{
                {"firefox"},
                {"chrome"}};
    }

    @Test(dataProvider = "data4")
    public void gridsTest(String browser) throws MalformedURLException,InterruptedException {
        DesiredCapabilities dc =null;
        if(browser.equals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else if(browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else{
            System.out.println("error");
        }

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.123:4444/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(50000);
        driver.quit();
    }

}
