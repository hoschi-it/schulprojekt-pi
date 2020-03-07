package io.github.dimi1991.schulprojekt.Controller

import android.content.ClipData.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.github.dimi1991.schulprojekt.Model.Device
import java.security.InvalidParameterException


public class JsonParser {
    private val gson = Gson()

    public fun parseDevices(json: String): List<Device> {
        val array = gson.fromJson<Array<Device>>(json, Array<Device>::class.java).toList()
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