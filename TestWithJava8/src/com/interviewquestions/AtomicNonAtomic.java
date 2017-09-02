package com.interviewquestions;

public class AtomicNonAtomic {

	public static void main(String[] args) {
		SomeClass s=new SomeClass();s.m1();
		System.out.println(s.m2());
		System.out.println(s.m22());
		s.m11();
		System.out.println(s.m22());

	}

}
class SomeClass {
    private int i = 0;

    public void m1() { i = 5;}
    public int m2() { return i; }
    
    private long i1 = 0;

    public void m11() { i1 = 1234567890L; }
    public long m22() { return i1
    		; }
}