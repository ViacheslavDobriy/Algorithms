package Seminar3;

public class MyLinkedList {

    private Node head; // —сылка на первый элемент

    public Node getHead() {
//        System.out.println(head.getValue());
        return head;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head != null)
            node.setNext(head);
        head = node;
    }

    public void removeFirst() {
        if (head != null)
            head = head.getNext();
    }

    public Node contains(int value) {
        Node node = head;
        while (node != null) {
            if (node.getValue() == value)
                return node;
            node = node.getNext();
        }
        return null;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
    }

    public void removeLast() {
        if (head == null)
            return;
        Node node = head;
        while (node.getNext() != null) {
            if (node.getNext().getNext() == null) {
                node.setNext(null);
                return;
            }
            node = node.getNext();
        }
        head = null;
    }

    public void reverseLinks(){
        Node reversedPart = null;
        Node current = head;
        while(current != null) {
            Node next = current.getNext();
            current.setNext(reversedPart);
            reversedPart = current;
            current = next;
        }
        head = reversedPart;
    }
}
