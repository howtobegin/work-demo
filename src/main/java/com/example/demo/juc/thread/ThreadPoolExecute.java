package com.example.demo.juc.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.management.RuntimeErrorException;

public class ThreadPoolExecute {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			//executorService.execute(new TestRunnable()); // 出异常，继续
			// 如果不调用f.get()，出异常，继续；；否则，
			Future<String> f = (Future<String>) executorService.submit(new TestRunnable());
			System.out.println(f.get());
		}
		executorService.shutdown();
	}
}

class TestRunnable implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName() + "线程被调用了。");
		/*while (true) {
			try {
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		if (new Random().nextBoolean()) {
			System.out.println(Thread.currentThread().getName() + " errorrrrrrrrrrrrrrrrrrrr");
			throw new RuntimeException(Thread.currentThread().getName() + " 随机异常 ");
		}
	}
}
