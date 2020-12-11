import org.testng.annotations.Test;

public class TestNG02 {

    @Test(groups = "group2")
    public void test2(){
        System.out.println("this is test2 own to group2");
    }
}
