package com.example.quickdemo.designpattern.singleton;

public class Test {
	public static void main(String[] args) {
		Singleton1.getInstance().showName();
		Singleton2.getInstance().showName();
		Singleton3.getInstance().showName();
		Singleton4.getInstance().showName();
		Singleton5.INSTANCE.showName();
	}
}
