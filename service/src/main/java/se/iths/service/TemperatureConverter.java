package se.iths.service;

public interface TemperatureConverter {

    double toCelsius(double temperature);
    double toFahrenheit(double temperature);
    double toKelvin(double temperature);
}
