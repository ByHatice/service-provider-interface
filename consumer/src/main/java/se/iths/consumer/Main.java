package se.iths.consumer;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ServiceLoader<TemperatureConverter> loader = ServiceLoader.load(TemperatureConverter.class);
    private static String convertTo;
    private static double temperature;

    public static void main(String[] args) {

        String userInput;

        do {
            System.out.println("\nWhat scale would you like to convert from? \nType the name of the scale.");
            printMenu();

            String convertFrom = scanner.nextLine().trim();
            convertTemperature(convertFrom);

            System.out.println("Do you want to continue converting? (y/n)");
            userInput = scanner.nextLine();

            while (!userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("n")) {
                System.out.println("Invalid input! Please enter 'y' or 'n'.");
                userInput = scanner.nextLine();
            }
        } while (!userInput.equalsIgnoreCase("n"));
    }


    private static void printMenu() {
        System.out.println("Available scales:");
        for (TemperatureConverter converter : loader) {
            Scale annotation = converter.getClass().getAnnotation(Scale.class);
            System.out.println(annotation.name());
        }
    }

    private static void convertTemperature(String convertFrom) {
        for (TemperatureConverter converter : loader) {
            Scale annotation = converter.getClass().getAnnotation(Scale.class);
            if (annotation != null && annotation.name().equalsIgnoreCase(convertFrom)) {
                getInfoFromUser();
                try {
                    Method method = converter.getClass().getMethod(convertTo.toLowerCase(), double.class);
                    System.out.println(method.invoke(converter, temperature));
                } catch (Exception e) {
                    System.out.println("Invalid scale!\n");
                }
                return;
            }
        }
        System.out.println("Invalid scale!\n");
    }

    private static void getInfoFromUser() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\nEnter the temperature you want to convert");
                temperature = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("\nWhat scale do you want to convert to?");
                printMenu();
                convertTo = scanner.nextLine().trim();

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number for temperature.");
                scanner.nextLine();
            }
        }
    }
}