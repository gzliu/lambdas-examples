package com.java8.optional;

import java.math.BigDecimal;
import java.util.Optional;

import com.java8.pojo.TestEntity;

public class OptionalMain 
{
	public static void main(String[] args) 
	{
		TestEntity t = null;
		System.out.println(Optional.ofNullable(t).isPresent());
		t = new TestEntity("testName");
		Optional.of(t).ifPresent((f)->{f.setQty(BigDecimal.ZERO);});
		
		System.out.println(t.toString());
	}
}
