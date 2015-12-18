package com.jds.javaeight.streams.collect;

import java.util.EnumSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class PersonFirstLetterUpperCaseNameCollector implements Collector<Person, StringJoiner, String> {

    @Override
    public BiConsumer<StringJoiner, Person> accumulator() {
	return (j, p) -> j.add(p.name.substring(0, 1).toUpperCase()+p.name.substring(1, p.name.length()).toLowerCase());
    }

    @Override
    public Set<java.util.stream.Collector.Characteristics> characteristics() {
	return EnumSet.noneOf(Characteristics.class);
    }

    @Override
    public BinaryOperator<StringJoiner> combiner() {
	return (j1, j2) -> j1.merge(j2);
    }

    @Override
    public Function<StringJoiner, String> finisher() {
	return StringJoiner::toString;
    }

    @Override
    public Supplier<StringJoiner> supplier() {
	return () -> new StringJoiner(" | ");
    }
    
}
