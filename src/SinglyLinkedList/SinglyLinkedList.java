package SinglyLinkedList;

public class SinglyLinkedList {
    private SinglyLinkedListNode head;
    private SinglyLinkedListNode tail;
    private int size;

    public SinglyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void insert(int value, int location) {
        SinglyLinkedListNode node = new SinglyLinkedListNode();
        node.setValue(value);
        node.setNextNode(null);
        if (head == null) {
            head = node;
            tail = node;
        } else if (location == 0) {
            node.setNextNode(head);
            head = node;
            tail = node;
        } else if (location > size) {
            tail.setNextNode(node);
            tail = node;
        } else {
            int index = 0;
            SinglyLinkedListNode temp = head;
            while (index < location - 1) {
                temp = temp.getNextNode();
                index++;
            }
            SinglyLinkedListNode nextNode = temp.getNextNode();
            temp.setNextNode(node);
            node.setNextNode(nextNode);
        }
        size++;
    }

    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("Singly Linked List does not exists.");
        } else {
            SinglyLinkedListNode current = head;
            while (current != null) {
                System.out.print(current.getValue());
                System.out.print("->");
                current = current.getNextNode();
            }
        }
        System.out.println();
    }


    public boolean clear() {
        head = null;
        tail = null;
        return true;
    }

    public int getSize() {
        return size;
    }

    public void delete(int location) {
        if (head == null) {
            System.out.println("SLL is empty");
        } else if (location == 0) {
            head = head.getNextNode();
            size--;
            if (size == 0) {
                tail = head = null;
            }
        } else if (location >= size) {
            if (size == 1) {
                head = tail = null;
                size--;
                return;
            }
            SinglyLinkedListNode currentNode = head;
            for (int i = 0; i < size - 1 - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(null);
            size--;
        } else {
            SinglyLinkedListNode currentNode = head;
            for (int i = 0; i < location - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(currentNode.getNextNode().getNextNode());
            size--;
        }
    }

}
