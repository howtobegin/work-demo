package com.example.demo.juc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MaxWithFJ extends RecursiveAction {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int threshold;  
    private final SelectMaxProblem problem;  
    public int result;  

    public MaxWithFJ(SelectMaxProblem problem, int threshold) {  
        this.problem = problem;  
        this.threshold = threshold;  
    }  

    protected void compute() {  
        String pre = problem.toString();  
        if (problem.size < threshold) {  
            result = problem.solveSequentially();  
            print(pre,"return result:"+result);  
        }else {  
            int midpoint = problem.size / 2;  
            SelectMaxProblem leftProblem = problem.subproblem(0, midpoint);  
            SelectMaxProblem rightProblem = problem.subproblem(midpoint + 1, problem.size);  
            MaxWithFJ left = new MaxWithFJ(leftProblem, threshold);  
            MaxWithFJ right = new MaxWithFJ(rightProblem, threshold);  
            left.fork();  
            right.fork();  
            left.join();  
            right.join();  
            result = Math.max(left.result, right.result);  
        }  
    }  

    public static void main(String[] args) {  
        int size = 40;  
        int[] numbers = new int[size];  
        for (int i = 0; i < size; i++) {  
            numbers[i] = i;  
        }  
        SelectMaxProblem problem = new SelectMaxProblem(numbers,0,numbers.length);  
        int threshold = 10;  
        int nThreads = 2;  
        MaxWithFJ mfj = new MaxWithFJ(problem, threshold);  
        ForkJoinPool fjPool = new ForkJoinPool(nThreads);  
        fjPool.invoke(mfj);  
        int result = mfj.result;  
        print("main",result);  
    }  

    static void print(String pre,Object object) {  
        Thread thread = Thread.currentThread();  
        String msg = String.format("Thread[%s] %s > %s", thread.getId(), pre, object);  

        System.out.println(msg);  
    }  
} 
