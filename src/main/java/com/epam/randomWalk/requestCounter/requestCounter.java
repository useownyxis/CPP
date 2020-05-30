package com.epam.randomWalk.requestCounter;

import java.util.concurrent.Semaphore;

public class requestCounter {
    private int counter;
    private Semaphore semaphore;

    public requestCounter(int counter, Semaphore semaphore) {
        this.counter = counter;
        this.semaphore = semaphore;
    }

    public int getCounter() {
        return counter;
    }

    public void increaseNumberOfRequests() {
        try {
            this.semaphore.acquire();
            this.counter++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.semaphore.release();
        }
    }
}
