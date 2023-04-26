package com.example.demo01.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class One {
    public static void main(String[] args) {
        String bh = "A080";
        String pattern = "[1-9]+.*";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(bh);

        if (matcher.find())
            System.out.println(matcher.group());
    }
}
