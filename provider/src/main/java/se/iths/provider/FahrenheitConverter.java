package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Fahrenheit")
public class FahrenheitConverter implements TemperatureConverter {

    @Override
    public double toCelsius(double temperature){
        return (temperature - 32) * 5/9;
    }

    @Override
    public double toKelvin(double temperature) {
        return (temperature - 32) * 5/9 + 273.15;
    }

    @Override
    public double toFahrenheit(double temperature) {
        return temperature;
    }
}
