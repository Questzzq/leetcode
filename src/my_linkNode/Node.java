package my_linkNode;

public class Node<T> {
    private T val;
    private Node<T> next;

    public Node(T val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node() {
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
