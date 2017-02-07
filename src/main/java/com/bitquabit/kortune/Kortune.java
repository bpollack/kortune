package com.bitquabit.kortune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Kortune {
    private static final Pattern divider = Pattern.compile("^%$", Pattern.MULTILINE);

    private static String readAll(String resourceName) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Kortune.class.getResourceAsStream(resourceName)));
            char[] chars = new char[4096];
            StringBuilder sb = new StringBuilder();
            int read = 0;
            while ((read = reader.read(chars)) > 0) {
                sb.append(chars, 0, read);
            }
            return sb.toString();
        } catch (IOException e) {
            return null;
        }
    }

    private static List<String> loadFortunes(String resourceName) {
        String contents = readAll(resourceName);
        String[] matches = divider.split(contents);
        return Arrays.asList(matches).subList(1, matches.length);
    }

    public static void main(String[] args) {
        List<String> fortunes = loadFortunes("/offensive.fortunes");
        System.out.println(fortunes.get(5));
    }
}
