package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Celsius to Fahrenheit")
public class CelsiusToFahrenheit implements TemperatureConverter {

    @Override
    public double converter(double temperature){
        return temperature * 9/5 + 32;
    }
}
