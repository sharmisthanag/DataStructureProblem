package com.collectionframeworkDS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class CustomHashMap {

	public static void main(String[] args) {
		
		HashMap hm=new HashMap();
		hm.put("hh", "nn");
		
		MyHashMap h=new MyHashMap();
		System.out.println(h.put("hello","world"));
		System.out.println(h.put("hello","world1"));
		h.put(1,"world");
		h.put(1, "hello");
		h.put(2, "hello");
		h.put(null, "mmm");
		System.out.println(h);
		System.out.println(h.get("hello"));
	}

}
class MyHashMap<K ,V>{
	private interface NestedInterface{
		
	}


	static final int DEFAULT_INITIAL_CAPACITY = 16;
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	static final int MAXIMUM_CAPACITY = 1 << 30;
	transient float loadFactor;
	transient int threshold;
	transient int size;
	transient int modcount;
	Node<K,V>[] elements;

	public MyHashMap(){
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public MyHashMap(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);

		if(initialCapacity>MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;

		this.threshold=initialCapacity>>>1;
	this.loadFactor = DEFAULT_LOAD_FACTOR;
	}
	class Node<K,V> implements Map.Entry<K, V>{

		private final int hash;
		private final K key;
		private V value;
		private Node<K,V> next;
		Node(int hash, K key, V value, Node<K,V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}
		@Override
		public K getKey() {return key;}

		@Override
		public V getValue() {return value;}

		@Override
		public V setValue(V newValue) {
			V oldvalue=value;
			value = newValue;
			return oldvalue;
		}
		/*@Override
		public boolean equals(Object o){
			if(o == this)return true;
			if(o instanceof Map.Entry){
				@SuppressWarnings("unchecked")
				Map.Entry<K, V> e=(Entry<K, V>) o;
				if(Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())){
					return true;
				}
			}
			return false;
		}
		@Override
		public int hashCode(){
			return Objects.hashCode(key) ^ Objects.hashCode(value);  //^ => 11=0,00=0,10=1,01=1
		}*/
		@Override
		public String toString() {
			return "Node [hash=" + hash + ", key=" + key + ", value=" + value + ", next=" + next + "]";
		}
	}
	private V putVal(int hash, K key, V value) {
		Node<K,V>[] tab;int tabLength;int bucketIndex;Node<K,V> oldNode;
		if((tab=elements)==null || (tabLength = tab.length)==0){
			tabLength = (tab = resize()).length;
		}
		bucketIndex=(hash & (tabLength-1));//10 & 5 value within in 
		//bucketIndex =1;
		if((oldNode = tab[bucketIndex]) == null){
			tab[bucketIndex] = new Node(hash, key, value, null);
		}
		else{
			Node<K,V> oldNodeCopy = null;
			if(oldNode.hash == hash && 
					(key == oldNode.key || (key!=null && key.equals(oldNode.key)))){
				oldNodeCopy = oldNode;
			}
			else{
				for(int i=0;;i++){
					if(oldNode.next == null){
						oldNode.next = new Node(hash, key, value, null);
						break;
					}
					oldNode = oldNode.next; 
					if(oldNode.hash == hash && (key == oldNode.key || (key!=null && key.equals(oldNode.key)))){
						oldNodeCopy = oldNode;
						break;
					}
				}
			}
			if(oldNodeCopy !=null){
				/*V oldValue = oldNodeCopy.getValue();
				oldNodeCopy.setValue(value);*/
				
				V oldValue = oldNodeCopy.setValue(value);
				modcount++;
				return oldValue;
			}

		}
		modcount++;
		if (++size > threshold)
			resize();

		return null;
	}

	public V get(K key) {
		Node<K,V> e;
		return (e=getNode(hash(key),key))!=null?e.getValue():null;
		
	}

	private Node<K,V> getNode(int hash, K key) {
		Node<K,V>[] tab = elements;
		Node<K,V> first;int n;K k=null;Node<K,V> e;
		n=tab.length;
		System.out.println(tab.length);
		System.out.println(hash&(n-1));
		if(tab != null && (n=tab.length) > 0 && (first = tab[hash & (n-1)])!=null){
			if(first.hash == hash &&
					(k=first.key)==key || (k!=null && k.equals(key))){
				return first;
			}
			if((e=first.next)!=null){
				do{
				if(e.hash == hash &&
						(k=e.key)==key || (k!=null && k.equals(key))){
					return e;
				}
				}while((e=e.next)!=null);
			}
			
		}
		return null;
	}

	private Node[] resize() {
		Node<K,V>[] newTab = (Node<K,V>[])new Node[threshold];
		elements = newTab;

		return newTab;
	}
	public V put(K key, V value) {
		return putVal(hash(key), key, value);	

	}	
	private static final int hash(Object key) {
		int h;		
		return key==null?0:(h=key.hashCode())^h>>>16;
	}
	@Override
	public String toString() {
		return "MyHashMap [elements=" + Arrays.toString(elements) + "]";
	}
}