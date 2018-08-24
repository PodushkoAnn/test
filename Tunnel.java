import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private Semaphore sm;

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.sm = new Semaphore(MainClass.CARS_COUNT / 2);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                sm.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                sm.release();
                MainClass.finish.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
