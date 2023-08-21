import SimulationLoader.SimulationLoader;

import java.util.Scanner;

public class LaunchConfigIslandSimulation {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в симуляцию Острова Животных!\n" +
                "----------------------------------------------\n" +
                "В этой увлекательной симуляции вы сможете наблюдать за жизнью различных видов животных на острове.");

        while (true) {
            int height;
            int width;
            int numberOfAnimalsPerLocation;
            int timeSecondsWork;
            System.out.println("Давайте начнем! Сначала вам нужно настроить параметры острова.");
            System.out.println("Введите размеры острова:");
            height = inputValidNumber("Высота: ");
            width = inputValidNumber("Ширина: ");
            System.out.println("Теперь напишите количество животных на каждой локации.");
            numberOfAnimalsPerLocation = inputValidNumber("Количество животных: ");
            System.out.println("Теперь время работы симуляции в секундах");
            timeSecondsWork = inputValidNumber("Секунд: ");
            System.out.println("Спасибо! Ваши параметры сохранены. Симуляция готова к запуску.");
            System.out.println("Приятного наблюдения.");
            SimulationLoader.startSimulation(width, height, numberOfAnimalsPerLocation, timeSecondsWork);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                int yesOrNo = inputValidNumber("\nПопробовать еще раз? (1)Да (2)Нет : ");
                if (yesOrNo == 1) {
                    System.out.println();
                    break;
                } else if (yesOrNo == 2) {
                    System.out.println("Удачи!");
                    System.exit(0);
                } else {
                    System.out.println("Некорректный выбор.");
                }
            }
        }
    }

    private static int inputValidNumber(String outSting) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(outSting);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Пустая строка не допустима. Пожалуйста, попробуйте еще раз.");
                continue;
            }

            try {
                int number = Integer.parseInt(input);
                if (number <= 0) {
                    System.out.println("Нам нужно положительное число и не ноль. Пожалуйста, попробуйте еще раз.");
                    continue;
                }
                return number;

            } catch (NumberFormatException e) {
                System.out.println("Не допустимый ввод. Пожалуйста, попробуйте еще раз.");
            }
        }
    }
}