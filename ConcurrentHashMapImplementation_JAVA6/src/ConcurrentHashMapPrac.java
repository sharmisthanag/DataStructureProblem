

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapPrac {
	static final int MAXIMUM_CAPACITY = 1 << 30;
	static final int MIN_SEGMENT_TABLE_CAPACITY = 2;
	public static void main(String[] args) {
		// private static final Unsafe unsafe = Unsafe.getUnsafe();
		ConcurrentHashMap<String, String> chm=new ConcurrentHashMap<String, String>(17,0.75f,5);
		chm.put("hello", "hello");
		chm.put("1", "23");
		chm.get("1");
		
		String s="hh";
		HashMap hm=new HashMap();
		int sshift = 0;
		int ssize = 1;
		int concurrencyLevel=16;
		while (ssize < concurrencyLevel) {
			++sshift;
			ssize <<= 1;
		}
		System.out.println("ssize is next multiple of 2 if concurrencyLevel is not multiple of 2 => ssize: "+ssize);

		int segmentShift = 32 - sshift;
		int segmentMask = ssize - 1;
		System.out.println("segmentShift(32-ssize)=>"+segmentShift);
		System.out.println("segmentMask(ssize-1)=>"+segmentMask);

		int initialCapacity=16;
		if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		int c = initialCapacity / ssize;
		System.out.println("c=initialCapacity / ssize ==> "+c);
		if (c * ssize < initialCapacity)
			++c;
		System.out.println("c to find capacity if not exact multiple of initial capacity/sszie,then plus 1=> c="+c);
		int cap = MIN_SEGMENT_TABLE_CAPACITY;
		while (cap < c)
			cap <<= 1;
		System.out.println("capacity="+cap);
		System.out.println((hash("hello")>>>segmentShift )&segmentMask);
		
		
		//int j = (hash >>> segmentShift) & segmentMask;
		

	}
	final static int hash(Object k) {
        int h = 0;
       

        h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

}
