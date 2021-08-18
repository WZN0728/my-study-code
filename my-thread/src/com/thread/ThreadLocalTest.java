/**
 * All rights Reserved, Designed By MyCompany
 *
 * @Title: ThreadLocalTest.java
 * @Package com.thread
 * @Copyright: 2018 All rights reserved.
 */
package com.thread;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @ClassName: ThreadLocalTest
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��3��9�� ����9:28:38
 */
public class ThreadLocalTest {

    /**
     * ThreadLocal�����̱߳�������һ����ThreadLocal����Ϊ�����������Ϊֵ�Ĵ洢�ṹ����
     * ���ṹ���������߳��ϣ�Ҳ����˵һ���߳̿��Ը���һ��ThreadLocal�����ѯ����������߳��ϵ�һ��ֵ��
     */
    // ��һ��get()��������ʱ����г�ʼ�������set����û�е��ã���ÿ���̻߳����һ��
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        ThreadLocalTest.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + ThreadLocalTest.end() + " mills");
    }

}
