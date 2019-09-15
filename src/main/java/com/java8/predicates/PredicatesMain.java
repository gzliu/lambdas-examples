package com.java8.predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicatesMain 
{
	public static void main(String[] args) 
	{
		Predicate<String> p = (s) -> s.length() > 0;
		Predicate<String> p2 = (s) -> s.length() == 0;
		// 判断值长度是否大于零
		System.out.println(p.test("1111"));
		// 判断值长度是否大于零并取反
		System.out.println(p.negate().test("1111"));
		// 判断两个值是否相等
		System.out.println(Predicate.isEqual("1111").test(null));
		// 判断两个Predicate，或门
		System.out.println(p.or(p2).test("1111"));
		// 判断两个Predicate，并门
		System.out.println(p.and(p2).test("1111"));
//		System.out.println(p2.eq);
		
		// 使用集合的筛选
		List<String> str = Stream.of("111","222","333").collect(Collectors.toList());
		str.parallelStream().filter(p).collect(Collectors.toList());
	}

}
