package com.sortZH;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuting
 * @date 2019/06/21
 */
public class SortZh {

    public static void main(String[] args) {
        int[] data = {1, 21, 11, 3, 5, 84, 45, 61, 77, 98, 56};
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        int len = lcs("asdfcxdadddfdaaasdf", "fdacxdadddfdaacvzxc");
        System.out.println();
        System.out.println(len);
        int[] arr = new int[]{32, 12, 1, 3, 4, 55, 98, 88, 78};
        //bubbleSort(arr);
        //selectSort(arr);
        //insertSort(arr);
        basicSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Math.pow(10, 0) + "   " + Math.pow(10, 1));
        test1();
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int povit = partation(arr, startIndex, endIndex);
        quickSort(arr, startIndex, povit - 1);
        quickSort(arr, povit + 1, endIndex);
    }

    private static int partation(int[] arr, int startIndex, int endIndex) {
        int left = startIndex, right = endIndex, povit = arr[startIndex];
        while (left != right) {
            while (left < right && arr[right] > povit) {
                right--;
            }
            while (left < right && arr[left] <= povit) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;
        return left;
    }

    private static ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();

    public void test() {
        concurrentSkipListMap.put("1", 1);
        concurrentSkipListMap.size();
        concurrentSkipListMap.remove("1");
    }

    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    /*public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";// A录入银行流水数据
                    String B = exgr.exchange(A);
                    System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是："
                            + A + "，B录入是：" + B);
                } catch (InterruptedException e) {
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";// B录入银行流水数据
                    String A = exgr.exchange(B);
                    System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是："
                            + A + "，B录入是：" + B);
                } catch (InterruptedException e) {
                }
            }
        });
        threadPool.shutdown();
    }*/

    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c[len1][len2];
    }

    //冒泡排序
    public static void bubbleSort(int[] numbers) {
        int temp = 0;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                //借鉴冒泡排序
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    //选择排序
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            //选出之后待排序中值最小的位置
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            //最小值不等于当前值时进行交换
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public static void basicSort(int[] array) {
        //创建叠加数组
        List<ArrayList> dyadic = new ArrayList<ArrayList>();
        //给大数组dyadic添加子数组
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            dyadic.add(arr);
        }

        //找出数组中的最大值
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        //判断最大值为几位数，其位数就是应该循环的次数
        int times = 0;
        while (max > 0) {
            max /= 10;
            times++;
        }

        //循环times次，每次将对应位的数分配到相应的自数组中
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < array.length; j++) {
                //找出每个数对应的位的数值
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                //将该数组作为下标，找到对应的子数组
                ArrayList arr = dyadic.get(x);
                //将该元素添加到子数组中
                arr.add(array[j]);
                //因为子数组改变，因此更新大数组
                dyadic.set(x, arr);
            }

            //将重新排好的子数组的值依次将需要被排序的数组的值覆盖
            int index = 0;   //用index作为数组array的下标
            //将子数组依次遍历，将每个子数组中的元素添加到array中
            for (int k = 0; k < 10; k++) {
                //当下标为k的子数组中有元素时
                while (dyadic.get(k).size() > 0) {
                    //得到该数组
                    ArrayList arr = dyadic.get(k);
                    ///将该数组的第一个元素添加到array中
                    array[index++] = Integer.parseInt(arr.get(0).toString());
                    //移除子数组中的第一个元素，这样就能在第一个元素被使用之后，后面元素替换
                    arr.remove(0);
                    //将array数组中下标也后移一位
                }
            }
        }
    }

    private static class Person {

        private int age;

        private String userName;

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", userName='" + userName + '\'' +
                    '}';
        }

        public Person(int age, String userName) {
            this.age = age;
            this.userName = userName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(userName, person.userName);
        }

        /**
         * hashCode方法本身与equals方法没有一毛钱关系,只有在使用set map这种通过hash值定位到数组下表的散列表才与hashCode有关系,因为散列表中要通过hash值来排重
         * 如果在使用set map时重写了hashCode方法之后对象的hash值相同,
         * 因为set的底层实现时map,再放入元素的时候会通过hash值做equals比较,这时就会用到hashCode方法,所以这时候必须重写hashCode方法
         *
         * @return
         */
        @Override
        public int hashCode() {
            return Objects.hash(age, userName);
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

    }

    public static void test1() {
        Person person1 = new Person(18, "zhangsan");
        Person person2 = new Person(18, "zhangsan");
        System.out.println("person1 hashCode:" + person1.hashCode() + " person2 hashCode:" + person2.hashCode());
        System.out.println("person1 equals person2 result :" + person1.equals(person2));
        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2);
        for (Person p : personSet) {
            System.out.println("person : " + p);
        }
    }

}
