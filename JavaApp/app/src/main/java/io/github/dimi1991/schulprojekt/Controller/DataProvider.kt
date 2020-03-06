package io.github.dimi1991.schulprojekt.Controller

import io.github.dimi1991.schulprojekt.Model.Device

public class DataProvider(private val baseUrl: String) {
    private val _apiRequestor = ApiRequestor(baseUrl)
    private val _jsonParser = JsonParser()

    public fun getAllDevices(): List<Device>{
        var json = _apiRequestor.getDevices()
        return _jsonParser.parseDevices(json)
    }
}