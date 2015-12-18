package com.jds.javaeight.builtinfunctions;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.jds.javaeight.references.Person;

public class Launcher {

    public static void main(String[] args) {
	//Predicates
	Predicate<String> predicate = (s) -> s.length() > 0;
	System.out.println(predicate.test("foo"));
	System.out.println(predicate.negate().test("foo"));
	Predicate<String> notNull = Objects::nonNull;
	Predicate<String> isNull = Objects::isNull;
	Predicate<String> isEmpty = String::isEmpty;
	System.out.println(notNull.test("foo"));
	System.out.println(notNull.test(null));
	System.out.println(isNull.test(null));
	System.out.println(isEmpty.test("foo"));
	System.out.println(isEmpty.test(""));
	
	//Functions
	Function<String, Integer> toInteger = Integer::valueOf;
	Function<String, String> backToString = toInteger.andThen(String::valueOf);
	System.out.println(backToString.apply("123"));
	
	//Suppliers
	Supplier<Person> personSupplier = Person::new;
	personSupplier.get();   // new Person
	
	//Consumers
	Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
	greeter.accept(new Person("Luke", "Skywalker"));
	
	//Comparators
	Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
	Person p1 = new Person("John", "Doe");
	Person p2 = new Person("Alice", "Wonderland");
	comparator.compare(p1, p2);             // > 0
	comparator.reversed().compare(p1, p2);  // < 0
	
	//Optional
	//How is this useful if the constructor cannot take null as argument?
	Optional<String> optional = Optional.of("bam");
	System.out.println(optional.isPresent());           // true
	System.out.println(optional.get());                 // "bam"
	System.out.println(optional.orElse("fallback"));    // "bam"
	optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
	
    }

}
