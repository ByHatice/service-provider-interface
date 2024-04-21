package se.iths.provider;

import se.iths.service.TemperatureConverter;

public class Celsius implements TemperatureConverter {

        @Override
        public double converter(double tempurature) {
            return tempurature * 9/5 + 32;
        }
}
