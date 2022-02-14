package org.tyaa.demo.java.se.annotations.reflection.beans;

import org.tyaa.demo.java.se.annotations.reflection.annotations.Inject;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MathDemo implements Serializable {

    @Inject
    Object feature;

    public void runDemo (Integer n) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> featureClass = feature.getClass();
        System.out.println(featureClass.getName());
        Method setValuesMethod =
            featureClass.getMethod("setValues", Integer.class);
        setValuesMethod.invoke(feature, n);
        System.out.println("Results:");
        Method getValuesMethod =
            featureClass.getMethod("getValues");
        System.out.println(getValuesMethod.invoke(feature));
    }
}
