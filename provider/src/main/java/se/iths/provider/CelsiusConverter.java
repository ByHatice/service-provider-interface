package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Celsius")
public class CelsiusConverter implements TemperatureConverter {

    @Override
    public double fahrenheit(double temperature){
        return temperature * 9/5 + 32;
    }

    @Override
    public double kelvin(double temperature) {
        return temperature + 273.15;
    }

    @Override
    public double celsius(double temperature) {
        return temperature;
    }
}
