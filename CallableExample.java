import java.util.concurrent.Callable;

public class CallableExample implements Callable<Integer> {

    private int seek;

    public CallableExample(int i) {
        seek = i;
    }

    @Override
    public Integer call() throws Exception {
        for(int i = 0; i<5; i++) {
            System.out.println("Thread id : " + Thread.currentThread().getId() +
                    "Seek Is : "+seek);
            try {
                Thread.sleep(5000);
            }
            catch(Exception ex) {
                System.out.println("Sleep Interrupted");
            }

            seek++;
        }

        return seek;
    }
}
