import lesson6.Calculator;
import org.junit.*;

public class Test1 {
    Calculator calc;

    @Before
    public void init(){
        calc = new Calculator();
    }

    @Test
    public void test1(){
        Assert.assertEquals(4, calc.add(2,2));
    }

    @Test
    @Ignore(value = "не хочу ждать час!")
    public void test2(){
        Assert.assertEquals(5, calc.div(6, 3));
    }

    @Test (expected = ArithmeticException.class)
    public void test3(){
        calc.div(10,0);
    }

    @Test(timeout = 100)
    public void testDiv1(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calc.div(10,1);
    }

    @After
    public void end(){
        System.out.println("END");
    }
}
