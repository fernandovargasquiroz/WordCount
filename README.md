# WordCount
WordCount

https://github.com/fernandovargasquiroz/WordCount.git

Word Count has the main class WordsFrequency.java, which has as input a text file in this case located at E: /words.txt.

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
//reading the file
        while ((line = reader.readLine()) != null) 
		//we get the words
            tok = new StringTokenizer(line);
            while (tok.hasMoreTokens()) {
                String word = (String) tok.nextElement();
                word = word.toLowerCase();
				//remove rare characters
                word = word.replaceAll("[^a-z]^\\s*", "");
                if (frequenciesWords.containsKey(word)) {
                    frequenciesWords.put(word, frequenciesWords.get(word) + 1);
                } else {
                    frequenciesWords.put(word, 1);
                }

            }
        }
        // sort in descending order with the most common words first
        final Map<String, Integer> sortedFrequenciesWords;
        sortedFrequenciesWords = sortByValue(frequenciesWords);
		//printing occurrences
        for (Map.Entry<String, Integer> entry : sortedFrequenciesWords.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }

    }
  //function to sort in descending order
    public static Map<String, Integer> sortByValue(Map<String, Integer> frequenciesWords) {
        return frequenciesWords.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}


output.txt result based on file words.txt

output example

and 38
i 27
my 24
of 22
that 17
this 16
a 15
chamber 11
bird 10
on 10
is 9
at 8
