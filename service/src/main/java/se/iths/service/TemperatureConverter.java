package se.iths.service;

public interface TemperatureConverter {

    double celsius(double temperature);
    double fahrenheit(double temperature);
    double kelvin(double temperature);
}
