import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG {
    //BeforeSuite  是在配置文件的suite内执行的所有内容之前执行，测试套件是用于测试软件程序的行为或一组行为的测试用例的集合。
    //BeforeTest   是在配置文件的test内执行的所有内容之前执行  是在suite下一层级
    //BeforeClass  只是在当前类执行前执行，其他内的都是作用于单个类内的
    //group        作用于配置文件中的所有类

    //基本标签测试
    @Test(groups="group1",enabled = true)
    public void test1() {
        System.out.println("test1 from group1");
        Assert.assertTrue(true);
    }

    @Test(groups="group1",enabled = true)
    public void test11() {
        System.out.println("test11 from group1");
        Assert.assertTrue(true);
    }
    //忽略属性该测试用例，不执行
    @Test(groups="group2",enabled = true)
    public void test2()
    {
        System.out.println("test2 from group2");
        Assert.assertTrue(true);
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("beforeTest——在所有test之前执行");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("afterTest——在所有test之后执行");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("beforeClass——在类之前执行");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("afterClass——在类之后执行");
    }

    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("beforeSuite");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("afterSuite");
    }

    //只对group1有效，即test1和test11
    @BeforeGroups(groups="group1")
    public void beforeGroups()
    {
        System.out.println("beforeGroups————在组1之前执行");
    }

    //只对group1有效，即test1和test11
    @AfterGroups(groups="group1")
    public void afterGroups()
    {
        System.out.println("afterGroups————在组1之后执行");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("beforeMethod——在每个test之前执行");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("afterMethod——在每个test之后执行");
    }

    /*
    //预期异常测试
    @Test(expectedExceptions = ArithmeticException.class,enabled = true)
    public void exceptionTest(){
        int i = 1 / 0;
        System.out.println("After division the value of i is :"+ i);
    }


    //这是一个超时测试，超过时间记为该条用例失败，时间为毫秒
    @Test(timeOut = 100)
    public void outTimeTest(){
        while (true){
            System.out.println("超时内容执行中...");
        }
    }
    */


}
