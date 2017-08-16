package main.java.com.viseo.reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FAB3659 on 2017-08-16.
 */
public class Main {
    public static void main (String[] args){
        List<String> outputs = new ArrayList<>();

        Class<?> concreteClassObject = ConcreteClass.class;
        concreteClassObject = new ConcreteClass(5).getClass();

        try {
            concreteClassObject = Class.forName("main.java.com.viseo.reflection.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        outputs.add(concreteClassObject.getPackage().toString());

        for (String str: outputs) {
            System.out.println(str);
        }
    }
}
