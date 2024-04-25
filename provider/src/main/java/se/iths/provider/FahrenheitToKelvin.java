package se.iths.provider;

import se.iths.service.Scale;
import se.iths.service.TemperatureConverter;

@Scale(name = "Kelvin to Celsius")
public class FahrenheitToKelvin implements TemperatureConverter {

        @Override
        public double converter(double temperature){
            return (temperature - 32) * 5/9 + 273.15;
        }
}
