package CircularSinglyLinledList;

public class CircularSinglyLinkedListTest {
    public static void main(String args[]) {
        CircularSinglyLinkedList circularSinglyLinkedList=new CircularSinglyLinkedList();
        circularSinglyLinkedList.insert(1,0);
        circularSinglyLinkedList.insert(2,0);
        circularSinglyLinkedList.insert(3,0);
        circularSinglyLinkedList.insert(4,0);
        circularSinglyLinkedList.insert(7,3);
        circularSinglyLinkedList.traverse();

        circularSinglyLinkedList.delete(0);
        circularSinglyLinkedList.traverse();
        circularSinglyLinkedList.delete(1);
        circularSinglyLinkedList.traverse();
        circularSinglyLinkedList.delete(10);
        circularSinglyLinkedList.traverse();
        circularSinglyLinkedList.delete(6);
        circularSinglyLinkedList.traverse();
        circularSinglyLinkedList.delete(6);
        circularSinglyLinkedList.traverse();
    }
}
