package org.marketplus.utils;

import java.util.Scanner;

public class InputUtils {

    public static int intInput(String... text) {
        for(String s : text) {
            System.out.println(s);
        }
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String strInput(String... text) {
        for(String s : text) {
            System.out.println(s);
        }
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
