package se.iths.provider;

import se.iths.service.TemperatureConverter;

public class FahrenheitToCelsius implements TemperatureConverter {

        @Override
        public double converter(double temperature){
            return (temperature - 32) * 5/9;
        }
}
