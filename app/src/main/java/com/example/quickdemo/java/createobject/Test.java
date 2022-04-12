package com.example.quickdemo.java.createobject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
	public static void main(String[] args) {
		// 方式1 new
		createByNew();
		// 方式2 反射
		createByReflection();
		// 方式3 clone
		createByClone();
		// 方式3 反序列化
		createByDeserialization();
	}

	private static void createByNew() {
		Person person1 = new Person("abc", 10);
		System.out.println("person1 name: " + person1.getName() + ", age: " + person1.getAge());
	}

	private static void createByReflection() {
		Class<?> clazz = Person.class;

		try {
			Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
			Object person2 = constructor.newInstance("abc", 10);
			if (person2 instanceof Person) {
				System.out.println("person2 name: " + ((Person) person2).getName() + ", age: " + ((Person) person2).getAge());
			}
		} catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private static void createByClone() {
		Person personRaw = new Person("abc", 10);
		try {
			Person person3 = (Person) personRaw.clone();
			System.out.println("person3 name: " + person3.getName() + ", age: " + person3.getAge());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	private static void createByDeserialization() {
		Person personOutput = new Person("abc", 10);
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person.txt"));
			outputStream.writeObject(personOutput);
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("person.txt"));
			Person person4 = (Person) inputStream.readObject();
			System.out.println("person4 name: " + person4.getName() + ", age: " + person4.getAge());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
