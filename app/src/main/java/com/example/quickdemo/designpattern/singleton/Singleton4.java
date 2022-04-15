package com.example.quickdemo.designpattern.singleton;

public class Singleton4 {
	private Singleton4() {
	}

	public static Singleton4 getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public void showName() {
		System.out.println(this.getClass().getSimpleName());
	}

	private static class SingletonHolder {
		private static final Singleton4 INSTANCE = new Singleton4();
	}
}
