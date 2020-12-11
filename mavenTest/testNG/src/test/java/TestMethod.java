public class TestMethod {
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClase");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }

    @Test
    public void testcase1(){
        Assert.assertEquals(1,1);
        System.out.println("test01");
    }

    @Test
    public void testcase2(){
        Assert.assertTrue(true);
        System.out.println("test02");
    }

    @DataProvider(name="user")
    public Object[][] getStr(){
        return new Object[][]{
                {"","","账户不能为空"},
                {"admin","","密码不能为空"},
                {"admin","123","密码错误"}
        };
    }

    @Test(dataProvider = "user")
    private void sout(String uname,String pword,String msg){
        System.out.println(uname+"->"+pword+"->"+msg);
    }

}
