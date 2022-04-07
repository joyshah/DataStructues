package CircularDoublyLinkedList;

public class CircularDoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }


    public void insert(int value, int location) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
        } else if (location == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node currentNode = head;
            int index = 0;
            while (index < location - 1) {
                currentNode = currentNode.next;
                index++;
            }

            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next.prev = newNode;
            currentNode.next = newNode;
        }
        size++;
    }


    public void traversal() {
        if (head == null) {
            System.out.println("DLL is empty");
        } else {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.value);
                System.out.print("->");
                currentNode = currentNode.next;
            }
        }
        System.out.println();
    }

    public void reverseTraversal() {
        if (head == null) {
            System.out.println("DLL is empty");
        } else {
            Node currentNode = tail;
            while (currentNode != null) {
                System.out.print(currentNode.value);
                System.out.print("->");
                currentNode = currentNode.prev;
            }
        }
        System.out.println();
    }

    public void delete(int location) {

    }


}
