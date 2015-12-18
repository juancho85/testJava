package com.jds.javaeight.defaultmethodsinterfaces;

public class Launcher {

    public static void main(String[] args) {
	Formula formula = new FormulaImpl();
	System.out.println(formula.calculate(0));
	System.out.println(formula.sqrt(81));
    }

}
