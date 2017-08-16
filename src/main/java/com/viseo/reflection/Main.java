package main.java.com.viseo.reflection;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by FAB3659 on 2017-08-16.
 */
public class Main {
    public static void main (String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
        List<String> outputs = new ArrayList<>();

        Class<?> concreteClassObject = ConcreteClass.class;
        concreteClassObject = new ConcreteClass(5).getClass();

        try {
            concreteClassObject = Class.forName(concreteClassObject.getCanonicalName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        outputs.add(concreteClassObject.getPackage().toString());


        Class<?> booleanClass;

        booleanClass = boolean.class;
        outputs.add(booleanClass.getCanonicalName());
        booleanClass = Boolean.class;
        outputs.add(booleanClass.getCanonicalName());

        Class<?> varDoubleType;
        varDoubleType = double.class;
        outputs.add(varDoubleType.getCanonicalName());
        varDoubleType = Double.class;
        outputs.add(varDoubleType.getCanonicalName());
        varDoubleType = Double.TYPE;
        outputs.add(varDoubleType.getCanonicalName());

        Class<?> varFloatTypeArray;
        try {
            varFloatTypeArray = Class.forName("[F");
            outputs.add(varFloatTypeArray.getCanonicalName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> varStringTypeArray;
        varStringTypeArray = String[][].class;
        outputs.add(varStringTypeArray.getCanonicalName());

        for (String str: outputs) {
            System.out.println(str);
        }


        String mod = Modifier.toString(concreteClassObject.getModifiers());
        System.out.println("Class modifier : "+mod);

        TypeVariable<? extends Class<?>>[] typeParameters = concreteClassObject.getTypeParameters();
        Arrays.asList(typeParameters).forEach(typeVariable -> System.out.println("type variable : " +typeVariable));

        Type[] genericInterfaces = concreteClassObject.getGenericInterfaces();
        Arrays.asList(genericInterfaces).forEach(type -> System.out.println("Implemented Interface : "+ type.getTypeName()));

        Method[] methods = concreteClassObject.getMethods();
        Arrays.asList(methods).forEach(method -> System.out.println("Method : "+ method.getName() + " | return type : " + method.getReturnType().getCanonicalName()));

        Constructor<?>[] constructors = concreteClassObject.getConstructors();
        Arrays.asList(constructors).forEach(constructor -> System.out.println("Constructor : "+ constructor.getName() + " | nb of arguements = " + constructor.getParameters().length + " | Arguments : " + Arrays.toString(constructor.getParameters())  ));

        Field[] fields = concreteClassObject.getFields();
        for (Field field : fields){
            System.out.println("Public attribute : " + field.getName() + " | filed type : " + field.getType().getCanonicalName());
        }

        try {
            Field classField = concreteClassObject.getField("attr");
            ConcreteClass obj = new ConcreteClass(5);
            System.out.println("Attribute value (initialize in constructor): " + classField.get(obj));
            classField.set(obj, 10);
            System.out.println("New Attribute value : " + classField.get(obj));

            Field baseClassAttribute = concreteClassObject.getField("baseClassAttribute");
            baseClassAttribute.set(obj, 9564);
            System.out.println("Another Attribute : "+ baseClassAttribute.get(obj));

            Field privateField = obj.getClass().getDeclaredField("str");
            privateField.setAccessible(true);
            System.out.println("private attribute value : " + privateField.get(obj));
            privateField.set(obj, "Updated String");
            System.out.println("private attribute value : " + privateField.get(obj));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        Method classMethod = concreteClassObject.getMethod("classMethod", int.class);
        ConcreteClass obj = new ConcreteClass();
        classMethod.invoke(obj, 546);

        Method secondMethod = concreteClassObject.getMethod("secondMethod", int.class);
        secondMethod.invoke(obj, 62);

        Method thirdMethod = concreteClassObject.getMethod("thirdMethod", null);
        thirdMethod.invoke(obj, null);


        Constructor<?> constructor = concreteClassObject.getConstructor();
        Object o = constructor.newInstance();
        Method classMethod1 = o.getClass().getMethod("classMethod", int.class);
        classMethod1.invoke(o, 999999);


    }
}
