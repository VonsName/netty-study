package com.example.demo;

/**
 * @author ： fjl
 * @date ： 2018/12/17/017 14:20
 */
public class Base {

    private String basename = "base";

    public Base() {
        callname();
    }

    public void callname() {
        System.out.println(basename);
    }

    static class Sub extends Base {
        private String basename = "sub";

        @Override
        public void callname() {
            System.out.println(basename);
        }
    }

    public static void main(String[] args) {
        Base base = new Sub();
    }
}
