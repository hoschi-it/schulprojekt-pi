package io.github.dimi1991.schulprojekt.Controller

import com.google.gson.Gson
import io.github.dimi1991.schulprojekt.Model.Device
import java.security.InvalidParameterException

public class JsonParser {
    private val gson = Gson()

    public fun parseDevices(json: String): Array<Device> {
        var array = gson.fromJson<Array<Device>>(json, Array<Device>::class.java)
        if(array == null){
            throw InvalidParameterException()
        }
        return array
    }

    public fun parseDevice(json: String): Device {
        var device = gson.fromJson<Device>(json, Device::class.java)
        if(device == null){
            throw InvalidParameterException()
        }
        return device
    }
}