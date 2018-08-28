import org.junit.Assert;
import org.junit.Test;
//задание 2
public class Test_Array2 {

    int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
    int[] y = {0,2,5,6,3,5,6,8};
    int[] aaa = {1,4,1,4,1,4};
    int[] bbb = {1,1,1};

    @Test
    public void testArray1(){
        Assert.assertTrue(Main.checkArray2(aaa));
    }

    @Test (expected = RuntimeException.class)
    public void testArray2 (){
        Main.checkArray2(y);
    }

    @Test
    public void testArray3(){
        Assert.assertTrue(Main.checkArray2(bbb));
    }

    @Test
    public void testArray4(){
        Assert.assertTrue(Main.checkArray2(aaa));
    }
}
