package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyAnalyzerDTO implements WordFrequencyAnalyzer {

        public int calculateHighestFrequency(String text) {
            // split text into words
            String[] words = text.split("\\W+");
            // convert words to lowercase
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
            }
            // create a HashMap to store the frequency of each word
            HashMap<String, Integer> wordCount = new HashMap<>();
            // populate the HashMap with the frequency of each word
            for (String word : words) {
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
            // find the highest frequency
            int highestFrequency = 0;
            for (int frequency : wordCount.values()) {
                highestFrequency = Math.max(highestFrequency, frequency);
            }
            return highestFrequency;
        }

        public int calculateFrequencyForWord(String text, String word) {
            // split text into words
            String[] words = text.split("\\W+");
            // convert word to lowercase
            word = word.toLowerCase();
            // create a variable to store the frequency of the specified word
            int frequency = 0;
            // calculate the frequency of the specified word
            for (String w : words) {
                if (w.toLowerCase().equals(word)) {
                    frequency++;
                }
            }
            return frequency;
        }

        public WordFrequency[] calculateMostFrequentNWords(String text, int n) {
            // split text into words
            String[] words = text.split("\\W+");
            // convert words to lowercase
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
            }
            // create a HashMap to store the frequency of each word
            HashMap<String, Integer> wordCount = new HashMap<>();
            // populate the HashMap with the frequency of each word
            for (String word : words) {
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
            // create a list to store the most frequent words
            List<WordFrequency> mostFrequentWords = new ArrayList<>();
            // populate the list with the most frequent words
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                mostFrequentWords.add(new WordFrequencyDTO(entry.getKey(), entry.getValue()));
            }
            // sort the list by frequency in descending order

            Collections.sort(mostFrequentWords, new Comparator<WordFrequency>() {
                @Override
                public int compare(WordFrequency w1, WordFrequency w2) {
                    if (w1.getFrequency() != w2.getFrequency()) {
                        return w2.getFrequency() - w1.getFrequency();
                    } else {
                        return w1.getWord().compareTo(w2.getWord());
                    }
                }
            });
            // return the first n elements of the list
            return mostFrequentWords.subList(0, n).toArray(new WordFrequency[n]);
        }
}
