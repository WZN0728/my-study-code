package com.test;

import lombok.Data;

/**
 * @author wuting
 * @date 2020/06/05
 */
@Data
public class TestLombok {

    private String name;

    private Integer age;

    public static void main(String[] args) {
        TestLombok testLombok = new TestLombok();
        testLombok.setAge(12);
        testLombok.setName("zs");
    }

}
