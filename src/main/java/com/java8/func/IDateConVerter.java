package com.java8.func;

@FunctionalInterface
public interface IDateConVerter<F,V> 
{
	F convert(V v);
}
