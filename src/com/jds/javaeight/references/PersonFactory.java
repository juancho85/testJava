package com.jds.javaeight.references;

public interface PersonFactory<P extends Person> {

    P create(String firstName, String lastName);
}
