package my_Template;

public class TestNew<T> implements TemInter<T> {

    @Override
    public T getName(T name) {
        return name;
    }

    public static void main(String[] args) {
        TestNew testNew = new TestNew();
        System.out.println(testNew.getName(768));
        System.out.println(testNew.getName("kljd"));
        Test1 test1 = new Test1();
        System.out.println(test1.getName("123"));
    }
}

