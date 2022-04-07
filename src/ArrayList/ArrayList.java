package ArrayList;

public class ArrayList {

    private static final int INITIAL_SIZE = 5;
    private Object[] object;
    private int index;

    public ArrayList() {
        object = new Object[INITIAL_SIZE];
        index = 0;
    }

    public void add(Object value) {
        if (index == object.length) {
            System.out.println("Increasing capacity as array is full");
            increaseCapacity();
        }
        object[index] = value;
        index++;
        System.out.println("Added " + value + " Element Successfully");
    }

    private void increaseCapacity() {
        int newSize = object.length * 2;
        Object[] newObject = new Object[newSize];
        for (int i = 0; i < object.length; i++) {
            newObject[i] = object[i];
        }
        this.object = newObject;
    }

    public void display() {
        if (object == null || index == 0) {
            System.out.println("ArrayList is Empty");
        } else {
            for (int i = 0; i < index; i++) {
                System.out.print(object[i] + "->");
            }
        }
        System.out.println();
    }

    public Object get(int index) {
        if (index >= this.index) {
            throw new IndexOutOfBoundsException("Array Index Out of Bound");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index");
        }
        return object[index];
    }

    public void remove(int index) {
        if (index >= this.index) {
            throw new IndexOutOfBoundsException("Array Index Out of Bound");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index");
        }
        for (int i = index; i < this.index - 1; i++) {
            object[i] = object[i + 1];
        }
        this.index--;
    }

    public int getSize() {
        return this.index;
    }

}
