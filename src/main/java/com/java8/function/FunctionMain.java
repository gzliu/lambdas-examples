package com.java8.function;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.java8.pojo.TestEntity;

public class FunctionMain 
{
	public static void main(String[] args) 
	{
//		Function<Date, String> fun = (f)-> DateFormatUtils.format(f, "yyyyMMdd");
//		System.out.println(fun.apply(new Date()));
		// 第一个是传入参数，第二个是输出参数
		Function<String,BigDecimal> funQty =BigDecimal::new;
		Function<String,String> funName = String::valueOf;
		Function<String,TestEntity> composeFun = TestEntity::new;
		Function<String,TestEntity> thenFun = TestEntity::new;
		Function<TestEntity,String> afterFun = (f)->f.toString();
		// Function.apply用法
		System.out.println(funQty.apply("10"));
		// Function.compose组合，先调用funName.apply方法，然后再调用composeFun.apply方法
		System.out.println(composeFun.compose(funName).apply("test"));
		System.out.println("zzz");
		// thenFun.andThen，先调用thenFun.apply方法，然后再调用afterFun.apply方法
		System.out.println(thenFun.andThen(afterFun).apply("xxx"));
		
		// 与集合的应用

		// Supplier,方法无参数
		Supplier<TestEntity> supplierEn = TestEntity::new;
		TestEntity su = supplierEn.get();
		System.out.println(su.toString());
		// Consumer一个输入参数上需要进行的操作
		Consumer<TestEntity> con = (f)-> f.setName("test");
		con.accept(su);
		System.out.println(su.toString());
	}

}
