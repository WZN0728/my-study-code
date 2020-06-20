package com;

/**
 * @author wuting
 * @date 2020/02/13
 */
public class Test {

    static class Person {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }

    public static void main(String[] args) {
        Person person = null;
        if (person != null && person.getName() != null) {
            System.out.println("test");
        }
    }

}
