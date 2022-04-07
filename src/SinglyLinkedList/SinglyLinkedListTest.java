package SinglyLinkedList;

public class SinglyLinkedListTest {
    public static void main(String args[]) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insert(1, 0);
        singlyLinkedList.insert(2, 0);
        singlyLinkedList.insert(3, 0);
        singlyLinkedList.insert(4, 0);
        singlyLinkedList.insert(7, 3);
        singlyLinkedList.traverseSinglyLinkedList();

        singlyLinkedList.delete(0);
        singlyLinkedList.traverseSinglyLinkedList();
        singlyLinkedList.delete(3);
        singlyLinkedList.traverseSinglyLinkedList();
        singlyLinkedList.delete(10);
        singlyLinkedList.traverseSinglyLinkedList();
        singlyLinkedList.delete(10);
        singlyLinkedList.traverseSinglyLinkedList();
        singlyLinkedList.delete(10);
        singlyLinkedList.traverseSinglyLinkedList();
    }
}
