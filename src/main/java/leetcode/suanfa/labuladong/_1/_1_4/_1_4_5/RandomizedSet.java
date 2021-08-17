package leetcode.suanfa.labuladong._1._1_4._1_4_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandomizedSet {

    //常数时间插入、删除和获取随机元素

    List<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public boolean insert(int val) {
        if(valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)) {
            return false;
        }
        //拿到val的index
        int index = valToIndex.get(val);
        //将最后一个元素对应的index替换为index
        valToIndex.put(list.get(list.size() - 1), index);
        swap(index, list.size() - 1);
        //移除最后一个元素
        list.remove(list.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
    public void swap(int index1, int index2) {
        int temp = list.get(index1);
        list.remove(index1);
        list.add(index1, list.get(index2));
        list.remove(index2);
        list.add(index2, temp);
    }
}
