import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

    private int similarWork;

    public SimpleRecursiveAction(int a) {
        this.similarWork = a;
    }

    @Override
    protected void compute() {
        if (similarWork > 100) {
            System.out.println("Parallel Action > 100");

            SimpleRecursiveAction a1 = new SimpleRecursiveAction(50);
            SimpleRecursiveAction a2 = new SimpleRecursiveAction(50);

            a1.fork();
            a2.fork();
        }
        else {
            System.out.println("No Need of Parallelisation.");
        }
    }
}
