package se.iths.provider;

import se.iths.service.TemperatureConverter;

public class KelvinToCelsius implements TemperatureConverter {

            @Override
            public double converter(double temperature) {
                return temperature - 273.15;
            }
}

