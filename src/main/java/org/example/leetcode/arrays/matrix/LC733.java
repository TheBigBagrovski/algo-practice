package org.example.leetcode;

import java.util.Arrays;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * Return the modified image after performing the flood fill.
 * РЕШЕНИЕ:
 * тупо рекурсией перебираем соседей и меняем цвет
 */
public class LC733 {

    static boolean[] visited;

    public static void main(String[] args) {
        int[][] image = new int[][] {{0,0,0},{0,0,0}};
        System.out.println(Arrays.deepToString(best(image, 1, 0, 2)));
    }



    /* O(m*n), O(m*n), ограничение из-за глубины рекурсии, меньше затраты по времени, тк есть быстрый выход из рекурсии */

    public static int[][] best (int[][] img, int i, int j, int col) {
        if(img[i][j]==col)return img;
        fill(img,i,j,img[i][j], col);
        return img;
    }

    public static void fill(int[][] img, int i, int j, int col, int newcol){
        if(i<0 || j<0 || i>=img.length || j>=img[0].length || img[i][j]!=col)return;
        img[i][j]=newcol;
        fill(img, i-1, j, col, newcol);
        fill(img, i+1, j, col, newcol);
        fill(img, i, j-1, col, newcol);
        fill(img, i, j+1, col, newcol);
    }


    /* O(m*n), O(m*n), ограничение из-за глубины рекурсии */
    public static int[][] bad(int[][] image, int sr, int sc, int color) {
       visited = new boolean[image.length * image[0].length];
       fill(image, sr, sc, color);
       return image;
    }

    private static void fill(int[][] image, int y, int x, int color) {
        int initColor = image[y][x];
        image[y][x] = color;
        visited[y * image[0].length + x] = true;
        if(x !=image[0].length -1 && image[y][x+1] == initColor && !visited[y * image[0].length + x + 1]) fill(image, y, x+1, color);
        if(x !=0 && image[y][x-1]== initColor && !visited[y * image[0].length + x - 1])fill(image, y, x-1, color);
        if(y != image.length - 1 && image[y+1][x]== initColor && !visited[(y + 1) * image[0].length + x])fill(image, y+1, x, color);
        if(y !=0 && image[y-1][x]== initColor && !visited[(y - 1) * image[0].length + x])fill(image, y-1, x, color);
    }

}
