package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Kelvin")
public class KelvinConverter implements TemperatureConverter {

    @Override
    public double toCelsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double toFahrenheit(double temperature) {
        return temperature * 9/5 - 459.67;
    }

    @Override
    public double toKelvin(double temperature) {
        return temperature;
    }
}

