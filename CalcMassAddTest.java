import lesson6.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@RunWith(Parameterized.class)
public class CalcMassAddTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{{0,0,0}, {1,1,2}, {5,5,10}, {2,2,5}});
    }

    private int a;
    private int b;
    private int c;
    Calculator calc;

    public CalcMassAddTest(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Before
    public void init(){
        calc = new Calculator();
    }

    @Test public void massTestAdd(){
        Assert.assertEquals(c, calc.add(a,b));
    }
}
