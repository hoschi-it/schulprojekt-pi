package io.github.dimi1991.schulprojekt.Model

import java.text.SimpleDateFormat
import java.util.*

class Device(
    var Name: String = "",
    private var _nextMaintenance: GregorianCalendar,
    var Location: Location
){

    fun NextMaintenanceString(): String {
        val format = SimpleDateFormat("yyyy-MM-dd")
        return format.format(_nextMaintenance.time)
    }
}