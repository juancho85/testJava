package com.jds.javaeight.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Launcher {

    public static void main(String[] args) {
	
	//Initial Data
	List<String> stringCollection = new ArrayList<>();
	stringCollection.add("ddd2");
	stringCollection.add("aaa2");
	stringCollection.add("bbb1");
	stringCollection.add("aaa1");
	stringCollection.add("bbb3");
	stringCollection.add("ccc");
	stringCollection.add("bbb2");
	stringCollection.add("ddd1");

	//Filter
	System.out.println("Filter:");
	stringCollection
	.stream()
	.filter((s) -> s.startsWith("a"))
	.forEach(System.out::println);
	// "aaa2", "aaa1"

	//Sorted
	System.out.println("Sorted:");
	stringCollection
	.stream()
	.sorted()
	.filter((s) -> s.startsWith("a"))
	.forEach(System.out::println);
	// "aaa1", "aaa2"

	//Map
	System.out.println("Map:");
	stringCollection
	.stream()
	.map(String::toUpperCase)
	.sorted((a, b) -> b.compareTo(a))
	.forEach(System.out::println);
	// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"

	//Match
	System.out.println("Match:");
	boolean anyStartsWithA =
		stringCollection
		.stream()
		.anyMatch((s) -> s.startsWith("a"));
	System.out.println(anyStartsWithA);      // true

	boolean allStartsWithA =
		stringCollection
		.stream()
		.allMatch((s) -> s.startsWith("a"));
	System.out.println(allStartsWithA);      // false

	boolean noneStartsWithZ =
		stringCollection
		.stream()
		.noneMatch((s) -> s.startsWith("z"));
	System.out.println(noneStartsWithZ);      // true

	//Count
	System.out.println("Count:");
	long startsWithB =
		stringCollection
		.stream()
		.filter((s) -> s.startsWith("b"))
		.count();
	System.out.println(startsWithB);    // 3

	//Reduce
	System.out.println("Reduce:");
	Optional<String> reduced =
		stringCollection
		.stream()
		.sorted()
		.reduce((s1, s2) -> s1 + "#" + s2);
	reduced.ifPresent(System.out::println);
	// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
	
	//Stream.of
	System.out.println("Stream.of:");
	Stream.of("Hola", 1).forEach(System.out::println);
	
	//loop with IntStreams
	System.out.println("loop with IntStreams");
	IntStream.range(1, 4).forEach(System.out::println);
	//1 2 3
	
	//average
	System.out.println("average");
	Arrays.stream(new int[] {1, 2, 3})
	    .average()
	    .ifPresent(System.out::println);  // 2.0

    }

}
