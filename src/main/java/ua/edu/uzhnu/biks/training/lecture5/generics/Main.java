package ua.edu.uzhnu.biks.training.lecture5.generics;

import java.util.*;

/**
 * Created by Actine on 16.03.2017.
 */
public class Main {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(10);
        List<String> list = new LinkedList<>();
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add("123");
        list.add(0, "12356678");
        list.add(0, "1234");
        list.set(3, "1234345");
        list.get(12);
        list.remove(0);
        boolean contains = list.contains("123");
        list.indexOf("123");
        list.lastIndexOf("123");
        for (String s : list) {

        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            iterator.remove();
        }

        Deque<String> deque = new LinkedList<>(list);
        deque.push("123");
        deque.push("567");
        deque.pop();
        deque.removeLast();

        List<String> strings = new ArrayList<>(Arrays.asList("123", "4346"));
        strings.add("678");

        String[] export = new String[list.size()];
        list.toArray(export);

        // Set - HashSet, TreeSet, LinkedHashSet
        // Map - HashMap, LinkedHashMap
    }

}
