package task1;

public class taskFirst {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        // Создание кругового массива
        int[] circularArray = new int[n];
        for (int i = 0; i < n; i++) {
            circularArray[i] = i + 1;
        }

        // Переменная для хранения результата
        StringBuilder result = new StringBuilder();

        // Переменная для отслеживания текущей позиции в массиве
        int currentIndex = 0;

        // Проходим по массиву до тех пор, пока не вернемся к началу
        for (int i = 0; i < n; i++) {
            // Добавляем начальный элемент текущего интервала в результат
            result.append(circularArray[currentIndex]);

            // Вычисляем следующую позицию с учетом кругового обхода
            currentIndex = (currentIndex + m - 1) % n;
        }

        // Выводим полученный путь
        System.out.println("Полученный путь: " + result.toString());
    }
}

