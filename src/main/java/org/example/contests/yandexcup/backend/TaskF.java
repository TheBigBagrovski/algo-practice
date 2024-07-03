package org.example.contests.yandexcup.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskF {

    public static void main(String[] args) throws IOException { // O(n*k), O(n)
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String[] str = br.readLine().split(" ");
        int studentsNum = Integer.parseInt(str[0]);
        int facultiesNum = Integer.parseInt(str[1]);
        int[] faculties = new int[facultiesNum];
        str = br.readLine().split(" ");
        for (int i = 0; i < facultiesNum; i++) {
            faculties[i] = Integer.parseInt(str[i]);
        }
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < studentsNum; i++) {
            str = br.readLine().split(" ");
            Student student = new Student(Integer.parseInt(str[0]));
            for (int j = 2; j < str.length; j++) {
                student.wishlist.add(Integer.parseInt(str[j]));
            }
            studentList.add(student);
        }
        List<Student> sortedStudents = new ArrayList<>(studentList);
        Collections.sort(sortedStudents);

        for (int i = 0; i < studentList.size(); i++) {
            Student student = sortedStudents.get(i);
            List<Integer> wishlist = student.wishlist;
            for (Integer integer : wishlist) {
                if (faculties[integer - 1] > 0) {
                    student.passed = integer;
                    faculties[integer - 1]--;
                    break;
                }
            }
        }
        int j;
        for (j = 0; j < studentList.size() - 1; j++) {
            bw.write(Integer.toString(studentList.get(j).passed));
            bw.write(" ");
        }
        bw.write(Integer.toString(studentList.get(j).passed));
        br.close();
        bw.close();
    }

    static class Student implements Comparable<Student> {
        int place;
        List<Integer> wishlist = new ArrayList<>();
        int passed = -1;

        public Student(int place) {
            this.place = place;
        }

        @Override
        public int compareTo(Student student) {
            return this.place - student.place;
        }
    }

}