import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

    public static Lock lock1 = new ReentrantLock();
    public static Lock lock2 = new ReentrantLock();

    public void producer() {
        lock1.lock();
        System.out.println("Producer Acquired Lock 1");
        try {
            Thread.sleep(10000);
        }
        catch (Exception e) {
        }

        lock2.lock();
        System.out.println("Producer Acquired Lock 2");

        System.out.println("Executing Further in Producer");

        try {
            Thread.sleep(10000);
        }
        catch (Exception e) {
        }

        System.out.println("Producer Unlocking lock2");
        lock2.unlock();
        System.out.println("Producer Unlocking lock1");
        lock1.unlock();
    }

    public void consumer() {
        lock2.tryLock();
        System.out.println("Consumer Acquired Lock 2");
        try {
            Thread.sleep(10000);
        }
        catch (Exception e) {
        }

        while(!lock1.tryLock()) {}
        System.out.println("Consumer Acquired Lock 1");

        System.out.println("Executing Further in Consumer");

        try {
            Thread.sleep(10000);
        }
        catch (Exception e) {
        }

        System.out.println("Consumer Unlocking lock2");
        lock2.unlock();
        System.out.println("Consumer Unlocking lock1");
        lock1.unlock();

    }
}
