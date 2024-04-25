package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Kelvin to Celsius")
public class KelvinToCelsius implements TemperatureConverter {

            @Override
            public double converter(double temperature) {
                return temperature - 273.15;
            }
}

