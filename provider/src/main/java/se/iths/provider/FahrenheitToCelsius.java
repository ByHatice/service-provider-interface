package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Fahrenheit to Celsius")
public class FahrenheitToCelsius implements TemperatureConverter {

        @Override
        public double converter(double temperature){
            return (temperature - 32) * 5/9;
        }
}
