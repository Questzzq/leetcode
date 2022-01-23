package my_Template;

public class TestTemplate<T> {
    public static void main(String[] args) {
        TestTemplate testTemplate = new TestTemplate(122);
        System.out.println(testTemplate.name);
        TestTemplate<String> test = new TestTemplate<>("hi");
        System.out.println(test.getName());
    }

    T name;
    public TestTemplate(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}
