package io.github.dimi1991.schulprojekt.Model

import java.text.SimpleDateFormat
import java.util.*
import com.google.gson.annotations.SerializedName;

class Device(
    @SerializedName("type")
    var Name: String,
    @SerializedName("next_maintenance")
    private var _nextMaintenance: GregorianCalendar,
    @SerializedName("location")
    var Location: Location
){

    fun NextMaintenanceString(): String {
        if(_nextMaintenance == null)
            throw NullPointerException("_nextMaintenance is not allowed to be null")
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN)
        return format.format(_nextMaintenance.time)
    }
}