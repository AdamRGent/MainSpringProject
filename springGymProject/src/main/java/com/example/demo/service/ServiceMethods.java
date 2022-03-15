package com.example.demo.service;

import java.util.List;

public interface ServiceMethods <T>{

	T create(T person);
	
	List<T> readAll();
	
	T readById(long id);
	
	T update(long id, T person);
	
	boolean delete(long id);
	
	
}
