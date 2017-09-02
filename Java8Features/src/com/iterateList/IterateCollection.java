package com.iterateList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class IterateCollection {

	public static void main(String[] args) {
		List<Integer> l=new ArrayList<Integer>();
		l.add(1);l.add(2);l.add(3);l.add(4);
		
		/*for(Integer i:l){
			if(i==1){
				l.remove(i);//throws concurrent modification exception
			}
		}*/
		
		/*Iterator<Integer> i=l.iterator();
		while(i.hasNext()){
			//i.remove()//Removes the current element. Throws IllegalStateException if an attempt is made to call remove() that is not preceded by a call to next( ).
			Integer value=i.next();
			if(value==1){
				i.remove();//o/p -> [2,3,4]
			}
		}
		System.out.println(l);*/
		
		l.forEach(new Consumer<Integer>(){

			@Override
			public void accept(Integer t) {
						System.out.println("check check=>"+t);		
			}
			
		});
		
		l.forEach((Integer t) -> System.out.println(t));
		l.forEach((t)->System.out.println(t));
		l.forEach(System.out::println);
		System.out.println("-------------");
		List<Topic> topics=new ArrayList(Arrays.asList(
				new Topic("Spring","Spring Core","Dependency Injection"),
				new Topic("Spring","Spring Core","Autowiring"),
				new Topic("Java","Core Java","constructure")));
		
		topics.forEach(t-> {if(t.getId().equals("Spring")){System.out.println(t);}});
		topics.forEach(System.out::println);
		System.out.println("-----------------------------");
		
		System.out.println(topics.stream().allMatch(t->t.getId().equals("Spring")));
		System.out.println("-----------------------------");

		System.out.println(topics.stream().anyMatch(t->t.getId().equals("Spring")));
		System.out.println("-----------------------------");

		System.out.println(topics.stream().filter(t->t.getId().equals("Spring")).collect(Collectors.toList()));
		
		System.out.println(topics.removeIf(t -> t.getId().equals("Spring")));

		
	}
	@SuppressWarnings("unchecked")
	public static String[] removeDuplicatesFrom1stArray(String[] obj1,String[] obj2) {
		List<String> l1=(List<String>) ((obj1!=null)?new ArrayList<String>(Arrays.asList(obj1)):Collections.emptyList());
		List<String> l2=(List<String>) ((obj2!=null)?new ArrayList<String>(Arrays.asList(obj2)):Collections.emptyList());
		l1.removeAll(l2);
		if(Collections.emptyList().equals(l1)){
			return null;
		}
		else{
			return l1.toArray(new String[l1.size()]);
		}
	}

}
class Topic{
	private String id;
	private String name;
	private String desc;
	
	
	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

	public Topic() {
		super();
	}
	
	public Topic(String id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}