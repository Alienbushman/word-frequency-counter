package org.example;

import org.junit.jupiter.api.Assertions;


class WordFrequencyAnalyzerDTOTest {
    WordFrequencyAnalyzerDTO analyzer = new WordFrequencyAnalyzerDTO();

    @org.junit.jupiter.api.Test
    public void testCalculateHighestFrequency() {
        String text = "The sun shines over the lake";
        int expectedResult = 2;
        int result = analyzer.calculateHighestFrequency(text);
        Assertions.assertEquals(expectedResult, result);

        text = "The sun shines over the lake, the sun is bright";
        expectedResult = 3;
        result = analyzer.calculateHighestFrequency(text);
        Assertions.assertEquals(expectedResult, result);

        text = "";
        expectedResult = 0;
        result = analyzer.calculateHighestFrequency(text);
        Assertions.assertEquals(expectedResult, result);
    }

    @org.junit.jupiter.api.Test
    void calculateFrequencyForWord() {
        String text = "The sun shines over the lake";
        String word = "the";
        int expectedResult = 2;
        int result = analyzer.calculateFrequencyForWord(text, word);
        Assertions.assertEquals(expectedResult, result);

        text = "The sun shines over the lake, the sun is bright";
        word = "The";
        expectedResult = 3;
        result = analyzer.calculateFrequencyForWord(text, word);
        Assertions.assertEquals(expectedResult, result);

        text = "The sun shines over the lake";
        word = "moon";
        expectedResult = 0;
        result = analyzer.calculateFrequencyForWord(text, word);
        Assertions.assertEquals(expectedResult, result);

        text = "The sun shines over the lake";
        word = "over!";
        expectedResult = 0;
        result = analyzer.calculateFrequencyForWord(text, word);
        Assertions.assertEquals(expectedResult, result);
    }

    //todo needs work
    @org.junit.jupiter.api.Test
    void testCalculateMostFrequentNWords() {
        String text = "The sun shines over the lake, the sun is bright";
        int n = 3;
        WordFrequency[] expectedResult = new WordFrequency[]{new WordFrequencyDTO("the", 2), new WordFrequencyDTO("sun", 2), new WordFrequencyDTO("over", 1)};
        WordFrequency[] result = analyzer.calculateMostFrequentNWords(text, n);
        //todo add a assert which compares values and caters for case n=2, [a =3, b=2, c=2], where b or c could be returned
        Assertions.assertArrayEquals(expectedResult, result);

        text = "The sun shines over the lake! the sun is bright.";
        n = 2;
        expectedResult = new WordFrequency[]{new WordFrequencyDTO("the", 2), new WordFrequencyDTO("sun", 2)};
        result = analyzer.calculateMostFrequentNWords(text, n);
        Assertions.assertArrayEquals(expectedResult, result);

        text = "";
        n = 2;
        expectedResult = new WordFrequency[0];
        result = analyzer.calculateMostFrequentNWords(text, n);
        Assertions.assertArrayEquals(expectedResult, result);
    }


}