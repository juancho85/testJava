package com.jds.javaeight.references;

public class Launcher {

    public static void main(String[] args) {
	Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
	Integer converted  = converter.convert("123");
	System.out.println(converted);
	
	//using method reference
	Converter<String, Integer> converter2 = Integer::valueOf;
	Integer converted2  = converter2.convert("123");
	System.out.println(converted2);
	
	//It can also be used with object methods (not only static methods)
	ComienzaPor comienzaPor = new ComienzaPor();
	Converter<String, String> converter3 = comienzaPor::startsWith;
	System.out.println(converter3.convert("Java"));
	
	//references can also be used for constructors
	//Here, the compiler chooses the right constructor by matching the signature of PersonFactory.create
	PersonFactory<Person> personFactory = Person::new;
	Person person = personFactory.create("Peter", "Parker");
	System.out.println(person);
	
    }

}
