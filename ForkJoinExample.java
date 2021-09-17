import java.util.concurrent.RecursiveAction;

public class ForkJoinExample extends RecursiveAction {

    @Override
    protected void compute() {
        System.out.println("Executing ForkJoinExample");
        try {
            Thread.sleep(5000);
        }
        catch(Exception e) {
            System.out.println("Sleep Interrupted.");
        }
    }
}
