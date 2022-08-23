package chapter3;

import java.util.Comparator;

public class LearnComparator {
    /*
     * 重载比较运算符 > < = <= >=
     * 对于任意比较器，首先需要指定两个对象，o1，o2；
     * 返回值有统一的规范：
     * 返回负数时：认为o1应该排在o2的前面；
     * 返回正数时：认为o2应该排在o1的前面；
     * 返回0时：谁排前面都可以
     */
    public static class MyCompare implements Comparator<Fruit> {
        @Override
        public int compare(Fruit o1, Fruit o2) {
            if(o1.price != o2.price) return o1.price - o2.price;
            else return o1.name.compareTo(o2.name);
        }
    }

    static class Fruit {
        int id;
        String name;
        int price;

        public Fruit(int id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
}
