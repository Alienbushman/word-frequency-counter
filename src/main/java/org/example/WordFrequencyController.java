package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//todo test holds true in swagger
@RestController
@RequestMapping("/api/word-frequency")
public class WordFrequencyController {
//    @GetMapping("/highestFrequency")
//    public int getHighestFrequencyWord(@RequestParam(value = "text") String text) {
//        WordFrequencyAnalyzerDTO analyzer = new WordFrequencyAnalyzerDTO();
//        return analyzer.calculateHighestFrequency(text);
//    }

    @GetMapping("/highest-frequency")
    public int getHighestFrequency(@RequestParam(value = "text") String text) {
        WordFrequencyAnalyzerDTO analyzer = new WordFrequencyAnalyzerDTO();

        return analyzer.calculateHighestFrequency(text);
    }

    @GetMapping("/frequency-for-word")
    public int getFrequencyForWord(@RequestParam(value = "text") String text,
                                   @RequestParam(value = "word") String word) {
        WordFrequencyAnalyzerDTO analyzer = new WordFrequencyAnalyzerDTO();

        return analyzer.calculateFrequencyForWord(text, word);
    }

    @GetMapping("/most-frequent-n-words")
    public WordFrequency[] getMostFrequentNWords(@RequestParam(value = "text") String text,
                                                 @RequestParam(value = "n") int n) {
        WordFrequencyAnalyzerDTO analyzer = new WordFrequencyAnalyzerDTO();

        return analyzer.calculateMostFrequentNWords(text, n);
    }
}
