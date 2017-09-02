package com.interviewquestions_nokia;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapImplementation<K,V> extends AbstractMap<K,V> implements Map<K,V> ,Cloneable, Serializable{

	transient Set<Map.Entry<K,V>> entrySet;
	 transient int size;
	private static final long serialVersionUID = -9211718840554797162L;

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> es;
		return ( es = entrySet ) == null ? (entrySet = new MyEntrySet()) : es;
	}
	final class MyEntrySet<K,V> extends AbstractSet<Map.Entry<K,V>> {

		@Override
		public Iterator<Entry<K, V>> iterator() {
			return null;
		}

		@Override
		public int size() {
			return size;
		}

		
	}

}
