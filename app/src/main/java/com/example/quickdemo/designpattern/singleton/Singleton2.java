package com.example.quickdemo.designpattern.singleton;

public class Singleton2 {
	private static Singleton2 INSTANCE;

	private Singleton2() {
	}

	public static synchronized Singleton2 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton2();
		}
		return INSTANCE;
	}

	public void showName() {
		System.out.println(this.getClass().getSimpleName());
	}
}