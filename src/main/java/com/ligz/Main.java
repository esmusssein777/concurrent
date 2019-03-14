package com.ligz;

/**
 * author:ligz
 */

public class Main {

    private static int x = 10;
    private static Integer y = 10;

    public static void updateX(int value) {
        value = 3 * value;
    }

    public static void updateY(Integer value) {
        value = 3 * value;
    }

    public static void main(String[] args) {
        updateX(x);
        updateY(y);
        System.out.println(x + " " + y);
    }
}
