import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG06 {
    //依赖测试
    /*在@Test注释中使用属性dependsOnMethods
       在@Test注释中使用属性dependsOnGroups
       */
    @Test(enabled=true)
    public void TestNgLearn1() {
        System.out.println("this is TestNG test case1");
    }

    @Test(dependsOnMethods= {"TestNgLearn1"})
    public void TestNgLearn2() {
        System.out.println("this is TestNG test case2");
    }

    @Test(enabled=true)
    public void TestNgLearn3() {
        System.out.println("this is TestNG test case3");
        Assert.assertFalse(true);
    }

    //alwaysRun=true软依赖，不管依赖的方法失败还是成功，都执行，不加这个属性，就忽略执行改条用例
    @Test(dependsOnMethods= {"TestNgLearn3"},alwaysRun=true)
    public void TestNgLearn4() {
        System.out.println("this is TestNG test case4");
    }

    //这里写法有没有{}都可以
    @Test(groups = { "init" })
    public void serverStartedOk() {
        Assert.assertFalse(true);
    }

    @Test(groups = { "init" })
    public void initEnvironment() {
        Assert.assertFalse(true);
    }

    @Test(dependsOnGroups = { "init.*" })
    public void method1() {}
}
