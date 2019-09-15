package com.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import com.java8.pojo.TestEntity;

public class TestJava8Lama 
{
	
	private static List<TestEntity> entityList = new ArrayList<>();
	static 
	{
		
		Random rom = new Random();
		rom.ints().limit(5).forEach(e ->{
			String numbString = String.valueOf(e).substring(0, 2);
			TestEntity entity = new TestEntity(new BigDecimal(numbString), "test"+numbString);
			entityList.add(entity);
		});
		
		String sourceString = entityList.stream().map(TestEntity::toString).collect(Collectors.joining(","));
		System.out.println(sourceString);
	}
	
	public static void main(String[] args) 
	{
		// 计算总qty
//		entityList.stream().map(TestEntity::getQty).collect(Collectors.toList()).forEach(System.out::println);
		//		Stream
//		System.out.println(Stream.of(TestEntity.class));
		// 打印出某个对象中的某个属性�??
		System.out.println("// 打印出某个对象中的某个属性�??");
		entityList.stream()
		.map(TestEntity::getQty)
		.map(e -> e.add(e)).forEach(System.out::println);
		System.out.println("// 打印出某个对象中的某个属性�?�且排序");
		entityList.stream()
		.map(TestEntity::getQty).map(e -> e.add(e))
		.sorted()
		.forEach(e ->{ System.out.print(e+"_");});
		// 排序某个对象
		System.out.println("");
		System.out.println("// 排序某个对象");
		entityList.stream()
		.sorted(Comparator.comparing(TestEntity::getQty).reversed())
		.forEach(e ->{System.out.print(e.getQty()+"_");});
		System.out.println("");
		// 计算总数
		System.out.println("// 计算总数");
		BigDecimal totalQty = entityList.stream()
				.map(TestEntity::getQty)
				.reduce(BigDecimal.ZERO,(ecc,element)-> ecc.add(element));
		System.out.println(totalQty.toString());
		
		//计算�?�?
		System.out.println("// 计算�?�?");
		TestEntity minEntity = entityList.stream().min(Comparator.comparing(TestEntity::getQty)).get();
		System.out.println(minEntity.getQty());
		
		//获取小于零的名字
		System.out.println("//获取小于零的名字");
		List<String> names = entityList.stream()
			.filter(e ->{return (BigDecimal.ZERO.compareTo(e.getQty())) > 0 ;})
			.map(e -> e.getName()).collect(Collectors.toList());
		System.out.println(names.toString());
		
		// 统计
		System.out.println("//统计");
		DoubleSummaryStatistics summaryStatics = entityList.stream().mapToDouble(e-> e.getQty().doubleValue()).summaryStatistics();
		System.out.printf("Max:%f,Min:%f,avg:%f,sum:%f,count:%d,\n", 
				summaryStatics.getMax(),
				summaryStatics.getMin(),
				summaryStatics.getAverage(),
				summaryStatics.getSum(),
				summaryStatics.getCount());
		
		TestJava8Lama java8Lama = new TestJava8Lama();
		
//		java8Lama.test(java8Lama::testFunction);
		// 使用方法进行筛�??
		String filterDatas = entityList.stream()
		.filter(e -> java8Lama.filterDataTest(e))
		.map(TestEntity::getName).collect(Collectors.joining("_")); 
		System.out.println("使用方法进行筛�??"+filterDatas);
		
		
	}
	
	public boolean filterDataTest(TestEntity entity) 
	{
		return entity.getName().length()>5;
	}
	
	
	public Stream<TestEntity> filterDatas(Predicate<? super TestEntity> predicate)
	{
		return null;
	}
	
	public DoubleStream test(ToDoubleFunction<? extends TestEntity> func) 
	{
		return null;
	}
	public void testFunction() 
	{
		
	}

	
}
