package my_linkNode;

public class LinkNode<T> {
    //首元结点
    private Node<T> first;
    //头指针
    private Node<T> head;
    //链表长度
    private int size;

    public LinkNode() {

    }

    //获取链表的长度
    public int getSize() {
        return this.size;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    //获取节点
    public Node<T> getNodeByIndex(int index) {
        if(isEmpty() || index < 0 || index > this.size) {
            return null;
        }
        Node point = first;
        for(int i = 0; i < index; i++) {
            point = first.getNext();
        }
        return point;
    }

    //在末尾添加元素
    public void addFromTail(T data) {
        Node<T> newNode = new Node<>(data, null);
        if(head == null) {
            head = new Node<>();
            head.setNext(newNode);
            first = newNode;
        } else {
            Node<T> point = first;
            while (point.getNext() != null) {
                point = point.getNext();
            }
            point.setNext(newNode);
        }
        this.size++;
    }

    // 获取链表
    public Node<T> getLinkNode() {
        return head;
    }

    //打印链表
    public void printLinkNode() {
        Node<T> point = first;
        while (point!=null) {
            System.out.print(point.getVal() + " ");
            point = point.getNext();
        }
        System.out.println();
    }
}
