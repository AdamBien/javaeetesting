package com.airhacks.weather.business.forecast.boundary;

import javax.ejb.Stateless;
import javax.ws.rs.GET;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class WeatherService {

    @GET
    public String forecast() {
        return "sunny";
    }

}
