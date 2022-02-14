package org.tyaa.demo.java.se.annotations.reflection.beans;

import org.tyaa.demo.java.se.annotations.reflection.annotations.NumericSequenceBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NumericSequenceBean
public class Factorial implements Serializable {

    private List<Integer> values;

    public Factorial () {
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
        Integer fact = 1;
        for(int i = 1; i <= n; i++)
        {
            fact = fact * i;
            values.add(fact);
        }
    }

    public List<Integer> getValues() {
        return values;
    }
}
