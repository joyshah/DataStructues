package LinkedHashMap;

public class LinkedHashMap<K, V> {


    public static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> after;
        Node<K, V> before;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    private int capacity;
    private int size;
    private float loadFactor;
    private Node<K, V> head;
    private Node<K, V> tail;
    private Node<K, V>[] table;

    private final int INITIAL_CAPACITY = 4;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;


    public LinkedHashMap() {
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        table = (Node<K, V>[]) new Node[this.capacity];
    }

    public LinkedHashMap(int capacity, float loadFactor) {
        this();
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }


    public V put(K key, V value) {
        V result = null;
        if (key == null) {
            result = null;
        }
        if (shouldResize()) {
            resize();
        }
        Node<K, V> newNode = new Node<K, V>(key, value, null);
        maintainOrderAfterInsert(newNode);
        int index = getIndex(key, table.length);
        Node<K, V> curr = table[index];
        if (curr == null) {
            table[index] = newNode;
            result = null;
        } else {
            Node<K, V> prev = null;
            while (curr != null) {
                if (curr.key.equals(key)) {
                    V tempValue = curr.value;
                    curr.value = value;
                    return tempValue;
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = newNode;
        }
        size++;
        return result;
    }

    private void resize() {
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[this.table.length * 2];
        System.out.println("Resizing HashMap from size" + table.length + " to size" + newTable.length);
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) putEntries(table[i], newTable);
        }
        this.table = newTable;
    }

    private void putEntries(Node<K, V> node, Node<K, V>[] newTable) {
        Node<K, V> nextNode = node.next;
        putEntry(node, newTable);
        if (nextNode != null)
            putEntries(nextNode, newTable);
    }

    private V putEntry(Node<K, V> node, Node<K, V>[] newTable) {
        node.next = null;
        int index = getIndex(node.key, newTable.length);
        Node<K, V> currentNode = newTable[index];
        if (currentNode == null) {
            newTable[index] = node;
        } else {
            Node<K, V> prev = null;
            while (currentNode != null) {
                if (currentNode.value.equals(node.value)) {
                    V tempNodeValue = currentNode.value;
                    currentNode.value = node.value;
                    return tempNodeValue;
                }
                prev = currentNode;
                currentNode = currentNode.next;
            }
            prev.next = node;
        }
        return null;
    }

    private boolean shouldResize() {
        return this.size > Math.ceil(table.length * this.loadFactor);
    }

    private void maintainOrderAfterInsert(Node<K, V> newNode) {
        if (head == null) {
            newNode.before = null;
            newNode.after = null;
            head = newNode;
            tail = head;
            return;
        }
        Node<K, V> oldNode = this.getNode(newNode.key);
        if (oldNode != null) {
            oldNode.value = newNode.value;
        } else {
            newNode.before = tail;
            tail.after = newNode;
            tail = newNode;
        }
    }

    public void traverseInOrdered() {
        if (head == null) {
            System.out.println("No enteries in LinkedHashMap");
        } else {
            Node<K, V> curr = head;
            while (curr != null) {
                System.out.print(curr.key + ":" + curr.value + "->");
                curr = curr.after;
            }
        }
        System.out.print("NULL");
        System.out.println();
    }

    public void traverseInReverseOrdered() {
        if (tail == null) {
            System.out.println("No enteries in LinkedHashMap");
        } else {
            Node<K, V> curr = tail;
            while (curr != null) {
                System.out.print(curr.key + ":" + curr.value + "->");
                curr = curr.before;
            }
        }
        System.out.print("NULL");
        System.out.println();
    }

    private Node<K, V> getNode(K key) {
        Node<K, V> result = null;
        int index = getIndex(key, table.length);
        Node<K, V> curr = table[index];
        if (curr == null) {
        } else {
            while (curr != null) {
                if (curr.key.equals(key)) {
                    result = curr;
                    break;
                }
                curr = curr.next;
            }
        }
        return result;
    }

    public V get(K key) {
        Node<K, V> oldNode = this.getNode(key);
        return oldNode != null ? oldNode.value : null;
    }

    public void traverse() {
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + "->");
            if (table[i] != null) printData(table[i]);
            System.out.println();
        }
    }

    public void printData(Node<K, V> node) {
        Node<K, V> nextNode = node.next;
        System.out.print(node.key + ":" + node.value + "->");
        if (nextNode != null) printData(nextNode);
    }


    public int getIndex(K key, int capacity) {
        int hashcode = key.hashCode();
        return Math.abs(hashcode % capacity);
    }

    public V remove(K key) {
        if (key == null) {
            return null;
        }
        int index = getIndex(key, table.length);
        Node<K, V> currNode = table[index];
        if (currNode == null) {
            return null;
        } else {
            Node<K, V> prevNode = null;
            while (currNode != null) {
                if (currNode.key.equals(key)) {
                    if (prevNode == null) {
                        table[index] = currNode.next;
                    } else {
                        prevNode.next = currNode.next;
                    }
                    maintainOrderAfterDeletion(key, currNode);
                    size--;
                    return currNode.value;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
        }
        return null;
    }

    private void maintainOrderAfterDeletion(K key, Node<K, V> currNode) {
        if (key.equals(head.key)) {
            if (head == tail) {
                head = tail = null;
                return;
            }
            head = head.after;
            head.before = null;
            return;
        }

        if (key.equals(tail.key)) {
            if (head == tail) {
                head = tail = null;
                return;
            }
            tail = tail.before;
            tail.after = null;
            return;
        }

        Node<K, V> prevNode = currNode.before;
        prevNode.after = currNode.after;
        currNode.after.before = prevNode;
        currNode.before = currNode.after = null;
    }

    public int size() {
        return size;
    }
}

