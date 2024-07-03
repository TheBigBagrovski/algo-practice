package org.example.leetcode;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * РЕШЕНИЕ:
 * идти с конца строк синхронно
 * если решетка - апаем счетчик решеток для своей строки, дальше скипаем столько символов, сколько в счетчике решеток
 * если дошли до конца строки - ставим собаку
 * аналогично с другой строкой
 * если буквы отличаются -  фолс
 */
public class LC844 {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(solve(s, t));
        s = "ab##";
        t = "c#d#";
        System.out.println(solve(s, t));
        s = "a#c";
        t = "b";
        System.out.println(solve(s, t));
    }

    public static boolean solve(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        int countS = 0;
        int countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') countS++;
                else countS--;
                i--;
            }
            char left = i < 0 ? '@' : S.charAt(i);
            while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') countT++;
                else countT--;
                j--;
            }
            char right = j < 0 ? '@' : T.charAt(j);
            if (left != right) return false;
            i--;
            j--;
        }
        return true;

    }

//    private static char skip(int i, String s) {
//        int counter = 1;
//        i--;
//        char sc = s.charAt(i);
//        while (sc == '#') {
//            i--;
//            sc = s.charAt(i);
//            counter++;
//        }
//        i -= counter - 1;
//        return s.charAt(i);
//    }

}
