import java.util.Scanner;

class Car {
    String name;
    int speed;

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    int calculateDistance() {
        return speed * 24;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название автомобиля номер " + (i + 1) + ":");
            String name = scanner.nextLine();

            int speed = 0;
            boolean validSpeed = false;
            while (!validSpeed) {
                System.out.println("Введите скорость автомобиля номер " + (i + 1) + ":");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    scanner.nextLine();
                    if (speed > 0 && speed <= 250) {
                        validSpeed = true;
                    } else {
                        System.out.println("Скорость должна быть в диапазоне от 0 до 250 км/ч.");
                    }
                } else {
                    System.out.println("Пожалуйста, введите корректное число.");
                    scanner.nextLine();
                }
            }

            cars[i] = new Car(name, speed);
        }

        Car winner = cars[0];
        for (int i = 1; i < 3; i++) {
            if (cars[i].calculateDistance() > winner.calculateDistance()) {
                winner = cars[i];
            }
        }

        System.out.println("Самая быстрая машина: " + winner.name);
    }
}