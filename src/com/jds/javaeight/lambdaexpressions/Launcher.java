package com.jds.javaeight.lambdaexpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
	
	
	List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
	
	//prior to java 8
	Collections.sort(names, new Comparator<String>() {
	    @Override
	    public int compare(String a, String b) {
	        return b.compareTo(a);
	    }
	});
	System.out.println(names);
	
	List<String> names2 = Arrays.asList("peter", "anna", "mike", "xenia");
	
	//after to java 8
	Collections.sort(names2, (String a, String b) -> {
	    return b.compareTo(a);
	});
	//and ever more compact: one line method bodies can ommit the braces and the return keyword
	Collections.sort(names2, (String a, String b) ->  b.compareTo(a));
	//the compiler is aware of the parameter types so they can be excluded
	Collections.sort(names2, (a, b) ->  b.compareTo(a));
	System.out.println(names2);
    }

}
