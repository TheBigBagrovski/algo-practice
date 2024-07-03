//package org.example.contests.yandexcup.backend;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TaskG {
//
//    static final List<Bid> activeSellBids = new ArrayList<>();
//    static final List<Bid> activeBuyBids = new ArrayList<>();
//    static final List<Bid> completeBids = new ArrayList<>();
//    static int currentId = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
//
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//
//            String[] command = br.readLine().split(" ");
//
//            switch (command[0]) {
//                case "ADD":
//                    OpType type;
//                    if (command[1].equals("BUY")) {
//                        type = OpType.BUY;
//                    } else {
//                        type = OpType.SELL;
//                    }
//                    int id = addBid(
//                            type,
//                            new BigDecimal(command[2]),
//                            Integer.parseInt(command[3])
//                    );
//                    break;
//                case "GET":
//
//                    break;
//                case "DELETE":
//                    break;
//
//                case "SHOW_OPERATIONS":
//                    break;
//            }
//
//
//        }
//
//
//        br.close();
//        bw.close();
//    }
//
//    private static int addBid(OpType type, BigDecimal price, int volume) {
//        Bid bid = new Bid(++currentId, type, price, volume);
//        switch (type) {
//            case BUY -> {
//                for (Bid activeSellBid : activeSellBids) {
//                    if (activeSellBid.price.compareTo(price) <= 0) {
//
//                    }
//                }
//            }
//            case SELL -> {
//
//            }
//        }
//    }
//
//    public enum OpType {
//        BUY,
//        SELL
//    }
//
//    public enum Status {
//        ACTIVE,
//        DELETED,
//        COMPLETE
//    }
//
//    public static class Bid implements Comparable<> {
//        int id;
//        OpType type;
//        BigDecimal price;
//        int volume;
//        Status status;
//
//        public Bid(int id, OpType type, BigDecimal price, int volume) {
//            this.id = id;
//            this.type = type;
//            this.price = price;
//            this.volume = volume;
//            status = Status.ACTIVE;
//        }
//
//        @Override
//        public int compareTo(@NotNull Object o) {
//            return 0;
//        }
//    }
//
//}
