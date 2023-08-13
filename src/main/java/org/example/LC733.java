package org.example;

import java.util.Arrays;

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
