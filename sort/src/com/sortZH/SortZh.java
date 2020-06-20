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
                    String A = "������ˮA";// A¼��������ˮ����
                    String B = exgr.exchange(A);
                    System.out.println("A��B�����Ƿ�һ�£�" + A.equals(B) + "��A¼����ǣ�"
                            + A + "��B¼���ǣ�" + B);
                } catch (InterruptedException e) {
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "������ˮB";// B¼��������ˮ����
                    String A = exgr.exchange(B);
                    System.out.println("A��B�����Ƿ�һ�£�" + A.equals(B) + "��A¼����ǣ�"
                            + A + "��B¼���ǣ�" + B);
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

    //ð������
    public static void bubbleSort(int[] numbers) {
        int temp = 0;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1])  //��������λ��
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    //��������
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                //���ð������
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    //ѡ������
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            //ѡ��֮���������ֵ��С��λ��
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            //��Сֵ�����ڵ�ǰֵʱ���н���
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public static void basicSort(int[] array) {
        //������������
        List<ArrayList> dyadic = new ArrayList<ArrayList>();
        //��������dyadic���������
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            dyadic.add(arr);
        }

        //�ҳ������е����ֵ
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        //�ж����ֵΪ��λ������λ������Ӧ��ѭ���Ĵ���
        int times = 0;
        while (max > 0) {
            max /= 10;
            times++;
        }

        //ѭ��times�Σ�ÿ�ν���Ӧλ�������䵽��Ӧ����������
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < array.length; j++) {
                //�ҳ�ÿ������Ӧ��λ����ֵ
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                //����������Ϊ�±꣬�ҵ���Ӧ��������
                ArrayList arr = dyadic.get(x);
                //����Ԫ����ӵ���������
                arr.add(array[j]);
                //��Ϊ������ı䣬��˸��´�����
                dyadic.set(x, arr);
            }

            //�������źõ��������ֵ���ν���Ҫ������������ֵ����
            int index = 0;   //��index��Ϊ����array���±�
            //�����������α�������ÿ���������е�Ԫ����ӵ�array��
            for (int k = 0; k < 10; k++) {
                //���±�Ϊk������������Ԫ��ʱ
                while (dyadic.get(k).size() > 0) {
                    //�õ�������
                    ArrayList arr = dyadic.get(k);
                    ///��������ĵ�һ��Ԫ����ӵ�array��
                    array[index++] = Integer.parseInt(arr.get(0).toString());
                    //�Ƴ��������еĵ�һ��Ԫ�أ����������ڵ�һ��Ԫ�ر�ʹ��֮�󣬺���Ԫ���滻
                    arr.remove(0);
                    //��array�������±�Ҳ����һλ
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
         * hashCode����������equals����û��һëǮ��ϵ,ֻ����ʹ��set map����ͨ��hashֵ��λ�������±��ɢ�б����hashCode�й�ϵ,��Ϊɢ�б���Ҫͨ��hashֵ������
         * �����ʹ��set mapʱ��д��hashCode����֮������hashֵ��ͬ,
         * ��Ϊset�ĵײ�ʵ��ʱmap,�ٷ���Ԫ�ص�ʱ���ͨ��hashֵ��equals�Ƚ�,��ʱ�ͻ��õ�hashCode����,������ʱ�������дhashCode����
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
