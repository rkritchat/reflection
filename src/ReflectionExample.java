import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class cal = Calculator.class;
        //Get constructor from class
        Constructor constructor = cal.getConstructor(int.class, int.class);

        //Create instance on constructor that required int,int
        Calculator obj = (Calculator) constructor.newInstance(5, 6);

        //get private method by name
        Method calculate = obj.getClass().getDeclaredMethod("calculate");
        calculate.setAccessible(true);
        calculate.invoke(obj);
    }

}

class Calculator {

    private int x;
    private int y;

    public Calculator(){}

    public Calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void calculate(){
        System.out.println(x+y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
