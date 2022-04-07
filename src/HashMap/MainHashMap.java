package HashMap;

public class MainHashMap {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("key1","Value1");
        hashMap.put("key2","Value2");
        hashMap.put("key3","Value3");
        hashMap.put("key4","Value4");
        hashMap.put("key5","Value5");
        hashMap.traverse();
        hashMap.put("key6","Value6");
        hashMap.put("key7","Value7");
        hashMap.put("key8","Value8");
        hashMap.put("key9","Value9");
        hashMap.put("key10","Value10");
        hashMap.put("key11","Value11");
        hashMap.put("key12","Value12");
        hashMap.put("key13","Value13");
        hashMap.put("key14","Value14");
        hashMap.put("key15","Value15");
        hashMap.put("key16Joy","Value16");
        hashMap.put("kedqwy16dJo","Value16");
        hashMap.traverse();
        hashMap.remove("joy1");
        hashMap.traverse();
        System.out.println(hashMap.get("key11"));
        System.out.println(hashMap.get("key6"));
    }
}




