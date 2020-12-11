import org.testng.annotations.Test;

@Test(groups = "group2")
public class TestNG03 {
    @Test(enabled=false)
    public void TestNgLearn1() {
        System.out.println("this is TestNG test case1");
    }

    @Test
    public void TestNgLearn2() {
        System.out.println("this is TestNG test case2");
    }
}
