package com.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wuting
 * @date 2019/05/13
 */
public class WeixinHongbao {

    public static void main(String[] args) {
        List<Integer> list = qiangHongbao(10, 100);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个人抢到" + list.get(i));
        }
        System.out.println("总钱数" + list.stream().mapToInt((i) -> i).sum());
    }

    private static List<Integer> qiangHongbao(int personNum, int moneyNum) {
        int totalPersonNum = personNum;
        int totalMoneyNum = moneyNum;
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < personNum - 1; i++) {
            //二倍均值法,就是指100/10 * 2,每个人可以抢到0-20之间的红包,比较平均的做法
            //如果使用传统的做法
            // 第一个人抢0-100/2之间的红包那么就有可能抢到50元
            // 第二个人抢到0-50之间的25，以此类推，越后面抢到红包的人就越少
            int money = random.nextInt(totalMoneyNum / totalPersonNum * 2) + 1;
            totalPersonNum--;
            totalMoneyNum -= money;
            list.add(money);
        }
        list.add(totalMoneyNum);
        return list;
    }

}
