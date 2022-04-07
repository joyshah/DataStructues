package CircularSinglyLinledList;

public class CircularSinglyLinkedList {
    private Node head = null;
    private Node tail = null;
    private int size;

    public CircularSinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insert(int value, int location) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else if (location == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        } else if (location >= size) {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        } else {
            Node currentNode = head;
            int index = 0;
            while (index < location - 1) {
                currentNode = currentNode.next;
                index++;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        size++;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("CSLL is empty");
        } else {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.value);
                System.out.print("->");
                currentNode = currentNode.next;
                if (currentNode == head) {
                    break;
                }
            }
        }
        System.out.println();
    }


    public void clear() {
        head = null;
        tail.next = null;
        tail = null;
    }


    public void delete(int location) {
        if (head == null) {
            System.out.println("CSLL is empty");
        } else if (location == 0) {
            if (size == 1) {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            head = head.next;
            tail.next = head;
            size--;
        } else if (location >= size) {
            Node currentNode = head;
            int index = 0;
            while (index < size - 2) {
                currentNode = currentNode.next;
                index++;
            }
            if (currentNode == head && size == 1) {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            currentNode.next = head;
            tail = currentNode;
            size--;
        } else {
            Node currentNode = head;
            int index = 0;
            while (index < location - 1) {
                currentNode = currentNode.next;
                index++;
            }
            currentNode.next = currentNode.next.next;
            size--;
        }
    }

}
