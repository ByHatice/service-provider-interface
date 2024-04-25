package se.iths.consumer;

import se.iths.service.TemperatureConverter;
import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int choice;

    public static void main(String[] args) {

        inputMenu();
        switch (choice) {
            case 1 -> {
                int celsiusF = getInput("Celsius", "Fahrenheit");
                loadConverter(celsiusF);
            }
            case 2 -> {
                int celsiusK = getInput("Celsius", "Kelvin");
                loadConverter(celsiusK);
            }
            case 3 -> {
                int fahrenheitC = getInput("Fahrenheit", "Celsius");
                loadConverter(fahrenheitC);
            }
            case 4 -> {
                int fahrenheitK = getInput("Fahrenheit", "Kelvin");
                loadConverter(fahrenheitK);
            }
            case 5 -> {
                int kelvinC = getInput("Kelvin", "Celsius");
                loadConverter(kelvinC);
            }
            case 6 -> {
                int kelvinF = getInput("Kelvin", "Fahrenheit");
                loadConverter(kelvinF);
            }
            case 7 -> System.out.println("Exiting program...");
            default -> System.out.println("Invalid option! Please choose again.");
        }
        scanner.close();
    }
    public static int inputMenu() {
        System.out.println(
                """                       
                        1. Celsius to Fahrenheit
                        2. Celsius to Kelvin
                        3. Fahrenheit to Celsius
                        4. Fahrenheit to Kelvin
                        5. Kelvin to Celsius
                        6. Kelvin to Fahrenheit
                        7. Exit
                        Enter your choice:
                        """);
        choice = scanner.nextInt();

        return choice;
    }

    public static int getInput(String fromUnit, String toUnit) {
        System.out.printf("Please enter the temperature in %s to convert it to %s: %n", fromUnit, toUnit);
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }
    }

    public static void loadConverter(int value) {
        ServiceLoader<TemperatureConverter> loader = ServiceLoader.load(TemperatureConverter.class);
        for (TemperatureConverter converter : loader) {
            System.out.println(converter.converter(value));
        }
    }
}
