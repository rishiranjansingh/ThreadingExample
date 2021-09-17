import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample implements Runnable {
    private int id;
    private CyclicBarrier barrier;

    public CyclicBarrierExample(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
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
            barrier.await();
        } catch(Exception ex) {
            System.out.println("Await Exception : "+ex);
        }
    }
}
