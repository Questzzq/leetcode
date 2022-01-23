package my_linkNode;

public class TestLinkNode {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        LinkNode<Integer> linkNode = new LinkNode<>();
        for(int i = 0; i < nums.length; i++) {
            linkNode.addFromTail(nums[i]);
        }
        System.out.println(linkNode.getSize());
        linkNode.printLinkNode();
    }
}
