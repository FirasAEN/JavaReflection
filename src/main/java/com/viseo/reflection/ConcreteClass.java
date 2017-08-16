package main.java.com.viseo.reflection;

/**
 * Created by FAB3659 on 2017-08-16.
 */
public class ConcreteClass extends BaseClass implements BaseInterface {

    public int attr;

    private String str = "concrete class private string";

    protected boolean aBoolean;

    Object defaultObject;

    public ConcreteClass() {
    }

    public ConcreteClass(int attr) {
        this.attr = attr;
    }

    @Override
    public void someInterfaceMethod() {
        System.out.println("method 'some method' implementation");
    }

    @Override
    public int otherInterfaceMethod(String str) {
        System.out.println("method 'other method' implementation");
        return 0;
    }

    public void classMethod(int val){
        System.out.println("Method called with value : "+ val);
    }

    @Override
    public int secondMethod(int val) {
        System.out.println("method from base class called with value : " + val);
        return 0;
    }

    @Override
    public void thirdMethod() {
        System.out.print("Method called -> ");
        super.thirdMethod();
    }

    public class ConcreteClassPublicClass{}
    private class ConcreteClassPrivateClass{}
    protected class ProtectedClassPrivateClass{}
    class ConcreteDefaultClass{}

    enum ConcreteClassDefaultEnum{}
    public enum ConcreteClassPublicEnum{}

    public interface ConcreteClassPublicInterface{}

}
