package com.collectionframeowrkpracticess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronisedCollections {

	public static void main(String[] args) {
		List<String> l=new ArrayList<>();
        l.add("a");l.add("b");l.add("c");l.add("d");l.add("e");l.add("f");l.add("g");
        
        l = Collections.synchronizedList(l);

	}

}
