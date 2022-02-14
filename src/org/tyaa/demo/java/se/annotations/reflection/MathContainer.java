package org.tyaa.demo.java.se.annotations.reflection;

import org.tyaa.demo.java.se.annotations.reflection.annotations.DemoBean;
import org.tyaa.demo.java.se.annotations.reflection.annotations.Inject;
import org.tyaa.demo.java.se.annotations.reflection.annotations.NumericSequenceBean;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public class MathContainer {

    public static void run (Class<?> application) throws InvocationTargetException, InstantiationException, IllegalAccessException, URISyntaxException, ClassNotFoundException {

        for (Field field : application.getDeclaredFields()) {
            if (field.isAnnotationPresent(DemoBean.class)) {
                DemoBean demoBeanClass = field.getAnnotation(DemoBean.class);
                String numericSequenceBeanName = demoBeanClass.numericSequenceBeanName();
                Class<?> targetClass = field.getType();
                Constructor targetConstructor =
                    targetClass.getDeclaredConstructors()[0];
                Object target =
                    targetConstructor.newInstance();
                field.setAccessible(true);
                field.set(null, target);
                // ***
                for (Field tgcField : targetClass.getDeclaredFields()) {
                    if (tgcField.isAnnotationPresent(Inject.class)) {

                        // получение пути к каталогу суб-пакета beans в виде строки
                        final String beansPackagePath =
                            application.getResource("beans").toURI().getPath();
                        // получение суб-пакета beans в виде строки
                        final String beansPackage = application.getPackageName() + ".beans";
                        // полный перебор объектов метаданных о всех файлах и суб-каталогах каталога суб-пакета beans
                        for(var f : new File(beansPackagePath).listFiles()) {
                            // проверка - получено описание суб-каталога или файла
                            if(f.isFile()) {
                                // если это - описание файла, загружаем одноименный класс в память,
                                // получая ссылку на объект его отражения (описания типа)
                                Class injectionClass = Class.forName(beansPackage + "." + f.getName().replace(".class", ""));
                                // валидируем класс предполагаемого бина для нашей системы
                                if (injectionClass.isAnnotationPresent(NumericSequenceBean.class)) {
                                    if (injectionClass.getSimpleName().equals(numericSequenceBeanName)) {
                                        Constructor injectionConstructor =
                                            injectionClass.getDeclaredConstructors()[0];
                                        Object injection = injectionConstructor.newInstance();
                                        tgcField.setAccessible(true);
                                        tgcField.set(target, injection);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
