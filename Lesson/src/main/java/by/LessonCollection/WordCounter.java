package by.LessonCollection;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class WordCounter {
    public static void main(String[] args) {
        String[] array = {"качели", "мечта", "Игра", "пряник", "радость",
                "Сова", "слова", "горка", "качели", "банан",
                "радость", "качели", "яблоко",
                "пряник", "мечта", "банан", "улитка", "Мечта", "Поспать"};
        HashSet<String> uniqueWords = new HashSet<>();
        Collections.addAll(uniqueWords, array);
        System.out.println("Список уникальных слов: ");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : array) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        System.out.println("Количество повторений каждого слова: ");
        for (String word : wordCount.keySet()) {
            System.out.println(word + ":" + wordCount.get(word));
        }
    }
}