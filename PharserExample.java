import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

public class PharserExample implements Runnable {
    private int id;
    private Phaser phaser;

    public PharserExample(int id, Phaser phaser) {
        this.id = id;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println("Thread id : " + id + " Started.");
        try {
            for (int i = 0; i<10000000; i++) {}
            System.out.println("Thread id : " + id + " Completed.");
        } catch(Exception ex) {
            System.out.println("Exception : "+ex);
        }

        System.out.println("Thread id : " + id + " Waiting.");

        try {
            phaser.arrive();
        } catch(Exception ex) {
            System.out.println("Await Exception : "+ex);
        }

        try {
            for (int i = 0; i<10000000; i++) {}
            System.out.println("Thread id : " + id + " Completed 2.");
        } catch(Exception ex) {
            System.out.println("Exception : "+ex);
        }
    }
}
