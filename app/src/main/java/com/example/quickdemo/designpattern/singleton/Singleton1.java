package com.example.quickdemo.designpattern.singleton;

/**
 * 饿汉模式
 */
public class Singleton1 {
	private static final Singleton1 INSTANCE = new Singleton1();

	private Singleton1() {
	}

	public static Singleton1 getInstance() {
		return INSTANCE;
	}

	public void showName() {
		System.out.println(this.getClass().getSimpleName());
	}
}