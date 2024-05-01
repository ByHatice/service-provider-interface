package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Fahrenheit")
public class FahrenheitConverter implements TemperatureConverter {

    @Override
    public double celsius(double temperature){
        return (temperature - 32) * 5/9;
    }

    @Override
    public double kelvin(double temperature) {
        return (temperature - 32) * 5/9 + 273.15;
    }

    @Override
    public double fahrenheit(double temperature) {
        return temperature;
    }
}
