package com.sist.main2;

public class MainClass {

	public static void main(String[] args) {
		
		Hello hello=new HelloImpl();
		String msg=hello.sayHello("심청이");
		System.out.println(msg);

	}

}
