package ArrayList;

public class MainArrayList {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.display();
        System.out.println("Get 0 " + arrayList.get(0));
        System.out.println("Get 10 " + arrayList.get(10));
        arrayList.remove(5);
        arrayList.display();
        arrayList.remove(0);
        arrayList.display();
        arrayList.remove(8);
        arrayList.display();
        System.out.println("Get 11 " + arrayList.get(11));
    }
}
