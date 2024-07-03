package org.example.contests.nic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VideoService {

    public static void main(String[] args) throws IOException {
        VideoRequest vr = new VideoRequest("1", "2023", "12", "31", "23:30", "60");
        mergeVideos(vr);
    }

    static class VideoRequest {
        private String cameraNumber;
        private String year;
        private String month;
        private String day;
        private String time;
        private String duration;

        public VideoRequest(String cameraNumber, String year, String month, String day, String time, String duration) {
            this.cameraNumber = cameraNumber;
            this.year = year;
            this.month = month;
            this.day = day;
            this.time = time;
            this.duration = duration;
        }

        public String getCameraNumber() {
            return cameraNumber;
        }

        public String getYear() {
            return year;
        }

        public String getMonth() {
            return month;
        }

        public String getDay() {
            return day;
        }

        public String getTime() {
            return time;
        }

        public String getDuration() {
            return duration;
        }
    }

    public static void mergeVideos(VideoRequest videoRequest) throws IOException {
            String basePath = "D:/Movies/vid/1/";
            String year = videoRequest.getYear();
            String month = videoRequest.getMonth();
            String day = videoRequest.getDay();
            String startTime = videoRequest.getTime();
            String duration = videoRequest.getDuration();

            LocalDateTime startDateTime = LocalDateTime.of(
                    Integer.parseInt(year),
                    Integer.parseInt(month),
                    Integer.parseInt(day),
                    Integer.parseInt(startTime.substring(0, 2)),
                    Integer.parseInt(startTime.substring(3)));

            Duration durationTime = Duration.ofMinutes(Long.parseLong(duration));
            LocalDateTime endDateTime = startDateTime.plus(durationTime);

            List<Path> videoFilesToMerge = findFilesInTimeRange(basePath, startDateTime, endDateTime);
        System.out.println(videoFilesToMerge);
        // Вызов Ffmpeg для склеивания видеофайлов
//        if (videoFilesToMerge.size() > 1) {
//            try {
//                List<String> ffmpegCommand = buildFfmpegCommand(videoFilesToMerge);
//                executeFfmpegCommand(ffmpegCommand);
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private static List<Path> findFilesInTimeRange(String basePath, LocalDateTime startDateTime, LocalDateTime endDateTime) throws IOException {
        Path startPath = Paths.get(basePath);
        return Files.find(startPath, Integer.MAX_VALUE, (path, attr) -> {
                    if (Files.isRegularFile(path)) {
                        try {
                            FileTime fileTime = (FileTime) Files.getAttribute(path, "creationTime");
                            LocalDateTime fileDateTime = LocalDateTime.ofInstant(fileTime.toInstant(), ZoneId.systemDefault());
                            return !fileDateTime.isBefore(startDateTime) && !fileDateTime.isAfter(endDateTime);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    private static boolean isInTimeRange(Path file, LocalDateTime currentDateTime, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        String fileName = file.getFileName().toString();
        String[] parts = fileName.split("_");
        if (parts.length < 2) {
            return false;
        }

        int fileHour = Integer.parseInt(parts[0]);
        int fileMinute = Integer.parseInt(parts[1].substring(0, 2));

        LocalDateTime fileDateTime = LocalDateTime.of(
                currentDateTime.getYear(),
                currentDateTime.getMonth(),
                currentDateTime.getDayOfMonth(),
                fileHour,
                fileMinute);

        return !fileDateTime.isBefore(startDateTime) && !fileDateTime.isAfter(endDateTime);
    }

    // Построение команды Ffmpeg для склеивания файлов
    private static List<String> buildFfmpegCommand(List<String> videoFilesToMerge) {
        List<String> ffmpegCommand = new ArrayList<>();
        ffmpegCommand.add("ffmpeg");
        ffmpegCommand.add("-i");
        ffmpegCommand.addAll(videoFilesToMerge);
        ffmpegCommand.add("-c");
        ffmpegCommand.add("copy");
        ffmpegCommand.add("output.mp4");
        return ffmpegCommand;
    }

    // Выполнение команды Ffmpeg
    private static void executeFfmpegCommand(List<String> ffmpegCommand) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(ffmpegCommand);
        Process process = processBuilder.start();

        // Получение вывода команды Ffmpeg
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Ожидание завершения процесса
        int exitCode = process.waitFor();
        System.out.println("Код завершения: " + exitCode);
    }
}


