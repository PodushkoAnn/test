package lesson4.homework;

//Задание 1.
public class Task1 {

    static Object ob = new Object();
    static volatile char currentCh = 'A';

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (ob) {
                            while (currentCh != 'A') {
                                ob.wait();
                            }
                            System.out.print("A");
                            currentCh = 'B';
                            ob.notifyAll();
                        }
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (ob) {
                            while (currentCh != 'B') {
                                ob.wait();
                            }
                            System.out.print("B");
                            currentCh = 'C';
                            ob.notifyAll();
                        }
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (ob) {
                            while (currentCh != 'C') {
                                ob.wait();
                            }
                            System.out.print("C");
                            currentCh = 'A';
                            ob.notifyAll();
                        }
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
