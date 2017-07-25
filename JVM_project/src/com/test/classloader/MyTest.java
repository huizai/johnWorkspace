package com.test.classloader;

class Singleton{
	public static int count1 ;
	public static int count2=0;
	private static Singleton singleton = new Singleton();
	private Singleton(){
		count1++;
		count2++;
	}
	public static Singleton getInstance(){
		return singleton;
	}
}

public class MyTest {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println("coutn1 = "+singleton.count1);
		System.out.println("count2 = "+singleton.count2);
	}
}
