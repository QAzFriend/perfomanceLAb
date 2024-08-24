package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class taskSecond {
    public static void main(String[] args) {
        // Проверка на правильное количество аргументов
        if (args.length != 2) {
            System.out.println("Usage: java CirclePointRelation <circle_file> <points_file>");
            return;
        }

        String circleFile = args[0];
        String pointsFile = args[1];

        try {
            // Чтение данных окружности из файла
            BufferedReader circleReader = new BufferedReader(new FileReader(circleFile));
            String[] circleData = circleReader.readLine().split(" ");
            double circleX = Double.parseDouble(circleData[0]);
            double circleY = Double.parseDouble(circleData[1]);
            double radius = Double.parseDouble(circleData[2]);
            circleReader.close();

            // Чтение данных точек из файла
            BufferedReader pointsReader = new BufferedReader(new FileReader(pointsFile));
            String line;
            while ((line = pointsReader.readLine()) != null) {
                String[] pointData = line.split(" ");
                double pointX = Double.parseDouble(pointData[0]);
                double pointY = Double.parseDouble(pointData[1]);

                // Определение положения точки относительно окружности
                double distanceSquared = Math.pow(pointX - circleX, 2) + Math.pow(pointY - circleY, 2);
                double radiusSquared = Math.pow(radius, 2);

                if (distanceSquared == radiusSquared) {
                    System.out.println(0);  // Точка на окружности
                } else if (distanceSquared < radiusSquared) {
                    System.out.println(1);  // Точка внутри окружности
                } else {
                    System.out.println(2);  // Точка снаружи окружности
                }
            }
            pointsReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
