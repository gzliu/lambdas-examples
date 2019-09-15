package com.java8.map;

import java.util.stream.Stream;

public class MapsMain 
{
	public static void main(String[] args) 
	{
		String test = Stream.of("11","22","33","44")
						.filter(e->"22".equals(e))
						.findFirst()
						.orElse("");
		System.out.println(test);
		
		Thread thred = new Thread(()->{System.out.println("111");});
		thred.start();
	}
}
