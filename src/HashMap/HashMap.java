package HashMap;

public class HashMap {

    private float load_factor;
    private int capacity;
    private int size = 0;
    private Node[] table;

    public HashMap() {
        this.load_factor = 0.75f;
        this.capacity = 4;
        this.size = 0;
        table = new Node[capacity];
    }

    public HashMap(int capacity) {
        this.size = 0;
        this.load_factor = 0.75f;
        this.capacity = capacity;
        table = new Node[capacity];
    }

    public HashMap(int capacity, float load_factor) {
        this.size = 0;
        this.load_factor = load_factor;
        this.capacity = capacity;
        table = new Node[capacity];
    }


    public Object put(String key, Object value) {
        if (key == null) {
            System.out.println("Key is null");
            return null;
        }
        if (shouldResize()) {
            resize();
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        int index = getIndex(key, table.length);
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node curr = table[index];
            Node prev = null;

            while (curr != null) {
                if (curr.key.equals(key)) {
                    if (prev == null) {
                        newNode.next = curr.next;
                        table[index] = newNode;
                        return curr.value;
                    } else {
                        newNode.next = curr.next;
                        prev.next = newNode;
                        return curr.value;
                    }
                }
                prev = curr;
                curr = curr.next;
            }

            if (prev == null) {
                newNode.next = table[index];
                table[index] = newNode;
            } else {
                prev.next = newNode;
            }
        }
        size++;
        return null;
    }

    public Object remove(String key) {
        int index = getIndex(key, table.length);
        if (table[index] == null) {
            return null;
        } else {
            Node curr = table[index];
            Node prev = null;

            while (curr != null) {
                if (curr.key.equals(key)) {
                    if (prev == null) {
                        table[index] = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    size--;
                    return curr.value;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return null;
    }

    public Object get(String key) {
        int index = getIndex(key, table.length);
        if (table[index] == null) {
            return null;
        } else {
            Node curr = table[index];
            while (curr != null) {
                if (curr.key.equals(key)) {
                    return curr.value;
                }
                curr = curr.next;
            }
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < table.length; i++) {
            printData(i, table[i]);
            System.out.println();
        }
        System.out.println();
    }

    private void printData(int i, Node node) {
        System.out.print(i + "-> ");
        if (node == null) {

        } else {
            Node currentNode = node;
            while (currentNode != null) {
                System.out.print(currentNode.value + "->");
                currentNode = currentNode.next;
            }
        }
    }

    public int getSize() {
        return size;
    }


    public boolean shouldResize() {
        return this.size > Math.ceil(table.length * this.load_factor);
    }

    private int getIndex(String key, int capacity) {
        int hashCode = key.hashCode();
        System.out.println("HashCode for the key " + key + " is " + hashCode);
        return Math.abs(hashCode % capacity);
    }

    public void resize() {
        int newCapacity = table.length * 2;
        Node[] newTable = new Node[newCapacity];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null)
                addEntry(table[i], newTable);
        }
        this.table = newTable;
    }

    private void addEntry(Node node, Node[] newTable) {
        Node nextNode = node.next;
        this.putEntry(node, newTable);
        if (nextNode != null) {
            addEntry(nextNode, newTable);
        }
    }

    private void putEntry(Node existingNode, Node[] table) {
        int index = getIndex(existingNode.key, table.length);
        if (table[index] == null) {
            table[index] = existingNode;
        } else {
            Node curr = table[index];
            Node prev = null;

            while (curr != null) {
                if (curr.key.equals(existingNode.key)) {
                    if (prev == null) {
                        existingNode.next = curr.next;
                        table[index] = existingNode;
                        return;
                    } else {
                        existingNode.next = curr.next;
                        prev.next = existingNode;
                        return;
                    }
                }
                prev = curr;
                curr = curr.next;
            }

            if (prev == null) {
                existingNode.next = table[index];
                table[index] = existingNode;
            } else {
                prev.next = existingNode;
            }
        }
    }


}
