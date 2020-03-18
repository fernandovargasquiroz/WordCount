package com.bbdd.wordcount;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class WordsFrequency {

    public static void main(String[] args) throws IOException {
        File file = new File("E:/words.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        HashMap<String, Integer> frequenciesWords = new HashMap<>();
        StringTokenizer tok;

        while ((line = reader.readLine()) != null) {
            tok = new StringTokenizer(line);
            while (tok.hasMoreTokens()) {
                String word = (String) tok.nextElement();
                word = word.toLowerCase();
                word = word.replaceAll("[^a-z]^\\s*", "");
                if (frequenciesWords.containsKey(word)) {
                    frequenciesWords.put(word, frequenciesWords.get(word) + 1);
                } else {
                    frequenciesWords.put(word, 1);
                }

            }
        }

        final Map<String, Integer> sortedFrequenciesWords;
        sortedFrequenciesWords = sortByValue(frequenciesWords);
        for (Map.Entry<String, Integer> entry : sortedFrequenciesWords.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }

    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> frequenciesWords) {
        return frequenciesWords.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
