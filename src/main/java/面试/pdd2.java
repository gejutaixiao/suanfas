package 面试;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class pdd2 {

    public static int[] pdd2(int[] arr1, int[] arr2) {
        //多多鸡与多多鸭
        LinkedList<Integer> list = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int res1 = 0, res2 = 0;
        int n = arr1.length;
        int index1 = 0, index2 = 0;
        boolean flag = true;
        while (index1 < n || index2 < n) {
            if (index1 < n && flag) {
                if (map.containsKey(arr1[index1])) {
                    res1 += list.size() - map.get(arr1[index1]) + 2;
                    while (list.contains(arr1[index1])) {
                        int last = list.removeLast();
                        map.remove(last);
                    }
                    index1++;
                }
                if (index1 < n) {
                    list.add(arr1[index1]);
                    map.put(arr1[index1], list.size());
                    index1++;
                }
            } else if (index2 < arr2.length){
                if (map.containsKey(arr2[index2])) {
                    res2 += list.size() - map.get(arr2[index2]) + 1;
                    while (list.contains(arr1[index2])) {
                        int last = list.removeLast();
                        map.remove(last);
                    }
                    index2++;
                }
                if (index2 < n) {
                    list.add(arr2[index2]);
                    map.put(arr2[index2], list.size());
                    index2++;
                }
            }
            flag = !flag;
        }
        while (!list.isEmpty()) {
            int last = list.pollLast();
            if (last % 2 == 1) {
                res1++;
            } else {
                res2++;
            }
        }
        return new int[]{res1, res2};
    }

    public static void main(String[] args) {
        int[] list1 = {1, 1};
        int[] list2 = {2, 2};
        int[] ints = pdd2(list1, list2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
