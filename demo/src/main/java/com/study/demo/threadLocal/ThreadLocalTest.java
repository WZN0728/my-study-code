package com.study.demo.threadLocal;

import com.alibaba.fastjson.JSON;

/**
 * @author wuting
 * @date 2020/10/17
 */
public class ThreadLocalTest {

    private static final ThreadLocal<User> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        test1();
        test2();
        System.out.println(JSON.toJSONString(USER_THREAD_LOCAL.get()));
    }

    private static void test2() {
        User user = new User();
        user.setName("lisi");
        USER_THREAD_LOCAL.set(user);
    }

    private static void test1() {
        User user = new User();
        user.setName("zhangsan");
        USER_THREAD_LOCAL.set(user);
    }

    private static class User {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
