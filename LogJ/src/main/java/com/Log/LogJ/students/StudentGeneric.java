package com.Log.LogJ.students;

import java.util.List;

public interface StudentGeneric<T> {
	 public List<T>getall();
	  public T getById(Integer type);
	  public T save(T type);
	  public void update(Integer type3,T type1);
	  public void delete(Integer type);
}
