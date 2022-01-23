package my_Template;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Class c = Class.forName("java.util.ArrayList");
        Method m = c.getMethod("add", Object.class);
        m.invoke(list, "iu4r");
        System.out.println(list);
    }
}
