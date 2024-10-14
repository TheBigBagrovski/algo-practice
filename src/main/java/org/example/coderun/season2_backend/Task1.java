package org.example.coderun.itmo_mag;

import java.io.*;

/**
 * solve 1 = alpha^-a + alpha^-b + alpha^-c
 */
public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = reader.readLine().split(" ");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        double alpha = findAlpha(a, b, c);

        String answer = String.format("%.9f%n", alpha);
        writer.write(answer);
        reader.close();
        writer.close();
    }

    private static double findAlpha(int a, int b, int c) {
        double low = 1.0;
        double high = 4.0;
        double eps = 1e-10;

        while (high - low > eps) {
            double mid = (low + high) / 2.0;
            double leftSide = 1;
            double rightSide = Math.pow(mid, -a) + Math.pow(mid, -b) + Math.pow(mid, -c);

            if (leftSide > rightSide) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return (low + high) / 2.0;
    }
}