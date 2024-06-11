package com.bosch.example.impl;

import com.bosch.example.services.ReverseService;

public class IMPLReverse implements ReverseService{
    @Override
    public String reverse(String string) {
        String reversedStr = "";
        char ch;

        for (int i = 0; i < string.length(); i++) {
            ch = string.charAt(i);
            reversedStr = ch + reversedStr;
        }
        return reversedStr;
    }

    @Override
    public Boolean isPalindrome(String string, String reversedStr) {
        if(string.equals(reversedStr)) {
            return true;
        } else {
            return false;
        }
    }
}
