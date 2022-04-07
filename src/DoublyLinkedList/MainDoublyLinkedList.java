package DoublyLinkedList;

public class MainDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insert(1, 0);
        doublyLinkedList.insert(2, 0);
        doublyLinkedList.insert(3, 0);
        doublyLinkedList.insert(4, 0);
        doublyLinkedList.insert(4, 3);
        doublyLinkedList.insert(40, 10);
        doublyLinkedList.insert(50, 10);
        doublyLinkedList.insert(60, 0);


        doublyLinkedList.insert(60, 3);
        doublyLinkedList.traversal();
        doublyLinkedList.reverseTraversal();

        doublyLinkedList.delete(0);
        doublyLinkedList.traversal();
        doublyLinkedList.delete(10);
        doublyLinkedList.traversal();
        doublyLinkedList.delete(5);
        doublyLinkedList.traversal();
        doublyLinkedList.delete(50);
        doublyLinkedList.traversal();
        doublyLinkedList.delete(0);
        doublyLinkedList.traversal();
        doublyLinkedList.delete(2);
        doublyLinkedList.traversal();
        doublyLinkedList.delete(50);
        doublyLinkedList.traversal();
    }
}
