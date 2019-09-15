package com.java8.comparator;

import java.math.BigDecimal;
import java.util.Comparator;

import com.java8.pojo.TestEntity;

public class ComparatorMain 
{
	public static void main(String[] args) 
	{
		TestEntity o1 = new TestEntity(new BigDecimal(10), "米");
		TestEntity o2 = new TestEntity(new BigDecimal(11), "米");
		Comparator<TestEntity> com = (e1,e2)-> e1.getQty().compareTo(e2.getQty());
		System.out.println(com.compare(o1, o2));
		System.out.println(com.reversed().compare(o1, o2));
	}
}
