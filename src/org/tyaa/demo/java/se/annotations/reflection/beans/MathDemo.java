package org.tyaa.demo.java.se.annotations.reflection.beans;

import java.io.Serializable;

public class MathDemo implements Serializable {
    /* public void runDemo (Factorial factorial, Integer n) {
        factorial.setValues(n);
        System.out.println("Results:");
        System.out.println(factorial.getValues());
    } */
    public void runDemo (Fibonacci fibonacci, Integer n) {
        fibonacci.setValues(n);
        System.out.println("Results:");
        System.out.println(fibonacci.getValues());
    }
}
