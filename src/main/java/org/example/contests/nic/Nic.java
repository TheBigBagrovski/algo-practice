package org.example.contests.nic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Nic {

    public static void main(String[] args) throws IOException {
        VideoService.VideoRequest vr = new VideoService.VideoRequest("1", "2023", "12", "31", "23_30", "60");
//        System.out.println(getPaths(vr));
        concatenateVideos(getPaths(vr));

    }

    public static void concatenateVideos(List<String> videoPaths) {
        String ffmpegPath = "C:/ffmpeg/ffmpeg-2023-11-28-git-47e214245b-full_build/bin/ffmpeg.exe"; // Путь к исполняемому файлу ffmpeg.exe
        String outputVideoPath = "D:/text.txt"; // Путь для сохранения склеенного видео

        // Создание команды для склеивания видео с использованием ffmpeg
        StringBuilder command = new StringBuilder();
        command.append(ffmpegPath).append(" -i \"concat:");

        for (String path : videoPaths) {
            command.append(path).append(" | ");
        }
        command.deleteCharAt(command.length() - 1); // Удаляем лишний символ "|"
        command.append("\" -c copy ").append(outputVideoPath);

        try {
            // Выполнение команды через процесс
            Process process = Runtime.getRuntime().exec(command.toString());

            // Получение вывода команды
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Ожидание завершения процесса
            process.waitFor();

            System.out.println("Склеивание завершено. Сохранено в файл: " + outputVideoPath);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static File createInputFileList(List<String> videoPaths) throws IOException {
        File inputFileList = File.createTempFile("input", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFileList))) {
            for (String videoPath : videoPaths) {
                writer.write("file '" + videoPath + "'\n");
            }
        }
        return inputFileList;
    }

//    public static List<File> getExistingFiles(List<String> filePaths) {
//        List<File> existingFiles = new ArrayList<>();
//        for (String filePath : filePaths) {
//            File file = new File("D:/Movies/vid/" + filePath + ".mp4");
//            if (file.exists() && file.isFile()) {
//                existingFiles.add(file);
//            } else {
//                System.out.println("File " + filePath + " doesnt exist");
//            }
//        }
//        return existingFiles;
//    }

    public static final String EXTENSION = ".mp4";

    public static List<String> getPaths(VideoService.VideoRequest videoRequest) {
        String basePath = "D:/Movies/vid/" + videoRequest.getCameraNumber() + "/"; // Базовый путь до видеофайлов

        List<String> result = new ArrayList<>();
        int duration = Integer.parseInt(videoRequest.getDuration());

        LocalDateTime dateTime = LocalDateTime.of(
                Integer.parseInt(videoRequest.getYear()),
                Integer.parseInt(videoRequest.getMonth()),
                Integer.parseInt(videoRequest.getDay()),
                Integer.parseInt(videoRequest.getTime().split("_")[0]),
                Integer.parseInt(videoRequest.getTime().split("_")[1])
        );

        for (int i = 0; i < duration; i++) {
            String path = String.format("%04d/%d/%d/%02d_%02d%s",
                    dateTime.getYear(), dateTime.getMonthValue(), dateTime.getDayOfMonth(),
                    dateTime.getHour(), dateTime.getMinute(), EXTENSION);

            File file = new File(basePath + path);
            if (file.exists() && file.isFile()) {
                result.add(file.getPath());
            }

            dateTime = dateTime.plusMinutes(1);
        }

        return result;
    }

//    public static List<String> getPaths(VideoService.VideoRequest videoRequest) {
//        List<String> result = new ArrayList<>();
//        int year = Integer.parseInt(videoRequest.getYear());
//        int month = Integer.parseInt(videoRequest.getMonth());
//        int day = Integer.parseInt(videoRequest.getDay());
//        int duration = Integer.parseInt(videoRequest.getDuration());
//        String[] s = videoRequest.getTime().split("_");
//        int[] time = new int[2];
//        time[0] = Integer.parseInt(s[0]);
//        time[1] = Integer.parseInt(s[1]);
//        for (int i = 0; i < duration; i++) {
//            String pathS = videoRequest.getCameraNumber() + "/" + year + "/" + month + "/" + day + "/" + String.format("%02d", time[0]) + "_" + String.format("%02d", time[1]);
//            File file = new File("D:/Movies/vid/" + pathS + EXTENSION);
//            Path path = Paths.get("D:/Movies/vid/");
//            Path resolved = path.resolve(pathS);
//            if (file.exists() && file.isFile()) {
//                result.add(file.getPath());
//            }
//            time[1]++;
//            if (time[1] >= 60) { // переход по часу
//                time[0]++;
//                time[1] = 0;
//                if (time[0] >= 24) { // переход по суткам
//                    time[0] = 0;
//                    YearMonth date = YearMonth.of(year, month);
//                    day++;
//                    if (day > date.lengthOfMonth()) { // переход по месяцу
//                        day = 1;
//                        month++;
//                        if (month >= 12) { // переход по году
//                             month = 1;
//                             year++;
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }


}
