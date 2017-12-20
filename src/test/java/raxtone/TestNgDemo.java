package raxtone;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Administrator on 2017/12/13 0013.
 */
public class TestNgDemo {
    @Test
    public void fun(){
        int a =1;
        int b =1;
        Assert.assertEquals(a,b,"不相等");
    }

    @Test
    public void fun1(){
        String a = null;
        Assert.assertNull(a);
    }


}
