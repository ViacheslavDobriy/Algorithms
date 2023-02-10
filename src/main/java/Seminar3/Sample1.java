package Seminar3;

public class Sample1 {

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);

        Node head = myLinkedList.getHead();
    }

    public static Node middleNode(Node head) {
        int length = 1;
        Node node = head;
        while(node.getNext() != null) {
            length++;
            node = node.getNext();
        }

        length = length / 2 + 1;

        node = head;

        for (int i = 0; i < length - 1; i++) {
            node = node.getNext();
        }

        return node;
    }

}
