package se.iths.consumer;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;
import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ServiceLoader<TemperatureConverter> loader = ServiceLoader.load(TemperatureConverter.class);


    public static void main(String[] args) {

        int choice;

        do {
            try {
                inputMenu();
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        double inputValueC = getInput();
                        loadConverter(inputValueC, "Celsius", "°C");
                    }
                    case 2 -> {
                        double inputValueF = getInput();
                        loadConverter(inputValueF, "Fahrenheit", "°F");
                    }
                    case 3 -> {
                        double inputValueK = getInput();
                        loadConverter(inputValueK, "Kelvin", "K");
                    }
                    case 4 -> {
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid option! Please choose again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("An error occurred. Please try again.");
                scanner.next();
            }
        } while (true);
    }

    public static void inputMenu() {
        System.out.println(
                """  
               Choose an option to convert temperature to other scale:
                        1. Convert from Celsius
                        2. Convert from Fahrenheit
                        3. Convert from Kelvin
                        4. Exit
                        Enter your choice:
                        """);
    }

    public static double getInput() {
        System.out.println("Please enter a value to convert: ");
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
            return getInput();
        }
    }

    public static void loadConverter(double value, String annotation, String symbol) {
        for (TemperatureConverter converter : loader) {
            if (converter.getClass().getAnnotation(Scale.class).name().equals(annotation)) {
                System.out.println(value + " " + symbol + " is equal to:");
                switch (annotation) {
                    case "Celsius":
                        System.out.println(converter.toKelvin(value) + " K");
                        System.out.println(converter.toFahrenheit(value) + " °F" + "\n");
                        break;
                    case "Fahrenheit":
                        System.out.println(converter.toCelsius(value) + " °C");
                        System.out.println(converter.toKelvin(value) + " K" + "\n");
                        break;
                    case "Kelvin":
                        System.out.println(converter.toCelsius(value) + " °C");
                        System.out.println(converter.toFahrenheit(value) + " °F" + "\n");
                        break;
                    default:
                        System.out.println("Invalid scale.");
                        break;
                }
            }
        }
    }
}