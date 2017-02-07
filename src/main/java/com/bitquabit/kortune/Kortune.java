package com.bitquabit.kortune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class Kortune {
    private static List<String> loadFortunes(String resourceName) {
        final List<String> fortunes = new ArrayList<>();
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Kortune.class.getResourceAsStream(resourceName)));
            final StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("%")) {
                    fortunes.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(line);
                    sb.append("\n");
                }
            }
            fortunes.add(sb.toString());
        } catch (IOException ignored) {
        }
        return fortunes;
    }

    private static List<String> loadFortunes(String ...resourceNames) {
        List<String> fortunes = new ArrayList<>();
        for (String resourceName : resourceNames) {
            fortunes.addAll(loadFortunes(resourceName));
        }
        return fortunes;
    }

    public static void main(String[] args) {
        List<String> fortunes = loadFortunes("/offensive.fortunes", "/freebsd.fortunes");
        Random random = new Random();
        System.out.println(fortunes.get(random.nextInt(fortunes.size())));
    }
}
