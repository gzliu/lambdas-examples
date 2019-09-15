package com.java8.func;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiFunction;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.java8.pojo.TestEntity;

public class FuncMain 
{
	public static void main(String[] args) 
	{
		// 函数接口简写1
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		IDateConVerter<String, Date> convert = (d) -> format.format(d);
		System.out.println(convert.convert(date));
		
		// 函数接口简写1
		IDateConVerter<String, Date> convert4 = (d) ->{
			return DateFormatUtils.format(d, "yyyy-MM-dd");
		};
		System.out.println(convert4.convert(date));
		
		// 直接静态方法构造
		IDateConVerter<String, Date> convert2 = FuncMain::format;
		System.out.println(convert2.convert(date));
		
		// 通过对象构造方法构造
		IDateConVerter<TestEntity,String> convert3 = TestEntity::new;
		TestEntity entity = convert3.convert("小米");
		System.out.println(entity.toString());
		
		BiFunction<BigDecimal,String,TestEntity> add = TestEntity::new;
		add.apply(new BigDecimal(10), "test");
	}
	
	public static String format(Date date) 
	{
		return DateFormatUtils.format(date, "yyyyMMdd");
	}
}
