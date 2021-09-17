package dinner;

public class Philo implements Runnable {

    private int id;
    private volatile boolean isFull;
    private Chopstick lchop;
    private Chopstick rchop;
    private int eatingCounter;

    public Philo(int id, Chopstick c1, Chopstick c2) {
        this.id = id;
        this.lchop = c1;
        this.rchop = c2;
        eatingCounter = 0;
    }

    @Override
    public void run() {
        try {
                think();

                if(lchop.pickUp(this) && rchop.pickUp(this)) {
                    eat();
                    lchop.putDown(this);
                    rchop.putDown(this);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void think() throws Exception {
        System.out.println("Philo : "+ id + " is thinking");
        Thread.sleep(5000);
    }

    public void eat() throws Exception {
        System.out.println("Philo : "+ id + " is Eating");
        eatingCounter += 1;
        Thread.sleep(5000);
    }

    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }

    public int getId() {
        return id;
    }
}
