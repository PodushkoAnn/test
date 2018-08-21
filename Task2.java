package lesson4.homework;

//2. Написать совсем небольшой метод, в котором 3 потока
// построчно пишут данные в файл (штук по 10 записей, с периодом в 20 мс)

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Task2 {

    public static void main(String[] args) {
        File file  = new File("1/task2lesson4.txt");
        String s1 = "первый поток сделал запись\n";
        String s2 = "второй поток сделал запись\n";
        String s3 = "третий поток сделал запись\n";
        final int x = 10; //количество повторений

        writeIntoFile(x, file, s1, s2, s3);
    }

    private static void writeIntoFile(final int x, final File file, final String...s) {

        for (int i = 0; i < s.length; i++) {
            final int finalI = i;

            new Thread(new Runnable() {
                public void run() {
                    try {
                        FileWriter fw = new FileWriter(file, true);
                        for (int j = 0; j < x; j++) {
                            synchronized (file) {
                                fw.append(s[finalI]);
                                fw.flush();
                                sleep(20);
                            }
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}


