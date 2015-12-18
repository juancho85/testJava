package com.jds.javaeight.streams.collect;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectExamples {

    public static void main(String[] args) {
	List<Person> persons =
		Arrays.asList(
			new Person("Max", 18),
			new Person("Peter", 23),
			new Person("Pamela", 23),
			new Person("David", 12));


	System.out.println("***toList");
	List<Person> filtered = persons
		.stream()
		.filter(p -> p.name.startsWith("P"))
		.collect(Collectors.toList());
	System.out.println(filtered);

	System.out.println("***groupingBy");
	Map<Integer, List<Person>> personsByAge = persons
		.stream()
		.collect(Collectors.groupingBy(p -> p.age));
	personsByAge
	.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

	System.out.println("***summarizingInt");
	IntSummaryStatistics ageSummary =
		persons
		.stream()
		.collect(Collectors.summarizingInt(p -> p.age));
	System.out.println(ageSummary);
	// IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}

	System.out.println("***joining");
	String phrase = persons
		.stream()
		.filter(p -> p.age >= 18)
		.map(p -> p.name)
		.collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
	System.out.println(phrase);
	// In Germany Max and Peter and Pamela are of legal age.

	System.out.println("***Custom collector");
	//Person: type of the input element of the new collector
	//StringJoiner: The intermediate accumulation type of the new collector
	//String: Type of the final result of the collector
	Collector<Person, StringJoiner, String> personNameCollector =
		Collector.of(
			() -> new StringJoiner(" | "),          // supplier
			(j, p) -> j.add(p.name.toUpperCase()),  // accumulator
			(j1, j2) -> j1.merge(j2),               // combiner
			StringJoiner::toString);                // finisher
	String names = persons
		.stream()
		.collect(personNameCollector);
	System.out.println(names);  // MAX | PETER | PAMELA | DAVID
	
	
	System.out.println("***Custom collector separate class");
	PersonFirstLetterUpperCaseNameCollector colectorFirstLetter = new PersonFirstLetterUpperCaseNameCollector();
	String namesFirstUpper = persons
		.stream()
		.collect(colectorFirstLetter);
	System.out.println(namesFirstUpper);  // MAX | PETER | PAMELA | DAVID

    }

}
