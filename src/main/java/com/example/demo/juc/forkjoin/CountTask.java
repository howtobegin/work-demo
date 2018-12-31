package com.example.demo.juc.forkjoin;

import java.util.concurrent.ForkJoinTask;

public class CountTask extends ForkJoinTask<Integer> {
	private int lo;
	private int hi;

	public CountTask(int lo, int hi) {

		this.lo = lo;
		this.hi = hi;
	}

	@Override
	public Integer getRawResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setRawResult(Integer value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean exec() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
