package com.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author wuting
 * @date 2020/03/01
 */
public class ForkJoinTest extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2; // ��ֵ

    private int start;

    private int end;

    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean falg = (end - start) <= THRESHOLD;
        if (falg) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // ������������ֵ���ͷ��ѳ��������������
            int middle = (end - start) + start >> 1;
            ForkJoinTest leftTask = new ForkJoinTest(start, middle);
            ForkJoinTest rightTask = new ForkJoinTest(middle + 1, end);
            //ִ��������
            leftTask.fork();
            rightTask.fork();
            // �ȴ�������ִ���꣬���õ�����
            int leftTaskResult = leftTask.join();
            int rightTaskResult = rightTask.join();
            // �ϲ�������
            sum = leftTaskResult + rightTaskResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // ����һ���������񣬸������1+2+3+4
        ForkJoinTest forkJoinTest = new ForkJoinTest(1, 4);
        // ִ��һ������
        Future<Integer> result = forkJoinPool.submit(forkJoinTest);
        try {
            int countResult = result.get();
            System.out.println("����ִ�н��:" + countResult);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
