package HashMap;

public class Node {
    String key;
    Object value;
    Node next;

    public Node() {
    }

    public Node(String key, Object value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

}
