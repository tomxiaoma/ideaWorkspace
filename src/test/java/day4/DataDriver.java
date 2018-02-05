package day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/02/05 0005.
 */
public class DataDriver {
    @DataProvider(name ="loginUser" )
    public Object[][] dataDriverTest(){
        return new Object[][]{{"1","a"},{"2","b"}};
    }

    @Test(dataProvider = "loginUser")
    public void LoginUser(String x, String y){
        System.out.println(x);
        System.out.println(y);
    }

}
