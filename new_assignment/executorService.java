package new_assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {

    public static void main(String[] args) {
        // Create an ExecutorService with fixed thread pool of size 2
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Task 1: Print numbers from 1 to 5
        Runnable task1 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 1: " + i);
                try {
                    Thread.sleep(1000);  // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Task 2: Print alphabets from A to E
        Runnable task2 = () -> {
            for (char ch = 'A'; ch <= 'E'; ch++) {
                System.out.println("Task 2: " + ch);
                try {
                    Thread.sleep(1000);  // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Submit tasks to the ExecutorService
        executorService.submit(task1);
        executorService.submit(task2);

        // Shutdown the ExecutorService after tasks are done
        executorService.shutdown();
    }
}
