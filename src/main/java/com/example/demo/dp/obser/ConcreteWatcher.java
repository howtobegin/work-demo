package com.example.demo.dp.obser;

public class ConcreteWatcher implements Watcher {

	public void update(String str) {
		System.out.println(this + " : " + str);
	}

}
