package org.tyaa.demo.java.se.annotations.reflection.beans;

import org.tyaa.demo.java.se.annotations.reflection.annotations.NumericSequenceBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NumericSequenceBean
public class Fibonacci implements Serializable {

    private List<Integer> values;

    public Fibonacci() {
        values = new ArrayList<>();
        values.add(1);
        // values = List.of(1);
    }

    public void setValues(List<Integer> values) {
        values.clear();
        this.values = values;
    }

    public void setValues(Integer n) {
        values.clear();
        values = new ArrayList<>();
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be equals or greater than 0");
        }
        Integer fib = 0;
        for(int i = 0; i <= n; i++)
        {
            if (i < 2) {
                fib = i;
            } else {
                fib = values.get(i - 1) + values.get(i - 2);
            }
            values.add(fib);
        }
    }

    public List<Integer> getValues() {
        return values;
    }
}
