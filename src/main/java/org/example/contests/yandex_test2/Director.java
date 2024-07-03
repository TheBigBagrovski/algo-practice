//package org.example.contest.yandex_test2;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.PriorityQueue;
//
//public class Director {
//
//        public static void main(String[] args) throws IOException {
//            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
//            String[] str = br.readLine().split(" ");
//            int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
//            List<Scene> scenes = new ArrayList<>();
//
//            for (int i = 0; i < m; i++) {
//                str = br.readLine().split(" ");
//                int startDay = Integer.parseInt(str[0]);
//                int endDay = Integer.parseInt(str[1]);
//                int actorsRequired = Integer.parseInt(str[2]);
//                scenes.add(new Scene(startDay, endDay, actorsRequired));
//            }
//            scenes.sort(Comparator.comparingInt(Scene::getStartDay));
//
//            long actorDays = 0;
//            int sceneIndex = 0;
//            HashMap<Integer, Integer> endDayToIndex = new HashMap<>();
////            List<Integer> actors = new ArrayList<>();
//            Scene currentScene = scenes.get(sceneIndex);
//
//            for (int currentDay = 1; currentDay <= n; currentDay++) {
//
//                while ( == currentDay) {
//                    endDayToIndex.put()
//                }
//
//            }
//
//            bw.write(String.valueOf(actorDays));
//            br.close();
//            bw.close();
//        }
//
//        static class Scene {
//            private final int startDay;
//            private final int endDay;
//            private final int actorsRequired;
//
//            public Scene(int startDay, int endDay, int actorsRequired) {
//                this.startDay = startDay;
//                this.endDay = endDay;
//                this.actorsRequired = actorsRequired;
//            }
//
//            public int getStartDay() {
//                return startDay;
//            }
//
//            public int getEndDay() {
//                return endDay;
//            }
//
//            public int getActorsRequired() {
//                return actorsRequired;
//            }
//        }
//
//}
