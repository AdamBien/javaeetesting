package com.airhacks.weather.presentation;

import com.airhacks.weather.business.forecast.boundary.WeatherService;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Model
public class Index {

    @Inject
    WeatherService service;

    public String getForecast() {
        return this.service.forecast();
    }

}
