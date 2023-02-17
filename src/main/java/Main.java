import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Callable<Integer>> callableList = new ArrayList<>();
        callableList.add(new MyCallable("First"));
        callableList.add(new MyCallable("Second"));
        callableList.add(new MyCallable("Third"));
        callableList.add(new MyCallable("Fourth"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<Integer>> futures = new ArrayList<>();

        for (Callable<Integer> task : callableList) {
            futures.add(executorService.submit(task));
        }

        for(Future<Integer> future : futures) {
            System.out.println(future.get());
        }
    }
}