package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Kelvin to Fahrenheit")
public class KelvinToFahrenheit implements TemperatureConverter {

        @Override
        public double converter(double temperature) {
            return temperature * 9/5 - 459.67;
        }
}
