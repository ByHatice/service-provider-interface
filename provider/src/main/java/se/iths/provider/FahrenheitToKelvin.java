package se.iths.provider;

import se.iths.service.TemperatureConverter;

public class FahrenheitToKelvin implements TemperatureConverter {

        @Override
        public double converter(double temperature){
            return (temperature - 32) * 5/9 + 273.15;
        }
}
