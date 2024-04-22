package se.iths.consumer;

import se.iths.service.TemperatureConverter;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<TemperatureConverter> loader = ServiceLoader.load(TemperatureConverter.class);

        for (TemperatureConverter converter : loader) {
            System.out.println(converter.converter(100));
        }
    }
}
