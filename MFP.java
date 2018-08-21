package lesson4.homework;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MFP {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {


            System.out.println("Введите количество страниц для печати");
            final int pqty = scanner.nextInt();
            System.out.println("Введите количество страниц для сканирования");
            final int sqty = scanner.nextInt();

            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    toPrint(pqty);
                }
            });

            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    toScan(sqty);
                }
            });

            t1.start();
            t2.start();
        }

    }

    public static void toPrint(int qty){
        for (int i = 1; i <= qty; i++) {
            System.out.println("напечатано страниц: " + i);

            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void toScan(int qty){
        for (int i = 1; i <= qty; i++) {
            System.out.println("отсканировано страниц: " + i);

            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
