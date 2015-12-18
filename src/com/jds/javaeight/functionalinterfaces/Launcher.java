package com.jds.javaeight.functionalinterfaces;

public class Launcher {

    public static void main(String[] args) {
	Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
	Integer converted  = converter.convert("123");
	int sum = 321 + converted;
	System.out.println(sum);
    }

}
