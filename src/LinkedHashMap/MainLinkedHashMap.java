package LinkedHashMap;

import HashMap.HashMap;

public class MainLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<String, String>();
        stringStringLinkedHashMap.put("ewef", "Value1");
        stringStringLinkedHashMap.put("wfe", "Value2");
        stringStringLinkedHashMap.put("fe", "Value3");
        stringStringLinkedHashMap.traverse();
        stringStringLinkedHashMap.put("f3e", "Value4");
        stringStringLinkedHashMap.traverse();
        stringStringLinkedHashMap.put("qwe2", "Value5");
        stringStringLinkedHashMap.put("wfe", "Value10");
        stringStringLinkedHashMap.put("242", "Val6");
        stringStringLinkedHashMap.put("242", "Val69");
        stringStringLinkedHashMap.put("wfe", "Val180");
        stringStringLinkedHashMap.put("f3e", "Val181");
        stringStringLinkedHashMap.traverseInOrdered();
        stringStringLinkedHashMap.traverse();
        System.out.println(stringStringLinkedHashMap.get("qwe2"));
//        stringStringLinkedHashMap.traverseInOrdered();
//        stringStringLinkedHashMap.traverseInReverseOrdered();
//        stringStringLinkedHashMap.traverse();
//        System.out.println(stringStringLinkedHashMap.size());
//
//        stringStringLinkedHashMap.remove("wfe");
//        stringStringLinkedHashMap.traverseInOrdered();
//        stringStringLinkedHashMap.traverseInReverseOrdered();
//        stringStringLinkedHashMap.traverse();
//        System.out.println(stringStringLinkedHashMap.size());
//
//
//        stringStringLinkedHashMap.remove("242");
//        stringStringLinkedHashMap.traverseInOrdered();
//        stringStringLinkedHashMap.traverseInReverseOrdered();
//        stringStringLinkedHashMap.traverse();
//        System.out.println(stringStringLinkedHashMap.size());
//
//        stringStringLinkedHashMap.put("key10", "Val10");
//        stringStringLinkedHashMap.traverseInOrdered();
//        stringStringLinkedHashMap.traverseInReverseOrdered();
//        stringStringLinkedHashMap.traverse();
//
//        stringStringLinkedHashMap.remove("key10");
//        System.out.println( stringStringLinkedHashMap.remove("qwe2"));
//        System.out.println( stringStringLinkedHashMap.remove("qwe2"));
//        System.out.println( stringStringLinkedHashMap.remove("qwe2"));
//        stringStringLinkedHashMap.traverseInOrdered();
//        stringStringLinkedHashMap.traverseInReverseOrdered();
//        stringStringLinkedHashMap.traverse();
//        System.out.println(stringStringLinkedHashMap.size());
//
//        stringStringLinkedHashMap.remove("fe");
//        stringStringLinkedHashMap.traverseInOrdered();
//        stringStringLinkedHashMap.traverseInReverseOrdered();
//        stringStringLinkedHashMap.traverse();
//        System.out.println(stringStringLinkedHashMap.size());
//
//        stringStringLinkedHashMap.remove("ewef");
//        stringStringLinkedHashMap.traverseInOrdered();
//        stringStringLinkedHashMap.traverseInReverseOrdered();
//        stringStringLinkedHashMap.traverse();
//        System.out.println(stringStringLinkedHashMap.size());
//
//        stringStringLinkedHashMap.remove("f3e");
//        stringStringLinkedHashMap.traverseInOrdered();
//        stringStringLinkedHashMap.traverseInReverseOrdered();
//        stringStringLinkedHashMap.traverse();
//        System.out.println(stringStringLinkedHashMap.size());
    }
}
