package org.example;

interface WordFrequency {
    String getWord();
    int getFrequency();
}

interface WordFrequencyAnalyzer {
    int calculateHighestFrequency(String text);
    int calculateFrequencyForWord (String text, String word);
    WordFrequency[] calculateMostFrequentNWords (String text, int n);
}