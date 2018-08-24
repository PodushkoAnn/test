import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {

    protected static final int CARS_COUNT = 4;
    protected static final CountDownLatch START = new CountDownLatch(CARS_COUNT + 1);
    protected static CountDownLatch FINISH;
    protected static boolean win;

    public static void main(String[] args) throws InterruptedException {

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        FINISH = new CountDownLatch(CARS_COUNT * race.getStages().size());
        Car[] cars = new Car[CARS_COUNT];

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        while(START.getCount() > 1) Thread.sleep(100);
//        Thread.sleep(1000);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        START.countDown();

        while(FINISH.getCount() > 0) Thread.sleep(100);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

    }

}
