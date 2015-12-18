package com.jds.javaeight.references;

@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);
}
