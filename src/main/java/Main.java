import java.sql.SQLException;

public class Main {

//Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив,
// метод должен вернуть новый массив, который получен путем вытаскивания элементов из исходного массива,
// идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
// в противном случае в методе необходимо выбросить RuntimeException.


        public static int[] checkArray(int[] arr) {
            int x = 0;
            int [] result = null;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) {
                    x = arr[i];
                    result = new int[arr.length - i - 1];
                    for (int j = i + 1, k = 0; j < arr.length; j++, k++) {
                        if (arr[j] == 4) continue;
                        result[k] = arr[j];
                    }
                }
            }
            try{
                x = 1 / x;
            } catch(ArithmeticException e){
                throw new RuntimeException();
            }
            return result;
        }

//Написать метод, который проверяет что массив состоит только из чисел 1 и 4.
// Если в массиве нет хоть одной 4 или 1, то метод вернет false;
        public static boolean checkArray2(int[] arr){

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != 1 && arr[i] != 4) return false;
            }
            return true;
        }
    }

