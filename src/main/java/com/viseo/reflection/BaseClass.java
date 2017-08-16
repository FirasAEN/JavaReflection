package main.java.com.viseo.reflection;

/**
 * Created by FAB3659 on 2017-08-16.
 */
public class BaseClass {

    public int baseClassAttribute;

    private static void firstMethod(){
        System.out.println("First Class Method");
    }

    public int secondMethod(int val){
        System.out.println("Second Class Method : " + val);
        return 0;
    }

    public void thirdMethod(){
        System.out.println("Third Base Class Method");
    }

    private String fourthMethod(){
        System.out.println("Fourth Base Class Method");
        return "";
    }

    public class innerClass{}

    public enum classEnum{}


}
