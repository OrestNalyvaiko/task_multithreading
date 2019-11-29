package com.nalyvaiko;

import com.nalyvaiko.fibonacci.Fibonacci;
import com.nalyvaiko.pingpong.PingPong;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {

  private PingPong pingPong = new PingPong(5);

  public void show() {
    Thread t1 = new Thread(() -> {
      pingPong.ping();
    });

    Thread t2 = new Thread(() -> {
      pingPong.pong();
    });
    t1.start();
    t2.start();
  }

  public static void main(String[] args) {
    Application application = new Application();
    application.runRandomSleepTask(5);
    application.show();
    Fibonacci fibonacci = new Fibonacci();
    Thread t1 = new Thread(
        () -> {
          for (int i = 1; i <= 5; i++) {
            System.out.print(fibonacci.makeFibonacciSequence(i) + " ");
          }
          System.out.println();
        });
    Thread t2 = new Thread(
        () -> {
          for (int i = 1; i <= 4; i++) {
            System.out.print(fibonacci.makeFibonacciSequence(i) + " ");
          }
          System.out.println();
        });

    t1.start();
    t2.start();
  }

  private void runRandomSleepTask(int quantityTasks) {
    ScheduledExecutorService executorService =
        Executors.newSingleThreadScheduledExecutor();

    for (int i = 0; i < quantityTasks; i++) {
      Runnable callableTask = () -> {
        Random random = new Random();
        int sleepTime = random.nextInt(10) + 1;
        try {
          Thread.sleep(sleepTime * 1000);
          System.out.println(sleepTime);
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        }
      };

      executorService.schedule(callableTask, 0, TimeUnit.SECONDS);
    }
    executorService.shutdown();
  }
}
