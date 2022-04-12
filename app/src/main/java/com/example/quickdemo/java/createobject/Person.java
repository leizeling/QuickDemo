package com.example.quickdemo.java.createobject;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Person implements Cloneable, Serializable {
	private final String name;

	private final int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@NonNull
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
