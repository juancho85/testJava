package com.jds.javaeight.streams.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class FlatMapExamples {

    public static void main(String[] args) {
	List<Foo> foos = new ArrayList<>();
	
	// create foos
	IntStream
	    .range(1, 4)
	    .forEach(i -> foos.add(new Foo("Foo" + i)));

	// create bars
	foos.forEach(f ->
	    IntStream
	        .range(1, 4)
	        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
	
	//FlatMap accepts a function which has to return a stream of objects
	foos.stream()
	    .flatMap(f -> f.bars.stream())
	    .forEach(b -> System.out.println(b.name));
	
	System.out.println("-----------");
	//The above code example can be simplified into a single pipeline of stream operations:
	IntStream.range(1, 4)
	    .mapToObj(i -> new Foo("Foo" + i))
	    .peek(f -> IntStream.range(1, 4)
	        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
	        .forEach(f.bars::add))
	    .flatMap(f -> f.bars.stream())
	    .forEach(b -> System.out.println(b.name));
	
	//Hierarchical structure: Outer has a Nested has a Inner
	System.out.println("-----------");
	System.out.println("Outer > Nested > Inner");
	Inner inner = new Inner("Hello!");
	Nested nested = new Nested(inner);
	Outer outer = new Outer(nested);
	
	//To avoid structures like these with nasty null checks...
	if (outer != null && outer.nested != null && outer.nested.inner != null) {
	    System.out.println(outer.nested.inner.foo);
	}
	System.out.println("-----------");
	//One can instead use optional together with FlatMap
	Optional.of(outer)
	    .flatMap(o -> Optional.ofNullable(o.nested))
	    .flatMap(n -> Optional.ofNullable(n.inner))
	    .flatMap(i -> Optional.ofNullable(i.foo))
	    .ifPresent(System.out::println);
	System.out.println("-----------");
	//this happens with null inner
	Nested nestedNullInner = new Nested(null);
	Outer outerNullInner = new Outer(nestedNullInner);
	Optional.of(outerNullInner)
	    .flatMap(o -> Optional.ofNullable(o.nested))
	    .flatMap(n -> Optional.ofNullable(n.inner))
	    .flatMap(i -> Optional.ofNullable(i.foo))
	    .ifPresent(System.out::println);
	
	
	
	
    }

}
