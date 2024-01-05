// Thread Safety using Synchronization
class NumberCounter {
    private volatile int value = 0;

    // Method synchronized
    public synchronized void increaseValue() {
        value++;
    }

    public int getCurrentValue() {
        return value;
    }
}

class ThreadSafetyDemo {
    public static void main(String[] args) throws InterruptedException {
        final NumberCounter counter = new NumberCounter();

        // Initialize two threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increaseValue();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increaseValue();
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish execution
        thread1.join();
        thread2.join();

        // Display the final count value
        System.out.println("Current Value: " + counter.getCurrentValue());
    }
}
