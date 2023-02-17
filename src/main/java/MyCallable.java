import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int count = 20;
        for(int i = 0; i < count; i++) {
            System.out.println("Hello World! from " + name);
            Thread.sleep(2500);
        }
        return count;
    }
}
