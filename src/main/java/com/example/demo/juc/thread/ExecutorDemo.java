package com.example.demo.juc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(4); // LinkedBlockingQueue
		ExecutorService es2 = Executors.newCachedThreadPool(); // SynchronousQueue
		Executors.newScheduledThreadPool(4);
		Executors.newSingleThreadExecutor(); // LinkedBlockingQueue
		es.submit(()->{});
		es.execute(null);
	}
}
