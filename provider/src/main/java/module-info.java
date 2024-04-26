import se.iths.provider.CelsiusConverter;
import se.iths.provider.KelvinConverter;
import se.iths.provider.FahrenheitConverter;
import se.iths.service.TemperatureConverter;

module se.iths.provider {

    requires se.iths.service;
    provides TemperatureConverter with CelsiusConverter, FahrenheitConverter, KelvinConverter;

}