package org.example.leetcode;

import java.util.*;

import static org.example.problems.dynamic.NthDigitInSquareSequence.sqr;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * РЕШЕНИЯ:
 * создаем мапу <ОтсортСтрока, Список<Строки>>
 * идем по  массиву, сортируем встреченное слово, кладем в мапу
 * ответ: значения в мапе
 * О(n*klogk), O(1)
 * ----------------------
 * кэширование ----- ЗАЩИТА ОТ КОЛЛИЗИЙ?
 * для каждой строки создаем уникальный битный код:
 * 1) берем кодовое значение символа
 * 2) создаем маску, сдвинув 1 на 38 + код
 * 3) кэш этого слова ораем с маской
 * 4) добавляем к кэшу квадрат (кода + 1) - самое максимальное мы получим 27*27 = 729, таких чисел в 38 битах мы можем иметь вплоть до 377061600
 * то есть для строки длиной до 377061600 коллизии невозможны?
 * почему не работает code*code?????
 * O(n*k) --- тк нет сортировки!!! (однако литкод говорит что с сортом все равно быстрее)
 */
public class LC49 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(cache(strs));
        strs = new String[]{""};
        System.out.println(cache(strs));
        strs = new String[]{"a"};
        System.out.println(cache(strs));
    }

    public static List<List<String>> cache(String[] strs) {
        Map<Long, List<String>> map = new HashMap<>();
        for (String word : strs) {
            Long res = 0L;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int code = c - 'a';
                Long mask = 1L << (38 + code);
                res = res | mask;
                res += (long) (code + 1) * (code + 1); // иначе коллизии
            }
            if (!map.containsKey(res)) {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(res, list);
            } else {
                map.get(res).add(word);
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> better(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> solve(String[] strs) { // O(n). O(n)
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (strs.length == 0) return result;
        result.get(0).add(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            char[] str1 = strs[i].toCharArray();
            boolean hasBeenAdded = false;
            for (List<String> anagramList : result) {
                char[] str2 = anagramList.get(0).toCharArray();
                if (isAnagram(str1, str2)) {
                    anagramList.add(strs[i]);
                    hasBeenAdded = true;
                    break;
                }
            }
            if (!hasBeenAdded) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                result.add(newList);
            }
        }
        return result;
    }

    private static boolean isAnagram(char[] str1, char[] str2) {
        if (str1.length != str2.length) return false;
        int[] charCount = new int[256];
        for (char c : str1) {
            charCount[c]++;
        }
        for (char c : str2) {
            charCount[c]--;
        }
        for (int count : charCount) {
            if (count != 0) return false;
        }
        return true;
    }

}
