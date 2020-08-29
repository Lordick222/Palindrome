package ru.veselkov.service.operations;

public class PalindromeService {
    public boolean isPalindrome(String string) {
        String reverse = new StringBuilder(string).reverse().toString();
        return string.equals(reverse);
    }
}
