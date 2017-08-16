package main.java.com.viseo.reflection;

/**
 * Created by FAB3659 on 2017-08-16.
 */
public class BaseClass {

    public int classAttribute;

    private static void firstMethod(){
        System.out.println("First Class Method");
    }

    public int secondMethod(){
        System.out.println("Second Class Method");
        return 0;
    }

    public void thirdMethod(){
        System.out.println("Third Class Method");
    }

    private String fourthMethod(){
        System.out.println("Fourth Class Method");
        return "";
    }

    public class innerClass{}

    public enum classEnum{}


}
