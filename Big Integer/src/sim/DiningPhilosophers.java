package sim;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class DiningPhilosophers {
    static int p = 5;
    static Semaphore[] forks = new Semaphore[p];

    public static void main(String[] args) {
        for (int i = 0; i < p; i++)
            forks[i] = new Semaphore(1);
        for (int i = 0; i < p; i++) {
            final int p = i;
            new Thread(() -> table(p)).start();
        }
    }

    private static void table(int i) {
        for (int n = 0; n <= 10; n++) {
            try {
            	int left = i;
                int right = (i + 1) % p;
            	
                System.out.println("Philosopher " + i + " waits and thinks");

                forks[left].acquire();
                forks[right].acquire();

                System.out.println("Philosopher " + i + " eats");

                forks[left].release();
                forks[right].release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
