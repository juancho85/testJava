package com.jds.javaeight.streams.reduce;

import java.util.Arrays;
import java.util.List;

public class ReduceExamples {

    public static void main(String[] args) {
	List<Person> persons =
		Arrays.asList(
			new Person("Max", 18),
			new Person("Peter", 23),
			new Person("Pamela", 23),
			new Person("David", 12));

	System.out.println("reduce(BinaryOperator accumulator):");
	persons
	.stream()
	.reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
	.ifPresent(System.out::println);    // Pamela


	System.out.println("reduce(identity value, BinaryOperator accumulator):");
	Person result =
		persons
		.stream()
		.reduce(new Person("", 0), (p1, p2) -> {
		    p1.age += p2.age;
		    p1.name += p2.name;
		    return p1;
		});

	System.out.format("name=%s; age=%s", result.name, result.age);
	// name=MaxPeterPamelaDavid; age=76

	System.out.println("reduce(identity value, BiFunction accumulator, BinaryOperator combiner):");
	Integer ageSum = persons
		.stream()
		.reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

	System.out.println(ageSum);  // 76

    }

}
