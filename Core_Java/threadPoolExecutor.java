//Thread pool executor 
import java.util.concurrent.*;

class Main {
    public static void main(String[] args) {
        // Creating a fixed-size thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Creating three Runnable tasks with lambda expressions
        Runnable task1 = () -> System.out.println("Running Task1");
        Runnable task2 = () -> System.out.println("Running Task2");
        Runnable task3 = () -> System.out.println("Running Task3");

        // Submitting tasks to the thread pool for execution
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);

        // Shutting down the thread pool after tasks are completed
        executor.shutdown();
    }
}