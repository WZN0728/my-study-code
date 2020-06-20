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
            System.out.println("��" + (i + 1) + "��������" + list.get(i));
        }
        System.out.println("��Ǯ��" + list.stream().mapToInt((i) -> i).sum());
    }

    private static List<Integer> qiangHongbao(int personNum, int moneyNum) {
        int totalPersonNum = personNum;
        int totalMoneyNum = moneyNum;
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < personNum - 1; i++) {
            //������ֵ��,����ָ100/10 * 2,ÿ���˿�������0-20֮��ĺ��,�Ƚ�ƽ��������
            //���ʹ�ô�ͳ������
            // ��һ������0-100/2֮��ĺ����ô���п�������50Ԫ
            // �ڶ���������0-50֮���25���Դ����ƣ�Խ��������������˾�Խ��
            int money = random.nextInt(totalMoneyNum / totalPersonNum * 2) + 1;
            totalPersonNum--;
            totalMoneyNum -= money;
            list.add(money);
        }
        list.add(totalMoneyNum);
        return list;
    }

}
