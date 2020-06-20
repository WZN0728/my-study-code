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

    private static final int THRESHOLD = 2; // 阈值

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
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (end - start) + start >> 1;
            ForkJoinTest leftTask = new ForkJoinTest(start, middle);
            ForkJoinTest rightTask = new ForkJoinTest(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待子任务执行完，并得到其结果
            int leftTaskResult = leftTask.join();
            int rightTaskResult = rightTask.join();
            // 合并子任务
            sum = leftTaskResult + rightTaskResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 生成一个计算任务，负责计算1+2+3+4
        ForkJoinTest forkJoinTest = new ForkJoinTest(1, 4);
        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(forkJoinTest);
        try {
            int countResult = result.get();
            System.out.println("最后的执行结果:" + countResult);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
