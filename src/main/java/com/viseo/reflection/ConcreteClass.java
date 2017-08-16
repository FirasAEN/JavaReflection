package main.java.com.viseo.reflection;

/**
 * Created by FAB3659 on 2017-08-16.
 */
public class ConcreteClass extends BaseClass implements BaseInterface {

    public int attr;

    private String str = "concrete class private string";

    protected boolean aBoolean;

    Object defaultObject;

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


    @Override
    public int secondMethod() {
        System.out.println("Override method from base class");
        return 0;
    }

    @Override
    public void thirdMethod() {
        System.out.println("Override method and using method");
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
