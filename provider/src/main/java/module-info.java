import se.iths.provider.CelsiusToFahrenheit;
import se.iths.provider.CelsiusToKelvin;
import se.iths.provider.KelvinToCelsius;
import se.iths.provider.KelvinToFahrenheit;
import se.iths.provider.FahrenheitToCelsius;
import se.iths.provider.FahrenheitToKelvin;
import se.iths.service.TemperatureConverter;

module se.iths.provider {

    requires se.iths.service;
    provides TemperatureConverter with CelsiusToKelvin, CelsiusToFahrenheit, FahrenheitToCelsius,FahrenheitToKelvin, KelvinToFahrenheit, KelvinToCelsius; //flera klasser följs av kommatecken

}