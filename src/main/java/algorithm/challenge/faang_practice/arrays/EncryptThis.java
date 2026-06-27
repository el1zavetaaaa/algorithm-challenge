package algorithm.challenge.faang_practice.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EncryptThis {
    public static void main(String[] args) {
        System.out.println(encryptThis("Hello"));
        System.out.println(encryptThis("good"));
        System.out.println(encryptThis("hello world"));
    }

    /**
     * Description:
     * <p>
     * Encrypt this!
     * <p>
     * You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:
     * <p>
     * Your message is a string containing space separated words.
     * You need to encrypt each word in the message using the following rules:
     * The first letter must be converted to its ASCII code.
     * The second letter must be switched with the last letter
     * Keepin' it simple: There are no special characters in the input.
     * Examples:
     * <p>
     * Kata.encryptThis("Hello") => "72olle"
     * Kata.encryptThis("good") => "103doo"
     * Kata.encryptThis("hello world") => "104olle 119drlo"
     */
    public static String encryptThis(String text) {
        if (text.isEmpty()) return "";
        return Arrays.stream(text.split(" "))
                .map(EncryptThis::encryptedWord)
                .collect(Collectors.joining(" "));
    }

    private static String encryptedWord(final String word) {
        if (word.isEmpty()) return "";

        final int first = word.charAt(0);
        if (word.length() == 1) return String.valueOf(first);
        if (word.length() == 2) return first + String.valueOf(word.charAt(1));

        char second = word.charAt(1);
        char last = word.charAt(word.length() - 1);

        return String.format("%s%s%s%s", first, String.valueOf(last), word.substring(2, word.length() - 1), second);
    }
}
