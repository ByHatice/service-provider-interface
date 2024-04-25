package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Celsius to Kelvin")
public class CelsiusToKelvin implements TemperatureConverter {

        @Override
        public double converter(double temperature) {
            return temperature + 273.15;
        }
}
