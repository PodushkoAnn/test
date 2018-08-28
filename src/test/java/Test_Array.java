import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//задание 1
public class Test_Array {

    int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
    int[] y = {0,2,5,6,3,5,6,8};
    int[] aaa = {1,4,1,4,1,4};
    int[] bbb = {2,3,5};

    @Test
    public void testArray1(){
        Assert.assertArrayEquals(new int[]{1, 7}, Main.checkArray(arr));
    }

    @Test (expected = RuntimeException.class)
    public void testArray2 (){
        Main.checkArray(y);
    }

    @Test (expected = RuntimeException.class)
    public void testArray3() {
        Main.checkArray(aaa);
    }

    @Test
    public void testArray4(){
        Assert.assertArrayEquals(new int[]{2,2}, Main.checkArray(bbb));
    }


}
