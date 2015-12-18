package com.jds.javaeight.functionalinterfaces;

@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);
}
