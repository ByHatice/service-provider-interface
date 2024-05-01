package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Kelvin")
public class KelvinConverter implements TemperatureConverter {

    @Override
    public double celsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double fahrenheit(double temperature) {
        return temperature * 9/5 - 459.67;
    }

    @Override
    public double kelvin(double temperature) {
        return temperature;
    }
}

