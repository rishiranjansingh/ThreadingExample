import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample implements Runnable {

private int id;
private CountDownLatch latch;

    public CountDownLatchExample(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread id : " + id + " Completed.");
        } catch(Exception ex) {
            System.out.println("Exception");
        }

        latch.countDown();
    }
}
