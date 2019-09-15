package com.java8.pojo;

import java.math.BigDecimal;

public class TestEntity
{
	
	public TestEntity(BigDecimal qty, String name) 
	{
		super();
		this.qty = qty;
		this.name = name;
	}
	public TestEntity() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TestEntity(String name) {
		super();
		this.name = name;
	}


	private BigDecimal qty;
	private String name;
	
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "TestEntity [qty=" + qty + ", name=" + name + "]";
	}
}