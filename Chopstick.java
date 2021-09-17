package dinner;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

    public int id;
    public Lock lock;

    public Chopstick(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(Philo p) {
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                System.out.println("The Chopstick " + id + " is picked up by Philosopher" + p.getId());
                return true;
            }

            return false;
        }
        catch(Exception e) {
            return false;
        }
    }

    public void putDown(Philo p) {
        lock.unlock();
        System.out.println("The Chopstick " + id + " is released by Philosopher" + p.getId());
    }
}
