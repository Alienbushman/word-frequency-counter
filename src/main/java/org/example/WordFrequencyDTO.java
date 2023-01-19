package org.example;

public class WordFrequencyDTO  implements WordFrequency{
    private String word;
    private int frequency;

    public WordFrequencyDTO(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }
}
