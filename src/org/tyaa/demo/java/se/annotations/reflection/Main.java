package org.tyaa.demo.java.se.annotations.reflection;

import org.tyaa.demo.java.se.annotations.reflection.beans.Factorial;
import org.tyaa.demo.java.se.annotations.reflection.beans.Fibonacci;
import org.tyaa.demo.java.se.annotations.reflection.beans.MathDemo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* Factorial factorial = new Factorial();
        System.out.println(factorial.getValues());
        factorial.setValues(7);
        System.out.println(factorial.getValues()); */
        System.out.println("*** Math Demo ***");
        System.out.println("Input an integer value then press Enter:");
        Scanner scanner = new Scanner(System.in);
        MathDemo mathDemo = new MathDemo();
        // mathDemo.runDemo(new Factorial(), scanner.nextInt());
        mathDemo.runDemo(new Fibonacci(), scanner.nextInt());
    }
}
