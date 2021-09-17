package com.shred.array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String line = "W-210909-335矿泉水111*222mm塑料矿泉水";

        String test = "0909泉水";
        String[] split = test.split("");
        String pattern = "(.*)("+ String.join(")(.*)(", split) +")(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);

        System.out.println(m.matches());

    }
}
