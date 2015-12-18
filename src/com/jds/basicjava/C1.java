package com.jds.basicjava;

public class C1 {
    
    int i;
    
    C1(){
	i=1;
    }
    
    void m2(){
	m1();
	m1();
    }
    
    void m1(){
	System.out.println(i);
    }

}
