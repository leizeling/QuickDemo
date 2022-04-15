package com.example.quickdemo.designpattern.singleton;

public enum Singleton5 {
	INSTANCE;

	public void showName() {
		System.out.println(this.getClass().getSimpleName());
	}
}