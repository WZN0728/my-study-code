package com.hahsmap;

public interface MyMap<K,V> {

	public V get(K k);
	
	public V put(K k,V v);
	
	interface Entry<K,V>{
		
		K getKey();
		
		V getValue();
		
	}
	
}