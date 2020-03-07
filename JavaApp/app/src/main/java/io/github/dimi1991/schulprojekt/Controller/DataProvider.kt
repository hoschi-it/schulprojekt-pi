package io.github.dimi1991.schulprojekt.Controller

import io.github.dimi1991.schulprojekt.Model.Device
import io.github.dimi1991.schulprojekt.Model.Location
import java.util.*

public class DataProvider(private val isExampleData: Boolean) {
    private lateinit var _baseUrl : String
    private lateinit var _apiRequestor : ApiRequestor
    private val _jsonParser = JsonParser()

    public fun getAllDevices(): List<Device>{
        if(isExampleData){
            var conti = Location("Hannover", PostalCode = "24241", Street = "Bahnhofsstr. 245")
            var brd = Location("Berlin", PostalCode = "11111", Street = "Regierungsplatz 1")
            var list =  listOf<Device>(
                Device("FritzBox 12340", GregorianCalendar(2020, 20, 2), Location("Buxtehude")),
                Device("Switch X", GregorianCalendar(2019, 7, 17), Location("Prag")),
                Device("SmaViDo 934", GregorianCalendar(2012, 1, 1), brd)
            )
            return list + list + list + list + list + list
        } else {
            var json = _apiRequestor.getDevices()
            return _jsonParser.parseDevices(json)
        }
    }



    constructor(baseUrl: String) : this(false){
        _baseUrl = baseUrl
        _apiRequestor = ApiRequestor(baseUrl)
    }
}