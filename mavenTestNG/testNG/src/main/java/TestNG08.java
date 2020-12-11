import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG08 {
    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {

        return new Object[][] { { 10, 20 }, { 100, 110 }, { 200, 210 } };
    }

    @Test(dataProvider = "provideNumbers")
    public void TestNgLearn1(int param1, int param2) {
        System.out.println("this is TestNG test case1, and param1 is:"+param1+"; param2 is:"+param2);
        Assert.assertFalse(false);
    }

    @Test(dependsOnMethods= {"TestNgLearn1"})
    public void TestNgLearn2() {
        System.out.println("this is TestNG test case2");
    }
}
