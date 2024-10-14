package org.example.coderun.season2_backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(reader.readLine());
        int B = Integer.parseInt(reader.readLine());
        int N = Integer.parseInt(reader.readLine());

        int minB = (B % N == 0) ? B / N : B / N + 1;
        String answer = (A > minB) ? "Yes" : "No";
        
        writer.write(answer);
    
        
        reader.close();
        writer.close();
    }

}
