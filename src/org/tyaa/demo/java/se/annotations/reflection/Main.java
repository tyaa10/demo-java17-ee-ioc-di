package org.tyaa.demo.java.se.annotations.reflection;

import org.tyaa.demo.java.se.annotations.reflection.annotations.DemoBean;
import org.tyaa.demo.java.se.annotations.reflection.beans.Factorial;
import org.tyaa.demo.java.se.annotations.reflection.beans.Fibonacci;
import org.tyaa.demo.java.se.annotations.reflection.beans.MathDemo;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    // Factorial or Fibonacci specification
    @DemoBean(numericSequenceBeanName = "Fibonacci")
    private static MathDemo mathDemo;

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException, URISyntaxException, ClassNotFoundException {
        System.out.println("*** Math Demo ***");
        MathContainer.run(Main.class);
        System.out.println("mathDemo = " + mathDemo);
        System.out.println("Input an integer value then press Enter:");
        Scanner scanner = new Scanner(System.in);
        mathDemo.runDemo(scanner.nextInt());
    }
}
